package com.robertx22.mine_and_slash.database.affixes.prefixes.resource;

import com.robertx22.mine_and_slash.database.affixes.Prefix;
import com.robertx22.mine_and_slash.database.requirements.Requirements;
import com.robertx22.mine_and_slash.database.requirements.SlotRequirement;
import com.robertx22.mine_and_slash.database.stats.StatMod;
import com.robertx22.mine_and_slash.database.stats.mods.flat.corestats.CoreStatFlat;
import com.robertx22.mine_and_slash.database.stats.types.core_stats.Wisdom;

import java.util.Arrays;
import java.util.List;

public class Wise extends Prefix {

    public Wise() {
        super(new Requirements(SlotRequirement.jewerlyOnly()));
    }

    @Override
    public String GUID() {
        return "wise";
    }

    @Override
    public List<StatMod> StatMods() {
        return Arrays.asList(new CoreStatFlat(Wisdom.INSTANCE));
    }

    @Override
    public String locNameForLangFile() {
        return "Wise";
    }
}
