package com.sfgassistant.views.guides.enchantments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;

import com.sfgassistant.MainActivity;
import com.sfgassistant.R;
import com.sfgassistant.models.Enchantment;

import java.util.List;

import at.blogc.android.views.ExpandableTextView;
import butterknife.ButterKnife;

/**
 * Created by pierr on 18/09/2016.
 */

public class EnchantmentsView extends Fragment {

    private List<Enchantment> enchantments;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        enchantments = ((MainActivity) getActivity()).getModelManager().getEnchantments();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_guides_enchantments, container, false);
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        final RecyclerView recyclerView = ButterKnife.findById(view, R.id.recycler_view);
        recyclerView.setAdapter(new EnchantmentsRVAdapter(enchantments));
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerView.setNestedScrollingEnabled(true);
        recyclerView.setHasFixedSize(false);

        final ExpandableTextView expandableTextView = ButterKnife.findById(view, R.id.expandableTextView);
        final ImageButton expandBtn = ButterKnife.findById(view, R.id.btn_expand);
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

    }

}
