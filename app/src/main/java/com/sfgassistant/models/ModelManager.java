package com.sfgassistant.models;

import android.content.res.AssetManager;

import com.google.gson.reflect.TypeToken;
import com.sfgassistant.utils.Constants;
import com.sfgassistant.utils.Tools;
import com.squareup.moshi.JsonAdapter;
import com.squareup.moshi.Moshi;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by pierr on 18/09/2016.
 */

public class ModelManager {

    private AssetManager    assetManager;

    public ModelManager(AssetManager assetManager) {
        this.assetManager = assetManager;
    }

    public List<Race> getRaces() {
        List<Race> races = new ArrayList<>();
        Moshi moshi = new Moshi.Builder().build();
        JsonAdapter<List> jsonAdapter = moshi.adapter(new TypeToken<List<Race>>(){}.getType());

        try {
            races = jsonAdapter.fromJson(Tools.loadJSONFromAsset(assetManager, Constants.FILE_RACES));
        } catch (IOException e) {
            e.printStackTrace();
        }

        return races;
    }

    public List<Classs> getClasses() {
        List<Classs> classes = new ArrayList<>();
        Moshi moshi = new Moshi.Builder().build();
        JsonAdapter<List> jsonAdapter = moshi.adapter(new TypeToken<List<Classs>>(){}.getType());

        try {
            classes = jsonAdapter.fromJson(Tools.loadJSONFromAsset(assetManager, Constants.FILE_CLASSES));
        } catch (IOException e) {
            e.printStackTrace();
        }

        return classes;
    }

    public List<Enchantment> getEnchantments() {
        List<Enchantment>   enchantments = new ArrayList<>();
        Moshi moshi = new Moshi.Builder().build();
        JsonAdapter<List> jsonAdapter = moshi.adapter(new TypeToken<List<Enchantment>>(){}.getType());

        try {
            enchantments = jsonAdapter.fromJson(Tools.loadJSONFromAsset(assetManager, Constants.FILE_ENCHANTMENTS));
        } catch (IOException e) {
            e.printStackTrace();
        }

        return enchantments;
    }

}
