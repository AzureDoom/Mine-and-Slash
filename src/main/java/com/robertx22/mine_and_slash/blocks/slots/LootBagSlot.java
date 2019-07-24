package com.robertx22.mine_and_slash.blocks.slots;

import com.robertx22.mine_and_slash.items.bags.BaseSlot;
import com.robertx22.mine_and_slash.uncommon.item_filters.bases.ItemFilterGroup;
import net.minecraft.item.ItemStack;
import net.minecraftforge.items.IItemHandler;

public class LootBagSlot extends BaseSlot {

    public LootBagSlot(IItemHandler itemHandler, int index, int xPosition,
                       int yPosition) {
        super(itemHandler, index, xPosition, yPosition);

    }

    @Override
    public boolean isItemValid(ItemStack stack) {
        return ItemFilterGroup.LOOT_BAG.anyMatchesFilter(stack);
    }

}