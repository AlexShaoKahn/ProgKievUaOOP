package com.shao.progkievua.homework2.lecture06.multithreadfilecopy;

import com.shao.progkievua.homework2.lecture05.FileTools;

import java.io.File;

public class FileCopier implements Runnable {
    private File fromFileName;
    private File toFileName;

    public FileCopier(File fromFileName, File toFileName) {
        this.fromFileName = fromFileName;
        this.toFileName = toFileName;
    }

    @Override
    public void run() {
//        try {
        FileTools.fileCopy(fromFileName, toFileName);
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
    }
}
