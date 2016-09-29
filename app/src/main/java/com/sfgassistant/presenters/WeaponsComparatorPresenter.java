package com.sfgassistant.presenters;

import android.text.TextUtils;

import com.sfgassistant.models.WeaponsComparator.WeaponsComparatorModel;
import com.sfgassistant.models.WeaponsComparator.WeaponsComparatorResult;
import com.sfgassistant.views.comparators.WeaponsComparator;
import com.sfgassistant.views.comparators.WeaponsComparatorView;

/**
 * Created by pierr on 25/09/2016.
 */

public class WeaponsComparatorPresenter implements WeaponsComparator.Presenter {

    private WeaponsComparatorView   view;
    private WeaponsComparatorModel  data;
    private WeaponsComparatorModel  data2;

    public WeaponsComparatorPresenter(WeaponsComparatorView view) {
        this.view = view;
        data = new WeaponsComparatorModel();
        data2 = new WeaponsComparatorModel();
    }

    @Override
    public void setMainAttribute(String mainAttribute) {
        if (TextUtils.isEmpty(mainAttribute))
            data.setMainAttribute(0);
        else
            data.setMainAttribute(Integer.valueOf(mainAttribute));
        view.setData(updateResult(), updateResult2());
    }

    @Override
    public void setMinDmg(String minDmg) {
        if (TextUtils.isEmpty(minDmg))
            data.setMinDmg(0);
        else
            data.setMinDmg(Integer.valueOf(minDmg));
        view.setData(updateResult(), updateResult2());
    }

    @Override
    public void setMaxDmg(String maxDmg) {
        if (TextUtils.isEmpty(maxDmg))
            data.setMaxDmg(0);
        else
            data.setMaxDmg(Integer.valueOf(maxDmg));
        view.setData(updateResult(), updateResult2());
    }

    @Override
    public void setWeaponAttribute(String weaponAttribute) {
        if (TextUtils.isEmpty(weaponAttribute))
            data.setWeaponAttribute(0);
        else
            data.setWeaponAttribute(Integer.valueOf(weaponAttribute));
        view.setData(updateResult(), updateResult2());
    }

    @Override
    public void setGemAttribute(String gemAttribute) {
        if (TextUtils.isEmpty(gemAttribute))
            data.setGemAttribute(0);
        else
            data.setGemAttribute(Integer.valueOf(gemAttribute));
        view.setData(updateResult(), updateResult2());
    }

    @Override
    public void setMinDmg2(String minDmg) {
        if (TextUtils.isEmpty(minDmg))
            data2.setMinDmg(0);
        else
            data2.setMinDmg(Integer.valueOf(minDmg));
        view.setData(updateResult(), updateResult2());
    }

    @Override
    public void setMaxDmg2(String maxDmg) {
        if (TextUtils.isEmpty(maxDmg))
            data2.setMaxDmg(0);
        else
            data2.setMaxDmg(Integer.valueOf(maxDmg));
        view.setData(updateResult(), updateResult2());
    }

    @Override
    public void setWeaponAttribute2(String weaponAttribute) {
        if (TextUtils.isEmpty(weaponAttribute))
            data2.setWeaponAttribute(0);
        else
            data2.setWeaponAttribute(Integer.valueOf(weaponAttribute));
        view.setData(updateResult(), updateResult2());
    }

    @Override
    public void setGemAttribute2(String gemAttribute) {
        if (TextUtils.isEmpty(gemAttribute))
            data2.setGemAttribute(0);
        else
            data2.setGemAttribute(Integer.valueOf(gemAttribute));
        view.setData(updateResult(), updateResult2());
    }
    private WeaponsComparatorResult updateResult() {
        int mainAttr = data.getMainAttribute();
        int attrTotal = mainAttr + data.getWeaponAttribute() + data.getGemAttribute();
        int minDmg = data.getMinDmg() * (1 + attrTotal / 10);
        int maxDmg = data.getMaxDmg() * (1 + attrTotal / 10);
        int avgDmg = (minDmg + maxDmg) / 2;

        return new WeaponsComparatorResult(String.valueOf(minDmg), String.valueOf(maxDmg), String.valueOf(avgDmg), String.valueOf(data.getWeaponAttribute()), String.valueOf(attrTotal));
    }

    private WeaponsComparatorResult updateResult2() {
        int mainAttr = data.getMainAttribute();
        int attrTotal = mainAttr + data2.getWeaponAttribute() + data2.getGemAttribute();
        int minDmg = data2.getMinDmg() * (1 + attrTotal / 10);
        int maxDmg = data2.getMaxDmg() * (1 + attrTotal / 10);
        int avgDmg = (minDmg + maxDmg) / 2;

        return new WeaponsComparatorResult(String.valueOf(minDmg), String.valueOf(maxDmg), String.valueOf(avgDmg), String.valueOf(data2.getWeaponAttribute()), String.valueOf(attrTotal));
    }
}

