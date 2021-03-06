package com.robertx22.mine_and_slash.database.runewords.slots_2;

import com.robertx22.mine_and_slash.database.runes.Ber;
import com.robertx22.mine_and_slash.database.runes.Cen;
import com.robertx22.mine_and_slash.database.runes.base.BaseRune;
import com.robertx22.mine_and_slash.database.runewords.RuneWord;
import com.robertx22.mine_and_slash.database.stats.StatMod;
import com.robertx22.mine_and_slash.database.stats.mods.flat.defense.ArmorFlat;
import com.robertx22.mine_and_slash.database.stats.mods.generated.ElementalResistFlat;
import com.robertx22.mine_and_slash.uncommon.enumclasses.Elements;

import java.util.Arrays;
import java.util.List;

public class RuneWordScales extends RuneWord {

    @Override
    public List<StatMod> mods() {
        return Arrays.asList(new ElementalResistFlat(Elements.Nature), new ArmorFlat());
    }

    @Override
    public String GUID() {
        return "scales";
    }

    @Override
    public List<BaseRune> runes() {
        return Arrays.asList(new Ber(0), new Cen(0));
    }

    @Override
    public String locNameForLangFile() {
        return "Scales";
    }
}
