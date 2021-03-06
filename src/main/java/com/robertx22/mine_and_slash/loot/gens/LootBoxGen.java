package com.robertx22.mine_and_slash.loot.gens;

import com.robertx22.mine_and_slash.config.forge.ModConfig;
import com.robertx22.mine_and_slash.items.misc.ItemLootbox;
import com.robertx22.mine_and_slash.loot.LootInfo;
import com.robertx22.mine_and_slash.loot.blueprints.ItemBlueprint;
import com.robertx22.mine_and_slash.uncommon.enumclasses.LootType;
import com.robertx22.mine_and_slash.uncommon.utilityclasses.RandomUtils;
import net.minecraft.item.ItemStack;

public class LootBoxGen extends BaseLootGen<ItemBlueprint> {

    public LootBoxGen(LootInfo info) {
        super(info);
    }

    @Override
    public float baseDropChance() {
        return ModConfig.INSTANCE.DropRates.LOOTBOX_DROPRATE.get().floatValue();

    }

    @Override
    public LootType lootType() {
        return LootType.LootBox;
    }

    @Override
    public ItemStack generateOne() {
        return new ItemStack(RandomUtils.weightedRandom(ItemLootbox.Items.values()));

    }

}