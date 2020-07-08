package com.robertx22.mine_and_slash.config.forge.parts;

import net.minecraftforge.common.ForgeConfigSpec;
import net.minecraftforge.common.ForgeConfigSpec.DoubleValue;

public class DropRatesContainer {

    public DoubleValue RUNED_GEAR_DROPRATE;
    public DoubleValue UNIQUE_RUNE_DROPRATE;
    public DoubleValue RUNE_DROPRATE;
    public DoubleValue MAP_DROPRATE;
    public DoubleValue GEAR_DROPRATE;
    public DoubleValue UNIQUE_DROPRATE;
    public DoubleValue CURRENCY_DROPRATE;
    public DoubleValue AWAKEN_RUNEWORD_DROPRATE;
    public DoubleValue COMPATIBLE_ITEMS_DROPRATE;
    public DoubleValue LOOTBOX_DROPRATE;

    public DropRatesContainer(ForgeConfigSpec.Builder builder) {
        builder.push("DROPRATES");

        LOOTBOX_DROPRATE = builder.comment(".")
            .translation("mmorpg.config.lootbox_droprate")
            .defineInRange("LOOTBOX_DROPRATE", 0.05D, 0, Integer.MAX_VALUE);

        GEAR_DROPRATE = builder.comment(".")
            .translation("mmorpg.config.gear_droprate")
            .defineInRange("GEAR_DROPRATE", 7F, 0, Integer.MAX_VALUE);

        UNIQUE_DROPRATE = builder.comment(".")
            .translation("mmorpg.config.unique_droprate")
            .defineInRange("UNIQUE_DROPRATE", 0.25F, 0, Integer.MAX_VALUE);

        CURRENCY_DROPRATE = builder.comment(".")
            .translation("mmorpg.config.currency_droprate")
            .defineInRange("CURRENCY_DROPRATE", 1.2F, 0, Integer.MAX_VALUE);

        COMPATIBLE_ITEMS_DROPRATE = builder.comment(".")
            .translation("mmorpg.config.compatible_items_droprate")
            .defineInRange("COMPATIBLE_ITEMS_DROPRATE", 2F, 0, Integer.MAX_VALUE);

        builder.pop();

    }

}
