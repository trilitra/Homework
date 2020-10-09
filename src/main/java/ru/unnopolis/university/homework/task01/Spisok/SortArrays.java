package ru.unnopolis.university.homework.task01.Spisok;

import java.util.Arrays;

/**
 * Класс реализующий сортировку Arrays.sort и выводящий в консоль время работы алгоритма сортировки
 */

class SortArrays {
    /**
     * Метод в котором реализуется сортировка Arrays.sort, и замер времени работы алгоритма сортировки
     *
     * @param massiv принимает для сортировки массив объектов класса Person
     */
    static void sort(Person[] massiv) {

        long startTime = System.currentTimeMillis();

        Arrays.sort(massiv, new FullComparator());

        long endTime = System.currentTimeMillis();
        long delta = endTime - startTime;
        System.out.println("Время выполнения Arrays.sort = " + delta + " milliseconds");
    }
}

