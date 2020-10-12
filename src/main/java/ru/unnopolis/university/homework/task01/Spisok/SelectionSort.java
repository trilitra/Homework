package ru.unnopolis.university.homework.task01.Spisok;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Класс реализующий сортировку методм вставки
 */
class SelectionSort implements SortContract {
    /**
     * Метод в котором реализуется сортировка методом сортировки Selection
     * выводит в консоль отсортированный массив объектов класса Person
     *
     * @param massiv принимает для сортировки массив объектов класса Person
     */

    @Override
    public void sort(Person[] massiv) throws PersonException {

        Person temp;
        Person min;
        FullComparator comparator = new FullComparator();
        for (int i = 0; i < massiv.length; i++) {
            min = massiv[i];
            int minId = i;
            for (int j = i + 1; j < massiv.length; j++) {
                if (comparator.compare(massiv[minId], massiv[j]) > 0) {
                    min = massiv[j];
                    minId = j;
                } else if(comparator.compare(massiv[minId], massiv[j]) == 0){
                    throw new PersonException("\nВ сгенерированном массиве  есть дубликаты!");
                }
            }
            temp = massiv[i];
            massiv[i] = min;
            massiv[minId] = temp;
        }
        for (Person i : massiv) {
            System.out.println(i);
        }
    }
}
