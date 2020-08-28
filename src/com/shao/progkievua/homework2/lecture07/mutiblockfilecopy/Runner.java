package com.shao.progkievua.homework2.lecture07.mutiblockfilecopy;

public class Runner {
    public static void main(String[] args) {
        String fromFile = ".\\src\\com\\shao\\progkievua\\homework2\\lecture07\\mutiblockfilecopy\\from\\image.png";
        String toDir = ".\\src\\com\\shao\\progkievua\\homework2\\lecture07\\mutiblockfilecopy\\to";

        FileCopierController fileCopierController = new FileCopierController(fromFile, toDir);

        FileCopierThread readFromFile = new FileCopierThread(fileCopierController, FileCopyProcessStage.READ);
        FileCopierThread countPercent = new FileCopierThread(fileCopierController, FileCopyProcessStage.COUNTING);
        FileCopierThread writeToFile = new FileCopierThread(fileCopierController, FileCopyProcessStage.WRITE);

        Thread readThread = new Thread(readFromFile, "Thread reader");
        Thread countThread = new Thread(countPercent, "Thread counter");
        Thread writeThread = new Thread(writeToFile, "Thread writer");

        countThread.setDaemon(true);
        writeThread.setDaemon(true);

        readThread.start();
        countThread.start();
        writeThread.start();
    }
}
