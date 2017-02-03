package com.sfgassistant.presenters.tools;

import android.text.TextUtils;

import com.sfgassistant.models.WeaponsComparator.WeaponsComparatorModel;
import com.sfgassistant.models.WeaponsComparator.WeaponsComparatorResult;
import com.sfgassistant.views.tools.weapons.WeaponsTool;
import com.sfgassistant.views.tools.weapons.WeaponsToolView;

import java.text.NumberFormat;
import java.util.Locale;

/**
 * Created by red on 03/02/2017.
 */

public class WeaponsToolPresenter implements WeaponsTool.Presenter {

    private WeaponsToolView view;
    private WeaponsComparatorModel data;
    private WeaponsComparatorModel  data2;
    private NumberFormat numberFormat;

    public WeaponsToolPresenter(WeaponsToolView view) {
        this.view = view;
        data = new WeaponsComparatorModel();
        data2 = new WeaponsComparatorModel();
        numberFormat = NumberFormat.getNumberInstance(Locale.getDefault());
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

    @Override
    public void setGuildBonus(String bonus) {
        if (TextUtils.isEmpty(bonus))
            data.setGuildBonus(0);
        else {
            data.setGuildBonus(Integer.valueOf(bonus.replace("%", "")));
            data2.setGuildBonus(Integer.valueOf(bonus.replace("%", "")));
        }
        view.setData(updateResult(), updateResult());
        view.setData(updateResult(), updateResult2());
    }

    private WeaponsComparatorResult updateResult() {
        int attrTotal = data.getMainAttribute() + data.getWeaponAttribute() + data.getGemAttribute();
        int minDmg = data.getMinDmg() * (1 + attrTotal / 10);
        int maxDmg = data.getMaxDmg() * (1 + attrTotal / 10);
        //        int avgDmg = (minDmg + maxDmg) / 2;
        int avgDmg = ((data.getMinDmg() + data.getMaxDmg()) / 2) * (1 + attrTotal / 10);
        int guildBonus = data.getGuildBonus();

        if (guildBonus != 0) {
            minDmg += ((minDmg * guildBonus) / 100);
            maxDmg += ((maxDmg * guildBonus) / 100);
            avgDmg += ((avgDmg * guildBonus) / 100);
        }

        return new WeaponsComparatorResult(numberFormat.format(minDmg), numberFormat.format(maxDmg), numberFormat.format(avgDmg), numberFormat.format(data2.getWeaponAttribute()), numberFormat.format(attrTotal));
    }

    private WeaponsComparatorResult updateResult2() {
        int attrTotal = data.getMainAttribute() + data2.getWeaponAttribute() + data2.getGemAttribute();
        int minDmg = data2.getMinDmg() * (1 + attrTotal / 10);
        int maxDmg = data2.getMaxDmg() * (1 + attrTotal / 10);
        int avgDmg = (minDmg + maxDmg) / 2;

        int guildBonus = data.getGuildBonus();

        if (guildBonus != 0) {
            minDmg += ((minDmg * guildBonus) / 100);
            maxDmg += ((maxDmg * guildBonus) / 100);
            avgDmg += ((avgDmg * guildBonus) / 100);
        }

        return new WeaponsComparatorResult(numberFormat.format(minDmg), numberFormat.format(maxDmg), numberFormat.format(avgDmg), numberFormat.format(data2.getWeaponAttribute()), numberFormat.format(attrTotal));
    }
}
