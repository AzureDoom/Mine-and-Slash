package com.robertx22.db_lists;

import java.util.Arrays;
import java.util.List;

import com.robertx22.database.rarities.ItemRarity;
import com.robertx22.database.rarities.MapRarity;
import com.robertx22.database.rarities.MobRarity;
import com.robertx22.database.rarities.SpellRarity;
import com.robertx22.database.rarities.items.CommonItem;
import com.robertx22.database.rarities.items.EpicItem;
import com.robertx22.database.rarities.items.LegendaryItem;
import com.robertx22.database.rarities.items.MythicalItem;
import com.robertx22.database.rarities.items.RareItem;
import com.robertx22.database.rarities.items.UncommonItem;
import com.robertx22.database.rarities.maps.CommonMap;
import com.robertx22.database.rarities.maps.EpicMap;
import com.robertx22.database.rarities.maps.LegendaryMap;
import com.robertx22.database.rarities.maps.MythicalMap;
import com.robertx22.database.rarities.maps.RareMap;
import com.robertx22.database.rarities.maps.UncommonMap;
import com.robertx22.database.rarities.mobs.CommonMob;
import com.robertx22.database.rarities.mobs.EpicMob;
import com.robertx22.database.rarities.mobs.LegendaryMob;
import com.robertx22.database.rarities.mobs.MythicalMob;
import com.robertx22.database.rarities.mobs.RareMob;
import com.robertx22.database.rarities.mobs.UncommonMob;
import com.robertx22.database.rarities.spells.CommonSpell;
import com.robertx22.database.rarities.spells.EpicSpell;
import com.robertx22.database.rarities.spells.LegendarySpell;
import com.robertx22.database.rarities.spells.MythicalSpell;
import com.robertx22.database.rarities.spells.RareSpell;
import com.robertx22.database.rarities.spells.UncommonSpell;

public class Rarities {

    public static final int MAXIMUM_ITEM_RARITY = 5;
    public static final int MAXIMUM_Mob_RARITY = 5;

    public static List<ItemRarity> Items = Arrays.asList(new CommonItem(), new UncommonItem(), new RareItem(),
	    new EpicItem(), new LegendaryItem(), new MythicalItem());

    public static List<MapRarity> Maps = Arrays.asList(new CommonMap(), new UncommonMap(), new RareMap(), new EpicMap(),
	    new LegendaryMap(), new MythicalMap());

    public static List<MobRarity> Mobs = Arrays.asList(new CommonMob(), new RareMob(), new UncommonMob(), new EpicMob(),
	    new LegendaryMob(), new MythicalMob());

    public static List<SpellRarity> Spells = Arrays.asList(new CommonSpell(), new UncommonSpell(), new RareSpell(),
	    new EpicSpell(), new LegendarySpell(), new MythicalSpell());

}