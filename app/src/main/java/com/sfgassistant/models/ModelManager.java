package com.sfgassistant.models;

import android.content.res.AssetManager;

import com.google.gson.reflect.TypeToken;
import com.sfgassistant.models.dungeons.DungeonDetails;
import com.sfgassistant.models.dungeons.Dungeon;
import com.sfgassistant.models.dungeons.TowerStage;
import com.sfgassistant.models.guide.Classs;
import com.sfgassistant.models.guide.Enchantment;
import com.sfgassistant.models.guide.Race;
import com.sfgassistant.utils.Constants;
import com.sfgassistant.utils.Tools;
import com.squareup.moshi.JsonAdapter;
import com.squareup.moshi.Moshi;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

/**
 * Created by pierr on 18/09/2016.
 */

@SuppressWarnings("unchecked")
public class ModelManager {

    private AssetManager assetManager;
    private Moshi moshi;
    private String language;

    public ModelManager(AssetManager assetManager) {
        this.assetManager = assetManager;
        moshi = new Moshi.Builder().build();
        language = Locale.getDefault().getLanguage();
    }

    public List<Race> getRaces() {
        List<Race> races = new ArrayList<>();
        JsonAdapter<List> jsonAdapter = moshi.adapter(new TypeToken<List<Race>>(){}.getType());
        String file;

        switch (language) {
            case Constants.LANGUAGE_EN:
                file = Constants.FILE_JSON_RACES_EN;
                break;
            case Constants.LANGUAGE_FR:
                file = Constants.FILE_JSON_RACES_FR;
                break;
            default:
                file = Constants.FILE_JSON_RACES_EN;
                break;
        }

        try {
                races = jsonAdapter.fromJson(Tools.loadJSONFromAsset(assetManager, file));
        } catch (IOException e) {
            e.printStackTrace();
        }

        return races;
    }

    public List<Classs> getClasses() {
        List<Classs> classes = new ArrayList<>();
        JsonAdapter<List> jsonAdapter = moshi.adapter(new TypeToken<List<Classs>>(){}.getType());
        String file;

        switch (language) {
            case Constants.LANGUAGE_EN:
                file = Constants.FILE_JSON_CLASSES_EN;
                break;
            case Constants.LANGUAGE_FR:
                file = Constants.FILE_JSON_CLASSES_FR;
                break;
            default:
                file = Constants.FILE_JSON_CLASSES_EN;
                break;
        }

        try {
            classes = jsonAdapter.fromJson(Tools.loadJSONFromAsset(assetManager, file));
        } catch (IOException e) {
            e.printStackTrace();
        }

        return classes;
    }

    public List<Enchantment> getEnchantments() {
        List<Enchantment>   enchantments = new ArrayList<>();
        JsonAdapter<List> jsonAdapter = moshi.adapter(new TypeToken<List<Enchantment>>(){}.getType());
        String file;

        switch (language) {
            case Constants.LANGUAGE_EN:
                file = Constants.FILE_JSON_ENCHANTMENTS_EN;
                break;
            case Constants.LANGUAGE_DE:
                file = Constants.FILE_JSON_ENCHANTMENTS_DE;
                break;
            case Constants.LANGUAGE_FR:
                file = Constants.FILE_JSON_ENCHANTMENTS_FR;
                break;
            default:
                file = Constants.FILE_JSON_ENCHANTMENTS_EN;
                break;
        }

        try {
            enchantments = jsonAdapter.fromJson(Tools.loadJSONFromAsset(assetManager, file));
        } catch (IOException e) {
            e.printStackTrace();
        }

        return enchantments;
    }

    public List<Dungeon> getLightWorldDungeons() {
        List<Dungeon> Dungeons = new ArrayList<>();
        JsonAdapter<List> jsonAdapter = moshi.adapter(new TypeToken<List<Dungeon>>(){}.getType());
        String file;

        switch (language) {
            case Constants.LANGUAGE_EN:
                file = Constants.FILE_JSON_DUNGEONS_LIGHT_EN;
                break;
            case Constants.LANGUAGE_DE:
                file = Constants.FILE_JSON_DUNGEONS_LIGHT_DE;
                break;
            case Constants.LANGUAGE_FR:
                file = Constants.FILE_JSON_DUNGEONS_LIGHT_FR;
                break;
            default:
                file = Constants.FILE_JSON_DUNGEONS_LIGHT_EN;
                break;
        }

        try {
            Dungeons = jsonAdapter.fromJson(Tools.loadJSONFromAsset(assetManager, file));
        } catch (IOException e) {
            e.printStackTrace();
        }

        return Dungeons;
    }

