package com.robertx22.mine_and_slash.database.stats.mods.generated;

import com.robertx22.mine_and_slash.database.stats.Stat;
import com.robertx22.mine_and_slash.database.stats.StatMod;
import com.robertx22.mine_and_slash.database.stats.mods.ElementalStatMod;
import com.robertx22.mine_and_slash.database.stats.types.generated.ElementalDamageBonus;
import com.robertx22.mine_and_slash.uncommon.enumclasses.Elements;
import com.robertx22.mine_and_slash.uncommon.enumclasses.StatModTypes;
import com.robertx22.mine_and_slash.uncommon.wrappers.MapWrapper;

public class AllElementalDamageMulti extends ElementalStatMod {

    public AllElementalDamageMulti(Elements element) {
        super(element);
    }

    @Override
    public MapWrapper<Elements, ElementalDamageBonus> getBaseStatMap() {
        return ElementalDamageBonus.MAP;
    }

    @Override
    public final Stat GetBaseStat() {
        return new ElementalDamageBonus(element);
    }

    @Override
    public StatMod newGeneratedInstance(Elements element) {
        return new AllElementalDamageMulti(element);
    }

    @Override
    public float Min() {
        return 5;
    }

    @Override
    public float Max() {
        return 10;
    }

    @Override
    public StatModTypes getModType() {
        return StatModTypes.Flat;
    }

}


