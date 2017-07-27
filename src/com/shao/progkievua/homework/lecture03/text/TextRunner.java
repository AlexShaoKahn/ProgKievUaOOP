package com.shao.progkievua.homework.lecture03.text;

public class TextRunner {
    public static void main(String[] args) {
        Text text = new Text("Shakespeare's Sonnet #1");

        text
                .addText("From fairest creatures we desire increase,")
                .addText("That thereby beauty's rose might never die,")
                .addText("But as the riper should by time decease,")
                .addText("His tender heir might bear his memory:")
                .newLine()
                .addText("But thou, contracted to thine own bright eyes,")
                .addText("Feed'st thy light's flame with self-substantial fuel,")
                .addText("Making a famine where abundance lies,")
                .addText("Thy self thy foe, to thy sweet self too cruel.")
                .newLine()
                .addText("Thou that art now the world's fresh ornament,")
                .addText("And only herald to the gaudy spring,")
                .addText("Within thine own bud buriest thy content,")
                .addText("And tender churl mak'st waste in niggarding:")
                .newLine()
                .addText("Pity the world, or else this glutton be,")
                .addText("To eat the world's due, by the grave and thee.");

        System.out.println(text.toString());
    }
}
