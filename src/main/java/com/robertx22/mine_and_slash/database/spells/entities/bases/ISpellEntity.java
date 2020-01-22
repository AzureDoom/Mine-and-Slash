package com.robertx22.mine_and_slash.database.spells.entities.bases;

import com.robertx22.mine_and_slash.saveclasses.EntitySpellData;
import com.robertx22.mine_and_slash.uncommon.enumclasses.Elements;
import net.minecraft.entity.LivingEntity;
import net.minecraftforge.fml.common.registry.IEntityAdditionalSpawnData;

import java.util.UUID;

public interface ISpellEntity extends IEntityAdditionalSpawnData {

    default void initSpellEntity() {
    }

    EntitySpellData getSyncedSpellData();

    ServerEntitySpellData getServerSpellData();

    void setSyncedSpellData(EntitySpellData data);

    void setServerSpellData(ServerEntitySpellData data);

    default int getDefaultLifeInTicks() {
        return 200;
    }

    default Elements getElement() {
        return getSyncedSpellData().element;
    }

    default int getLifeInTicks() {
        return getSyncedSpellData().lifeInTicks;
    }

    default UUID getCasterUUID() {
        return getSyncedSpellData().getCasterUUID();
    }

    default void activateEffectOn(LivingEntity entity) {
        this.getServerSpellData().effect.Activate(this.getServerSpellData().data, (LivingEntity) entity);
    }

}