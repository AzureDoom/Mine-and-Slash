package com.robertx22.mine_and_slash.items.gearitems.baubles;

import com.robertx22.mine_and_slash.a_libraries.curios.interfaces.ICharm;
import com.robertx22.mine_and_slash.db_lists.Rarities;
import com.robertx22.mine_and_slash.items.gearitems.bases.BaseBaublesItem;
import com.robertx22.mine_and_slash.saveclasses.gearitem.gear_bases.Rarity;
import net.minecraft.item.Item;

import java.util.HashMap;

public class ItemCharm extends BaseBaublesItem implements ICharm {
    public static HashMap<Integer, Item> Items = new HashMap<Integer, Item>();

    public ItemCharm(int rar) {
        super(rar);
    }

    @Override
    public String locNameForLangFile() {
        Rarity rar = Rarities.Gears.get(rarity);
        return rar.textFormatting() + "Charm";
    }

}
