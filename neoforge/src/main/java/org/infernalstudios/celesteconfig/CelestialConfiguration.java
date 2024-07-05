package org.infernalstudios.celesteconfig;

import net.neoforged.fml.ModContainer;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.config.ModConfig;
import net.neoforged.neoforge.common.ModConfigSpec;
import org.infernalstudios.celesteconfig.config.CelestialConfigOptions;

@Mod(Constants.MOD_ID)
public class CelestialConfiguration {

    public static ModConfigSpec CLIENT_CONFIG;
    
    public CelestialConfiguration(ModContainer modContainer) {
        CelestialConfigOptions.init(modContainer);
        CommonClass.init(CelestialConfigOptions.getMoonWidthScalar(), CelestialConfigOptions.getMoonHeightScalar(), CelestialConfigOptions.getSunWidthScalar(), CelestialConfigOptions.getSunHeightScalar());
    }
}