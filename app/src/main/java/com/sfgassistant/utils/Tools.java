package com.sfgassistant.utils;

import android.content.res.AssetManager;

import java.io.IOException;
import java.io.InputStream;

/**
 * Created by pierr on 18/09/2016.
 */

public class Tools {

    public static String loadJSONFromAsset(AssetManager assetManager, String file) {
        String json = null;
        try {
            InputStream is = assetManager.open(file);
            int size = is.available();
            byte[] buffer = new byte[size];
            is.read(buffer);
            is.close();
            json = new String(buffer, "UTF-8");
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return json;
    }

}
