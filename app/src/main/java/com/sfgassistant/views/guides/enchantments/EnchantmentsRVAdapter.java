package com.sfgassistant.views.guides.enchantments;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.sfgassistant.R;
import com.sfgassistant.models.guide.Enchantment;
import com.sfgassistant.utils.Constants;
import com.squareup.picasso.Picasso;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by pierr on 18/09/2016.
 */

public class EnchantmentsRVAdapter extends RecyclerView.Adapter<EnchantmentsRVAdapter.DataObjectHolder> {

    private List<Enchantment>   enchantments;

    public EnchantmentsRVAdapter(List<Enchantment> enchantments) {
        this.enchantments = enchantments;
    }

    public class DataObjectHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.name) TextView name;
        @BindView(R.id.type_and_effect) TextView typeAndEffect;

        public DataObjectHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }

    @Override
    public DataObjectHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View                view = LayoutInflater.from(parent.getContext()).inflate(R.layout.fragment_guides_enchantments_rv_row, parent, false);
        DataObjectHolder    holder = new DataObjectHolder(view);

        return (holder);
    }

    @Override
    public void onBindViewHolder(DataObjectHolder holder, int position) {
        Enchantment enchantment = enchantments.get(position);

        holder.name.setText(enchantment.getName());
        holder.typeAndEffect.setText(String.format(holder.typeAndEffect.getResources().getString(R.string.enchantments_type_effect), enchantment.getType(), enchantment.getEffect()));
    }

    @Override
    public int getItemCount() {
        return enchantments.size();
    }

}
