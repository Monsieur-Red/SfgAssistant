package com.sfgassistant.presenters.tools;

import android.graphics.Typeface;
import android.text.TextUtils;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;

import com.sfgassistant.R;
import com.sfgassistant.models.ModelManager;
import com.sfgassistant.models.dungeons.Dungeon;
import com.sfgassistant.utils.Constants;
import com.sfgassistant.views.tools.dungeons.DungeonsTool;
import com.sfgassistant.views.tools.dungeons.DungeonsToolView;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by red on 03/02/2017.
 */

public class DungeonsToolPresenter implements DungeonsTool.Presenter {

    private DungeonsToolView view;
    private List<Dungeon> lightDungeons;
    private List<Dungeon> shadowDungeons;

    private Dungeon[] dungeons;
    private int[] dungeonNb;
    private int[] monsterNb;
    private List<Integer> numbers;
    private List<Integer> numbers2;
    private boolean light;

    public DungeonsToolPresenter(DungeonsToolView view, ModelManager modelManager) {
        this.view = view;
        lightDungeons = modelManager.getLightWorldDungeons();
        shadowDungeons = modelManager.getShadowWorldDungeons();

        dungeons = new Dungeon[3];
        dungeonNb = new int[] {1, 1, 1};
        monsterNb = new int[] {1, 1, 1};
        numbers = new ArrayList<>();
        numbers2 = new ArrayList<>();
        for (int i = 1; i <= 10; ++i) {
            numbers.add(i);
        }
        for (int i = 1; i <= 20; ++i) {
            numbers2.add(i);
        }
        light = true;
    }

    @Override
    public void setMonsterNbSpinners(Spinner spinner, int position, Integer dungeon) {
        ArrayAdapter<Integer> adapter;

        dungeonNb[position] = dungeon;
        if (dungeon == 14) {
            adapter = new ArrayAdapter<>(view.getContext(), R.layout.spinner_item, numbers2);
            adapter.setDropDownViewResource(R.layout.spinner_dropdow_item);
        }
        else {
            adapter = new ArrayAdapter<>(view.getContext(), R.layout.spinner_item, numbers);
            adapter.setDropDownViewResource(R.layout.spinner_dropdow_item);
        }
        spinner.setAdapter(adapter);
    }

    @Override
    public void update(int position, Integer stage) {
        Dungeon dungeon;
        int realStageNb;

        monsterNb[position] = stage;
        if (dungeonNb[position] ==  1)
            realStageNb = stage  - 1;
        else
            realStageNb = dungeonNb[position] * 10 + stage - 11;

        if (light)
            dungeon = lightDungeons.get(realStageNb);
        else
            dungeon = shadowDungeons.get(realStageNb);

        dungeons[position] = dungeon;
        view.update(position, dungeon, light);
        compare();
    }

    private void compare() {
        Dungeon dungeon1 = dungeons[0];
        Dungeon dungeon2 = dungeons[1];
        Dungeon dungeon3 = dungeons[2];
        int lvlPos = calc(dungeon1, dungeon2, dungeon3, Constants.DUNGEON_CALC.LVL);
        int hpPos = calc(dungeon1, dungeon2, dungeon3, Constants.DUNGEON_CALC.HP);
        int strPos = calc(dungeon1, dungeon2, dungeon3, Constants.DUNGEON_CALC.STR);
        int dexPos = calc(dungeon1, dungeon2, dungeon3, Constants.DUNGEON_CALC.DEX);
        int intPos = calc(dungeon1, dungeon2, dungeon3, Constants.DUNGEON_CALC.INT);
        int consPos = calc(dungeon1, dungeon2, dungeon3, Constants.DUNGEON_CALC.CON);
        int luckPos = calc(dungeon1, dungeon2, dungeon3, Constants.DUNGEON_CALC.LUCK);

        for (TextView textview : view.getMonstersLevels()) {
            textview.setTypeface(null, Typeface.NORMAL);
        }
        for (TextView textview : view.getMonstersHp()) {
            textview.setTypeface(null, Typeface.NORMAL);
        }
        for (TextView textview : view.getMonstersStr()) {
            textview.setTypeface(null, Typeface.NORMAL);
        }
        for (TextView textview : view.getMonstersDex()) {
            textview.setTypeface(null, Typeface.NORMAL);
        }
        for (TextView textview : view.getMonstersInt()) {
            textview.setTypeface(null, Typeface.NORMAL);
        }
        for (TextView textview : view.getMonstersCons()) {
            textview.setTypeface(null, Typeface.NORMAL);
        }
        for (TextView textview : view.getMonstersLuck()) {
            textview.setTypeface(null, Typeface.NORMAL);
        }

        if (lvlPos != -1)
            view.getMonstersLevels().get(lvlPos).setTypeface(null, Typeface.BOLD);
        if (hpPos != -1)
            view.getMonstersHp().get(hpPos).setTypeface(null, Typeface.BOLD);
        if (strPos != -1)
            view.getMonstersStr().get(strPos).setTypeface(null, Typeface.BOLD);
        if (dexPos != -1)
            view.getMonstersDex().get(dexPos).setTypeface(null, Typeface.BOLD);
        if (intPos != -1)
            view.getMonstersInt().get(intPos).setTypeface(null, Typeface.BOLD);
        if (consPos != -1)
            view.getMonstersCons().get(consPos).setTypeface(null, Typeface.BOLD);
        if (luckPos != -1)
            view.getMonstersLuck().get(luckPos).setTypeface(null, Typeface.BOLD);

    }

