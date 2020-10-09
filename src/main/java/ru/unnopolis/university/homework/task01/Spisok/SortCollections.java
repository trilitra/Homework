package ru.unnopolis.university.homework.task01.Spisok;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * CКласс реализующий сортировку Collections.sort и выводящий в консоль время работы алгоритма сортировки,
 * а также отсортированный массив объектов класса Person
 */
class SortCollections {
    /**
     * Метод в котором реализуется сортировка Collections.sort, вывод в консоль отсортированного массива объектов
     * класса Person и замер времени работы алгоритма сортировки
     *
     * @param massiv принимает для сортировки массив объектов класса Person
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
