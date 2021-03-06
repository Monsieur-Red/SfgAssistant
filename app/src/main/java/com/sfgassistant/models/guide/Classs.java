package com.sfgassistant.models.guide;

import com.google.gson.annotations.SerializedName;
import com.squareup.moshi.Json;

/**
 * Created by pierr on 18/09/2016.
 */

public class Classs {

    @Json(name = "class") private String  classs;
    private String  strength;
    private String  dexterity;
    private String  intelligence;
    private String  constitution;
    private String  luck;

    public String getClasss() {
        return classs;
    }

    public String getStrength() {
        return strength;
    }

    public String getDexterity() {
        return dexterity;
    }

    public String getIntelligence() {
        return intelligence;
    }

    public String getConstitution() {
        return constitution;
    }

    public String getLuck() {
        return luck;
    }
}
