package com.robertx22.mine_and_slash.database.currency;

import com.robertx22.mine_and_slash.database.currency.base.CurrencyItem;
import com.robertx22.mine_and_slash.database.currency.base.ICurrencyItemEffect;
import com.robertx22.mine_and_slash.database.currency.base.IShapedRecipe;
import com.robertx22.mine_and_slash.database.currency.loc_reqs.BaseLocRequirement;
import com.robertx22.mine_and_slash.database.currency.loc_reqs.GearEnumLocReq;
import com.robertx22.mine_and_slash.database.currency.loc_reqs.SimpleGearLocReq;
import com.robertx22.mine_and_slash.database.currency.loc_reqs.item_types.GearReq;
import com.robertx22.mine_and_slash.items.SimpleMatItem;
import com.robertx22.mine_and_slash.items.ores.ItemOre;
import com.robertx22.mine_and_slash.mmorpg.Ref;
import com.robertx22.mine_and_slash.mmorpg.registers.common.ModItems;
import com.robertx22.mine_and_slash.saveclasses.item_classes.GearItemData;
import com.robertx22.mine_and_slash.uncommon.datasaving.Gear;
import com.robertx22.mine_and_slash.uncommon.interfaces.data_items.IRarity;
import net.minecraft.data.ShapedRecipeBuilder;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;

import java.util.Arrays;
import java.util.List;

public class OrbOfDisorder extends CurrencyItem implements ICurrencyItemEffect, IShapedRecipe {
    @Override
    public String GUID() {
        return "currency/randomize_affixes";
    }

    private static final String name = Ref.MODID + ":currency/randomize_affixes";

    public OrbOfDisorder() {

        super(name);

    }

    @Override
    public ItemStack ModifyItem(ItemStack stack, ItemStack Currency) {
        GearItemData gear = Gear.Load(stack);
        gear.suffixes.forEach(x -> x.RerollFully(gear));
        gear.prefixes.forEach(x -> x.RerollFully(gear));
        Gear.Save(stack, gear);

        return stack;
    }

    @Override
    public List<BaseLocRequirement> requirements() {
        return Arrays.asList(GearReq.INSTANCE, GearEnumLocReq.AFFIXES, SimpleGearLocReq.HAS_SUFFIX);
    }

    @Override
    public int getTier() {
        return 0;
    }

    @Override
    public int getRarityRank() {
        return IRarity.Common;
    }

    @Override
    public List<String> loreLines() {
        return Arrays.asList("There is always a better choice");
    }

    @Override
    public String locNameForLangFile() {
        return nameColor + "Orb Of Disorder";
    }

    @Override
    public String locDescForLangFile() {
        return "Re-rolls All affixes";
    }

    @Override
    public int instabilityAddAmount() {
        return 25;
    }

    @Override
    public ShapedRecipeBuilder getRecipe() {
        return shaped(ModItems.ORB_OF_EVER_CHANGING_SUFFIX.get())
            .key('#', SimpleMatItem.INFUSED_IRON)
            .key('t', ModItems.ORB_OF_TRANSMUTATION.get())
            .key('v', Items.GOLD_NUGGET)
            .key('o', ItemOre.ItemOres.get(IRarity.Common))
            .patternLine("o#o")
            .patternLine("oto")
            .patternLine("vvv")
            .addCriterion("player_level", trigger());
    }

}
