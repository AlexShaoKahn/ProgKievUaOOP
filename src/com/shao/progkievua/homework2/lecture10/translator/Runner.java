package com.shao.progkievua.homework2.lecture10.translator;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Random;
import java.util.Set;

public class Runner {
    public final static String HOME_DIR = ".\\src\\com\\shao\\progkievua\\homework2\\lecture10\\translator\\";

    public static void main(String[] args) {

        String enukDictFilePath = HOME_DIR + "enukDict.dic";
        LanguageDictionary enukDictionary = new LanguageDictionary();
        enukDictionary.loadDictionaryFromFile(enukDictFilePath);

        try {
            translateTextFromFile(generateFileToTranslate(enukDictionary), HOME_DIR + "Ukrainian.out", enukDictionary);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void translateTextFromFile(String fromFilePath, String toFilePath, WordsTranslator translator) throws IOException {
        String textToTranslate = Files.readString(Paths.get(fromFilePath));
        StringBuilder translatedText = new StringBuilder();
        String[] words = textToTranslate.split(" ");
        for (String word : words) {
            translatedText.append(translator.translate(word)).append(" ");
        }
        Files.writeString(Paths.get(toFilePath), translatedText.toString());
    }

    private static String generateFileToTranslate(LanguageDictionary dictionary) throws IOException {
        StringBuilder result = new StringBuilder();
        Random random = new Random();
        Set<String> setStrings = dictionary.getDictionary().keySet();
        String[] words = setStrings
                .stream()
                .map(String::toLowerCase)
                .toArray(String[]::new);
        for (int i = 0; i < random.nextInt(10000) + 1000; i++) {
            result.append(words[random.nextInt(words.length)]).append(" ");
        }
        Files.writeString(Paths.get(HOME_DIR + "English.in"), result.toString());
        return HOME_DIR + "English.in";
    }
}
