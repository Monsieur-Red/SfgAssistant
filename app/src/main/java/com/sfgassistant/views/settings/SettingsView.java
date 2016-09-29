package com.sfgassistant.views.settings;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.Switch;
import android.widget.Toast;

import com.sfgassistant.R;
import com.sfgassistant.utils.Constants;

import butterknife.BindString;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnCheckedChanged;

/**
 * Created by pierr on 29/09/2016.
 */

public class SettingsView extends Fragment {

    @BindView(R.id.switch_drawer_menu) Switch drawerMenu;
    @BindView(R.id.switch_bottom_navigation_bar) Switch bottomNavBar;
    @BindString(R.string.settings_toast_restart_your_app) String msg;

    private SharedPreferences preferences;
    private Toast toast;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        preferences = getContext().getSharedPreferences(getString(R.string.package_name), Context.MODE_PRIVATE);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_settings, container, false);
        ButterKnife.bind(this, view);
        return (view);
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        if (preferences.getBoolean(Constants.SHARED_PREFS_MENU_DRAWER, false))
            drawerMenu.setChecked(true);
        else
            bottomNavBar.setChecked(true);

        toast = Toast.makeText(getContext(), msg, Toast.LENGTH_SHORT);
    }

    private void saveMenuChoice(boolean drawerMenu) {
        preferences.edit().putBoolean(Constants.SHARED_PREFS_MENU_DRAWER, drawerMenu).apply();
    }

    @OnCheckedChanged(R.id.switch_drawer_menu)
    public void OnCheckedChangedDrawerMenu(CompoundButton buttonView, boolean isChecked) {
        if (isChecked) {
            saveMenuChoice(true);
            bottomNavBar.setChecked(false);
        }
        else {
            saveMenuChoice(false);
            bottomNavBar.setChecked(true);
        }

        if (toast != null)
            toast.show();
    }

    @OnCheckedChanged(R.id.switch_bottom_navigation_bar)
    public void OnCheckedChangedBottomNavBar(CompoundButton buttonView, boolean isChecked) {
        if (isChecked) {
            saveMenuChoice(false);
            drawerMenu.setChecked(false);
        }
        else {
            saveMenuChoice(true);
            drawerMenu.setChecked(true);
        }

        if (toast != null)
            toast.show();
    }
}
