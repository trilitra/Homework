package ru;

import java.io.*;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Задание 1. Написать программу, читающую текстовый файл. Программа должна составлять отсортированный по алфавиту
 * список слов, найденных в файле и сохранять его в файл-результат. Найденные слова не должны повторяться, регистр
 * не должен учитываться. Одно слово в разных падежах – это разные слова.
 *
 *
 * Задание 2. Создать генератор текстовых файлов, работающий по следующим правилам:
 *
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
public class ReaderApp {

    public static void main(String[] args) throws FileNotFoundException {
        ArrayList<String> list = readTxtFile();
        TreeSet<String> sortedSet = sortTxtFile(list);
        writeTxtFile(sortedSet);
    }

    private static void writeTxtFile(TreeSet<String> sortedSet) {
        try(FileWriter writer = new FileWriter("SortedTask04.txt", false))
        {
            for (String i : sortedSet) {
                writer.write(i + "\n");
            }
            writer.flush();
        }
        catch(IOException ex){
            System.out.println(ex.getMessage());
        }
    }

    private static TreeSet<String> sortTxtFile(ArrayList<String> list) {
        Comparator<String> comparator = new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                int stringCompare = o1.compareToIgnoreCase(o2);

                if (stringCompare != 0) {
                    return stringCompare;
                } else {
                    return 0;
                }
            }
        };
        TreeSet<String> sortedSet = new TreeSet<>(comparator);
        Pattern pattern = Pattern.compile("[а-яА-яa-zA-Z]+\\b");
        for (int i = 0; i < list.size(); i++) {
            Matcher matcher = pattern.matcher(list.get(i));
            while (matcher.find()) {
                sortedSet.add(list.get(i).substring(matcher.start(), matcher.end()));
            }
        }
        return sortedSet;
    }

    private static ArrayList<String> readTxtFile() throws FileNotFoundException {
        ArrayList<String> list = new ArrayList<>();
        Scanner scanner = new Scanner(new File("task04.txt"));
        while (scanner.hasNext()) {
            list.add(scanner.nextLine());
        }
        scanner.close();
        return list;
    }
}


