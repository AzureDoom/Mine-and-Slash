package com.robertx22.mine_and_slash.uncommon.stat_calculation;

import com.robertx22.mine_and_slash.config.base_player_stat.BasePlayerStatContainer;
import com.robertx22.mine_and_slash.database.stats.Stat;
import com.robertx22.mine_and_slash.database.stats.StatMod;
import com.robertx22.mine_and_slash.saveclasses.StatData;
import com.robertx22.mine_and_slash.saveclasses.Unit;
import com.robertx22.mine_and_slash.saveclasses.gearitem.StatModData;
import com.robertx22.mine_and_slash.saveclasses.gearitem.gear_bases.IStatModsContainer;
import com.robertx22.mine_and_slash.saveclasses.item_classes.GearItemData;
import com.robertx22.mine_and_slash.uncommon.capability.entity.EntityCap.UnitData;
import net.minecraft.entity.Entity;
import net.minecraft.util.math.MathHelper;

import java.util.List;
import java.util.Map;

public class PlayerStatUtils {

    public static void AddPlayerBaseStats(UnitData data, Unit unit) {
        BasePlayerStatContainer.INSTANCE.applyStats(data);
    }

    // if at end of stat calculation you still don't meet the gear requirements, apply penalty
    public static void applyRequirementsUnmetPenalty(Entity en, UnitData data, List<GearItemData> gears) {

        float penalty = 1;
        for (GearItemData gear : gears) {
            if (!gear.meetsRequirements(data)) {
                penalty -= 0.25F;
            }
        }

        penalty = MathHelper.clamp(penalty, 0.1F, 1);

        if (penalty < 1) {

            for (Map.Entry<String, StatData> entry : data.getUnit()
                .getStats()
                .entrySet()) {
                if (entry.getValue()
                    .isMoreThanZero()) {
                    entry.getValue()
                        .setValue(entry.getValue()
                            .getAverageValue() * penalty);
                }
            }
        }

    }

    public static void AddAllGearStats(Entity entity, List<GearItemData> gears, UnitData unitdata) {

        for (GearItemData gear : gears) {

            if (!gear.isIdentified()) {
                continue;
            }

            List<IStatModsContainer.LevelAndStats> levelstats = gear.GetAllStats(gear.level);

            for (IStatModsContainer.LevelAndStats datas : levelstats) {

                if (datas == null) {
                    continue;
                }

                for (StatModData data : datas.mods) {

                    try {
                        if (data == null) {
                            continue;
                        }

                        StatMod mod = data.getStatMod();

                        if (mod == null) {
                            //  System.out.println(data.baseModName + " is null");
                        } else {
                            Stat stat = data.getStatMod()
                                .GetBaseStat();

                            if (stat != null) {
                                StatData statdata = unitdata.getUnit()
                                    .getCreateStat(stat);
                                if (statdata != null) {
                                    statdata.add(data, datas.level);
                                }
                            }
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }

            }
        }

    }

}
