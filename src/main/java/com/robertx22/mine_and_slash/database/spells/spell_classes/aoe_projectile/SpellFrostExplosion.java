package com.robertx22.mine_and_slash.database.spells.spell_classes.aoe_projectile;

import com.robertx22.mine_and_slash.database.spells.entities.aoe.EntityFrostExplosion;
import com.robertx22.mine_and_slash.database.spells.entities.bases.EntityElementalBolt;
import com.robertx22.mine_and_slash.database.spells.items.aoe_projectile.ItemFrostExplosion;
import com.robertx22.mine_and_slash.uncommon.enumclasses.Elements;
import net.minecraft.item.Item;
import net.minecraft.world.World;

public class SpellFrostExplosion extends BaseAoeSpellProjectile {

    public SpellFrostExplosion() {
        super();
    }

    @Override
    public Elements getElement() {
        return Elements.Water;
    }

    @Override
    public Item getSpellItem() {
        return ItemFrostExplosion.ITEM;
    }

    @Override
    public String GUID() {
        return "FrostExplosion";
    }

    @Override
    public EntityElementalBolt projectile(World world) {
        return new EntityFrostExplosion(world);
    }

}