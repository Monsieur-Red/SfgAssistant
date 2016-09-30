package com.sfgassistant.views.dungeons.theTower;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.sfgassistant.MainActivity;
import com.sfgassistant.R;
import com.sfgassistant.models.dungeons.TowerStage;

import java.util.List;

import butterknife.ButterKnife;

/**
 * Created by pierr on 30/09/2016.
 */

public class TheTowerView extends Fragment {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_dungeons_the_tower, container, false);
        ButterKnife.bind(this, view);

        List<TowerStage>    towerStages = ((MainActivity)getActivity()).getModelManager().getTowerStages();

        RecyclerView recyclerView = ButterKnife.findById(view, R.id.recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerView.setAdapter(new TheTowerRvAdapter(getContext(), towerStages));
        recyclerView.setHasFixedSize(true);
        recyclerView.setNestedScrollingEnabled(false);

        return (view);
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }

}
