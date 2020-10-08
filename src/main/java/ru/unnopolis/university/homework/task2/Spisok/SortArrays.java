package ru.unnopolis.university.homework.task2.Spisok;

import java.util.Arrays;

public class SortArrays {
    public static void sort(Person[] massiv) {

        long startTime = System.currentTimeMillis();

        Arrays.sort(massiv, new FullComparator());

        long endTime = System.currentTimeMillis();
        long delta = endTime - startTime;
        System.out.println("Время выполнения Arrays.sort = " + delta + " milliseconds");
    }
}

