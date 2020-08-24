package com.shao.progkievua.homework2.lecture05.filesmerge;

import com.shao.progkievua.homework2.lecture05.FileTools;

import java.io.IOException;

public class Runner {
    public static void main(String[] args) throws IOException {
        String fileName1 = ".\\src\\com\\shao\\progkievua\\homework2\\lecture05\\filesmerge\\60683986.txt";
        String fileName2 = ".\\src\\com\\shao\\progkievua\\homework2\\lecture05\\filesmerge\\71405319.txt";
        String toFileName = ".\\src\\com\\shao\\progkievua\\homework2\\lecture05\\filesmerge\\merged.txt";
        System.out.println(FileTools.mergeFiles(fileName1, fileName2, toFileName));
    }
}
