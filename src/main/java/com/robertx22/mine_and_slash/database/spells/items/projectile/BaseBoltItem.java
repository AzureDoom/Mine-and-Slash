package com.robertx22.mine_and_slash.database.spells.items.projectile;

import com.robertx22.mine_and_slash.database.spells.items.BaseSpellItem;

public abstract class BaseBoltItem extends BaseSpellItem {

    public BaseBoltItem() {
        super();

    }

    @Override
    public String locNameForLangFile() {
        return color + this.Spell().getElement().dmgName + " Bolt";
    }
}