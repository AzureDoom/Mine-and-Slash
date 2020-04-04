package com.robertx22.mine_and_slash.uncommon.enumclasses;

import com.robertx22.mine_and_slash.config.forge.ModConfig;
import com.robertx22.mine_and_slash.database.stats.types.offense.PhysicalDamage;
import com.robertx22.mine_and_slash.database.stats.types.resources.*;
import com.robertx22.mine_and_slash.mmorpg.Ref;
import com.robertx22.mine_and_slash.saveclasses.ExactStatData;
import com.robertx22.mine_and_slash.uncommon.localization.Words;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.text.TextFormatting;

import java.util.ArrayList;
import java.util.List;

public enum SpellSchools {

    OCEAN_MYSTIC("ocean_mystic", Elements.Water.format, Words.OceanMystic),
    EMBER_MAGE("ember_mage", Elements.Fire.format, Words.EmberMage),
    DRUID("druid", Elements.Nature.format, Words.Druid),
    SHAMAN("shaman", Elements.Thunder.format, Words.Shaman),

    RANGER("ranger", TextFormatting.GREEN, Words.Ranger),

    CLERIC("cleric", TextFormatting.WHITE, Words.Cleric);

    public static int MAXIMUM_POINTS = 50;

    SpellSchools(String id, TextFormatting format, Words locName) {
        this.id = id;
        this.format = format;
        this.locName = locName;
    }

    public String id;
    public TextFormatting format;
    public Words locName;

    public List<ExactStatData> getStatsFor(int schoolLevel) { // TODO make it differ per school;
        List<ExactStatData> list = new ArrayList<>();

        int level = ModConfig.INSTANCE.Server.MAXIMUM_PLAYER_LEVEL.get() * (schoolLevel / MAXIMUM_POINTS);

        // these will need a lot of fine tuning.

        list.add(new ExactStatData(2, Health.getInstance()));
        list.add(new ExactStatData(40, Mana.getInstance()));
        list.add(new ExactStatData(60, Energy.getInstance()));

        list.add(new ExactStatData(1.5F, ManaRegen.getInstance()));
        list.add(new ExactStatData(3, EnergyRegen.getInstance()));
        list.add(new ExactStatData(0.5F, HealthRegen.getInstance()));
        list.add(new ExactStatData(0.25F, MagicShieldRegen.getInstance()));

        list.add(new ExactStatData(0.12F, PhysicalDamage.getInstance()));

        list.forEach(x -> x.scaleToLvl(level)); // scale to this level, not player level

        return list;
    }

    public ResourceLocation getGuiIconLocation() {
        return new ResourceLocation(Ref.MODID, "textures/gui/spells/schools/" + id + ".png");
    }

}
