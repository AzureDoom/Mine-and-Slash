package com.robertx22.mine_and_slash.database.affixes.prefixes.curses;

import com.robertx22.mine_and_slash.database.affixes.Prefix;
import com.robertx22.mine_and_slash.database.requirements.Requirements;
import com.robertx22.mine_and_slash.database.requirements.SlotRequirement;
import com.robertx22.mine_and_slash.database.stats.StatMod;
import com.robertx22.mine_and_slash.database.stats.mods.flat.resources.EnergyFlat;
import com.robertx22.mine_and_slash.database.stats.mods.flat.resources.ManaRegenFlat;
import com.robertx22.mine_and_slash.uncommon.interfaces.data_items.IRarity;

import java.util.Arrays;
import java.util.List;

public class Reeking extends Prefix {

    public Reeking() {
        super(new Requirements(SlotRequirement.armorsOnly()));
    }

    @Override
    public int getRarityRank() {
        return IRarity.Rare;
    }

    @Override
    public String GUID() {
        return "reeking";
    }

    @Override
    public List<StatMod> StatMods() {
        return Arrays.asList(new ManaRegenFlat().size(StatMod.Size.HALF_LESS), new EnergyFlat().size(StatMod.Size.HALF_LESS));
    }

    @Override
    public String locNameForLangFile() {
        return "Reeking";
    }
}

