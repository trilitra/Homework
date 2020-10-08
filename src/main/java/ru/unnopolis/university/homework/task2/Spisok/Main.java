package ru.unnopolis.university.homework.task2.Spisok;

public class Main {
    public static void main(String[] args) {
        try {
            Person[] massiv = Massiv.generate(100);
            SortCollections.sort(massiv);
            SortArrays.sort(massiv);
        } catch (PersonException e) {
            System.out.println("В сгенерированном массиве есть одинаковые элементы!");
        }
    }
}
