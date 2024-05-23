package org.infernalstudios.celesteconfig;

import net.neoforged.fml.common.Mod;
import org.infernalstudios.celesteconfig.config.CelestialConfigOptions;

@Mod(Constants.MOD_ID)
public class CelestialConfiguration {
    
    public CelestialConfiguration() {
        CelestialConfigOptions.init();
        CommonClass.init(CelestialConfigOptions.getMoonWidthScalar(), CelestialConfigOptions.getMoonHeightScalar(), CelestialConfigOptions.getSunWidthScalar(), CelestialConfigOptions.getSunHeightScalar());
    }
}