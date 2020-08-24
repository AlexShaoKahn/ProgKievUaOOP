package com.shao.progkievua.homework2.lecture05.saveloadgroup;

import com.google.gson.Gson;
import com.shao.progkievua.homework2.lecture04.IGroup;

import java.io.IOException;
import java.io.Serializable;
import java.nio.file.Files;
import java.nio.file.Paths;

public class GroupDAO implements DAO<IGroup>, Serializable {

    private String dbFile;

    public GroupDAO() {
    }

    public GroupDAO(String dbFile) {
        this.dbFile = dbFile;
    }

    public String getDbFile() {
        return dbFile;
    }

    public void setDbFile(String dbFile) {
        this.dbFile = dbFile;
    }

    @Override
    public void saveGroup(IGroup group) throws IOException {
        Files.writeString(Paths.get(dbFile), new Gson().toJson(group));
    }

    @Override
    public IGroup loadGroup(String fileName) throws IOException {
        return new Gson().fromJson(Files.readString(Paths.get(fileName)), IGroup.class);
    }
}
