package com.sfgassistant.views.calculators;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import com.sfgassistant.views.calculators.stats.StatsCalculatorView;
import com.sfgassistant.views.comparators.WeaponsComparatorView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by pierr on 01/10/2016.
 */

public class CalculatorsPagerAdapter extends FragmentStatePagerAdapter {

    private List<Fragment> fragments;

    public CalculatorsPagerAdapter(FragmentManager fm) {
        super(fm);

        fragments = new ArrayList<>();
        fragments.add(new StatsCalculatorView());
        fragments.add(new WeaponsComparatorView());
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
