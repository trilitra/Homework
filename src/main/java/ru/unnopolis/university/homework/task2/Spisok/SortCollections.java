package ru.unnopolis.university.homework.task2.Spisok;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Class SortCollections
 */
class SortCollections {
    /**
     * Method Sorting
     *
     * @param massiv transmitted
     */
    static void sort(Person[] massiv) {
        List<Person> list = new ArrayList<Person>(Arrays.asList(massiv));

        long startTime = System.currentTimeMillis();

        Collections.sort(list, new FullComparator());

        long endTime = System.currentTimeMillis();
        long delta = endTime - startTime;

        for (Person i : list) {
            System.out.println(i);
        }
        System.out.println("Время выполнения Collections.sort = " + delta + " milliseconds");

    }
}
