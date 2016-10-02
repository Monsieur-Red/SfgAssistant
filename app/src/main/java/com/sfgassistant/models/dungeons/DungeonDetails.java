package com.sfgassistant.models.dungeons;

import com.squareup.moshi.Json;

/**
 * Created by pierr on 30/09/2016.
 */

public class DungeonDetails {

    private String  level;
    private String  name;
    private String  description;
    private String  key;
    @Json(name = "key_description") private String keyDescription;

    public String getLevel() {
        return level;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public String getKey() {
        return key;
    }

    public String getKeyDescription() {
        return keyDescription;
    }
}
