package com.sfgassistant.presenters.guides;

import com.sfgassistant.models.guide.Classs;
import com.sfgassistant.models.ModelManager;
import com.sfgassistant.models.guide.Race;

import java.util.List;

/**
 * Created by pierr on 18/09/2016.
 */

public class ClassesInteractor {

    private List<Race>      races;
    private List<Classs>    classes;

    public ClassesInteractor(ModelManager modelManager) {
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
