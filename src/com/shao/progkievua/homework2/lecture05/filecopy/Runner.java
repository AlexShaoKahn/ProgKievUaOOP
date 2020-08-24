package com.shao.progkievua.homework2.lecture05.filecopy;

import com.shao.progkievua.homework2.lecture05.FileTools;

import java.io.IOException;
import java.util.Arrays;

public class Runner {
    public static void main(String[] args) throws IOException {
        String fromDirPath = ".\\src\\com\\shao\\progkievua\\homework2\\lecture05\\filecopy\\CopyFrom";
        String toDirPath = ".\\src\\com\\shao\\progkievua\\homework2\\lecture05\\filecopy\\CopyTo";
        String[] copiedFilesList = FileTools.copyAllFilesByExtension(fromDirPath, toDirPath, FileExtensions.PDF);
        System.out.println("List of copied files");
        Arrays.stream(copiedFilesList).forEach(System.out::println);
    }
}
