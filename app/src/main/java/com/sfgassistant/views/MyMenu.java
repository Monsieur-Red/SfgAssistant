package com.sfgassistant.views;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.NavigationView;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import com.mxn.soul.flowingdrawer_core.MenuFragment;
import com.sfgassistant.MainActivity;
import com.sfgassistant.R;
import com.sfgassistant.utils.Constants;

import butterknife.ButterKnife;

/**
 * Created by pierr on 18/09/2016.
 */

public class MyMenu extends MenuFragment {

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_my_menu, container, false);
        NavigationView navigationView = ButterKnife.findById(view, R.id.navigation_view);

        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                selectDrawerItem(item);
                return false;
            }
        });

        return  setupReveal(view) ;
    }

    private void selectDrawerItem(MenuItem menuItem) {
        switch (menuItem.getItemId()) {
            case R.id.menu_news:
                break;
            case R.id.menu_guides:
                ((MainActivity)getActivity()).replaceView(Constants.VIEW_GUIDES);
                break;
            case R.id.menu_calculators:
                ((MainActivity)getActivity()).replaceView(Constants.VIEW_CALCULATORS_STATS);
                break;
            case R.id.menu_comparators:
                ((MainActivity)getActivity()).replaceView(Constants.VIEW_COMPARATORS_WEAPONS);
                break;
        }
    }

    public void onOpenMenu(){
//        Toast.makeText(getActivity(),"onOpenMenu",Toast.LENGTH_SHORT).show();
    }
    public void onCloseMenu(){
//        Toast.makeText(getActivity(),"onCloseMenu",Toast.LENGTH_SHORT).show();
    }

}
