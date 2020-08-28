package com.shao.progkievua.homework2.lecture07.multithreadsearch;

import com.shao.progkievua.homework2.lecture05.filecopy.FileExtensions;

public class Runner {
    public static void main(String[] args) {
        String startDir = ".";
        FileSearcher fileSearcherByExtension = new FileSearcher(FileExtensions.TXT, startDir);
        FileSearcher fileSearcherByName = new FileSearcher("fileToCopy4.txt", startDir);

        FileSearcher.getExecutor().submit(fileSearcherByExtension);
        while (FileSearcher.getExecutor().getActiveCount() > 0) {
        }

        System.out.println("---------------------------------------");
        FileSearcher.getExecutor().submit(fileSearcherByName);
        while (FileSearcher.getExecutor().getActiveCount() > 0) {
        }

        FileSearcher.getExecutor().shutdown();
    }
}
