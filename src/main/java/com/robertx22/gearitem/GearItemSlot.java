package com.robertx22.gearitem;

import java.util.HashMap;
import java.util.List;

import com.robertx22.interfaces.IWeighted;
import com.robertx22.stats.StatMod;

import net.minecraft.item.Item;

public abstract class GearItemSlot implements IWeighted {

	public abstract String Name();

	public abstract List<Suffix> PossibleSuffixes();

	public abstract List<Prefix> PossiblePrefixes();

	public abstract List<StatMod> PrimaryStats();

	public abstract List<StatMod> PossibleSecondaryStats();

	public abstract Item DefaultItem();

	public abstract HashMap<Integer, Item> ItemsForRarities();

	public abstract int Weight();

}