    private int calc(Dungeon dungeon1, Dungeon dungeon2, Dungeon dungeon3, Constants.DUNGEON_CALC dungeonCalc) {
        int max;
        int v1 = -1;
        int v2 = -1;
        int v3 = -1;

        switch (dungeonCalc) {
            case LVL:
                v1 = (dungeon1 == null || TextUtils.isEmpty(dungeon1.getOpponentLvl().replace(".", ""))) ? -1 : Integer.valueOf(dungeon1.getOpponentLvl().replace(".", ""));
                v2 = (dungeon2 == null || TextUtils.isEmpty(dungeon2.getOpponentLvl().replace(".", ""))) ? -1 : Integer.valueOf(dungeon2.getOpponentLvl().replace(".", ""));
                v3 = (dungeon3 == null || TextUtils.isEmpty(dungeon3.getOpponentLvl().replace(".", ""))) ? -1 : Integer.valueOf(dungeon3.getOpponentLvl().replace(".", ""));
                break;
            case HP:
                v1 = (dungeon1 == null || TextUtils.isEmpty(dungeon1.getOpponentHp().replace(".", ""))) ? -1 : Integer.valueOf(dungeon1.getOpponentHp().replace(".", ""));
                v2 = (dungeon2 == null || TextUtils.isEmpty(dungeon2.getOpponentHp().replace(".", ""))) ? -1 : Integer.valueOf(dungeon2.getOpponentHp().replace(".", ""));
                v3 = (dungeon3 == null || TextUtils.isEmpty(dungeon3.getOpponentHp().replace(".", ""))) ? -1 : Integer.valueOf(dungeon3.getOpponentHp().replace(".", ""));
                break;
            case STR:
                v1 = (dungeon1 == null || TextUtils.isEmpty(dungeon1.getOpponentStr().replace(".", ""))) ? -1 : Integer.valueOf(dungeon1.getOpponentStr().replace(".", ""));
                v2 = (dungeon2 == null || TextUtils.isEmpty(dungeon2.getOpponentStr().replace(".", ""))) ? -1 : Integer.valueOf(dungeon2.getOpponentStr().replace(".", ""));
                v3 = (dungeon3 == null || TextUtils.isEmpty(dungeon3.getOpponentStr().replace(".", ""))) ? -1 : Integer.valueOf(dungeon3.getOpponentStr().replace(".", ""));
                break;
            case DEX:
                v1 = (dungeon1 == null || TextUtils.isEmpty(dungeon1.getOpponentDex().replace(".", ""))) ? -1 : Integer.valueOf(dungeon1.getOpponentDex().replace(".", ""));
                v2 = (dungeon2 == null || TextUtils.isEmpty(dungeon2.getOpponentDex().replace(".", ""))) ? -1 : Integer.valueOf(dungeon2.getOpponentDex().replace(".", ""));
                v3 = (dungeon3 == null || TextUtils.isEmpty(dungeon3.getOpponentDex().replace(".", ""))) ? -1 : Integer.valueOf(dungeon3.getOpponentDex().replace(".", ""));
                break;
            case INT:
                v1 = (dungeon1 == null || TextUtils.isEmpty(dungeon1.getOpponentIntel().replace(".", ""))) ? -1 : Integer.valueOf(dungeon1.getOpponentIntel().replace(".", ""));
                v2 = (dungeon2 == null || TextUtils.isEmpty(dungeon2.getOpponentIntel().replace(".", ""))) ? -1 : Integer.valueOf(dungeon2.getOpponentIntel().replace(".", ""));
                v3 = (dungeon3 == null || TextUtils.isEmpty(dungeon3.getOpponentIntel().replace(".", ""))) ? -1 : Integer.valueOf(dungeon3.getOpponentIntel().replace(".", ""));
                break;
            case CON:
                v1 = (dungeon1 == null || TextUtils.isEmpty(dungeon1.getOpponentCons().replace(".", ""))) ? -1 : Integer.valueOf(dungeon1.getOpponentCons().replace(".", ""));
                v2 = (dungeon2 == null || TextUtils.isEmpty(dungeon2.getOpponentCons().replace(".", ""))) ? -1 : Integer.valueOf(dungeon2.getOpponentCons().replace(".", ""));
                v3 = (dungeon3 == null || TextUtils.isEmpty(dungeon3.getOpponentCons().replace(".", ""))) ? -1 : Integer.valueOf(dungeon3.getOpponentCons().replace(".", ""));
                break;
            case LUCK:
                v1 = (dungeon1 == null || TextUtils.isEmpty(dungeon1.getOpponentLuck().replace(".", ""))) ? -1 : Integer.valueOf(dungeon1.getOpponentLuck().replace(".", ""));
                v2 = (dungeon2 == null || TextUtils.isEmpty(dungeon2.getOpponentLuck().replace(".", ""))) ? -1 : Integer.valueOf(dungeon2.getOpponentLuck().replace(".", ""));
                v3 = (dungeon3 == null || TextUtils.isEmpty(dungeon3.getOpponentLuck().replace(".", ""))) ? -1 : Integer.valueOf(dungeon3.getOpponentLuck().replace(".", ""));
                break;
        }

        max = Math.max(v1, Math.max(v2, v3));
        if (max == v1)
            return 0;
        else if (max == v2)
            return 1;
        else if (max == v3)
            return 2;

        return -1;
    }

    public void setLight(boolean light) {
        this.light = light;
    }

}
