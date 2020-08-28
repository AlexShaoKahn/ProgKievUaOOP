package com.shao.progkievua.homework2.lecture07.mutiblockfilecopy;

public class FileCopierThread implements Runnable {
    private final FileCopierController controller;
    private final FileCopyProcessStage stage;

    public FileCopierThread(FileCopierController controller, FileCopyProcessStage stage) {
        this.controller = controller;
        this.stage = stage;
    }

    @Override
    public void run() {
        while (!Thread.currentThread().isInterrupted() && controller.getStage() != FileCopyProcessStage.DONE) {
            switch (stage) {
                case READ -> controller.readBlockFromFile(stage);
                case WRITE -> controller.writeBlockToFile(stage);
                case COUNTING -> controller.calculateProcess(stage);
            }
            System.out.print("File copy: " + controller.getFromFile().getName() + "\t");
            System.out.print(String.format("%.1f", controller.getProcess()) + "%\r");
        }
    }
}
