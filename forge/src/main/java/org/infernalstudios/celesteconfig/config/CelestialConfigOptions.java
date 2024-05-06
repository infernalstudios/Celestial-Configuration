package org.infernalstudios.celesteconfig.config;

import com.electronwill.nightconfig.core.file.CommentedFileConfig;
import com.electronwill.nightconfig.core.io.WritingMode;
import net.minecraftforge.common.ForgeConfigSpec;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.config.ModConfig;
import net.minecraftforge.fml.loading.FMLPaths;

import java.io.File;

public class CelestialConfigOptions {

    private static final ForgeConfigSpec.Builder client_builder = new ForgeConfigSpec.Builder();
    private static ForgeConfigSpec.DoubleValue moonWidthScalar;
    private static ForgeConfigSpec.DoubleValue moonHeightScalar;
    private static ForgeConfigSpec.DoubleValue sunWidthScalar;
    private static ForgeConfigSpec.DoubleValue sunHeightScalar;
    private static ForgeConfigSpec client_config;

    public static void init() {
        client_builder.comment("Celestial Configuration");
        moonWidthScalar = client_builder.comment("Moon Width Scalar").defineInRange("celesteconfig.moon.width", 1.0D, 0.0D, 100.0D);
        moonHeightScalar = client_builder.comment("Moon Height Scalar").defineInRange("celesteconfig.moon.height", 1.0D, 0.0D, 100.0D);
        sunWidthScalar = client_builder.comment("Sun Width Scalar").defineInRange("celesteconfig.sun.width", 1.0D, 0.0D, 100.0D);
        sunHeightScalar = client_builder.comment("Moon Height Scalar").defineInRange("celesteconfig.sun.height", 1.0D, 0.0D, 100.0D);
        client_config = client_builder.build();

        ModLoadingContext.get().registerConfig(ModConfig.Type.CLIENT, CelestialConfigOptions.client_config);

        CommentedFileConfig file = CommentedFileConfig.builder(new File(FMLPaths.CONFIGDIR.get().resolve("celesteconfig-client.toml").toString())).sync().autosave().writingMode(WritingMode.REPLACE).build();
        file.load();
        client_config.setConfig(file);
    }

    public static double getMoonWidthScalar() {
        return moonWidthScalar.get();
    }

    public static double getMoonHeightScalar() {
        return moonHeightScalar.get();
    }

    public static double getSunWidthScalar() {
        return sunWidthScalar.get();
    }

    public static double getSunHeightScalar() {
        return sunHeightScalar.get();
    }

}