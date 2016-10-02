package com.sfgassistant.views.dungeons.theTower;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;

import com.cengalabs.flatui.views.FlatButton;
import com.sfgassistant.MainActivity;
import com.sfgassistant.R;
import com.sfgassistant.models.dungeons.TowerStage;

import java.util.ArrayList;
import java.util.List;

import at.blogc.android.views.ExpandableTextView;
import butterknife.BindViews;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by pierr on 30/09/2016.
 */

public class TheTowerView extends Fragment {

    @BindViews({R.id.btn_1, R.id.btn_2, R.id.btn_3, R.id.btn_4, R.id.btn_5, R.id.btn_6, R.id.btn_7, R.id.btn_8, R.id.btn_9, R.id.btn_10})
    List<FlatButton> buttons;

    private List<TowerStage> towerStages;
    private boolean[] buttonsState;
    private TheTowerRvAdapter adapter;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_dungeons_the_tower, container, false);
        ButterKnife.bind(this, view);

        towerStages = ((MainActivity)getActivity()).getModelManager().getTowerStages();
        buttonsState = new boolean[15];

        final ExpandableTextView expandableTextView = ButterKnife.findById(view, R.id.expandableTextView);
        final ImageButton expandBtn = ButterKnife.findById(view, R.id.btn_expand);
        expandableTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                expandableTextView.toggle();
            }
        });
        expandableTextView.setOnExpandListener(new ExpandableTextView.OnExpandListener() {
            @Override
            public void onExpand(ExpandableTextView view) {
                expandBtn.setImageResource(R.drawable.ic_expand_less_white_24dp);
            }

            @Override
            public void onCollapse(ExpandableTextView view) {
                expandBtn.setImageResource(R.drawable.ic_expand_more_white_24dp);
            }
        });
        expandBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                expandableTextView.toggle();
            }
        });

        RecyclerView recyclerView = ButterKnife.findById(view, R.id.recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        adapter = new TheTowerRvAdapter(getContext());
        recyclerView.setAdapter(adapter);
        recyclerView.setHasFixedSize(true);
        recyclerView.setNestedScrollingEnabled(false);

        for (int i = 0; i < 10; i++) {
            FlatButton flatButton = buttons.get(i);
            flatButton.getAttributes().setTheme(R.array.button_inactive, getResources());
        }

        return (view);
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }

    private void setButtonsState(int id) {
        if (!buttonsState[id]) {
            buttons.get(id).getAttributes().setTheme(R.array.button_active, getResources());
            buttonsState[id] = true;
        } else {
            buttons.get(id).getAttributes().setTheme(R.array.button_inactive, getResources());
            buttonsState[id] = false;
        }
        adapter.update(getTowerStages());
    }

    private List<TowerStage> getTowerStages() {
        List<TowerStage> newTowerStages = new ArrayList<>();

        int i = 0;
        for (TowerStage towerStage : towerStages) {
            if (buttonsState[i])
                newTowerStages.add(towerStage);

            if (Integer.valueOf(towerStage.getTowerStage()) % 10 == 0)
                i++;
        }

        return newTowerStages;
    }

    @OnClick(R.id.btn_1)
    public void OnClickBtn1() {
        setButtonsState(0);
    }

    @OnClick(R.id.btn_2)
    public void OnClickBtn2() {
        setButtonsState(1);
    }

    @OnClick(R.id.btn_3)
    public void OnClickBtn3() {
        setButtonsState(2);
    }

    @OnClick(R.id.btn_4)
    public void OnClickBtn4() {
        setButtonsState(3);
    }

    @OnClick(R.id.btn_5)
    public void OnClickBtn5() {
        setButtonsState(4);
    }

    @OnClick(R.id.btn_6)
    public void OnClickBtn6() {
        setButtonsState(5);
    }

    @OnClick(R.id.btn_7)
    public void OnClickBtn7() {
        setButtonsState(6);
    }

    @OnClick(R.id.btn_8)
    public void OnClickBtn8() {
        setButtonsState(7);
    }

    @OnClick(R.id.btn_9)
    public void OnClickBtn9() {
        setButtonsState(8);
    }

    @OnClick(R.id.btn_10)
    public void OnClickBtn10() {
        setButtonsState(9);
    }

}
