package com.robertx22.mine_and_slash.vanilla_mc.potion_effects.bases;

import com.robertx22.mine_and_slash.saveclasses.gearitem.gear_bases.TooltipInfo;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.util.text.TextFormatting;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

public class OnTickAction {

    public Function<PotionContext, PotionContext> action;
    Function<TooltipInfo, List<ITextComponent>> tooltip;

    public OnTickAction(Function<PotionContext, PotionContext> action,
                        Function<TooltipInfo, List<ITextComponent>> tooltip) {

        this.action = action;
        this.tooltip = tooltip;

    }

    public final void onTick(PotionContext ctx) {
        action.apply(ctx);
    }

    public List<ITextComponent> getTooltip(TooltipInfo info, BasePotionEffect effect) {

        List<ITextComponent> list = new ArrayList<>();

        if (tooltip != null) {
            list.add(new StringTextComponent(TextFormatting.YELLOW + "Effect occurs every " + effect.getTickRate(info.player) + " ticks."));
            list.addAll(tooltip.apply(info));
        }

        return list;
    }
}
