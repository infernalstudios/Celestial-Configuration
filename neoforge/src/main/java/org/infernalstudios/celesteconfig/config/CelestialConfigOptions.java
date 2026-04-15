package org.infernalstudios.celesteconfig.config;

import net.neoforged.neoforge.common.ModConfigSpec;
import org.apache.commons.lang3.tuple.Pair;

public class CelestialConfigOptions {

    public static final ModConfigSpec CLIENT_SPEC;
    public static final ClientConfig CLIENT;

    static {
        final Pair<ClientConfig, ModConfigSpec> specPair = new ModConfigSpec.Builder().configure(ClientConfig::new);
        CLIENT_SPEC = specPair.getRight();
        CLIENT = specPair.getLeft();
    }

    public static double getMoonWidthScalar() {
        return CLIENT.moonWidthScalar.get();
    }

    public static void setMoonWidthScalar(double value) {
        CLIENT.moonWidthScalar.set(value);
        CLIENT.moonWidthScalar.save();
    }

    public static double getMoonHeightScalar() {
        return CLIENT.moonHeightScalar.get();
    }

    public static void setMoonHeightScalar(double value) {
        CLIENT.moonHeightScalar.set(value);
        CLIENT.moonHeightScalar.save();
    }

    public static double getSunWidthScalar() {
        return CLIENT.sunWidthScalar.get();
    }

    public static void setSunWidthScalar(double value) {
        CLIENT.sunWidthScalar.set(value);
        CLIENT.sunWidthScalar.save();
    }

    public static double getSunHeightScalar() {
        return CLIENT.sunHeightScalar.get();
    }

    public static void setSunHeightScalar(double value) {
        CLIENT.sunHeightScalar.set(value);
        CLIENT.sunHeightScalar.save();
    }

    public static class ClientConfig {
        public final ModConfigSpec.DoubleValue moonWidthScalar;
        public final ModConfigSpec.DoubleValue moonHeightScalar;
        public final ModConfigSpec.DoubleValue sunWidthScalar;
        public final ModConfigSpec.DoubleValue sunHeightScalar;

        public ClientConfig(ModConfigSpec.Builder builder) {
            builder.comment("Celestial Configuration").push("celesteconfig");

            moonWidthScalar = builder.comment("Moon Width Scalar")
                    .defineInRange("moon.width", 1.0D, 0.0D, 100.0D);

            moonHeightScalar = builder.comment("Moon Height Scalar")
                    .defineInRange("moon.height", 1.0D, 0.0D, 100.0D);

            sunWidthScalar = builder.comment("Sun Width Scalar")
                    .defineInRange("sun.width", 1.0D, 0.0D, 100.0D);

            sunHeightScalar = builder.comment("Sun Height Scalar")
                    .defineInRange("sun.height", 1.0D, 0.0D, 100.0D);

            builder.pop();
        }
    }
}