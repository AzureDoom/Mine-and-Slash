package com.robertx22.database.rarities.items;

import com.robertx22.database.MinMax;
import com.robertx22.database.rarities.ItemRarity;
import com.robertx22.database.rarities.base.BaseEpic;
import com.robertx22.mmorpg.ModConfig;

public class EpicItem extends BaseEpic implements ItemRarity {
    public EpicItem() {
    }

    @Override
    public int AffixChance() {
	return 60;
    }

    @Override
    public MinMax SecondaryStatsAmount() {
	return new MinMax(2, 3);
    }

    @Override
    public MinMax StatPercents() {
	return new MinMax(20, 75);
    }

    @Override
    public int SetChance() {
	return 30;
    }

    @Override
    public float specialItemChance() {
	return 4.5F;
    }

    @Override
    public int Weight() {
	return ModConfig.RarityWeightConfig.ITEMS.EPIC_WEIGHT;
    }
}
