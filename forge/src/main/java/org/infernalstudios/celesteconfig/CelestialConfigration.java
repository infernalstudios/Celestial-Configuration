package org.infernalstudios.celesteconfig;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.config.ModConfigEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.infernalstudios.celesteconfig.config.CelestialConfigOptions;

@Mod(Constants.MOD_ID)
public class CelestialConfigration {

    public CelestialConfigration() {
        CelestialConfigOptions.init();
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::onConfigLoad);
        CommonClass.init(CelestialConfigOptions.getMoonWidthScalar(), CelestialConfigOptions.getMoonHeightScalar(), CelestialConfigOptions.getSunWidthScalar(), CelestialConfigOptions.getSunHeightScalar());
    }

    public void onConfigLoad(ModConfigEvent event) {
        CommonClass.init(CelestialConfigOptions.getMoonWidthScalar(), CelestialConfigOptions.getMoonHeightScalar(), CelestialConfigOptions.getSunWidthScalar(), CelestialConfigOptions.getSunHeightScalar());
    }
}