package com.sfgassistant.views.dungeons.theTower;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;

import com.sfgassistant.models.dungeons.TowerStage;

import java.util.List;

import butterknife.ButterKnife;

/**
 * Created by pierr on 30/09/2016.
 */

public class TheTowerRvAdapter extends RecyclerView.Adapter<TheTowerRvAdapter.DataObjectHolder> {

    private Context context;
    private List<TowerStage> towerStages;

    public TheTowerRvAdapter(Context context, List<TowerStage> towerStages) {
        this.context = context;
        this.towerStages = towerStages;
    }

    @Override
    public DataObjectHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(DataObjectHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }

    public class DataObjectHolder extends RecyclerView.ViewHolder {
//        @BindView(R.id.image)
//        ImageView image;
//        @BindView(R.id.type)
//        TextView type;
//        @BindView(R.id.name) TextView name;
//        @BindView(R.id.effect) TextView effect;

        public DataObjectHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }


}
