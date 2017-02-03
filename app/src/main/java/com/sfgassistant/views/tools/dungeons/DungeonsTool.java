package com.sfgassistant.views.tools.dungeons;

import android.widget.Spinner;

import com.sfgassistant.models.dungeons.Dungeon;

/**
 * Created by red on 03/02/2017.
 */

public interface DungeonsTool {

    interface View {

        void update(int position, Dungeon dungeon, boolean light);
    }

    interface Presenter {
        void setMonsterNbSpinners(Spinner monstersNbSpinners, int position, Integer dungeon);

        void update(int position, Integer stage);
    }
}
