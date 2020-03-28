package com.robertx22.mine_and_slash.database.affixes.suffixes.curses;

import com.robertx22.mine_and_slash.database.affixes.Suffix;
import com.robertx22.mine_and_slash.database.requirements.LevelRequirement;
import com.robertx22.mine_and_slash.database.requirements.Requirements;
import com.robertx22.mine_and_slash.database.requirements.SlotRequirement;
import com.robertx22.mine_and_slash.database.stats.StatMod;
import com.robertx22.mine_and_slash.database.stats.mods.flat.resources.HealthFlat;
import com.robertx22.mine_and_slash.uncommon.interfaces.data_items.IRarity;

import java.util.Arrays;
import java.util.List;

public class OfMortality extends Suffix {

    public OfMortality() {
        super(new Requirements(SlotRequirement.armorsOnly(), LevelRequirement.fromLowLevel()));
    }

    @Override
    public String GUID() {
        return "of_mortality";
    }

    @Override
    public List<StatMod> StatMods() {
        return Arrays.asList(new HealthFlat().size(StatMod.Size.HALF_LESS));
    }

    @Override
    public int getRarityRank() {
        return IRarity.Epic;
    }

    @Override
    public String locNameForLangFile() {
        return "Of Mortality";
    }

}