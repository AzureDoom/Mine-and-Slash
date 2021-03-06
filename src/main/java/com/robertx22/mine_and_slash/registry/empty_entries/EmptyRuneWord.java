package com.robertx22.mine_and_slash.registry.empty_entries;

import com.robertx22.mine_and_slash.database.runes.base.BaseRune;
import com.robertx22.mine_and_slash.database.runewords.RuneWord;
import com.robertx22.mine_and_slash.database.stats.StatMod;

import java.util.ArrayList;
import java.util.List;

public class EmptyRuneWord extends RuneWord {
    private EmptyRuneWord() {
    }

    public static EmptyRuneWord getInstance() {
        return SingletonHolder.INSTANCE;
    }

    @Override
    public List<StatMod> mods() {
        return new ArrayList<>();
    }

    @Override
    public String GUID() {
        return "";
    }

    @Override
    public List<BaseRune> runes() {
        return new ArrayList<>();
    }

    @Override
    public String locNameForLangFile() {
        return "";
    }

    private static class SingletonHolder {
        private static final EmptyRuneWord INSTANCE = new EmptyRuneWord();
    }
}
