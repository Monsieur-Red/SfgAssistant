package com.sfgassistant.views.dungeons;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import com.sfgassistant.views.dungeons.lightWorld.LightWorldView;
import com.sfgassistant.views.dungeons.shadowWorld.ShadowWorldView;
import com.sfgassistant.views.dungeons.theTower.TheTowerView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by pierr on 30/09/2016.
 */

public class DungeonsPagerAdapter extends FragmentStatePagerAdapter {

    private List<Fragment> fragments;

    public DungeonsPagerAdapter(FragmentManager fm) {
        super(fm);

        // Init Fragment List
        fragments = new ArrayList<>();
        fragments.add(new LightWorldView());
        fragments.add(new ShadowWorldView());
        fragments.add(new TheTowerView());
    }

    @Override
    public Fragment getItem(int position) {
        return (fragments.get(position));
    }

    @Override
    public int getCount() {
        return (fragments.size());
    }
}
