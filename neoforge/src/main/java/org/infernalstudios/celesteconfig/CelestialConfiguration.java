package org.infernalstudios.celesteconfig;

import me.shedaniel.clothconfig2.api.ConfigBuilder;
import me.shedaniel.clothconfig2.api.ConfigCategory;
import me.shedaniel.clothconfig2.api.ConfigEntryBuilder;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.network.chat.Component;
import net.neoforged.fml.ModContainer;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.config.ModConfig;
import net.neoforged.neoforge.client.gui.IConfigScreenFactory;
import org.infernalstudios.celesteconfig.config.CelestialConfigOptions;

@Mod(Constants.MOD_ID)
public class CelestialConfiguration {

    public CelestialConfiguration(ModContainer container) {
        container.registerConfig(ModConfig.Type.CLIENT, CelestialConfigOptions.CLIENT_SPEC);

        updateCommonClass();

        container.registerExtensionPoint(IConfigScreenFactory.class, (modContainer, parent) -> buildConfigScreen(parent));
    }

    private void updateCommonClass() {
        CommonClass.init(
                CelestialConfigOptions.getMoonWidthScalar(),
                CelestialConfigOptions.getMoonHeightScalar(),
                CelestialConfigOptions.getSunWidthScalar(),
                CelestialConfigOptions.getSunHeightScalar()
        );
    }

    public Screen buildConfigScreen(Screen parent) {
        ConfigBuilder builder = ConfigBuilder.create()
                .setParentScreen(parent)
                .setTitle(Component.translatable("text.autoconfig.celesteconfig.title"));

        ConfigCategory general = builder.getOrCreateCategory(Component.translatable("text.autoconfig.celesteconfig.title"));
        ConfigEntryBuilder entryBuilder = builder.entryBuilder();

        general.addEntry(entryBuilder.startDoubleField(Component.translatable("text.autoconfig.celesteconfig.option.moonWidth"), CelestialConfigOptions.getMoonWidthScalar())
                .setDefaultValue(1.0D)
                .setSaveConsumer(CelestialConfigOptions::setMoonWidthScalar)
                .build());

        general.addEntry(entryBuilder.startDoubleField(Component.translatable("text.autoconfig.celesteconfig.option.moonHeight"), CelestialConfigOptions.getMoonHeightScalar())
                .setDefaultValue(1.0D)
                .setSaveConsumer(CelestialConfigOptions::setMoonHeightScalar)
                .build());

        general.addEntry(entryBuilder.startDoubleField(Component.translatable("text.autoconfig.celesteconfig.option.sunWidth"), CelestialConfigOptions.getSunWidthScalar())
                .setDefaultValue(1.0D)
                .setSaveConsumer(CelestialConfigOptions::setSunWidthScalar)
                .build());

        general.addEntry(entryBuilder.startDoubleField(Component.translatable("text.autoconfig.celesteconfig.option.sunHeight"), CelestialConfigOptions.getSunHeightScalar())
                .setDefaultValue(1.0D)
                .setSaveConsumer(CelestialConfigOptions::setSunHeightScalar)
                .build());

        builder.setSavingRunnable(this::updateCommonClass);

        return builder.build();
    }
}