package com.robertx22.mine_and_slash.vanilla_mc.blocks.conditions;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.StringTextComponent;

public class NoCondition extends LootCrateCondition {

    @Override
    public boolean canOpenCrate(PlayerEntity player, TileEntity box) {
        return true;
    }

    @Override
    public ITextComponent tellCondition() {
        return new StringTextComponent("");
    }
}
