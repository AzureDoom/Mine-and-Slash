package com.robertx22.mine_and_slash.uncommon.interfaces;

import com.robertx22.mine_and_slash.uncommon.localization.CLOC;
import net.minecraft.util.text.ITextComponent;

public interface IAutoLocDesc extends IBaseAutoLoc {

    public default String getDescGroupName() {
        return locDescGroup().name()
            .toUpperCase()
            .replaceAll("_", " ") + " - DESCRIPTIONS";
    }

    public AutoLocGroup locDescGroup();

    String locDescLangFileGUID();

    String locDescForLangFile();

    default boolean shouldRegisterLangDesc() {
        return true;
    }

    public default ITextComponent locDesc() {
        return CLOC.blank(getFormatedForLangFile(formattedLocDescLangFileGUID()));
    }

    public default String formattedLocDescLangFileGUID() {
        return getPrefix() + getFormatedForLangFile(locDescLangFileGUID());
    }

}

