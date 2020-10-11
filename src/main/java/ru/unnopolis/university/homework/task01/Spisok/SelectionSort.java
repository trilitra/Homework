package ru.unnopolis.university.homework.task01.Spisok;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Класс реализующий сортировку Collections.sort и выводящий в консоль время работы алгоритма сортировки,
 * а также отсортированный массив объектов класса Person
 */
class SelectionSort implements sortContract{
    /**
     * Метод в котором реализуется сортировка Collections.sort, вывод в консоль отсортированного массива объектов
     * класса Person и замер времени работы алгоритма сортировки
     *
     * @param massiv принимает для сортировки массив объектов класса Person
     */
    @Override
    public void sort(Person[] massiv) {

        long startTime = System.currentTimeMillis();

        for (int left = 0; left < massiv.length; left++) {

            Person value = massiv[left];
            int i = left - 1;
            FullComparator com = new FullComparator();
            for (; i >= 0; i--) {
                if (com.compare(massiv[i], massiv[left]) == 0) {
                    massiv[i + 1] = massiv[i];
                } else {
                    break;
                }
            }
            massiv[i + 1] = value;
        }


        long endTime = System.currentTimeMillis();
        long delta = endTime - startTime;

        System.out.println("Время выполнения сортировки методом вставки = " + delta + " milliseconds");

    }
}
