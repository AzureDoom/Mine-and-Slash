package com.robertx22.mine_and_slash.database.spells.entities.bases;

import com.robertx22.mine_and_slash.saveclasses.EntitySpellData;
import com.robertx22.mine_and_slash.uncommon.enumclasses.Elements;

import java.util.UUID;

public interface ISpellEntity {

    EntitySpellData getSyncedSpellData();

    ServerEntitySpellData getServerSpellData();

    void setSyncedSpellData(EntitySpellData data);

    void setServerSpellData(ServerEntitySpellData data);

    default Elements getElement() {
        return getSyncedSpellData().element;
    }

    default int getLifeInTicks() {
        return getSyncedSpellData().lifeInTicks;
    }

    default UUID getCasterUUID() {
        return getSyncedSpellData().getCasterUUID();
    }

}
