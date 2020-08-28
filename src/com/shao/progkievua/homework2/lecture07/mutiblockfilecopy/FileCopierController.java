package com.shao.progkievua.homework2.lecture07.mutiblockfilecopy;

import java.io.*;

public class FileCopierController {
    private FileCopyProcessStage stage;
    private File fromFile;
    private File toFile;
    private double process;
    private byte[] buffer = new byte[1024];
    private int byteRead;
    private FileInputStream fis;
    private FileOutputStream fos;

    public FileCopierController(String fromFilePath, String toDirPath) {
        init(fromFilePath, toDirPath);
    }

    private void init(String fromFilePath, String toDirPath) {
        stage = FileCopyProcessStage.READ;
        fromFile = new File(fromFilePath);
        toFile = new File(new File(toDirPath).getPath() + File.separator + fromFile.getName());
        try {
            fis = new FileInputStream(fromFile.toString());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        try {
            fos = new FileOutputStream(toFile.toString());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public synchronized void readBlockFromFile(FileCopyProcessStage stage) {
        waitThread(stage);
        try {
            byteRead = fis.read(buffer);
        } catch (IOException e) {
            e.printStackTrace();
        }
        if (byteRead <= 0) this.stage = FileCopyProcessStage.DONE;
        else this.stage = FileCopyProcessStage.COUNTING;
        sleepThread(10);
        notifyAll();
    }

    public synchronized void writeBlockToFile(FileCopyProcessStage stage) {
        waitThread(stage);
        if (byteRead <= 0) this.stage = FileCopyProcessStage.DONE;
        else this.stage = FileCopyProcessStage.READ;
        try {
            fos.write(buffer, 0, byteRead);
        } catch (IOException e) {
            e.printStackTrace();
        }
        sleepThread(10);
        notifyAll();
    }

    public synchronized void calculateProcess(FileCopyProcessStage stage) {
        waitThread(stage);
        if (byteRead <= 0) this.stage = FileCopyProcessStage.DONE;
        else this.stage = FileCopyProcessStage.WRITE;
        process += 1024 / (fromFile.length() / .100) * 1000;
        if (process > 100) process = 100;
        sleepThread(10);
        notifyAll();
    }

    public FileCopyProcessStage getStage() {
        return stage;
    }

    public double getProcess() {
        return process;
    }

    public File getFromFile() {
        return fromFile;
    }

    private void waitThread(FileCopyProcessStage stage) {
        while (this.stage != stage) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    private void sleepThread(long millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            System.out.println(e.getMessage());
            Thread.currentThread().interrupt();
        }
    }
}
