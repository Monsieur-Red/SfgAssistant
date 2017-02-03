package com.sfgassistant.views.tools.weapons;

import com.sfgassistant.models.WeaponsComparator.WeaponsComparatorResult;

/**
 * Created by pierr on 25/09/2016.
 */

public interface WeaponsTool {

    interface View {

        void setData(WeaponsComparatorResult result, WeaponsComparatorResult result2);

    }

    interface Presenter {
        void setMainAttribute(String mainAttribute);
        void setMinDmg(String minDmg);
        void setMaxDmg(String maxDmg);
        void setWeaponAttribute(String weaponAttribute);
        void setGemAttribute(String gemAttribute);

        void setMinDmg2(String minDmg);
        void setMaxDmg2(String maxDmg);
        void setWeaponAttribute2(String weaponAttribute);
        void setGemAttribute2(String gemAttribute);

        void setGuildBonus(String bonus);
    }
}
