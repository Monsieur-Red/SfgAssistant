package com.sfgassistant.views.guides.classes;

import com.sfgassistant.models.guide.Classs;
import com.sfgassistant.models.guide.Race;

/**
 * Created by pierr on 18/09/2016.
 */

public interface Classes {

    interface Presenter {
        Race getRace(int id);

        Classs getClass(int id);
    }

}
