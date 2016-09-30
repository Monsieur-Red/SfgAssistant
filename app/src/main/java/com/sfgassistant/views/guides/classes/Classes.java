package com.sfgassistant.views.guides.classes;

import com.sfgassistant.models.guide.Classs;
import com.sfgassistant.models.guide.Race;

/**
 * Created by pierr on 18/09/2016.
 */

public interface Classes {

    interface View {
        void setData(Race race);

        void setData(Classs classs);
    }

    interface Presenter {

        void onClick(int viewId);
    }

}
