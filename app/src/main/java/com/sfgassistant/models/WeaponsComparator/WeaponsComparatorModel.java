package com.sfgassistant.models.WeaponsComparator;

/**
 * Created by pierr on 25/09/2016.
 */

public class WeaponsComparatorModel {

    private int mainAttribute;

    private int minDmg;
    private int maxDmg;
    private int weaponAttribute;
    private int gemAttribute;
    private int guildBonus;

    public WeaponsComparatorModel() {
        mainAttribute = 0;
        minDmg = 0;
        maxDmg = 0;
        weaponAttribute = 0;
        gemAttribute = 0;
        guildBonus = 0;
    }

    public int getMainAttribute() {
        return mainAttribute;
    }

    public void setMainAttribute(int mainAttribute) {
        this.mainAttribute = mainAttribute;
    }

    public int getMinDmg() {
        return minDmg;
    }

    public void setMinDmg(int minDmg) {
        this.minDmg = minDmg;
    }

    public int getMaxDmg() {
        return maxDmg;
    }

    public void setMaxDmg(int maxDmg) {
        this.maxDmg = maxDmg;
    }

    public int getWeaponAttribute() {
        return weaponAttribute;
    }

    public void setWeaponAttribute(int weaponAttribute) {
        this.weaponAttribute = weaponAttribute;
    }

    public int getGemAttribute() {
        return gemAttribute;
    }

    public void setGemAttribute(int gemAttribute) {
        this.gemAttribute = gemAttribute;
    }

    public int getGuildBonus() {
        return guildBonus;
    }

    public void setGuildBonus(int guildBonus) {
        this.guildBonus = guildBonus;
    }
}
