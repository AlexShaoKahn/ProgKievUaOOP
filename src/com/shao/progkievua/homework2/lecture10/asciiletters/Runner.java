package com.shao.progkievua.homework2.lecture10.asciiletters;

import java.awt.*;
import java.awt.image.BufferedImage;

public class Runner {
    public static void main(String[] args) {
        System.out.println(asciiLine("Hello Shao!"));
    }

    private static String asciiLine(String lineToWrite) {
        StringBuilder result = new StringBuilder();
        int width = 150;
        int height = 20;

        BufferedImage bufferedImage = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
        Graphics graphics = bufferedImage.getGraphics();
        graphics.setFont(new Font("SansSerif", Font.PLAIN, 15));

        Graphics2D graphics2D = (Graphics2D) graphics;
        graphics2D.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING,
                RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
        graphics2D.drawString(lineToWrite, 10, 20);

        for (int y = 0; y < height; y++) {
            StringBuilder tempLine = new StringBuilder();
            for (int x = 0; x < width; x++) tempLine.append(bufferedImage.getRGB(x, y) == -16777216 ? " " : "#");
            if (tempLine.toString().trim().isEmpty()) continue;
            result.append(tempLine).append(System.lineSeparator());
        }
        return result.toString();
    }
}
