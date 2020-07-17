package com.robertx22.mine_and_slash.vanilla_mc.blocks.conditions;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.text.ITextComponent;

public abstract class LootCrateCondition {

    public abstract boolean canOpenCrate(PlayerEntity player, TileEntity box);

    public abstract ITextComponent tellCondition();
}
