package ru.unnopolis.university.homework.task01.Spisok;

/**
 * Class Main
 */
public class Main {
    public static void main(String[] args) {
        try {
            Person[] massiv = Massiv.generate(70);
            SortCollections.sort(massiv);
            SortArrays.sort(massiv);
        } catch (PersonException e) {
            System.out.println("В сгенерированном массиве есть одинаковые элементы! Попробуйте еще раз");
        }
    }
}
