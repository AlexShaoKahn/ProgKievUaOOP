package com.shao.progkievua.homework2.lecture05.filecopy;

import java.io.File;

@FunctionalInterface
public interface FilenameFilter {
    boolean accept(File dir, String name);
}
