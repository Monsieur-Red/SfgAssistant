package com.sfgassistant.models.dungeons;

import com.squareup.moshi.Json;

/**
 * Created by pierr on 30/09/2016.
 */

public class LightWorld {

    @Json(name = "D") private String dungeonLvl;
    @Json(name = "Stage") private String dungeonStage;
    @Json(name = "Opponent") private String opponentName;
    @Json(name = "Level") private String opponentLvl;
    @Json(name = "Class") private String opponentClass;
    @Json(name = "Strength") private String opponentStr;
    @Json(name = "Dexterity") private String opponentDex;
    @Json(name = "Intelligence") private String opponentIntel;
    @Json(name = "Constitution") private String opponentCons;
    @Json(name = "Luck") private String opponentLuck;
    @Json(name = "Hit Points") private String opponentHp;
    @Json(name = "Experience") private String experience;

    public String getDungeonLvl() {
        return dungeonLvl;
    }

    public String getDungeonStage() {
        return dungeonStage;
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

    public String getExperience() {
        return experience;
    }
}
