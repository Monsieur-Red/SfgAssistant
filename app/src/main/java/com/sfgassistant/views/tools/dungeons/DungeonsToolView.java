package com.sfgassistant.views.tools.dungeons;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;

import com.cengalabs.flatui.views.FlatButton;
import com.sfgassistant.MainActivity;
import com.sfgassistant.R;
import com.sfgassistant.models.dungeons.Dungeon;
import com.sfgassistant.presenters.tools.DungeonsToolPresenter;
import com.sfgassistant.utils.Constants;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindViews;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.OnItemSelected;

/**
 * Created by red on 03/02/2017.
 */

public class DungeonsToolView extends Fragment implements DungeonsTool.View {

    private DungeonsToolPresenter presenter;

    @BindViews({R.id.btn_light, R.id.btn_shadow}) List<FlatButton> buttons;
    @BindViews({R.id.spinner_dungeon_number_monster_1, R.id.spinner_dungeon_number_monster_2, R.id.spinner_dungeon_number_monster_3}) List<Spinner> dungeonsNbSpinners;
    @BindViews({R.id.spinner_monster_number_monster_1, R.id.spinner_monster_number_monster_2, R.id.spinner_monster_number_monster_3}) List<Spinner> monstersNbSpinners;
    @BindViews({R.id.world_monster_1, R.id.world_monster_2, R.id.world_monster_3}) List<TextView> monstersWorlds;
    @BindViews({R.id.name_monster_1, R.id.name_monster_2, R.id.name_monster_3}) List<TextView> monstersNames;
    @BindViews({R.id.classs_monster_1, R.id.classs_monster_2, R.id.classs_monster_3}) List<ImageView> monstersClasses;
    @BindViews({R.id.level_monster_1, R.id.level_monster_2, R.id.level_monster_3}) List<TextView> monstersLevels;
    @BindViews({R.id.hp_monster_1, R.id.hp_monster_2, R.id.hp_monster_3}) List<TextView> monstersHp;
    @BindViews({R.id.str_monster_1, R.id.str_monster_2, R.id.str_monster_3}) List<TextView> monstersStr;
    @BindViews({R.id.dex_monster_1, R.id.dex_monster_2, R.id.dex_monster_3}) List<TextView> monstersDex;
    @BindViews({R.id.int_monster_1, R.id.int_monster_2, R.id.int_monster_3}) List<TextView> monstersInt;
    @BindViews({R.id.cons_monster_1, R.id.cons_monster_2, R.id.cons_monster_3}) List<TextView> monstersCons;
    @BindViews({R.id.luck_monster_1, R.id.luck_monster_2, R.id.luck_monster_3}) List<TextView> monstersLuck;


