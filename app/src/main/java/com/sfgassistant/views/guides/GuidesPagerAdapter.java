package com.sfgassistant.views.guides;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import com.sfgassistant.views.guides.classes.ClassesView;
import com.sfgassistant.views.guides.enchantments.EnchantmentsView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by pierr on 18/09/2016.
 */

public class GuidesPagerAdapter extends FragmentStatePagerAdapter {

    private static final int NUM_PAGES = 4;

    private List<Fragment> fragments;

    public GuidesPagerAdapter(FragmentManager fm) {
        super(fm);

        // Init Fragment List
        fragments = new ArrayList<>();
        fragments.add(new ClassesView());
        fragments.add(new EnchantmentsView());
        fragments.add(new FortressView());
        fragments.add(new PetsView());
    }

    @Override
    public Fragment getItem(int position) {
        return (fragments.get(position));
    }

    @Override
    public int getCount() {
        return (NUM_PAGES);
    }

}
