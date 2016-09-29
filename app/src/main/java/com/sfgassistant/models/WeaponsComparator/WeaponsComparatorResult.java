package com.sfgassistant.models.WeaponsComparator;

/**
 * Created by pierr on 25/09/2016.
 */

public class WeaponsComparatorResult {

    private String minDmg;
    private String maxDmg;
    private String averageDmg;
    private String weaponAttribute;
    private String attributeTotal;

    public WeaponsComparatorResult(String minDmg, String maxDmg, String averageDmg, String weaponAttribute, String attributeTotal) {
        this.minDmg = minDmg;
        this.maxDmg = maxDmg;
        this.averageDmg = averageDmg;
        this.weaponAttribute = weaponAttribute;
        this.attributeTotal = attributeTotal;
    }

    public String getMinDmg() {
        return minDmg;
    }

    public String getMaxDmg() {
        return maxDmg;
    }

    public String getAverageDmg() {
        return averageDmg;
    }

    public String getWeaponAttribute() {
        return weaponAttribute;
    }

    public String getAttributeTotal() {
        return attributeTotal;
    }
}
