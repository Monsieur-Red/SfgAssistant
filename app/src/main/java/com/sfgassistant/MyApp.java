package com.sfgassistant;

import android.app.Application;

import com.crashlytics.android.Crashlytics;
import com.google.android.gms.ads.MobileAds;

import io.fabric.sdk.android.Fabric;

/**
 * Created by pierr on 02/10/2016.
 */

public class MyApp extends Application {

    @Override public void onCreate() {
        super.onCreate();
        Fabric.with(this, new Crashlytics());
        MobileAds.initialize(getApplicationContext(), getString(R.string.ad_app_id));
    }
}
