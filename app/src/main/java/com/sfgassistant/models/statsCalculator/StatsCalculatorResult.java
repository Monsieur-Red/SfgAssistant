package com.sfgassistant.models.statsCalculator;

/**
 * Created by pierr on 25/09/2016.
 */

public class StatsCalculatorResult {

    private String  dmgStat;
    private String  dmgValue;
    private String  constitution;
    private String  hitPoints;
    private String  luck;
    private String  criticalHit;

    public StatsCalculatorResult(String dmgStat, String dmgValue, String constitution, String hitPoints, String luck, String criticalHit) {
        this.dmgStat = dmgStat;
        this.dmgValue = dmgValue;
        this.constitution = constitution;
        this.hitPoints = hitPoints;
        this.luck = luck;
        this.criticalHit = criticalHit;
    }

    public String getDmgStat() {
        return dmgStat;
    }

    public String getDmgValue() {
        return dmgValue;
    }

    public String getConstitution() {
        return constitution;
    }

    public String getHitPoints() {
        return hitPoints;
    }

    public String getLuck() {
        return luck;
    }

    public String getCriticalHit() {
        return criticalHit;
    }
}
