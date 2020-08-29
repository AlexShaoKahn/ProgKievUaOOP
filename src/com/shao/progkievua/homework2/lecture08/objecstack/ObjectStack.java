package com.shao.progkievua.homework2.lecture08.objecstack;

import java.io.Serializable;
import java.util.EmptyStackException;

public class ObjectStack implements Serializable {
    private final static int MAX_SIZE = Integer.MAX_VALUE;
    private static final long serialVersionUID = -4361640141439464271L;
    private int index;
    private Object[] objects;
    private ClassBlackList blackList;

    public ObjectStack() {
        this(new ClassBlackList());
    }

    public ObjectStack(ClassBlackList blackList) {
        this.blackList = blackList;
        index = -1;
        objects = new Object[10];
    }

    public void push(Object object) {
        if (blackList.isClassInBlackList(object)) throw new ClassCastException();
        if (objects.length >= MAX_SIZE) throw new StackOverflowError();
        else {
            checkForResize();
            objects[++index] = object;
        }
    }

    public Object pop() {
        if (index - 1 < 0) throw new EmptyStackException();
        Object result = objects[index];
        objects[index--] = null;
        return result;
    }

    public Object peek() {
        if (index < 0) throw new EmptyStackException();
        return objects[index];
    }

    private void checkForResize() {
        if (objects.length == index + 1 && objects.length < MAX_SIZE) {
            Object[] newObjects = new Object[objects.length + (objects.length / 2) >= MAX_SIZE ? MAX_SIZE : objects.length + (objects.length / 2)];
            System.arraycopy(objects, 0, newObjects, 0, objects.length);
            objects = newObjects;
        }
    }

    public int size() {
        if (index < 0) return 0;
        else return index + 1;
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder("ObjectStack --------------").append(System.lineSeparator());
        for (int i = 0; i <= index; i++) {
            result.append(objects[i].getClass().getSimpleName()).append(": ").append(objects[i].toString())
                    .append(System.lineSeparator());
        }
        return result.toString();
    }
}
