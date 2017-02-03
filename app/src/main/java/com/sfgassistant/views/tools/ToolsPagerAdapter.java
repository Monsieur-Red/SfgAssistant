package com.sfgassistant.views.tools;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import com.sfgassistant.views.tools.dungeons.DungeonsToolView;
import com.sfgassistant.views.tools.weapons.WeaponsToolView;
import com.sfgassistant.views.tools.stats.StatsToolView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by pierr on 01/10/2016.
 */

public class ToolsPagerAdapter extends FragmentStatePagerAdapter {

    private List<Fragment> fragments;

    public ToolsPagerAdapter(FragmentManager fm) {
        super(fm);

        fragments = new ArrayList<>();
        fragments.add(new StatsToolView());
        fragments.add(new WeaponsToolView());
        fragments.add(new DungeonsToolView());
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
