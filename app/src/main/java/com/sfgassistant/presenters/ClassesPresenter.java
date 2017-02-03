package com.sfgassistant.presenters;

import com.sfgassistant.models.ModelManager;
import com.sfgassistant.models.guide.Classs;
import com.sfgassistant.models.guide.Race;
import com.sfgassistant.views.guides.classes.Classes;
import com.sfgassistant.views.guides.classes.ClassesView;

import java.util.List;

/**
 * Created by pierr on 18/09/2016.
 */

public class ClassesPresenter implements Classes.Presenter {

    private ClassesView view;
    private List<Race> races;
    private List<Classs> classes;

    public ClassesPresenter(ClassesView view, ModelManager modelManager) {
        this.view = view;
        races = modelManager.getRaces();
        classes = modelManager.getClasses();
    }

    public Race getRace(int id) {
        return races.get(id);
    }

    public Classs getClass(int id) {
        return classes.get(id);
    }

}
