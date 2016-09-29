package com.sfgassistant.presenters.guides;

import com.sfgassistant.R;
import com.sfgassistant.models.ModelManager;
import com.sfgassistant.utils.Constants;
import com.sfgassistant.views.guides.classes.Classes;
import com.sfgassistant.views.guides.classes.ClassesView;

/**
 * Created by pierr on 18/09/2016.
 */

public class ClassesPresenter implements Classes.Presenter {

    private ClassesView         view;
    private ClassesInteractor   interactor;

    public ClassesPresenter(ClassesView view, ModelManager modelManager) {
        this.view = view;
        this.interactor = new ClassesInteractor(modelManager);
    }

    @Override
    public void onClick(int viewId) {
        switch (viewId) {
            case R.id.m_human:
                view.setData(interactor.getRace(Constants.RACE_HUMAN));
                break;
            case R.id.f_human:
                view.setData(interactor.getRace(Constants.RACE_HUMAN));
                break;
            case R.id.m_orc:
                view.setData(interactor.getRace(Constants.RACE_ORC));
                break;
            case R.id.f_orc:
                view.setData(interactor.getRace(Constants.RACE_ORC));
                break;
            case R.id.m_elf:
                view.setData(interactor.getRace(Constants.RACE_ELF));
                break;
            case R.id.f_elf:
                view.setData(interactor.getRace(Constants.RACE_ELF));
                break;
            case R.id.m_darkelf:
                view.setData(interactor.getRace(Constants.RACE_DARKELF));
                break;
            case R.id.f_darkelf:
                view.setData(interactor.getRace(Constants.RACE_DARKELF));
                break;
            case R.id.m_dwarf:
                view.setData(interactor.getRace(Constants.RACE_DWARF));
                break;
            case R.id.f_dwarf:
                view.setData(interactor.getRace(Constants.RACE_DWARF));
                break;
            case R.id.m_goblin:
                view.setData(interactor.getRace(Constants.RACE_GOBLIN));
                break;
            case R.id.f_goblin:
                view.setData(interactor.getRace(Constants.RACE_GOBLIN));
                break;
            case R.id.m_gnome:
                view.setData(interactor.getRace(Constants.RACE_GNOME));
                break;
            case R.id.f_gnome:
                view.setData(interactor.getRace(Constants.RACE_GNOME));
                break;
            case R.id.m_demon:
                view.setData(interactor.getRace(Constants.RACE_DEMON));
                break;
            case R.id.f_demon:
                view.setData(interactor.getRace(Constants.RACE_DEMON));
                break;
            case R.id.mage:
                view.setData(interactor.getClass(Constants.CLASS_MAGE));
                break;
            case R.id.warrior:
                view.setData(interactor.getClass(Constants.CLASS_WARRIOR));
                break;
            case R.id.scout:
                view.setData(interactor.getClass(Constants.CLASS_SCOUT));
                break;
        }
    }
}
