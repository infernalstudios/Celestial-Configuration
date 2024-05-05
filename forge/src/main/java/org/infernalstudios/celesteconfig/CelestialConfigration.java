package org.infernalstudios.celesteconfig;

import net.minecraftforge.fml.common.Mod;
import org.infernalstudios.celesteconfig.config.CelestialConfigOptions;

@Mod(Constants.MOD_ID)
public class CelestialConfigration {
    
    public CelestialConfigration() {
        CelestialConfigOptions.init();
        CommonClass.init(CelestialConfigOptions.getMoonWidthScalar(), CelestialConfigOptions.getMoonHeightScalar(), CelestialConfigOptions.getSunWidthScalar(), CelestialConfigOptions.getSunHeightScalar());
    }
}