package com.sfgassistant.views.calculators.stats;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;

import com.sfgassistant.R;
import com.sfgassistant.models.statsCalculator.StatsCalculatorResult;
import com.sfgassistant.presenters.StatsCalculatorPresenter;
import com.sfgassistant.utils.Constants;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnCheckedChanged;
import butterknife.OnClick;
import butterknife.OnItemSelected;
import butterknife.OnTextChanged;

/**
 * Created by pierr on 25/09/2016.
 */

public class StatsCalculatorView extends Fragment implements StatsCalculator.View {

    private StatsCalculatorPresenter    presenter;

    @BindView(R.id.text_view_damage) TextView dmgTv;
    @BindView(R.id.text_view_damage_modification) TextView modificationDmgTv;
    @BindView(R.id.text_view_news_damage) TextView newsDmgTv;
    @BindView(R.id.text_view_news_damage_value) TextView newsDmgValueTv;
    @BindView(R.id.text_view_news_damage_value_2) TextView newsDmgValue2Tv;
    @BindView(R.id.text_view_news_constitution_value) TextView constitutionValueTv;
    @BindView(R.id.text_view_news_hit_points_value) TextView hitPtsValueTv;
    @BindView(R.id.text_view_news_luck_value) TextView luckValueTv;
    @BindView(R.id.text_view_news_critical_hit_value) TextView criticalHitValueTv;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        presenter = new StatsCalculatorPresenter(this);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_calculators_stats, container, false);
        ButterKnife.bind(this, view);
        return (view);
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        OnClickWarriorBtn();

        Spinner guildSpinner = ButterKnife.findById(view, R.id.spinner_bonus_guild);
        Spinner dungeonSpinner = ButterKnife.findById(view, R.id.spinner_bonus_dungeon);
        List<String> numbers = new ArrayList<>();
        for (int i = 0; i <= 50; ++i) {
            numbers.add(String.valueOf(i) + "%");
        }
        ArrayAdapter<String> adapter = new ArrayAdapter<>(getContext(), R.layout.spinner_item, numbers);
        adapter.setDropDownViewResource(R.layout.spinner_dropdow_item);
        guildSpinner.setAdapter(adapter);
        dungeonSpinner.setAdapter(adapter);
    }

    @Override
    public void setData(StatsCalculatorResult result) {
        newsDmgValueTv.setText(result.getDmgStat());
        newsDmgValue2Tv.setText(result.getDmgValue());
        constitutionValueTv.setText(result.getConstitution());
        hitPtsValueTv.setText(result.getHitPoints());
        luckValueTv.setText(result.getLuck());
        criticalHitValueTv.setText(result.getCriticalHit());
    }

    @OnClick(R.id.btn_warrior)
    public void OnClickWarriorBtn() {
        dmgTv.setText(R.string.strength);
        modificationDmgTv.setText(R.string.strength);
        newsDmgTv.setText(R.string.strength);
        presenter.setClass(Constants.CLASS_WARRIOR);
    }

    @OnClick(R.id.btn_mage)
    public void OnClickMageBtn() {
        dmgTv.setText(R.string.intelligence);
        modificationDmgTv.setText(R.string.intelligence);
        newsDmgTv.setText(R.string.intelligence);
        presenter.setClass(Constants.CLASS_MAGE);
    }

    @OnClick(R.id.btn_scout)
    public void OnClickScoutBtn() {
        dmgTv.setText(R.string.dexterity);
        modificationDmgTv.setText(R.string.dexterity);
        newsDmgTv.setText(R.string.dexterity);
        presenter.setClass(Constants.CLASS_SCOUT);
    }

    @OnTextChanged(R.id.edit_text_level)
    public void OnTextChangedLevel(CharSequence text) {
        presenter.setLevel(text.toString());
    }

    @OnTextChanged(R.id.edit_text_weapon_damage)
    public void OnTextChangedWeaponDamage(CharSequence text) {
        presenter.setWeaponDmg(text.toString());
    }

    @OnTextChanged(R.id.edit_text_basis_damage)
    public void OnTextChangedBasisDamage(CharSequence text) {
        presenter.setBasisDmg(text.toString());
    }
    
    @OnTextChanged(R.id.edit_text_equipment_damage)
    public void OnTextChangedEquipDmg(CharSequence text) {
        presenter.setEquipmentDmg(text.toString());
    }

    @OnTextChanged(R.id.edit_text_pets_damage)
    public void OnTextChangedPetsDmg(CharSequence text) {
        presenter.setPetsDmg(text.toString());
    }

    @OnTextChanged(R.id.edit_text_temporary_damage)
    public void OnTextChangedTempoDmg(CharSequence text) {
        presenter.setTemporaryDmg(text.toString());
    }

    @OnTextChanged(R.id.edit_text_basis_constitution)
    public void OnTextChangedBasisCons(CharSequence text) {
        presenter.setBasisConstitution(text.toString());
    }

    @OnTextChanged(R.id.edit_text_equipment_constitution)
    public void OnTextChangedEquipConstitution(CharSequence text) {
        presenter.setEquipmentConstitution(text.toString());
    }

    @OnTextChanged(R.id.edit_text_pets_constitution)
    public void OnTextChangedPetsConstitution(CharSequence text) {
        presenter.setPetsConstitution(text.toString());
    }

    @OnTextChanged(R.id.edit_text_temporary_constitution)
    public void OnTextChangedTempoConstitution(CharSequence text) {
        presenter.setTemporaryConstitution(text.toString());
    }

    @OnTextChanged(R.id.edit_text_basis_luck)
    public void OnTextChangedBasisLuck(CharSequence text) {
        presenter.setBasisLuck(text.toString());
    }

    @OnTextChanged(R.id.edit_text_equipment_luck)
    public void OnTextChangedEquipLuck(CharSequence text) {
        presenter.setEquipmentLuck(text.toString());
    }

    @OnTextChanged(R.id.edit_text_pets_luck)
    public void OnTextChangedPetsLuck(CharSequence text) {
        presenter.setPetsLuck(text.toString());
    }

    @OnTextChanged(R.id.edit_text_temporary_luck)
    public void OnTextChangedTempoLuck(CharSequence text) {
        presenter.setTemporaryLuck(text.toString());
    }

    @OnItemSelected(R.id.spinner_bonus_guild)
    public void OnItemClickGuild(Spinner spinner, int position) {
        presenter.setGuildBonus((String) spinner.getItemAtPosition(position));
    }

    @OnItemSelected(R.id.spinner_bonus_dungeon)
    public void OnItemClickDungeon(Spinner spinner, int position) {
        presenter.setDungeonBonus((String) spinner.getItemAtPosition(position));
    }

    @OnCheckedChanged(R.id.checkbox_potion_eternal_life)
    public void OnCheckChangedPotionCheckBox(boolean isChecked) {
        presenter.setPotionEternalLife(isChecked);
    }

    @OnTextChanged(R.id.edit_text_modification_plus_damage)
    public void OnTextChangedDmgPlus(CharSequence text) {
        presenter.addStr(text.toString());
    }

    @OnTextChanged(R.id.edit_text_modification_plus_constitution)
    public void OnTextChangedConsPlus(CharSequence text) {
        presenter.addCons(text.toString());
    }

    @OnTextChanged(R.id.edit_text_modification_plus_luck)
    public void OnTextChangedLuckPlus(CharSequence text) {
        presenter.addLuck(text.toString());
    }

    @OnTextChanged(R.id.edit_text_modification_minus_damage)
    public void OnTextChangedDmgMinus(CharSequence text) {
        presenter.removeStr(text.toString());
    }

    @OnTextChanged(R.id.edit_text_modification_minus_constitution)
    public void OnTextChangedCondMinus(CharSequence text) {
        presenter.removeCons(text.toString());
    }

    @OnTextChanged(R.id.edit_text_modification_minus_luck)
    public void OnTextChangedLuckMinus(CharSequence text) {
        presenter.removeLuck(text.toString());
    }


}
