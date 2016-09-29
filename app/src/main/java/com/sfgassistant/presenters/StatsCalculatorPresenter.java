package com.sfgassistant.presenters;

import android.text.TextUtils;

import com.sfgassistant.models.statsCalculator.StatsCalculatorModel;
import com.sfgassistant.models.statsCalculator.StatsCalculatorResult;
import com.sfgassistant.views.calculators.StatsCalculator;
import com.sfgassistant.views.calculators.StatsCalculatorView;

/**
 * Created by pierr on 25/09/2016.
 */

public class StatsCalculatorPresenter implements StatsCalculator.Presenter {

    private StatsCalculatorView     view;
    private StatsCalculatorModel    data;

    public StatsCalculatorPresenter(StatsCalculatorView view) {
        this.view = view;
        data = new StatsCalculatorModel();
    }

    @Override
    public void setLevel(String level) {
        if (TextUtils.isEmpty(level))
            data.setLevel(0);
        else
            data.setLevel(Integer.valueOf(level));
        view.setData(updateResult());
    }

    @Override
    public void setWeaponDmg(String weaponDmg) {
        if (TextUtils.isEmpty(weaponDmg))
            data.setWeaponDmg(0);
        else
            data.setWeaponDmg(Integer.valueOf(weaponDmg));
        view.setData(updateResult());
    }

    @Override
    public void setBasisDmg(String basisDmg) {
        if (TextUtils.isEmpty(basisDmg))
            data.setBasisDmg(0);
        else
            data.setBasisDmg(Integer.valueOf(basisDmg));
        view.setData(updateResult());
    }

    @Override
    public void setEquipmentDmg(String equipmentDmg) {
        if (TextUtils.isEmpty(equipmentDmg))
            data.setEquipmentDmg(0);
        else
            data.setEquipmentDmg(Integer.valueOf(equipmentDmg));
        view.setData(updateResult());
    }

    @Override
    public void setPetsDmg(String petsDmg) {
        if (TextUtils.isEmpty(petsDmg))
            data.setPetsDmg(0);
        else
            data.setPetsDmg(Integer.valueOf(petsDmg));
        view.setData(updateResult());
    }

    @Override
    public void setTemporaryDmg(String temporaryDmg) {
        if (TextUtils.isEmpty(temporaryDmg))
            data.setTemporaryDmg(0);
        else
            data.setTemporaryDmg(Integer.valueOf(temporaryDmg));
        view.setData(updateResult());
    }

    @Override
    public void setBasisConstitution(String basisConstitution) {
        if (TextUtils.isEmpty(basisConstitution))
            data.setBasisConstitution(0);
        else
            data.setBasisConstitution(Integer.valueOf(basisConstitution));
        view.setData(updateResult());
    }

    @Override
    public void setEquipmentConstitution(String equipmentConstitution) {
        if (TextUtils.isEmpty(equipmentConstitution))
            data.setEquipmentConstitution(0);
        else
            data.setEquipmentConstitution(Integer.valueOf(equipmentConstitution));
        view.setData(updateResult());
    }

    @Override
    public void setPetsConstitution(String petsConstitution) {
        if (TextUtils.isEmpty(petsConstitution))
            data.setPetsConstitution(0);
        else
            data.setPetsConstitution(Integer.valueOf(petsConstitution));
        view.setData(updateResult());
    }

    @Override
    public void setTemporaryConstitution(String temporaryConstitution) {
        if (TextUtils.isEmpty(temporaryConstitution))
            data.setTemporaryConstitution(0);
        else
            data.setTemporaryConstitution(Integer.valueOf(temporaryConstitution));
        view.setData(updateResult());
    }

    @Override
    public void setBasisLuck(String basisLuck) {
        if (TextUtils.isEmpty(basisLuck))
            data.setBasisLuck(0);
        else
            data.setBasisLuck(Integer.valueOf(basisLuck));
        view.setData(updateResult());
    }

    @Override
    public void setEquipmentLuck(String equipmentLuck) {
        if (TextUtils.isEmpty(equipmentLuck))
            data.setEquipmentLuck(0);
        else
            data.setEquipmentLuck(Integer.valueOf(equipmentLuck));
        view.setData(updateResult());
    }

