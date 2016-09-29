package com.sfgassistant;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.sfgassistant.views.calculators.StatsCalculatorView;
import com.sfgassistant.views.comparators.WeaponsComparatorView;
import com.sfgassistant.views.guides.GuidesView;
import com.sfgassistant.views.settings.SettingsView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by pierr on 29/09/2016.
 */

public class MainPagerAdapter extends FragmentStatePagerAdapter {

    private List<Fragment>  fragments;

    public MainPagerAdapter(FragmentManager fragmentManager) {
        super(fragmentManager);

        fragments = new ArrayList<>();
        fragments.add(new GuidesView());
        fragments.add(new StatsCalculatorView());
        fragments.add(new WeaponsComparatorView());
        fragments.add(new SettingsView());
    }

    @Override
    public Fragment getItem(int position) {
        return fragments.get(position);
    }

    @Override
    public int getCount() {
        return fragments.size();
    }

    public View getTabView(Context context, int position) {
        View v = LayoutInflater.from(context).inflate(R.layout.view_navigation_bottom_bar_tab, null);
        ImageView img = (ImageView) v.findViewById(R.id.icon);
        TextView tv = (TextView) v.findViewById(R.id.title);

        switch (position) {
            case 0:
                img.setImageResource(R.drawable.ic_guides);
                tv.setText(R.string.bottom_nav_bar_guides);
                break;
            case 1:
                img.setImageResource(R.drawable.ic_calculators);
                tv.setText(R.string.bottom_nav_bar_calculators);
                break;
            case 2:
                img.setImageResource(R.drawable.ic_dungeons);
                tv.setText(R.string.bottom_nav_bar_dungeons);
                break;
            case 3:
                img.setImageResource(R.drawable.ic_settings);
                tv.setText(R.string.bottom_nav_bar_settings);
                break;
        }
        return v;
    }


}
