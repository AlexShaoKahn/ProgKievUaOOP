package com.shao.progkievua.homework2.lecture08.objecstack;

import java.util.ArrayList;
import java.util.List;

public class ClassBlackList {
    private List<Class> blackList;

    public ClassBlackList() {
        blackList = new ArrayList<>();
    }

    public void addClass(Class blackClass) {
        if (!blackList.contains(blackClass)) blackList.add(blackClass);
    }

    public boolean isClassInBlackList(Object object) {
        return blackList.contains(object.getClass());
    }
}
