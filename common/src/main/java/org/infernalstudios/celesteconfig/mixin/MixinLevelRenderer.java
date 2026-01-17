package org.infernalstudios.celesteconfig.mixin;

import net.minecraft.client.renderer.LevelRenderer;
import org.infernalstudios.celesteconfig.Constants;
import org.joml.Matrix4f;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.ModifyVariable;

@Mixin(LevelRenderer.class)
public class MixinLevelRenderer {

    @Unique
    private Matrix4f celesteconfig$originalCelestialMatrix;

    @ModifyVariable(method = "renderSky(Lorg/joml/Matrix4f;Lorg/joml/Matrix4f;FLnet/minecraft/client/Camera;ZLjava/lang/Runnable;)V", at = @At(value = "INVOKE", target = "Lcom/mojang/blaze3d/systems/RenderSystem;setShaderTexture(ILnet/minecraft/resources/ResourceLocation;)V", ordinal = 0), ordinal = 2)
    private Matrix4f celesteConfig$scaleSun(Matrix4f in) {
        celesteconfig$originalCelestialMatrix = new Matrix4f(in);
        Matrix4f copy = new Matrix4f(in);
        copy.scale((float) Constants.sunWidth, 1.0F, (float) Constants.sunHeight);
        return copy;
    }

    @ModifyVariable(method = "renderSky(Lorg/joml/Matrix4f;Lorg/joml/Matrix4f;FLnet/minecraft/client/Camera;ZLjava/lang/Runnable;)V", at = @At(value = "INVOKE", target = "Lcom/mojang/blaze3d/systems/RenderSystem;setShaderTexture(ILnet/minecraft/resources/ResourceLocation;)V", ordinal = 1), ordinal = 2)
    private Matrix4f celesteConfig$scaleMoon(Matrix4f in) {
        if (celesteconfig$originalCelestialMatrix != null) {
            Matrix4f copy = new Matrix4f(celesteconfig$originalCelestialMatrix);
            copy.scale((float) Constants.moonWidth, 1.0F, (float) Constants.moonHeight);
            celesteconfig$originalCelestialMatrix = null;
            return copy;
        } else {
            return in;
        }
    }
}