package com.shao.progkievua.homework2.lecture10.asciiletters2;

import java.io.IOException;

public class Runner {
    public static void main(String[] args) {
        CustomizableFont myFont = new CustomizableFont();
        try {
            myFont.loadFontFromFile(".\\src\\com\\shao\\progkievua\\homework2\\lecture10\\asciiletters2\\font.fnt");
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }

        System.out.println(myFont.drawToString("Hello Shao!"));
    }
}
