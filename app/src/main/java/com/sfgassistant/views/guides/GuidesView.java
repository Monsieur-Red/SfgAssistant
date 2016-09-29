package com.sfgassistant.views.guides;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.gigamole.navigationtabstrip.NavigationTabStrip;
import com.sfgassistant.R;

import butterknife.ButterKnife;

/**
 * Created by pierr on 18/09/2016.
 */

public class GuidesView extends Fragment {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_guides, container, false);
        ButterKnife.bind(this, view);
        return (view);
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        final ViewPager   viewPager = ButterKnife.findById(view, R.id.view_pager);
        final NavigationTabStrip navigationTabStrip = ButterKnife.findById(view, R.id.navigation_tab_strip);
        viewPager.setAdapter(new GuidesPagerAdapter(getChildFragmentManager()));
        viewPager.setCurrentItem(0);
        navigationTabStrip.setViewPager(viewPager, 0);
    }

}
