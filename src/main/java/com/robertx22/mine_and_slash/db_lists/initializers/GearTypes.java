package com.robertx22.mine_and_slash.db_lists.initializers;

import com.robertx22.mine_and_slash.database.gearitemslots.bases.GearItemSlot;
import com.robertx22.mine_and_slash.database.gearitemslots.cloth.ClothSlippers;
import com.robertx22.mine_and_slash.database.gearitemslots.cloth.OccultistRobes;
import com.robertx22.mine_and_slash.database.gearitemslots.cloth.SilkPants;
import com.robertx22.mine_and_slash.database.gearitemslots.cloth.SorcererCirclet;
import com.robertx22.mine_and_slash.database.gearitemslots.curios.LifeNecklace;
import com.robertx22.mine_and_slash.database.gearitemslots.curios.LifeRing;
import com.robertx22.mine_and_slash.database.gearitemslots.curios.OccultNecklace;
import com.robertx22.mine_and_slash.database.gearitemslots.curios.OccultRing;
import com.robertx22.mine_and_slash.database.gearitemslots.leather.HunterHood;
import com.robertx22.mine_and_slash.database.gearitemslots.leather.LeatherLeggings;
import com.robertx22.mine_and_slash.database.gearitemslots.leather.RawhideBoots;
import com.robertx22.mine_and_slash.database.gearitemslots.leather.WildTunic;
import com.robertx22.mine_and_slash.database.gearitemslots.offhand.Buckler;
import com.robertx22.mine_and_slash.database.gearitemslots.offhand.SpiritShield;
import com.robertx22.mine_and_slash.database.gearitemslots.offhand.TowerShield;
import com.robertx22.mine_and_slash.database.gearitemslots.plate.IronChestplate;
import com.robertx22.mine_and_slash.database.gearitemslots.plate.IronGreaves;
import com.robertx22.mine_and_slash.database.gearitemslots.plate.IronHelmet;
import com.robertx22.mine_and_slash.database.gearitemslots.plate.IronLegguards;
import com.robertx22.mine_and_slash.database.gearitemslots.weapons.Crossbow;
import com.robertx22.mine_and_slash.database.gearitemslots.weapons.HunterBow;
import com.robertx22.mine_and_slash.database.gearitemslots.weapons.melee.GemstoneSword;
import com.robertx22.mine_and_slash.database.gearitemslots.weapons.melee.PrimitiveAxe;
import com.robertx22.mine_and_slash.database.gearitemslots.weapons.melee.SageWand;
import com.robertx22.mine_and_slash.registry.ISlashRegistryInit;

import java.util.ArrayList;
import java.util.List;

public class GearTypes implements ISlashRegistryInit {

    @Override
    public void registerAll() {
        List<GearItemSlot> All = new ArrayList<GearItemSlot>() {
            {
                {
                    add(IronGreaves.INSTANCE);
                    add(IronLegguards.INSTANCE);
                    add(IronHelmet.INSTANCE);
                    add(IronChestplate.INSTANCE);

                    add(RawhideBoots.INSTANCE);
                    add(LeatherLeggings.INSTANCE);
                    add(HunterHood.INSTANCE);
                    add(WildTunic.INSTANCE);

                    add(ClothSlippers.INSTANCE);
                    add(OccultistRobes.INSTANCE);
                    add(SorcererCirclet.INSTANCE);
                    add(SilkPants.INSTANCE);

                    add(TowerShield.INSTANCE);
                    add(SpiritShield.INSTANCE);
                    add(Buckler.INSTANCE);

                    add(OccultRing.INSTANCE);
                    add(LifeRing.INSTANCE);
                    add(LifeNecklace.INSTANCE);
                    add(OccultNecklace.INSTANCE);

                    add(HunterBow.INSTANCE);
                    add(SageWand.INSTANCE);
                    add(PrimitiveAxe.INSTANCE);
                    add(Crossbow.INSTANCE);
                    add(GemstoneSword.INSTANCE);

                }

            }
        };

        All.forEach(x -> x.registerToSlashRegistry());

    }
}
