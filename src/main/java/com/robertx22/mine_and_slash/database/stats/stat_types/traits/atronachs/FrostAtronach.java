package com.robertx22.mine_and_slash.database.stats.stat_types.traits.atronachs;

import com.robertx22.mine_and_slash.database.stats.StatMod;
import com.robertx22.mine_and_slash.database.stats.Trait;
import com.robertx22.mine_and_slash.database.stats.stat_mods.generated.ElementalSpellDamageMulti;
import com.robertx22.mine_and_slash.uncommon.enumclasses.Elements;
import com.robertx22.mine_and_slash.uncommon.interfaces.IAffectsOtherStats;

import java.util.Arrays;
import java.util.List;

public class FrostAtronach extends Trait implements IAffectsOtherStats {

    public static String GUID = "Frost Atronach";

    @Override
    public String GUID() {
        return GUID;
    }

    @Override
    public List<StatMod> getStats() {
        return Arrays.asList(new ElementalSpellDamageMulti(Elements.Water));

    }

    @Override
    public String locNameForLangFile() {
        return "Frost Atronach";
    }
}