    public List<DungeonDetails> getLightWorldDungeonsDetails() {
        List<DungeonDetails> lightWorldsDetails = new ArrayList<>();
        JsonAdapter<List> jsonAdapter = moshi.adapter(new TypeToken<List<DungeonDetails>>(){}.getType());
        String file;

        switch (language) {
            case Constants.LANGUAGE_EN:
                file = Constants.FILE_JSON_DUNGEONS_LIGHT_DETAILS_EN;
                break;
            case Constants.LANGUAGE_DE:
                file = Constants.FILE_JSON_DUNGEONS_LIGHT_DETAILS_DE;
                break;
            case Constants.LANGUAGE_FR:
                file = Constants.FILE_JSON_DUNGEONS_LIGHT_DETAILS_FR;
                break;
            default:
                file = Constants.FILE_JSON_DUNGEONS_LIGHT_DETAILS_EN;
                break;
        }

        try {
            lightWorldsDetails = jsonAdapter.fromJson(Tools.loadJSONFromAsset(assetManager, file));
        } catch (IOException e) {
            e.printStackTrace();
        }

        return lightWorldsDetails;
    }

    public List<Dungeon> getShadowWorldDungeons() {
        List<Dungeon> Dungeons = new ArrayList<>();
        JsonAdapter<List> jsonAdapter = moshi.adapter(new TypeToken<List<Dungeon>>(){}.getType());
        String file;

        switch (language) {
            case Constants.LANGUAGE_EN:
                file = Constants.FILE_JSON_DUNGEONS_SHADOW_EN;
                break;
            case Constants.LANGUAGE_DE:
                file = Constants.FILE_JSON_DUNGEONS_SHADOW_DE;
                break;
            case Constants.LANGUAGE_FR:
                file = Constants.FILE_JSON_DUNGEONS_SHADOW_FR;
                break;
            default:
                file = Constants.FILE_JSON_DUNGEONS_SHADOW_EN;
                break;
        }

        try {
            Dungeons = jsonAdapter.fromJson(Tools.loadJSONFromAsset(assetManager, file));
        } catch (IOException e) {
            e.printStackTrace();
        }

        return Dungeons;
    }

    public List<DungeonDetails> getShadowWorldDungeonsDetails() {
        List<DungeonDetails> lightWorldsDetails = new ArrayList<>();
        JsonAdapter<List> jsonAdapter = moshi.adapter(new TypeToken<List<DungeonDetails>>(){}.getType());
        String file;

        switch (language) {
            case Constants.LANGUAGE_EN:
                file = Constants.FILE_JSON_DUNGEONS_SHADOW_DETAILS_EN;
                break;
            case Constants.LANGUAGE_DE:
                file = Constants.FILE_JSON_DUNGEONS_SHADOW_DETAILS_DE;
                break;
            case Constants.LANGUAGE_FR:
                file = Constants.FILE_JSON_DUNGEONS_SHADOW_DETAILS_FR;
                break;
            default:
                file = Constants.FILE_JSON_DUNGEONS_SHADOW_DETAILS_EN;
                break;
        }

        try {
            lightWorldsDetails = jsonAdapter.fromJson(Tools.loadJSONFromAsset(assetManager, file));
        } catch (IOException e) {
            e.printStackTrace();
        }

        return lightWorldsDetails;
    }

    public List<TowerStage> getTowerStages() {
        List<TowerStage>    towerStages = new ArrayList<>();
        JsonAdapter<List> jsonAdapter = moshi.adapter(new TypeToken<List<TowerStage>>(){}.getType());
        String file;

        switch (language) {
            case Constants.LANGUAGE_EN:
                file = Constants.FILE_JSON_DUNGEONS_TOWER_EN;
                break;
            case Constants.LANGUAGE_DE:
                file = Constants.FILE_JSON_DUNGEONS_TOWER_DE;
                break;
            case Constants.LANGUAGE_FR:
                file = Constants.FILE_JSON_DUNGEONS_TOWER_FR;
                break;
            default:
                file = Constants.FILE_JSON_DUNGEONS_TOWER_EN;
                break;
        }

        try {
            towerStages = jsonAdapter.fromJson(Tools.loadJSONFromAsset(assetManager, file));
        } catch (IOException e) {
            e.printStackTrace();
        }

        return towerStages;
    }

}
