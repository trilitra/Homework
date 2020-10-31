package ru;

import java.math.BigInteger;

/**
 * Дан массив случайных чисел. Написать программу для вычисления факториалов всех элементов массива. Использовать пул
 * потоков для решения задачи.
 *
 * Особенности выполнения:
 * Для данного примера использовать рекурсию - не очень хороший вариант, т.к. происходит большое выделение памяти,
 * очень вероятен StackOverFlow. Лучше перемножать числа в простом цикле при этом создавать объект типа BigInteger
 * По сути, есть несколько способа решения задания:
 *
 * 1) распараллеливать вычисление факториала для одного числа
 *
 * 2) распараллеливать вычисления для разных чисел
 *
 * 3) комбинированный
 *
 * При чем вычислив факториал для одного числа, можно запомнить эти данные и использовать их для вычисления другого,
 * что будет гораздо быстрее
 */
public class Factorial {
    static final Integer[] array = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
    private static final int numberOfTreads = array.length;

    public static void main(String[] args) {
        runThreads();
    }

    /**
     * Метод для создания и запуска пула потоков
     */

    public static void runThreads() {

        for (int i = 0; i < numberOfTreads; i++) {
            Runnable threadsFactorial = new ThreadsFactorial(array[i]);
            Thread thread = new Thread(threadsFactorial);
            thread.start();
        }
    }

    /**
     * Метод для расчета факториала
     * @param i передаваемый аргумент число, для которого необходимо высчитать факториал
     * @return возвращаемый параметр - факториал
     */
    public static BigInteger factorial(int i) {
        BigInteger f = BigInteger.valueOf(1);
        for (int j = 1; j <= i; j++) {
            f = f.multiply(BigInteger.valueOf(j));
        }
        return f;
    }
}

class ThreadsFactorial implements Runnable {

    private int numberOfArray;

    public ThreadsFactorial(int numberOfArray) {
        this.numberOfArray = numberOfArray;
    }

    @Override
    public void run() {
        BigInteger f;
        f = Factorial.factorial(numberOfArray);
        System.out.println("Факториал " + numberOfArray + " равен " + f);
    }
}

