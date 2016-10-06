package com.sfgassistant.views.guides.classes;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.cengalabs.flatui.views.FlatButton;
import com.sfgassistant.MainActivity;
import com.sfgassistant.R;
import com.sfgassistant.models.guide.Classs;
import com.sfgassistant.models.guide.Race;
import com.sfgassistant.presenters.ClassesPresenter;
import com.sfgassistant.utils.Constants;

import java.util.List;

import butterknife.BindString;
import butterknife.BindView;
import butterknife.BindViews;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by pierr on 18/09/2016.
 */

public class ClassesView extends Fragment {

    private ClassesPresenter    presenter;

    @BindViews({R.id.btn_human, R.id.btn_orc, R.id.btn_elf, R.id.btn_dark_elf, R.id.btn_dwarf, R.id.btn_goblin, R.id.btn_gnome, R.id.btn_demon}) List<FlatButton> buttons;
    @BindViews({R.id.btn_mage, R.id.btn_warrior, R.id.btn_scout}) List<ImageView> classButtons;
    @BindView(R.id.race) TextView race;
    @BindView(R.id.race_2) TextView race2;
    @BindView(R.id.classs) TextView classs;
    @BindView(R.id.strength_race) TextView strRace;
    @BindView(R.id.strength_race_2) TextView strRace2;
    @BindView(R.id.strength_class) TextView strClass;
    @BindView(R.id.dexterity_race) TextView dexRace;
    @BindView(R.id.dexterity_race_2) TextView dexRace2;
    @BindView(R.id.dexterity_class) TextView dexClass;
    @BindView(R.id.intelligence_race) TextView intRace;
    @BindView(R.id.intelligence_race_2) TextView intRace2;
    @BindView(R.id.intelligence_class) TextView intClass;
    @BindView(R.id.constitution_race) TextView consRace;
    @BindView(R.id.constitution_race_2) TextView consRace2;
    @BindView(R.id.constitution_class) TextView consClass;
    @BindView(R.id.luck_race) TextView luckRace;
    @BindView(R.id.luck_race_2) TextView luckRace2;
    @BindView(R.id.luck_class) TextView luckClass;
    @BindString(R.string.class_message) String message;

    private boolean[] buttonsState;
    private boolean leftRaceContentEmpty;
    private boolean rightRaceContentEmpty;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        presenter = new ClassesPresenter(this, ((MainActivity)getActivity()).getModelManager());
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_guides_classes, container, false);
        ButterKnife.bind(this, view);
        buttonsState = new boolean[8];
        leftRaceContentEmpty = true;
        rightRaceContentEmpty = true;
        return (view);
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        onClickHumanBtn();
        onClickOrcBtn();
        onClickWarriorBtn();
    }

    private void updateData(int raceId) {
        if (buttonsState[raceId] || (leftRaceContentEmpty || rightRaceContentEmpty)) {
            setButtonState(raceId);
            if (buttonsState[raceId])
                addRaceData(presenter.getRace(raceId));
            else
                removeRaceData(presenter.getRace(raceId));
        }
        else
            Toast.makeText(getContext(), message, Toast.LENGTH_SHORT).show();
    }

    private void setButtonState(int id) {
        if (buttonsState[id]) {
            buttons.get(id).getAttributes().setTheme(R.array.button_inactive, getResources());
            buttonsState[id] = false;
        }
        else {
            buttons.get(id).getAttributes().setTheme(R.array.button_active, getResources());
            buttonsState[id] = true;
        }
    }

    public void addRaceData(Race race) {
        if (leftRaceContentEmpty) {
            leftRaceContentEmpty = false;
            this.race.setText(race.getRace());
            strRace.setText(race.getStrength());
            dexRace.setText(race.getDexterity());
            intRace.setText(race.getIntelligence());
            consRace.setText(race.getConstitution());
            luckRace.setText(race.getLuck());
        }
        else {
            rightRaceContentEmpty = false;
            this.race2.setText(race.getRace());
            strRace2.setText(race.getStrength());
            dexRace2.setText(race.getDexterity());
            intRace2.setText(race.getIntelligence());
            consRace2.setText(race.getConstitution());
            luckRace2.setText(race.getLuck());
        }
    }

    public void removeRaceData(Race race) {
        if (this.race.getText().equals(race.getRace())) {
            leftRaceContentEmpty = true;
            this.race.setText("");
            strRace.setText("");
            dexRace.setText("");
            intRace.setText("");
            consRace.setText("");
            luckRace.setText("");
        }
        else {
            rightRaceContentEmpty = true;
            this.race2.setText("");
            strRace2.setText("");
            dexRace2.setText("");
            intRace2.setText("");
            consRace2.setText("");
            luckRace2.setText("");
        }
    }

    public void setClassData(Classs classs) {
        this.classs.setText(classs.getClasss());
        strClass.setText(classs.getStrength());
        dexClass.setText(classs.getDexterity());
        intClass.setText(classs.getIntelligence());
        consClass.setText(classs.getConstitution());
        luckClass.setText(classs.getLuck());
    }

    @OnClick(R.id.btn_human)
    public void onClickHumanBtn() {
        updateData(Constants.RACE_HUMAN);
    }

    @OnClick(R.id.btn_orc)
    public void onClickOrcBtn() {
        updateData(Constants.RACE_ORC);
    }

    @OnClick(R.id.btn_elf)
    public void onClickElfBtn() {
        updateData(Constants.RACE_ELF);
    }

    @OnClick(R.id.btn_dark_elf)
    public void onClickDarkElfBtn() {
        updateData(Constants.RACE_DARKELF);
    }

    @OnClick(R.id.btn_dwarf)
    public void onClickDwarfBtn() {
        updateData(Constants.RACE_DWARF);
    }

    @OnClick(R.id.btn_goblin)
    public void onClickGoblinBtn() {
        updateData(Constants.RACE_GOBLIN);
    }

    @OnClick(R.id.btn_gnome)
    public void onClickGnomeBtn() {
        updateData(Constants.RACE_GNOME);
    }

    @OnClick(R.id.btn_demon)
    public void onClickDemonBtn() {
        updateData(Constants.RACE_DEMON);
    }

    @OnClick(R.id.btn_warrior)
    public void onClickWarriorBtn() {
        classButtons.get(Constants.CLASS_WARRIOR).setSelected(true);
        classButtons.get(Constants.CLASS_MAGE).setSelected(false);
        classButtons.get(Constants.CLASS_SCOUT).setSelected(false);
        setClassData(presenter.getClass(Constants.CLASS_WARRIOR));
    }

    @OnClick(R.id.btn_mage)
    public void onClickMageBtn() {
        classButtons.get(Constants.CLASS_WARRIOR).setSelected(false);
        classButtons.get(Constants.CLASS_MAGE).setSelected(true);
        classButtons.get(Constants.CLASS_SCOUT).setSelected(false);
        setClassData(presenter.getClass(Constants.CLASS_MAGE));
    }

    @OnClick(R.id.btn_scout)
    public void onClickScoutBtn() {
        classButtons.get(Constants.CLASS_WARRIOR).setSelected(false);
        classButtons.get(Constants.CLASS_MAGE).setSelected(false);
        classButtons.get(Constants.CLASS_SCOUT).setSelected(true);
        setClassData(presenter.getClass(Constants.CLASS_SCOUT));
    }

}
