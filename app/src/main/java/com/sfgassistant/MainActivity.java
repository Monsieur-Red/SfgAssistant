package com.sfgassistant;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.cengalabs.flatui.FlatUI;
import com.crashlytics.android.Crashlytics;
import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.mxn.soul.flowingdrawer_core.FlowingView;
import com.mxn.soul.flowingdrawer_core.LeftDrawerLayout;
import com.sfgassistant.models.ModelManager;
import com.sfgassistant.utils.Constants;
import com.sfgassistant.views.MyMenu;
import com.sfgassistant.widgets.MyViewPager;

import butterknife.BindView;
import butterknife.ButterKnife;
import io.fabric.sdk.android.Fabric;

/**
 * Created by pierr on 17/09/2016.
 */

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.adView) AdView mAdView;
    @BindView(R.id.view_pager) MyViewPager viewPager;

    private boolean drawerMenu;
    private LeftDrawerLayout mLeftDrawerLayout;
    private Toolbar toolbar;
    private ModelManager modelManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Fabric.with(this, new Crashlytics());

        SharedPreferences preferences = getSharedPreferences(getString(R.string.package_name), Context.MODE_PRIVATE);
        drawerMenu = preferences.getBoolean(Constants.SHARED_PREFS_MENU_DRAWER, false);

        FlatUI.initDefaultValues(this);
        FlatUI.setDefaultTheme(R.array.button_active);

        if (drawerMenu)
            setContentView(R.layout.activity_main_drawer_menu);
        else
            setContentView(R.layout.activity_main_bottom_nav_bar);

        ButterKnife.bind(this);
        setupToolbar();

        modelManager = new ModelManager(getAssets());

        MainPagerAdapter pagerAdapter = new MainPagerAdapter(getSupportFragmentManager());
        viewPager.setAdapter(pagerAdapter);
        viewPager.setOffscreenPageLimit(3);

        if (drawerMenu) {
            setupDrawerMenu();
            viewPager.setPagingEnabled(false);
        }
        else {
            toolbar.setVisibility(View.GONE);
            setupTabLayout(pagerAdapter);
            viewPager.setPagingEnabled(true);
        }

        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);
    }

    private void setupToolbar() {
        toolbar = ButterKnife.findById(this, R.id.toolbar);
        setSupportActionBar(toolbar);
        toolbar.setNavigationIcon(R.drawable.ic_menu_white_24dp);

        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mLeftDrawerLayout.toggle();
            }
        });
    }

    private void setupDrawerMenu() {
        mLeftDrawerLayout = ButterKnife.findById(this, R.id.drawerlayout);
        FragmentManager fm = getSupportFragmentManager();
        MyMenu myMenu = (MyMenu) fm.findFragmentById(R.id.container_menu);
        FlowingView flowingView = ButterKnife.findById(this, R.id.sv);
        if (myMenu == null)
            fm.beginTransaction().add(R.id.container_menu, myMenu = new MyMenu()).commit();
        mLeftDrawerLayout.setFluidView(flowingView);
        mLeftDrawerLayout.setMenuFragment(myMenu);
    }

    private void setupTabLayout(MainPagerAdapter pagerAdapter) {
        TabLayout tabLayout = ButterKnife.findById(this, R.id.tab_layout);
        tabLayout.setupWithViewPager(viewPager);
        for (int i = 0; i < tabLayout.getTabCount(); i++) {
            TabLayout.Tab tab = tabLayout.getTabAt(i);

            if (tab != null)
                tab.setCustomView(pagerAdapter.getTabView(this, i));
        }
    }

    @Override
    public void onPause() {
        if (mAdView != null)
            mAdView.pause();
        super.onPause();
    }

    @Override
    public void onResume() {
        super.onResume();
        if (mAdView != null)
            mAdView.resume();
    }

    @Override
    public void onDestroy() {
        if (mAdView != null)
            mAdView.destroy();
        super.onDestroy();
    }

    @Override
    public void onBackPressed() {
        if (drawerMenu && mLeftDrawerLayout.isShownMenu())
            mLeftDrawerLayout.closeDrawer();
        else
            super.onBackPressed();
    }

    public void closeDrawer(int position) {
        viewPager.setCurrentItem(position);
        mLeftDrawerLayout.closeDrawer();
    }

    public ModelManager getModelManager() {
        return modelManager;
    }

}
