package ru;

import java.math.BigInteger;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;

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
    public Integer[] array = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
    private ExecutorService threadPool;
    private ThreadFactory threadFactory;

    public static void main(String[] args) {
        Factorial factorial = new Factorial();
        factorial.runThreadsPool();
    }

    /**
     * Метод для создания и запуска пула потоков
     */

    public void runThreadsPool() {
        threadFactory = Thread::new;
        threadPool = Executors.newFixedThreadPool(getAvialableCountTread(), threadFactory);
        Runnable threadsFactorial = new ThreadsFactorial(array);
        threadPool.execute(threadsFactorial);
        threadPool.shutdown();
    }

    private int getAvialableCountTread() {
        return Runtime.getRuntime().availableProcessors() * 2;
    }

    /**
     * Метод для расчета факториала
     *
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

    private Integer[] array;

    public ThreadsFactorial(Integer[] array) {
        this.array = array;
    }
    @Override
    public void run() {
        BigInteger f;
        for (int i = 0; i < array.length; i++) {
            f = Factorial.factorial(i);
            System.out.println("Факториал " + array[i] + " равен " + f);
        }
    }
}

