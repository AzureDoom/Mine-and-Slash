package com.robertx22.mine_and_slash.database.spells.items.aoe_projectile;

import com.robertx22.mine_and_slash.database.spells.items.BaseSpellItem;

public abstract class BaseExplosionItem extends BaseSpellItem {

    public BaseExplosionItem() {
        super();

    }

    @Override
    public String locNameForLangFile() {
        return color + this.Spell().getElement().dmgName + " Explosion";
    }
}