package com.shao.progkievua.homework2.lecture08.groupsserialization;

import com.shao.progkievua.homework2.lecture04.IGroup;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Faculty implements Serializable {
    private static final long serialVersionUID = -8542411169537317604L;
    private List<IGroup> groupsList;

    public Faculty() {
        groupsList = new ArrayList<>();
    }

    public Faculty(List<IGroup> groupsList) {
        this.groupsList = groupsList;
    }

    public void addGroup(IGroup group) {
        groupsList.add(group);
    }

    public void writeToDB(String dbFile) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(new File(dbFile)))) {
            oos.writeObject(groupsList);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public List<IGroup> readFromDb(String dbFile) {
        List<IGroup> result = new ArrayList<>();
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(new File(dbFile)))) {
            result = (List<IGroup>) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return result;
    }

    public void readAndAddFromDB(String dbFile) {
        List<IGroup> additionalGroupList = readFromDb(dbFile);
        groupsList.addAll(additionalGroupList);
    }

    public List<IGroup> getGroupsList() {
        return groupsList;
    }

    public void setGroupsList(List<IGroup> groupsList) {
        this.groupsList = groupsList;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Faculty)) return false;
        Faculty faculty = (Faculty) o;
        return groupsList.equals(faculty.groupsList);
    }

    @Override
    public int hashCode() {
        return Objects.hash(groupsList);
    }

    @Override
    public String toString() {
        return "Faculty{" +
                "groupsList=" + groupsList +
                '}';
    }
}
