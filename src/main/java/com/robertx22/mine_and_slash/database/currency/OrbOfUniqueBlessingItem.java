package com.robertx22.mine_and_slash.database.currency;

import com.robertx22.mine_and_slash.database.currency.base.CurrencyItem;
import com.robertx22.mine_and_slash.database.currency.base.ICurrencyItemEffect;
import com.robertx22.mine_and_slash.database.currency.base.IShapedRecipe;
import com.robertx22.mine_and_slash.database.currency.loc_reqs.BaseLocRequirement;
import com.robertx22.mine_and_slash.database.currency.loc_reqs.SimpleGearLocReq;
import com.robertx22.mine_and_slash.database.currency.loc_reqs.item_types.GearReq;
import com.robertx22.mine_and_slash.items.SimpleMatItem;
import com.robertx22.mine_and_slash.mmorpg.Ref;
import com.robertx22.mine_and_slash.mmorpg.registers.common.ModItems;
import com.robertx22.mine_and_slash.saveclasses.gearitem.gear_bases.IRerollable;
import com.robertx22.mine_and_slash.saveclasses.item_classes.GearItemData;
import com.robertx22.mine_and_slash.uncommon.datasaving.Gear;
import com.robertx22.mine_and_slash.uncommon.interfaces.IRenamed;
import net.minecraft.data.ShapedRecipeBuilder;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;

import java.util.Arrays;
import java.util.List;

public class OrbOfUniqueBlessingItem extends CurrencyItem implements ICurrencyItemEffect, IRenamed, IShapedRecipe {
    @Override
    public String GUID() {
        return "currency/reroll_unique_numbers";
    }

    private static final String name = Ref.MODID + ":currency/reroll_unique_numbers";

    @Override
    public List<String> oldNames() {
        return Arrays.asList(Ref.MODID + ":reroll_unique_numbers");
    }

    public OrbOfUniqueBlessingItem() {

        super(name);

    }

    @Override
    public ItemStack ModifyItem(ItemStack stack, ItemStack Currency) {

        GearItemData gear = Gear.Load(stack);

        for (IRerollable rel : gear.GetAllRerollable()) {
            rel.RerollNumbers(gear);
        }
        Gear.Save(stack, gear);

        return stack;
    }

    @Override
    public List<BaseLocRequirement> requirements() {
        return Arrays.asList(GearReq.INSTANCE, SimpleGearLocReq.IS_UNIQUE);
    }

    @Override
    public int getTier() {
        return 4;
    }

    @Override
    public int getRarityRank() {
        return Epic;
    }

    @Override
    public List<String> loreLines() {
        return Arrays.asList("Anything can change.");
    }

    @Override
    public String locNameForLangFile() {
        return nameColor + "Orb Of Unique Blessing";
    }

    @Override
    public String locDescForLangFile() {
        return "Re-rolls unique stat numbers";
    }

    @Override
    public int instabilityAddAmount() {
        return 100;
    }

    @Override
    public ShapedRecipeBuilder getRecipe() {
        return shaped(ModItems.ORB_OF_UNIQUE_BLESSING.get())
            .key('#', SimpleMatItem.GOLDEN_ORB)
            .key('t', ModItems.ORB_OF_BLESSING.get())
            .key('v', Items.GOLD_INGOT)
            .key('o', ModItems.RARE_MAGIC_ESSENCE.get())
            .patternLine("o#o")
            .patternLine("oto")
            .patternLine("v#v")
            .addCriterion("player_level", trigger());
    }

}