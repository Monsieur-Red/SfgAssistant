package com.sfgassistant.views.calculators.stats;

import com.sfgassistant.models.statsCalculator.StatsCalculatorResult;

/**
 * Created by pierr on 25/09/2016.
 */

public interface StatsCalculator {

    interface View {

        void setData(StatsCalculatorResult result);
    }

    interface Presenter {
        void setClass(int classs);
        void setLevel(String level);
        void setWeaponDmg(String weaponDmg);

        void setBasisDmg(String basisDmg);
        void setEquipmentDmg(String equipmentDmg);
        void setPetsDmg(String petsDmg);
        void setTemporaryDmg(String temporaryDmg);

        void setBasisConstitution(String basisConstitution);
        void setEquipmentConstitution(String equipmentConstitution);
        void setPetsConstitution(String petsConstitution);
        void setTemporaryConstitution(String temporaryConstitution);

        void setBasisLuck(String basisLuck);
        void setEquipmentLuck(String equipmentLuck);
        void setPetsLuck(String petsLuck);
        void setTemporaryLuck(String temporaryLuck);

        void setGuildBonus(String guildBonus);
        void setDungeonBonus(String dungeonBonus);
        void setPotionEternalLife(boolean isChecked);

        void addStr(String str);
        void addCons(String cons);
        void addLuck(String luck);
        void removeStr(String str);
        void removeCons(String cons);
        void removeLuck(String luck);



    }
}
