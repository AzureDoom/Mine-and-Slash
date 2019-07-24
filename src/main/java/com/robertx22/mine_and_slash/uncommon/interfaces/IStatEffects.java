package com.robertx22.mine_and_slash.uncommon.interfaces;

import com.robertx22.mine_and_slash.database.IGUID;

import java.util.List;

public interface IStatEffects extends IGUID {

    public abstract List<IStatEffect> GetEffects();
}
