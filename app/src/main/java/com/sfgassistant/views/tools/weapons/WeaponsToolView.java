package com.sfgassistant.views.tools.weapons;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;

import com.sfgassistant.R;
import com.sfgassistant.models.WeaponsComparator.WeaponsComparatorResult;
import com.sfgassistant.presenters.tools.WeaponsToolPresenter;
import com.sfgassistant.utils.Constants;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.BindViews;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.OnItemSelected;
import butterknife.OnTextChanged;

/**
 * Created by pierr on 25/09/2016.
 */

public class WeaponsToolView extends Fragment implements WeaponsTool.View {

    private WeaponsToolPresenter presenter;

    @BindViews({R.id.btn_mage, R.id.btn_warrior, R.id.btn_scout}) List<ImageView> classButtons;
    @BindView(R.id.edit_text_my_attribute) EditText mainAttr;
    @BindView(R.id.text_view_weapon_attr) TextView weaponAttr;
    @BindView(R.id.text_view_gem_attr) TextView gemAttr;
    @BindView(R.id.text_view_weapon_attr_2) TextView weaponAttr2;
    @BindView(R.id.text_view_total_attr) TextView totalAttr;

    @BindView(R.id.text_view_weapon_1_min_dmg) TextView minDmg;
    @BindView(R.id.text_view_weapon_2_min_dmg) TextView minDmg2;
    @BindView(R.id.text_view_weapon_1_max_dmg) TextView maxDmg;
    @BindView(R.id.text_view_weapon_2_max_dmg) TextView maxDmg2;
    @BindView(R.id.text_view_weapon_1_average_dmg) TextView avgDmg;
    @BindView(R.id.text_view_weapon_2_average_dmg) TextView avgDmg2;
    @BindView(R.id.text_view_weapon_1_weapon_attribute) TextView weaponAttribute;
    @BindView(R.id.text_view_weapon_2_weapon_attribute) TextView weaponAttribute2;
    @BindView(R.id.text_view_weapon_1_total_attribute) TextView totalAttribute;
    @BindView(R.id.text_view_weapon_2_total_attribute) TextView totalAttribute2;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        presenter = new WeaponsToolPresenter(this);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_tools_weapons, container, false);
        ButterKnife.bind(this, view);

        Spinner guildSpinner = ButterKnife.findById(view, R.id.spinner_bonus_guild);
        List<String> numbers = new ArrayList<>();
        for (int i = 0; i <= 50; ++i) {
            numbers.add(String.valueOf(i) + "%");
        }
        ArrayAdapter<String> adapter = new ArrayAdapter<>(getContext(), R.layout.spinner_item, numbers);
        adapter.setDropDownViewResource(R.layout.spinner_dropdow_item);
        guildSpinner.setAdapter(adapter);

        return (view);
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        OnClickWarriorBtn();
    }

    @Override
    public void setData(WeaponsComparatorResult result, WeaponsComparatorResult result2) {
        minDmg.setText(result.getMinDmg());
        minDmg2.setText(result2.getMinDmg());
        maxDmg.setText(result.getMaxDmg());
        maxDmg2.setText(result2.getMaxDmg());
        avgDmg.setText(result.getAverageDmg());
        avgDmg2.setText(result2.getAverageDmg());
        weaponAttribute.setText(result.getWeaponAttribute());
        weaponAttribute2.setText(result2.getWeaponAttribute());
        totalAttribute.setText(result.getAttributeTotal());
        totalAttribute2.setText(result2.getAttributeTotal());
    }

    @OnClick(R.id.btn_warrior)
    public void OnClickWarriorBtn() {
        classButtons.get(Constants.CLASS_WARRIOR).setSelected(true);
        classButtons.get(Constants.CLASS_MAGE).setSelected(false);
        classButtons.get(Constants.CLASS_SCOUT).setSelected(false);

        mainAttr.setHint(R.string.your_str);
        weaponAttr.setText(R.string.weapon_str);
        weaponAttr2.setText(R.string.weapon_str);
        gemAttr.setText(R.string.gem_str);
        totalAttr.setText(R.string.total_str);
    }

    @OnClick(R.id.btn_mage)
    public void OnClickMageBtn() {
        classButtons.get(Constants.CLASS_WARRIOR).setSelected(false);
        classButtons.get(Constants.CLASS_MAGE).setSelected(true);
        classButtons.get(Constants.CLASS_SCOUT).setSelected(false);

        mainAttr.setHint(R.string.your_intel);
        weaponAttr.setText(R.string.weapon_intel);
        weaponAttr2.setText(R.string.weapon_intel);
        gemAttr.setText(R.string.gem_intel);
        totalAttr.setText(R.string.total_intel);
    }

    @OnClick(R.id.btn_scout)
    public void OnClickScoutBtn() {
        classButtons.get(Constants.CLASS_WARRIOR).setSelected(false);
        classButtons.get(Constants.CLASS_MAGE).setSelected(false);
        classButtons.get(Constants.CLASS_SCOUT).setSelected(true);

        mainAttr.setHint(R.string.your_dex);
        weaponAttr.setText(R.string.weapon_dex);
        weaponAttr2.setText(R.string.weapon_dex);
        gemAttr.setText(R.string.gem_dex);
        totalAttr.setText(R.string.total_dex);
    }

    @OnTextChanged(R.id.edit_text_my_attribute)
    public void OnTextChangedMyAttr(CharSequence text) {
        presenter.setMainAttribute(text.toString());
    }

    @OnTextChanged(R.id.edit_text_weapon_1_min_dmg)
    public void OnTextChangedWeapon1MinDmg(CharSequence text) {
        presenter.setMinDmg(text.toString());
    }

    @OnTextChanged(R.id.edit_text_weapon_2_min_dmg)
    public void OnTextChangedWeapon2MinDmg(CharSequence text) {
        presenter.setMinDmg2(text.toString());
    }

    @OnTextChanged(R.id.edit_text_weapon_1_max_dmg)
    public void OnTextChangedWeapon1MaxDmg(CharSequence text) {
        presenter.setMaxDmg(text.toString());
    }

    @OnTextChanged(R.id.edit_text_weapon_2_max_dmg)
    public void OnTextChangedWeapon2MaxDmg(CharSequence text) {
        presenter.setMaxDmg2(text.toString());
    }

    @OnTextChanged(R.id.edit_text_weapon_1_attribute)
    public void OnTextChangedWeapon1Attr(CharSequence text) {
        presenter.setWeaponAttribute(text.toString());
    }

    @OnTextChanged(R.id.edit_text_weapon_2_attribute)
    public void OnTextChangedWeapon2Attr(CharSequence text) {
        presenter.setWeaponAttribute2(text.toString());
    }

    @OnTextChanged(R.id.edit_text_weapon_1_gem)
    public void OnTextChangedWeapon1Gem(CharSequence text) {
        presenter.setGemAttribute(text.toString());
    }

    @OnTextChanged(R.id.edit_text_weapon_2_gem)
    public void OnTextChangedWeapon2Gem(CharSequence text) {
        presenter.setGemAttribute2(text.toString());
    }

    @OnItemSelected(R.id.spinner_bonus_guild)
    public void OnItemClickGuild(Spinner spinner, int position) {
        presenter.setGuildBonus((String) spinner.getItemAtPosition(position));
    }
}
