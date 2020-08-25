package com.shao.progkievua.homework2.lecture06.multithreadfilecopy;

import java.io.File;

public class Runner {
    public static void main(String[] args) throws InterruptedException {
        String fromDir = ".\\src\\com\\shao\\progkievua\\homework2\\lecture06\\multithreadfilecopy\\CopyFrom";
        String toDir = ".\\src\\com\\shao\\progkievua\\homework2\\lecture06\\multithreadfilecopy\\CopyTo";
        System.out.println("Copied " + multiThreadDirCopy(fromDir, toDir) + " files");
    }

    private static int multiThreadDirCopy(String fromDir, String toDir) throws InterruptedException {
        File fDir = new File(fromDir);
        File[] files = fDir.listFiles(File::isFile);
        if (files == null) return 0;
        Thread[] threads = new Thread[files.length];
        for (int i = 0; i < threads.length; i++) {
            threads[i] = new Thread(new FileCopier(files[i], new File(new File(toDir).getPath() + "/" + files[i].getName())));
        }
        int count = 0;
        for (int i = 0; i < threads.length; i++) {
            if (count == 10) {
                for (int j = i - count; j < i; j++) {
                    threads[j].join();
                    count = 0;
                }
            }
            threads[i].start();
            count++;
        }
        return files.length;
    }
}
