package com.robertx22.mine_and_slash.uncommon.capability.bases;

import com.robertx22.mine_and_slash.vanilla_mc.packets.sync_cap.MobCaps;
import net.minecraft.nbt.CompoundNBT;

public interface ICommonMobCap extends ICommonCap {
    CompoundNBT saveToNBT();

    void loadFromNBT(CompoundNBT value);

    MobCaps getCapType();

}