    @Override
    public void setPetsLuck(String petsLuck) {
        if (TextUtils.isEmpty(petsLuck))
            data.setPetsLuck(0);
        else
            data.setPetsLuck(Integer.valueOf(petsLuck));
        view.setData(updateResult());
    }

    @Override
    public void setTemporaryLuck(String temporaryLuck) {
        if (TextUtils.isEmpty(temporaryLuck))
            data.setTemporaryLuck(0);
        else
            data.setTemporaryLuck(Integer.valueOf(temporaryLuck));
        view.setData(updateResult());
    }

    @Override
    public void setGuildBonus(String guildBonus) {
        if (TextUtils.isEmpty(guildBonus))
            data.setGuildBonus(0);
        else
            data.setGuildBonus(Integer.valueOf(guildBonus.replace("%", "")));
        view.setData(updateResult());
    }

    @Override
    public void setDungeonBonus(String dungeonBonus) {
        if (TextUtils.isEmpty(dungeonBonus))
            data.setDungeonBonus(0);
        else
            data.setDungeonBonus(Integer.valueOf(dungeonBonus.replace("%", "")));
        view.setData(updateResult());
    }

    @Override
    public void addStr(String str) {
        if (TextUtils.isEmpty(str))
            data.setDmgPlus(0);
        else
            data.setDmgPlus(Integer.valueOf(str));
        view.setData(updateResult());
    }

    @Override
    public void addCons(String cons) {
        if (TextUtils.isEmpty(cons))
            data.setConstitutionPlus(0);
        else
            data.setConstitutionPlus(Integer.valueOf(cons));
        view.setData(updateResult());
    }

    @Override
    public void addLuck(String luck) {
        if (TextUtils.isEmpty(luck))
            data.setLuckPlus(0);
        else
            data.setLuckPlus(Integer.valueOf(luck));
        view.setData(updateResult());
    }

    @Override
    public void removeStr(String str) {
        if (TextUtils.isEmpty(str))
            data.setDmgMinus(0);
        else
            data.setDmgMinus(Integer.valueOf(str));
        view.setData(updateResult());
    }

    @Override
    public void removeCons(String cons) {
        if (TextUtils.isEmpty(cons))
            data.setConstitutionMinus(0);
        else
            data.setConstitutionMinus(Integer.valueOf(cons));
        view.setData(updateResult());
    }

    @Override
    public void removeLuck(String luck) {
        if (TextUtils.isEmpty(luck))
            data.setLuckMinus(0);
        else
            data.setLuckMinus(Integer.valueOf(luck));
        view.setData(updateResult());
    }

    private StatsCalculatorResult updateResult() {
        int dmgStat = data.getBasisDmg() + data.getEquipmentDmg() + data.getPetsDmg() + data.getTemporaryDmg() + data.getDmgPlus() - data.getDmgMinus();
        int constitutionStat = data.getBasisConstitution() + data.getEquipmentConstitution() + data.getPetsConstitution() + data.getTemporaryConstitution() + data.getConstitutionPlus() - data.getConstitutionMinus();
        int luckStat = data.getBasisLuck() + data.getEquipmentLuck() + data.getPetsLuck() + data.getTemporaryLuck() + data.getLuckPlus() - data.getLuckMinus();

        int level = data.getLevel();
        int dmgValue = 0;
        int hitPts = 0;
        int criticalHit = 0;

        if (level > 0) {
            int guildBonus = data.getGuildBonus();
            int dungeonBonus = data.getDungeonBonus();

            dmgValue = data.getWeaponDmg() * (1 + dmgStat / 10);
            if (guildBonus != 0)
                dmgValue += ((dmgValue * guildBonus) / 100);

            hitPts = constitutionStat * 2 * (data.getLevel() + 1);
            if (dungeonBonus != 0)
                hitPts += ((hitPts * dungeonBonus) / 100);

            criticalHit = Math.round(luckStat * 5 / (data.getLevel() * 2));

            if (criticalHit > 50)
                criticalHit = 50;
        }

        return new StatsCalculatorResult(String.valueOf(dmgStat), "~" + String.valueOf(dmgValue), String.valueOf(constitutionStat), String.valueOf(hitPts), String.valueOf(luckStat), String.valueOf(criticalHit) + "%");
    }

}
