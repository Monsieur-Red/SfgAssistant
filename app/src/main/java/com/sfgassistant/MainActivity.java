package com.sfgassistant;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.mxn.soul.flowingdrawer_core.FlowingView;
import com.mxn.soul.flowingdrawer_core.LeftDrawerLayout;
import com.sfgassistant.models.ModelManager;
import com.sfgassistant.views.MyMenu;
import com.sfgassistant.views.calculators.StatsCalculatorView;
import com.sfgassistant.views.comparators.WeaponsComparatorView;
import com.sfgassistant.views.guides.GuidesView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by pierr on 17/09/2016.
 */

public class MainActivity extends AppCompatActivity {


    @BindView(R.id.drawerlayout) LeftDrawerLayout mLeftDrawerLayout;
//    @BindView(R.id.container_fragment) FrameLayout fragmentContainer;

    private ModelManager    modelManager;
    private List<Fragment>  fragments;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        setupToolbar();

        FragmentManager fm = getSupportFragmentManager();
        MyMenu myMenu = (MyMenu) fm.findFragmentById(R.id.container_menu);
        FlowingView flowingView = ButterKnife.findById(this, R.id.sv);
        if (myMenu == null)
            fm.beginTransaction().add(R.id.container_menu, myMenu = new MyMenu()).commit();
        mLeftDrawerLayout.setFluidView(flowingView);
        mLeftDrawerLayout.setMenuFragment(myMenu);

        fragments = new ArrayList<>();
        fragments.add(new GuidesView());
        fragments.add(new StatsCalculatorView());
        fragments.add(new WeaponsComparatorView());

        modelManager = new ModelManager(getAssets());
    }

    protected void setupToolbar() {
        Toolbar toolbar = ButterKnife.findById(this, R.id.toolbar);
        setSupportActionBar(toolbar);
        toolbar.setNavigationIcon(R.drawable.ic_menu_white_24dp);

        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mLeftDrawerLayout.toggle();
            }
        });
    }

    @Override
    public void onBackPressed() {
        if (mLeftDrawerLayout.isShownMenu()) {
            mLeftDrawerLayout.closeDrawer();
        } else {
            super.onBackPressed();
        }
    }

    public void replaceView(int idFragment) {
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.container_fragment, fragments.get(idFragment))
                .addToBackStack(null)
                .commit();

        mLeftDrawerLayout.closeDrawer();
    }

    public ModelManager getModelManager() {
        return modelManager;
    }
}
