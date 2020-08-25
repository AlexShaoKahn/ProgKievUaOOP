package com.shao.progkievua.homework2.lecture06.dirchecker;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

public class DirChecker implements Runnable {
    private File dir;
    private int filesCounter;
    private Thread thread;

    public DirChecker(String dir) {
        this.dir = new File(dir);
        filesCounter = this.dir.listFiles(File::isFile) != null ? this.dir.listFiles(File::isFile).length : 0;
        thread = new Thread(this);
        thread.start();
    }

    private String checkDir() {
        StringBuilder answer = new StringBuilder();
        SimpleDateFormat sdf = new SimpleDateFormat("dd:MM:yy hh:mm:ss");
        answer.append(sdf.format(new Date())).append(System.lineSeparator());
        if (dir.listFiles(File::isFile) != null)
            Arrays.stream(dir.listFiles(File::isFile)).forEach(file -> answer.append(file.getName()).append(System.lineSeparator()));
        int currentFilesCounter = dir.listFiles(File::isFile) != null ? dir.listFiles(File::isFile).length : 0;
        if (filesCounter > currentFilesCounter)
            answer.append(filesCounter - currentFilesCounter).append(" file(s) deleted!");
        else if (filesCounter < currentFilesCounter)
            answer.append(currentFilesCounter - filesCounter).append(" file(s) added");
        else if (filesCounter == currentFilesCounter) answer.append("OK");
        answer.append(System.lineSeparator());
        filesCounter = currentFilesCounter;
        return answer.toString();
    }

    @Override
    public void run() {
        for (; ; ) {
            System.out.println(checkDir());
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                System.out.println(e.getMessage());
                break;
            }
        }
    }
}
