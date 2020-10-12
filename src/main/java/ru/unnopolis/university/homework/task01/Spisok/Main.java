package ru.unnopolis.university.homework.task01.Spisok;

import java.sql.SQLOutput;
import java.util.Arrays;

/**
 * Главный класс выполняющий следующую задачу :
 * Генерация массива объектов Person. Класс Person характеризуется полями age (возраст, целое число 0-100),
 * sex (пол – объект класса Sex со строковыми константами внутри MAN, WOMAN),
 * name (имя - строка). Создано два класса: BubbleSort и SelectionSort , методы которых будут
 * реализовывать сортировку объектов.
 * Предусмотрен единый интерфейс: FullComparator для классов сортировки
 * Реализована сортировка этого массива по правилам:
 * - первые идут мужчины
 * - выше в списке тот, кто более старший
 * - имена сортируются по алфавиту
 * Программа выводит на экран отсортированный список и время работы каждого алгоритма сортировки в классах
 * Предусмотренна генерация исходного массива (10000 элементов и более).
 * Если имена людей и возраст совпадают, выбрасывается пользовательское исключение.
 */
public class Main {
    /**
     * Точка входа в программу
     * исключение появляется если в сгенерированном массиве есть одинаковые элементы
     *
     * @param args принимаемый параметр массив String
     */
    public static void main(String[] args)  {
       new Main().startSort();
    }

    /**
     * Выполнение основных методов программы
     */
    private  void startSort() {
        SortContract bubble = new BubbleSort();
        SortContract select = new SelectionSort();
        Person[] massiv = Massiv.generate(10);
        try {
            selectSortArray(select, massiv);
            bubbleSortArray(bubble, massiv);
        } catch (PersonException e) {
            System.out.println(e.getMessage());
        }
    }

    /**
     * Метод,генерирует массив объектов Person, запускает сортировку с помощью алгоритма Bubble,
     * считает время выполнения данного алгоритма сортировки
     * @param bubble принимает объект класса BubbleSort
     * @param massiv принимает массив объектов Person
     * @throws PersonException прокидывает навверх ошибку при создании дубликатов в массиве объектов Person
     */
    private void bubbleSortArray(SortContract bubble, Person[] massiv) throws PersonException {
        Person[] array = Arrays.copyOf(massiv, massiv.length);
        long startTime = System.currentTimeMillis();
        bubble.sort(array);
        long endTime = System.currentTimeMillis();
        long delta = endTime - startTime;
        System.out.println("\nВремя выполнения сортировки методом Bubble = " + delta + " milliseconds");
    }
    /**
     * Метод,генерирует массив объектов Person, запускает сортировку с помощью алгоритма Selection,
     * считает время выполнения данного алгоритма сортировки
     * @param select принимает объект класса BubbleSort
     * @param massiv принимает массив объектов Person
     * @throws PersonException прокидывает навверх ошибку при создании дубликатов в массиве объектов Person
     */
    private void selectSortArray(SortContract select, Person[] massiv) throws PersonException {
        Person[] array = Arrays.copyOf(massiv, massiv.length);
        long startTime = System.currentTimeMillis();
        select.sort(array);
        long endTime = System.currentTimeMillis();
        long delta = endTime - startTime;
        System.out.println("\nВремя выполнения сортировки методом Selection = " + delta + " milliseconds");
    }
}
