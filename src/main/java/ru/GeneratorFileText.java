package ru;

import java.io.*;
import java.util.Random;

/**
 * Задание 2. Создать генератор текстовых файлов, работающий по следующим правилам:
 * <p>
 * Предложение состоит из 1<=n1<=15 слов. В предложении после произвольных слов могут находиться запятые.
 * Слово состоит из 1<=n2<=15 латинских букв
 * Слова разделены одним пробелом
 * Предложение начинается с заглавной буквы
 * Предложение заканчивается (.|!|?)+" "
 * Текст состоит из абзацев. в одном абзаце 1<=n3<=20 предложений. В конце абзаца стоит разрыв строки и перенос каретки.
 * Есть массив слов 1<=n4<=1000. Есть вероятность probability вхождения одного из слов этого массива в следующее
 * предложение (1/probability).
 * Необходимо написать метод getFiles(String path, int n, int size, String[] words, int probability),
 * который создаст n файлов размером size в каталоге path. words - массив слов, probability - вероятность.
 */
public class GeneratorFileText {
    private static final String[] words = {"program", "idea", "mama", "papa", "mail", "work", "learn"};
    private static final Random random = new Random();
    private static final String lower = "abcdefghijklmnopqrstuvwxyz";
    private static final String upper = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    private static final String punctuation = "!.?";

    public static void main(String[] args) {
        getFiles("C:\\Users\\efano\\IdeaProjects\\Homework", 3, 300, 10);
    }

    /**
     * Метод для создания текстовых файлов, путем создания текста, состоящего из абзацев. Абзац состоит из предложений.
     * Предложения состоят из первого слова, последнего слова, слов в серидине.
     *
     * @param path        место расположения дя создаваемых файлов
     * @param n           количество создаваемых файлов
     * @param size        размер в байтах создаваемого файла
     * @param probability вероятность включения слова из исходного массива слов в создаваемые файлы (1/probability)
     */
    private static void getFiles(String path, int n, int size, int probability) {

        for (int i = 0; i < n; i++) {
            File file = new File(path, "TextFile" + i + ".txt");
            try (FileWriter writer = new FileWriter(file)) {
                String text = getText(probability);
                while (file.length() <= size) {
                    writer.write(text);
                }
                writer.flush();
            } catch (IOException ex) {
                ex.getStackTrace();
            }
        }
    }

    private static String getText(Integer probability) {

        int length = random.nextInt(20) + 1;
        StringBuilder text = new StringBuilder(length);
        for (int i = 0; i < length; i++) {
            text.append(getParagraph(probability));
        }
        return new String(text);
    }

    private static String getParagraph(Integer probability) {

        int length = random.nextInt(20) + 1;
        StringBuilder paragraph = new StringBuilder(length);
        paragraph.append("    ");
        for (int i = 0; i < length; i++) {
            paragraph.append(getSentence(probability));
        }
        paragraph.append("\n");
        return new String(paragraph);

    }

    private static String getSentence(Integer probability) {

        int length = random.nextInt(12) + 1;
        StringBuilder sentence = new StringBuilder(length);
        sentence.append(getFirstWord());
        boolean val = random.nextInt(probability) == 0;
        if (val) {
            sentence.append(words[random.nextInt(words.length)] + " ");
        }
        for (int i = 0; i < length; i++) {
            sentence.append(getMiddleWord());
        }
        sentence.append(getLastWord());
        sentence.append("\n");
        return new String(sentence);
    }

    private static String getFirstWord() {

        int length = random.nextInt(14) + 1;
        StringBuilder word = new StringBuilder(length);
        int positionUpper = random.nextInt(26);
        word.append(upper.charAt(positionUpper));

        for (int i = 0; i < length; i++) {
            int position = random.nextInt(26);
            word.append(lower.charAt(position));
        }
        boolean val = random.nextInt(10) == 0;
        if (val) {
            word.append(",");
        }
        word.append(" ");
        return new String(word);
    }


    private static String getLastWord() {

        int length = random.nextInt(15) + 1;
        StringBuilder word = new StringBuilder(length);

        for (int i = 0; i < length; i++) {
            int position = random.nextInt(26);
            word.append(lower.charAt(position));
        }
        int positionUpper = random.nextInt(3);
        word.append(punctuation.charAt(positionUpper));
        word.append(" ");
        return new String(word);
    }


    private static String getMiddleWord() {

        int length = random.nextInt(15) + 1;
        StringBuilder word = new StringBuilder(length);

        for (int i = 0; i < length; i++) {
            int position = random.nextInt(26);
            word.append(lower.charAt(position));
        }
        boolean val = random.nextInt(10) == 0;
        if (val) {
            word.append(",");
        }
        word.append(" ");
        return new String(word);
    }
}
