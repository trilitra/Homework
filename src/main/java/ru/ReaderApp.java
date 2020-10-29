package ru;

import java.io.*;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static com.sun.xml.internal.ws.util.VersionUtil.compare;

/**
 * Задание 1. Написать программу, читающую текстовый файл. Программа должна составлять отсортированный по алфавиту
 * список слов, найденных в файле и сохранять его в файл-результат. Найденные слова не должны повторяться, регистр
 * не должен учитываться. Одно слово в разных падежах – это разные слова.
 */
public class ReaderApp {

    public static void main(String[] args)  {
        try{
            ArrayList<String> list = readTxtFile();
            TreeSet<String> sortedSet = sortTxtFile(list);
            writeTxtFile(sortedSet);
        }catch (FileNotFoundException e){
            e.getStackTrace();
        }
    }

    /**
     * Метод для записи отсоритрованного текста в файл .txt , если файл уже записывался, он будет перезаписан
     * @param sortedSet принимаемый аргумент - TreeSet отсортированных слов
     */
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

    /**
     * Метод для записи считанных слов из исходного файла  их в TreeSet и их сортировки
     * @param list принимаемый аргумент - ArrayList созданный из слов считанных из исходного файла
     * @return возвращаемый аргумент - TreeSet отсортированных слов
     */
    private static TreeSet<String> sortTxtFile(ArrayList<String> list) {
        Comparator<String> comparator = (String string1, String string2) -> string1.compareToIgnoreCase(string2) ;
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

    /**
     * Метод для считавания и записи в ArrayList слов из исходного файла
     * @return  возвращаемы параметр - ArrayList слов из исходного текста
     * @throws FileNotFoundException исключение появится если будет не найден исходный файл для считывания
     */
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


