package ru.unnopolis.university.homework.task01;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Класс, генерирующий массив случайных чисел. Для каждого числа из массива k вычислить квадратный корень q.
 * Если квадрат целой части q числа равен k, то вывести это число на экран.
 * Первоначальные числа могут быть отрицательные, в этом случае генерируется исключение.
 */
public class Generator {

    /**
     * Точка входа в программу
     *
     * @param args принимаемый параметр массив String
     */
    public static void main(String[] args) {
        int[] emptyArray = getEmptyArray();
        int[] fullArray = getFullArray(emptyArray);
        checkArray(fullArray);
    }

    /**
     * Метод, с помощью которого пользователь генерирует "пустой" массив необходимой длины путем ввода числа в консоль
     * Если пользователь ввел в консоль не целое число, появляется и обрабатывается исключение,
     * метод Main запускается снова(рекурсия)
     *
     * @return возвращает "пустой" сгенерированный массив чисел
     */
    private static int[] getEmptyArray() {
        System.out.println("Введите количество чисел, которое хотите сгенерировать");
        int[] array = new int[0];
        try {
            Scanner sc = new Scanner(System.in);
            array = new int[Math.abs(sc.nextInt())];
        } catch (InputMismatchException e) {

            System.out.println("Введите целое положительное число");
            main(null);
        }
        return array;
    }

    /**
     * Метод для заполнения массива рандомно сгенерированными числами в диапазоне от -100 до 100 (включительно)
     *
     * @param array принимает "пустой" массив заданной пользователем длины для заполнения
     * @return возвращает массив, заполненный  рандомно сгенерированными числами
     */
    private static int[] getFullArray(int[] array) {
        for (int i = 0; i < array.length; i++) {
            array[i] = (int) (Math.random() * (200 + 1) - 100);
            try {
                if (array[i] < 0) {
                    throw new Exception();
                }
            } catch (Exception e) {
                System.out.println("Было сгенерировано отрицательное число! Квадратный корень вычислить нельзя");
            }
        }
        return array;
    }

    /**
     * Метод проверяющий все члены массива на соответсвие условиям задачи класса, в случае успешного прохождения
     * проверки выводит член массива на экран в консоль
     *
     * @param array принимает массив, заполненный  рандомно сгенерированными числами
     */
    private static void checkArray(int[] array) {
        for (int i = 0; i < array.length; i++) {
            double b = Math.sqrt(array[i]);
            long a = (long) b;
            if (array[i] == (a * a)) {
                System.out.println(array[i]);
            }
        }
    }
}