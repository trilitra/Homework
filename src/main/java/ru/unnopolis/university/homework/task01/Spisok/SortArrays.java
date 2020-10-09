package ru.unnopolis.university.homework.task01.Spisok;

import java.util.Arrays;

/**
 * Class SortArrays
 */

class SortArrays {
    /**
     * Method Sorting
     *
     * @param massiv transmitted
     */
    static void sort(Person[] massiv) {

        long startTime = System.currentTimeMillis();

        Arrays.sort(massiv, new FullComparator());

        long endTime = System.currentTimeMillis();
        long delta = endTime - startTime;
        System.out.println("Время выполнения Arrays.sort = " + delta + " milliseconds");
    }
}

