package com.shao.progkievua.homework2.lecture07.multithreadsearch;

import com.shao.progkievua.homework2.lecture05.filecopy.FileExtensions;

import java.io.File;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

public class FileSearcher implements Runnable {

    private static ThreadPoolExecutor executor = (ThreadPoolExecutor) Executors.newFixedThreadPool(5);
    private File fileName;
    private FileExtensions extension;
    private File startDir;

    public FileSearcher(String fileNamePath, String startDirPath) {
        this(fileNamePath, new File(startDirPath));
    }

    private FileSearcher(String fileNamePath, File startDir) {
        this(new File(fileNamePath), startDir);
    }

    private FileSearcher(File fileName, File startDir) {
        this.fileName = fileName;
        this.startDir = startDir;
    }

    public FileSearcher(FileExtensions extension, String startDirPath) {
        this(extension, new File(startDirPath));
    }

    private FileSearcher(FileExtensions extension, File startDir) {
        this.extension = extension;
        this.startDir = startDir;
    }

    public static ThreadPoolExecutor getExecutor() {
        return executor;
    }

    @Override
    public void run() {
        if (fileName != null) searchFile(fileName);
        else searchFile(extension);
    }

    private void searchFile(File fileName) {
        File[] dirList = startDir.listFiles();
        if (dirList != null)
            for (File file : dirList) {
                if (file.isDirectory()) {
                    executor.submit(new Thread(new FileSearcher(fileName, file)));
                } else {
                    if (file.getName().equals(fileName.getName()))
                        System.out.println(file.getPath());
                }
            }
    }

    private void searchFile(FileExtensions extension) {
        File[] dirList = startDir.listFiles();
        if (dirList != null)
            for (File file : dirList) {
                if (file.isDirectory()) {
                    executor.submit(new Thread(new FileSearcher(extension, file)));
                } else {
                    if (file.getName().endsWith("." + extension.name().toLowerCase()))
                        System.out.println(file.getPath());
                }
            }
    }
}
