package com.shao.progkievua.homework2.lecture07.multithreadsearch;

import com.shao.progkievua.homework2.lecture05.filecopy.FileExtensions;

public class Runner {
    public static void main(String[] args) {
        String startDir = ".";
        FileSearcher fileSearcherByExtension = new FileSearcher(FileExtensions.TXT, startDir);
        FileSearcher fileSearcherByName = new FileSearcher("fileToCopy4.txt", startDir);

        FileSearcher.executor.submit(new Thread(fileSearcherByExtension));
        while (FileSearcher.executor.getActiveCount() > 0) {
        }

        System.out.println("---------------------------------------");
        FileSearcher.executor.submit(new Thread(fileSearcherByName));
        while (FileSearcher.executor.getActiveCount() > 0) {
        }

        FileSearcher.executor.shutdown();
    }
}
