package com.sfgassistant.models.dungeons;

import com.squareup.moshi.Json;

/**
 * Created by pierr on 30/09/2016.
 */

public class TowerStage {

    @Json(name = "Stage") private String towerStage;
    @Json(name = "Opponent") private String opponentName;
    @Json(name = "Level") private String opponentLvl;
    @Json(name = "Class") private String opponentClass;
    @Json(name = "Strength") private String opponentStr;
    @Json(name = "Dexterity") private String opponentDex;
    @Json(name = "Intelligence") private String opponentIntel;
    @Json(name = "Constitution") private String opponentCons;
    @Json(name = "Luck") private String opponentLuck;
    @Json(name = "Hit Points") private String opponentHp;
    @Json(name = "Gold") private String gold;

    public String getTowerStage() {
        return towerStage;
    }

    public String getOpponentName() {
        return opponentName;
    }

    public String getOpponentLvl() {
        return opponentLvl;
    }

    public String getOpponentClass() {
        return opponentClass;
    }

    public String getOpponentStr() {
        return opponentStr;
    }

    public String getOpponentDex() {
        return opponentDex;
    }

    public String getOpponentIntel() {
        return opponentIntel;
    }

    public String getOpponentCons() {
        return opponentCons;
    }

    public String getOpponentLuck() {
        return opponentLuck;
    }

    public String getOpponentHp() {
        return opponentHp;
    }

    public String getGold() {
        return gold;
    }
}
