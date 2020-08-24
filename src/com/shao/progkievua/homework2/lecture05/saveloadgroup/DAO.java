package com.shao.progkievua.homework2.lecture05.saveloadgroup;

import java.io.IOException;

public interface DAO<T> {

    void saveGroup(T group) throws IOException;

    T loadGroup(String fileName) throws IOException;
}
