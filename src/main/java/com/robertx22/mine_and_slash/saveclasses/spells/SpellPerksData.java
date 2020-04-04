package com.robertx22.mine_and_slash.saveclasses.spells;

import com.robertx22.mine_and_slash.config.forge.ModConfig;
import com.robertx22.mine_and_slash.saveclasses.gearitem.gear_bases.IApplyableStats;
import com.robertx22.mine_and_slash.uncommon.capability.entity.EntityCap;
import com.robertx22.mine_and_slash.uncommon.enumclasses.SpellSchools;
import info.loenwind.autosave.annotations.Storable;
import info.loenwind.autosave.annotations.Store;

import java.util.HashMap;

@Storable
public class SpellPerksData implements IApplyableStats {

    @Store
    public int resetPoints = 0;

    @Store
    public HashMap<String, AbilityData> map = new HashMap<>();

    @Store
    public HashMap<String, Integer> schoolPoints = new HashMap<>();

    @Override
    public void applyStats(EntityCap.UnitData data, int level) {

        schoolPoints.entrySet()
            .forEach(x -> {

                SpellSchools school = SpellSchools.valueOf(x.getKey());
                int points = x.getValue();

                school.getStatsFor(points)
                    .forEach(s -> {
                        s.applyStats(data);
                    });

            });

    }

    public void addSchoolPoint(SpellSchools school) {
        int points = schoolPoints.getOrDefault(school.id, 0) + 1;
        schoolPoints.put(school.id, points);
    }

    public void removeSchoolPoint(SpellSchools school) {
        int points = schoolPoints.getOrDefault(school.id, 0) - 1;
        schoolPoints.put(school.id, points);
    }

    public int getAllocatedAbilityPoints() {

        int points = 0;

        for (AbilityData x : map.values()) {
            if (x.isValid()) {
                points += x.currentLvl;
            }
        }

        for (Integer x : this.schoolPoints.values()) {
            points += x;
        }

        return points;
    }

    public int getTotalAllowedAbilityPoints(EntityCap.UnitData data) {

        int perlvl = (int) ((float) ModConfig.INSTANCE.Server.SPELL_POINTS_AT_MAX_LEVEL.get() / (float) ModConfig.INSTANCE.Server.MAXIMUM_PLAYER_LEVEL.get() * data.getLevel());

        int starting = ModConfig.INSTANCE.Server.STARTING_SPELL_POINTS.get();

        return starting + perlvl;

    }

    public int getFreeAbilityPoints(EntityCap.UnitData data) {
        return getTotalAllowedAbilityPoints(data) - getAllocatedAbilityPoints();
    }

    public boolean canAddPoints(IAbility ability) {

        if (ability.getRequiredAbility() != null) {
            if (getLevelOf(ability.getRequiredAbility()) < 1) {
                return false;
            }
        }

        int current = schoolPoints.getOrDefault(ability.getSchool().id, 0);
        int needed = ability.getSchoolPointsNeeded();

        return current >= needed;

    }

    public int getLevelOf(IAbility ability) {
        return map.getOrDefault(ability.GUID(), EMPTY_ABILITY).currentLvl;
    }

    public int getLevelOf(String id) {
        return map.getOrDefault(id, EMPTY_ABILITY).currentLvl;
    }

    public boolean isAllocated(IAbility ability) {
        return getLevelOf(ability) > 0;
    }

    public boolean isAllocated(String id) {
        return getLevelOf(id) > 0;
    }

    public void addPoint(IAbility ability) {

        if (!map.containsKey(ability.GUID())) {
            map.put(ability.GUID(), new AbilityData(ability));
        }

        map.get(ability.GUID()).currentLvl++;

    }

    public void removePoint(IAbility ability) {
        if (!map.containsKey(ability.GUID())) {
            map.put(ability.GUID(), new AbilityData(ability));
        }
        map.get(ability.GUID()).currentLvl--;
    }

    public void reset() {
        this.map.clear();
        this.schoolPoints.clear();

    }

    private static AbilityData EMPTY_ABILITY = new AbilityData();

}
