package com.robertx22.mine_and_slash.database.affixes.prefixes.offense;

import com.robertx22.mine_and_slash.database.affixes.Prefix;
import com.robertx22.mine_and_slash.database.requirements.Requirements;
import com.robertx22.mine_and_slash.database.requirements.SlotRequirement;
import com.robertx22.mine_and_slash.database.stats.StatMod;
import com.robertx22.mine_and_slash.database.stats.mods.flat.offense.CriticalHitFlat;
import com.robertx22.mine_and_slash.database.stats.mods.percent.offense.CriticalHitPercent;
import com.robertx22.mine_and_slash.uncommon.interfaces.data_items.IRarity;

import java.util.Arrays;
import java.util.List;

public class HeavenlyStrikes extends Prefix {

    public HeavenlyStrikes() {
        super(new Requirements(SlotRequirement.weaponsOnly()));
    }

    @Override
    public String GUID() {
        return "heavenly_strikes";
    }

    @Override
    public List<StatMod> StatMods() {

        return Arrays.asList(new CriticalHitFlat(), new CriticalHitPercent().size(StatMod.Size.HALF_MORE));

    }

    @Override
    public int getRarityRank() {
        return IRarity.Epic;
    }

    @Override
    public String locNameForLangFile() {
        return "Heavenly Strikes";
    }
}
