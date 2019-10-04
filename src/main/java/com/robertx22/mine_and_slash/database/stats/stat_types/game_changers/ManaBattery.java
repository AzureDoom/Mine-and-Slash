package com.robertx22.mine_and_slash.database.stats.stat_types.game_changers;

import com.robertx22.mine_and_slash.database.stats.Stat;
import com.robertx22.mine_and_slash.database.stats.stat_effects.game_changers.ManaBatteryEffect;
import com.robertx22.mine_and_slash.uncommon.interfaces.IStatEffect;
import com.robertx22.mine_and_slash.uncommon.interfaces.IStatEffects;

public class ManaBattery extends BaseGameChangerTrait implements IStatEffects {

    private ManaBattery() {
    }

    public static final Stat INSTANCE = new ManaBattery();

    @Override
    public String locDescForLangFile() {
        return "If mana is above 25%, absorbs dmg instead of health";
    }

    @Override
    public String locNameForLangFile() {
        return "Mana Battery";
    }

    @Override
    public String GUID() {
        return "mana_battery_trait";
    }

    @Override
    public IStatEffect getEffect() {
        return ManaBatteryEffect.INSTANCE;
    }
}


