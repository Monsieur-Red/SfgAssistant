package com.sfgassistant.views.dungeons.lightWorld;

import android.content.Context;
import android.graphics.Typeface;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.sfgassistant.R;
import com.sfgassistant.models.dungeons.LightWorld;
import com.sfgassistant.models.dungeons.LightWorldDetails;
import com.sfgassistant.utils.Constants;
import com.squareup.picasso.Picasso;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import io.github.luizgrp.sectionedrecyclerviewadapter.SectionedRecyclerViewAdapter;
import io.github.luizgrp.sectionedrecyclerviewadapter.StatelessSection;

/**
 * Created by pierr on 30/09/2016.
 */

public class LightWorldSectionAdapter extends StatelessSection {

    private Context context;
    private SectionedRecyclerViewAdapter adapter;
    private LightWorldDetails lightWorldDetails;
    private List<LightWorld> lightWorlds;
    private boolean expanded;

    public LightWorldSectionAdapter(Context context, SectionedRecyclerViewAdapter adapter, LightWorldDetails lightWorldDetails, List<LightWorld> lightWorlds) {
        super(R.layout.fragment_dungeons_light_world_rv_section_header, R.layout.fragment_dungeons_light_world_rv_section_item);
        this.context = context;
        this.adapter = adapter;
        this.lightWorldDetails = lightWorldDetails;
        this.lightWorlds = lightWorlds;
        expanded = true;
    }

    class HeaderViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
//        @BindView(R.id.btn_expand) ImageButton expand;
//        @BindView(R.id.name) TextView name;
//        @BindView(R.id.description) TextView description;
//        @BindView(R.id.key_img) ImageView keyImg;
//        @BindView(R.id.key_description) TextView keyDescription;

        ImageButton expand;
        TextView name;
        TextView description;
        ImageView keyImg;
        TextView keyDescription;

        public HeaderViewHolder(View view) {
            super(view);
//            ButterKnife.bind(this, view);
            expand = (ImageButton) view.findViewById(R.id.btn_expand);
            name = (TextView) view.findViewById(R.id.name);

            description = (TextView) view.findViewById(R.id.description);
            keyImg = (ImageView) view.findViewById(R.id.key_img);
            keyDescription = (TextView) view.findViewById(R.id.key_description);
            view.setOnClickListener(this);
            expand.setOnClickListener(this);
        }

//        @OnClick(R.id.btn_expand)
//        public void onClickExpandBtn() {
//            if (expanded) {
//                expanded = false;
//                expand.setImageResource(R.drawable.ic_expand_more_white_24dp);
//            }
//            else {
//                expanded = true;
//                expand.setImageResource(R.drawable.ic_expand_less_white_24dp);
//            }
//            adapter.notifyDataSetChanged();
//        }

        @Override
        public void onClick(View view) {
            if (expanded) {
                expanded = false;
                expand.setImageResource(R.drawable.ic_expand_more_white_24dp);
            }
            else {
                expanded = true;
                expand.setImageResource(R.drawable.ic_expand_less_white_24dp);
            }
            adapter.notifyDataSetChanged();
        }
    }

    class ItemViewHolder extends RecyclerView.ViewHolder {
//        @BindView(R.id.title) TextView title;
//        @BindView(R.id.hp) TextView hp;
//        @BindView(R.id.str) TextView str;
//        @BindView(R.id.dex) TextView dex;
//        @BindView(R.id.intel) TextView intel;
//        @BindView(R.id.cons) TextView cons;
//        @BindView(R.id.luck) TextView luck;

        TextView title;
        TextView hp;
        TextView str;
        TextView dex;
        TextView intel;
        TextView cons;
        TextView luck;

        public ItemViewHolder(View view) {
            super(view);
            //ButterKnife.bind(this, view);
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
    public int getContentItemsTotal() {
        if (!expanded)
            return 0;
        return lightWorlds.size();
    }

    @Override
    public RecyclerView.ViewHolder getHeaderViewHolder(View view) {
        return new HeaderViewHolder(view);
    }

    @Override
    public void onBindHeaderViewHolder(RecyclerView.ViewHolder holder) {
        final HeaderViewHolder headerHolder = (HeaderViewHolder) holder;

        headerHolder.name.setText(String.format(context.getResources().getString(R.string.dungeons_section_header), lightWorldDetails.getLevel(), lightWorldDetails.getName()));
        headerHolder.description.setText(lightWorldDetails.getDescription());
        Picasso.with(context).load(Constants.PATH_ASSETS_DUNGEONS_KEYS + lightWorldDetails.getKey()).error(R.drawable.error_img).into(headerHolder.keyImg);
        headerHolder.keyDescription.setText(lightWorldDetails.getKeyDescription());
    }

    @Override
    public RecyclerView.ViewHolder getItemViewHolder(View view) {
        return new ItemViewHolder(view);
    }

    @Override
    public void onBindItemViewHolder(RecyclerView.ViewHolder holder, int position) {
        final ItemViewHolder itemHolder = (ItemViewHolder) holder;
        final LightWorld lightWorld = lightWorlds.get(position);

        itemHolder.title.setText(String.format(context.getResources().getString(R.string.dungeons_section_item_title), lightWorld.getDungeonStage(), lightWorld.getOpponentName(), lightWorld.getOpponentLvl(), lightWorld.getExperience()));

        switch (lightWorld.getOpponentClass()) {
            case Constants.CLASS_MAGE_STR:
                itemHolder.title.setCompoundDrawablesWithIntrinsicBounds(R.drawable.ic_mage, 0, 0, 0);
                itemHolder.intel.setTypeface(Typeface.DEFAULT_BOLD);
                break;
            case Constants.CLASS_WARRIOR_STR:
                itemHolder.title.setCompoundDrawablesWithIntrinsicBounds(R.drawable.ic_warrior, 0, 0, 0);
                itemHolder.str.setTypeface(Typeface.DEFAULT_BOLD);
                break;
            case Constants.CLASS_SCOUT_STR:
                itemHolder.title.setCompoundDrawablesWithIntrinsicBounds(R.drawable.ic_scout, 0, 0, 0);
                itemHolder.dex.setTypeface(Typeface.DEFAULT_BOLD);
                break;
        }
        itemHolder.hp.setText(lightWorld.getOpponentHp());
        itemHolder.str.setText(lightWorld.getOpponentStr());
        itemHolder.dex.setText(lightWorld.getOpponentDex());
        itemHolder.intel.setText(lightWorld.getOpponentIntel());
        itemHolder.cons.setText(lightWorld.getOpponentCons());
        itemHolder.luck.setText(lightWorld.getOpponentLuck());
    }
}
