package ru.unnopolis.university.homework.task2.Spisok;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SortCollections {
    public static void sort(Person[] massiv) {
        List<Person> list = new ArrayList<Person>();

        for (int i = 0; i < massiv.length; i++) {
            list.add(massiv[i]);
        }

        long startTime = System.currentTimeMillis();

        Collections.sort(list, new FullComparator());

        long endTime = System.currentTimeMillis();
        long delta = endTime - startTime;

        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }
        System.out.println("Время выполнения Collections.sort = " + delta + " milliseconds");

    }
}