    @Override
    public void update(int position, Dungeon dungeon, boolean light) {
        if (light)
            monstersWorlds.get(position).setText(R.string.light);
        else
            monstersWorlds.get(position).setText(R.string.shadow);

        monstersNames.get(position).setText(dungeon.getOpponentName());

        switch (dungeon.getOpponentClass()) {
            case Constants.CLASS_MAGE_STR:
                monstersClasses.get(position).setImageResource(R.drawable.ic_mage);
                break;
            case Constants.CLASS_SCOUT_STR:
                monstersClasses.get(position).setImageResource(R.drawable.ic_scout);
                break;
            case Constants.CLASS_WARRIOR_STR:
                monstersClasses.get(position).setImageResource(R.drawable.ic_warrior);
                break;
        }

        monstersLevels.get(position).setText(dungeon.getOpponentLvl());
        monstersHp.get(position).setText(dungeon.getOpponentHp());
        monstersStr.get(position).setText(dungeon.getOpponentStr());
        monstersDex.get(position).setText(dungeon.getOpponentDex());
        monstersInt.get(position).setText(dungeon.getOpponentIntel());
        monstersCons.get(position).setText(dungeon.getOpponentCons());
        monstersLuck.get(position).setText(dungeon.getOpponentLuck());
    }


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        presenter = new DungeonsToolPresenter(this, ((MainActivity)getActivity()).getModelManager());
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_tools_dungeons, container, false);
        ButterKnife.bind(this, view);

        Spinner dungeonsNb1 = ButterKnife.findById(view, R.id.spinner_dungeon_number_monster_1);
        Spinner dungeonsNb2 = ButterKnife.findById(view, R.id.spinner_dungeon_number_monster_2);
        Spinner dungeonsNb3 = ButterKnife.findById(view, R.id.spinner_dungeon_number_monster_3);
        List<Integer> numbers = new ArrayList<>();
        for (int i = 1; i <= 14; ++i) {
            numbers.add(i);
        }
        ArrayAdapter<Integer> adapter1 = new ArrayAdapter<>(getContext(), R.layout.spinner_item, numbers);
        ArrayAdapter<Integer> adapter2 = new ArrayAdapter<>(getContext(), R.layout.spinner_item, numbers);
        ArrayAdapter<Integer> adapter3 = new ArrayAdapter<>(getContext(), R.layout.spinner_item, numbers);
        adapter1.setDropDownViewResource(R.layout.spinner_dropdow_item);
        adapter2.setDropDownViewResource(R.layout.spinner_dropdow_item);
        adapter3.setDropDownViewResource(R.layout.spinner_dropdow_item);
        dungeonsNb1.setAdapter(adapter1);
        dungeonsNb2.setAdapter(adapter2);
        dungeonsNb3.setAdapter(adapter3);

        List<Integer> numbers2 = new ArrayList<>();
        for (int i = 1; i <= 10; ++i) {
            numbers2.add(i);
        }
        for (Spinner spinner : monstersNbSpinners) {
            ArrayAdapter<Integer> adapter = new ArrayAdapter<>(getContext(), R.layout.spinner_item, numbers2);
            adapter.setDropDownViewResource(R.layout.spinner_dropdow_item);
            spinner.setAdapter(adapter);
        }

        return (view);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        onClickLightBtn();
    }


    @OnClick(R.id.btn_light)
    public void onClickLightBtn() {
        buttons.get(0).getAttributes().setTheme(R.array.button_active, getResources());
        buttons.get(1).getAttributes().setTheme(R.array.button_inactive, getResources());
        presenter.setLight(true);
    }

    @OnClick(R.id.btn_shadow)
    public void onClickShadowBtn() {
        buttons.get(0).getAttributes().setTheme(R.array.button_inactive, getResources());
        buttons.get(1).getAttributes().setTheme(R.array.button_active, getResources());
        presenter.setLight(false);
    }

    @OnItemSelected(R.id.spinner_dungeon_number_monster_1)
    public void onItemSelectedDungeonNbM1Spinner(AdapterView<?> parentView, View selectedItemView, int position, long id) {
        presenter.setMonsterNbSpinners(monstersNbSpinners.get(0), 0, (Integer) parentView.getItemAtPosition(position));
    }

    @OnItemSelected(R.id.spinner_dungeon_number_monster_2)
    public void onItemSelectedDungeonNbM2Spinner(AdapterView<?> parentView, View selectedItemView, int position, long id) {
        presenter.setMonsterNbSpinners(monstersNbSpinners.get(1), 1, (Integer) parentView.getItemAtPosition(position));
    }

    @OnItemSelected(R.id.spinner_dungeon_number_monster_3)
    public void onItemSelectedDungeonNbM3Spinner(AdapterView<?> parentView, View selectedItemView, int position, long id) {
        presenter.setMonsterNbSpinners(monstersNbSpinners.get(2), 2, (Integer) parentView.getItemAtPosition(position));
    }

    @OnItemSelected(R.id.spinner_monster_number_monster_1)
    public void onItemSelectedMonsterNbM1Spinner(AdapterView<?> parentView, View selectedItemView, int position, long id) {
        presenter.update(0 ,(Integer) parentView.getItemAtPosition(position));
    }

    @OnItemSelected(R.id.spinner_monster_number_monster_2)
    public void onItemSelectedMonsterNbM2Spinner(AdapterView<?> parentView, View selectedItemView, int position, long id) {
        presenter.update(1 ,(Integer) parentView.getItemAtPosition(position));
    }

    @OnItemSelected(R.id.spinner_monster_number_monster_3)
    public void onItemSelectedMonsterNbM3Spinner(AdapterView<?> parentView, View selectedItemView, int position, long id) {
        presenter.update(2 ,(Integer) parentView.getItemAtPosition(position));
    }

    public List<TextView> getMonstersLevels() {
        return monstersLevels;
    }

    public List<TextView> getMonstersHp() {
        return monstersHp;
    }

    public List<TextView> getMonstersStr() {
        return monstersStr;
    }

    public List<TextView> getMonstersDex() {
        return monstersDex;
    }

    public List<TextView> getMonstersInt() {
        return monstersInt;
    }

    public List<TextView> getMonstersCons() {
        return monstersCons;
    }

    public List<TextView> getMonstersLuck() {
        return monstersLuck;
    }
}
