package com.sfgassistant.views.dungeons.lightWorld;

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
import com.sfgassistant.models.dungeons.LightWorld;
import com.sfgassistant.models.dungeons.LightWorldDetails;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;

import at.blogc.android.views.ExpandableTextView;
import butterknife.BindViews;
import butterknife.ButterKnife;
import butterknife.OnClick;
import io.github.luizgrp.sectionedrecyclerviewadapter.Section;
import io.github.luizgrp.sectionedrecyclerviewadapter.SectionedRecyclerViewAdapter;

/**
 * Created by pierr on 30/09/2016.
 */

public class LightWorldView extends Fragment {

    @BindViews({R.id.btn_all, R.id.btn_1, R.id.btn_2, R.id.btn_3, R.id.btn_4, R.id.btn_5, R.id.btn_6, R.id.btn_7, R.id.btn_8, R.id.btn_9, R.id.btn_10, R.id.btn_11, R.id.btn_12, R.id.btn_13, R.id.btn_14})
    List<FlatButton> buttons;

    private boolean[] buttonsState;
    private SectionedRecyclerViewAdapter adapter;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_dungeons_light_world, container, false);
        ButterKnife.bind(this, view);

        List<LightWorld> lightWorldDungeons = ((MainActivity)getActivity()).getModelManager().getLightWorldDungeons();
        List<LightWorldDetails> lightWorldDetailsDungeons = ((MainActivity)getActivity()).getModelManager().getLightWorldDungeonsDetails();

        buttonsState = new boolean[15];
        Arrays.fill(buttonsState, Boolean.TRUE);

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

        final RecyclerView recyclerView = ButterKnife.findById(view, R.id.recycler_view);
        adapter = new SectionedRecyclerViewAdapter();
        int i2 = 0;
        for (int i = 0; i < lightWorldDetailsDungeons.size(); i++) {
            LightWorldDetails lightWorldDetails = lightWorldDetailsDungeons.get(i);
            List<LightWorld> lightWorlds = new ArrayList<>();
            LightWorld lightWorld = lightWorldDungeons.get(i2);

            while (lightWorld != null && Integer.valueOf(lightWorld.getDungeonLvl()) == i + 1) {
                lightWorlds.add(lightWorld);

                i2++;
                if (i2 < lightWorldDungeons.size())
                    lightWorld = lightWorldDungeons.get(i2);
                else
                    lightWorld = null;
            }

            adapter.addSection(String.valueOf(i + 1),new LightWorldSectionAdapter(getContext(), adapter, lightWorldDetails, lightWorlds));
        }
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerView.setAdapter(adapter);
        recyclerView.setHasFixedSize(true);
        recyclerView.setNestedScrollingEnabled(false);

        return (view);
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        OnClickAllBtn();
    }

    private void setButtonsState(int id) {
        if (!buttonsState[id]) {
            buttons.get(id).getAttributes().setTheme(R.array.button_active, getResources());
            buttonsState[id] = true;
        } else {
            buttons.get(id).getAttributes().setTheme(R.array.button_inactive, getResources());
            buttonsState[id] = false;
        }

        if (isAllButtonsSelected()) {
            buttons.get(0).getAttributes().setTheme(R.array.button_active, getResources());
            buttonsState[0] = true;
        }
        else {
            buttons.get(0).getAttributes().setTheme(R.array.button_inactive, getResources());
            buttonsState[0] = false;
        }
    }

    private void setSectionsVisibility(int position) {
        if (buttonsState[position])
            adapter.getSection(String.valueOf(position)).setVisible(true);
        else
            adapter.getSection(String.valueOf(position)).setVisible(false);
        adapter.notifyDataSetChanged();

    }

    private boolean isAllButtonsSelected() {
        for (int i = 1; i < 15; i++) {
            if (!buttonsState[i])
                return false;
        }
        return true;
    }

    @OnClick(R.id.btn_all)
    public void OnClickAllBtn() {
        LinkedHashMap<String, Section> sections = adapter.getSectionsMap();
        if (!buttonsState[0]) {
            for (int i = 0; i < 15; i++) {
                FlatButton flatButton = buttons.get(i);
                flatButton.getAttributes().setTheme(R.array.button_active, getResources());
                buttonsState[i] = true;
            }
            for (Section section : sections.values()) {
                section.setVisible(true);
            }
        }
        else  {
            for (int i = 0; i < 15; i++) {
                FlatButton flatButton = buttons.get(i);
                flatButton.getAttributes().setTheme(R.array.button_inactive, getResources());
                buttonsState[i] = false;
            }
            for (Section section : sections.values()) {
                section.setVisible(false);
            }
        }
        adapter.notifyDataSetChanged();
    }

    @OnClick(R.id.btn_1)
    public void OnClickBtn1() {
        setButtonsState(1);
        setSectionsVisibility(1);
    }

    @OnClick(R.id.btn_2)
    public void OnClickBtn2() {
        setButtonsState(2);
        setSectionsVisibility(2);
    }

    @OnClick(R.id.btn_3)
    public void OnClickBtn3() {
        setButtonsState(3);
        setSectionsVisibility(3);
    }

    @OnClick(R.id.btn_4)
    public void OnClickBtn4() {
        setButtonsState(4);
        setSectionsVisibility(4);
    }

    @OnClick(R.id.btn_5)
    public void OnClickBtn5() {
        setButtonsState(5);
        setSectionsVisibility(5);
    }

    @OnClick(R.id.btn_6)
    public void OnClickBtn6() {
        setButtonsState(6);
        setSectionsVisibility(6);
    }

    @OnClick(R.id.btn_7)
    public void OnClickBtn7() {
        setButtonsState(7);
        setSectionsVisibility(7);
    }

    @OnClick(R.id.btn_8)
    public void OnClickBtn8() {
        setButtonsState(8);
        setSectionsVisibility(8);
    }

    @OnClick(R.id.btn_9)
    public void OnClickBtn9() {
        setButtonsState(9);
        setSectionsVisibility(9);
    }

    @OnClick(R.id.btn_10)
    public void OnClickBtn10() {
        setButtonsState(10);
        setSectionsVisibility(10);
    }

    @OnClick(R.id.btn_11)
    public void OnClickBtn11() {
        setButtonsState(11);
        setSectionsVisibility(11);
    }

    @OnClick(R.id.btn_12)
    public void OnClickBtn12() {
        setButtonsState(12);
        setSectionsVisibility(12);
    }

    @OnClick(R.id.btn_13)
    public void OnClickBtn13() {
        setButtonsState(13);
        setSectionsVisibility(13);
    }

    @OnClick(R.id.btn_14)
    public void OnClickBtn14() {
        setButtonsState(14);
        setSectionsVisibility(14);
    }
}
