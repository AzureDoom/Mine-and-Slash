package com.robertx22.database.rarities.items;

import com.robertx22.database.MinMax;
import com.robertx22.database.rarities.ItemRarity;
import com.robertx22.database.rarities.base.BaseCommon;
import com.robertx22.mmorpg.ModConfig;

public class CommonItem extends BaseCommon implements ItemRarity {

    @Override
    public int AffixChance() {
	return 10;
    }

    @Override
    public MinMax SecondaryStatsAmount() {
	return new MinMax(0, 1);
    }

    @Override
    public MinMax StatPercents() {
	return new MinMax(3, 60);
    }

    @Override
    public int SetChance() {
	return 5;
    }

    @Override
    public float specialItemChance() {
	return 0.5F;
    }

    @Override
    public int Weight() {
	return ModConfig.RarityWeightConfig.ITEMS.COMMON_WEIGHT;
    }
}
