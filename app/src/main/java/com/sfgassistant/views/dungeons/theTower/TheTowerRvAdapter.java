package com.sfgassistant.views.dungeons.theTower;

import android.content.Context;
import android.graphics.Typeface;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.sfgassistant.R;
import com.sfgassistant.models.dungeons.TowerStage;
import com.sfgassistant.utils.Constants;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by pierr on 30/09/2016.
 */

public class TheTowerRvAdapter extends RecyclerView.Adapter<TheTowerRvAdapter.DataObjectHolder> {

    private Context context;
    private List<TowerStage> towerStages;

    public TheTowerRvAdapter(Context context) {
        this.context = context;
        this.towerStages = new ArrayList<>();
    }

    public class DataObjectHolder extends RecyclerView.ViewHolder {
        TextView title;
        TextView hp;
        TextView str;
        TextView dex;
        TextView intel;
        TextView cons;
        TextView luck;

        public DataObjectHolder(View view) {
            super(view);
//            ButterKnife.bind(this, itemView);
            title = (TextView) view.findViewById(R.id.title);
            hp = (TextView) view.findViewById(R.id.hp);
            str = (TextView) view.findViewById(R.id.str);
            dex = (TextView) view.findViewById(R.id.dex);
            intel = (TextView) view.findViewById(R.id.intel);
            cons = (TextView) view.findViewById(R.id.cons);
            luck = (TextView) view.findViewById(R.id.luck);
        }
    }

    @Override
    public DataObjectHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View                view = LayoutInflater.from(parent.getContext()).inflate(R.layout.rv_row_dungeons_the_tower, parent, false);
        return new DataObjectHolder(view);
    }

    @Override
    public void onBindViewHolder(DataObjectHolder holder, int position) {
        final TowerStage towerStage = towerStages.get(position);

        switch (towerStage.getOpponentClass()) {
            case Constants.CLASS_MAGE_STR:
                holder.title.setCompoundDrawablesWithIntrinsicBounds(R.drawable.ic_mage, 0, 0, 0);
                holder.intel.setTypeface(Typeface.DEFAULT_BOLD);
                break;
            case Constants.CLASS_WARRIOR_STR:
                holder.title.setCompoundDrawablesWithIntrinsicBounds(R.drawable.ic_warrior, 0, 0, 0);
                holder.str.setTypeface(Typeface.DEFAULT_BOLD);
                break;
            case Constants.CLASS_SCOUT_STR:
                holder.title.setCompoundDrawablesWithIntrinsicBounds(R.drawable.ic_scout, 0, 0, 0);
                holder.dex.setTypeface(Typeface.DEFAULT_BOLD);
                break;
        }

        holder.title.setText(String.format(context.getResources().getString(R.string.dungeons_tower_rv_row_title), towerStage.getTowerStage(), towerStage.getOpponentName(), towerStage.getOpponentLvl(), towerStage.getGold()));
        holder.hp.setText(towerStage.getOpponentHp());
        holder.str.setText(towerStage.getOpponentStr());
        holder.dex.setText(towerStage.getOpponentDex());
        holder.intel.setText(towerStage.getOpponentIntel());
        holder.cons.setText(towerStage.getOpponentCons());
        holder.luck.setText(towerStage.getOpponentLuck());
    }

    @Override
    public int getItemCount() {
        return towerStages.size();
    }

    public void update(List<TowerStage> towerStages) {
        this.towerStages.clear();
        this.towerStages.addAll(towerStages);
        notifyDataSetChanged();
    }

}
