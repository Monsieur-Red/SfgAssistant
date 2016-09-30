package com.sfgassistant.views.guides.classes;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.sfgassistant.MainActivity;
import com.sfgassistant.R;
import com.sfgassistant.models.guide.Classs;
import com.sfgassistant.models.guide.Race;
import com.sfgassistant.presenters.guides.ClassesPresenter;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by pierr on 18/09/2016.
 */

public class ClassesView extends Fragment implements Classes.View, View.OnClickListener {

    private ClassesPresenter    presenter;

    @BindView(R.id.race) TextView race;
    @BindView(R.id.classs) TextView classs;
    @BindView(R.id.strength_race) TextView strRace;
    @BindView(R.id.strength_class) TextView strClass;
    @BindView(R.id.dexterity_race) TextView dexRace;
    @BindView(R.id.dexterity_class) TextView dexClass;
    @BindView(R.id.intelligence_race) TextView intRace;
    @BindView(R.id.intelligence_class) TextView intClass;
    @BindView(R.id.constitution_race) TextView consRace;
    @BindView(R.id.constitution_class) TextView consClass;
    @BindView(R.id.luck_race) TextView luckRace;
    @BindView(R.id.luck_class) TextView luckClass;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        presenter = new ClassesPresenter(this, ((MainActivity)getActivity()).getModelManager());
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_guides_classes, container, false);
        ButterKnife.bind(this, view);
        return (view);
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        ButterKnife.findById(view, R.id.m_human).setOnClickListener(this);
        ButterKnife.findById(view, R.id.f_human).setOnClickListener(this);
        ButterKnife.findById(view, R.id.m_orc).setOnClickListener(this);
        ButterKnife.findById(view, R.id.f_orc).setOnClickListener(this);
        ButterKnife.findById(view, R.id.m_elf).setOnClickListener(this);
        ButterKnife.findById(view, R.id.f_elf).setOnClickListener(this);
        ButterKnife.findById(view, R.id.m_darkelf).setOnClickListener(this);
        ButterKnife.findById(view, R.id.f_darkelf).setOnClickListener(this);
        ButterKnife.findById(view, R.id.m_dwarf).setOnClickListener(this);
        ButterKnife.findById(view, R.id.f_dwarf).setOnClickListener(this);
        ButterKnife.findById(view, R.id.m_goblin).setOnClickListener(this);
        ButterKnife.findById(view, R.id.f_goblin).setOnClickListener(this);
        ButterKnife.findById(view, R.id.m_gnome).setOnClickListener(this);
        ButterKnife.findById(view, R.id.f_gnome).setOnClickListener(this);
        ButterKnife.findById(view, R.id.m_demon).setOnClickListener(this);
        ButterKnife.findById(view, R.id.f_demon).setOnClickListener(this);
        ButterKnife.findById(view, R.id.mage).setOnClickListener(this);
        ButterKnife.findById(view, R.id.warrior).setOnClickListener(this);
        ButterKnife.findById(view, R.id.scout).setOnClickListener(this);
    }

    @Override
    public void setData(Race race) {
        this.race.setText(race.getRace());
        strRace.setText(race.getStrenght());
        dexRace.setText(race.getDexterity());
        intRace.setText(race.getIntelligence());
        consRace.setText(race.getConstitution());
        luckRace.setText(race.getLuck());
    }

    @Override
    public void setData(Classs classs) {
        this.classs.setText(classs.getClasss());
        strClass.setText(classs.getStrength());
        dexClass.setText(classs.getDexterity());
        intClass.setText(classs.getIntelligence());
        consClass.setText(classs.getConstitution());
        luckClass.setText(classs.getLuck());
    }

    @Override
    public void onClick(View view) {
        presenter.onClick(view.getId());
    }
}
