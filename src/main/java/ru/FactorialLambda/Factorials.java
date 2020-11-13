package ru.FactorialLambda;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;

/**
 * Демонстрация использования лямбда выражений
 */
public class Factorials {
    public Integer[] arrays = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
    private ExecutorService threadPool;
    private ThreadFactory threadFactory;

    public static void main(String[] args) {
        Factorials factorial = new Factorials();
        factorial.createThreadsPool();
    }

    public void createThreadsPool() {
        threadFactory = Thread::new;
        threadPool = Executors.newFixedThreadPool(getAvialableCountTread(), threadFactory);
        runThreadsPool(threadPool);
    }

    private void runThreadsPool(ExecutorService threadPool) {
        Thread thread = new Thread(
                () -> threadPool.execute(new ThreadsFactorial(arrays))
        );
        thread.start();
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

}

class ThreadsFactorial implements Runnable {

    private Integer[] arrays;

    public ThreadsFactorial(Integer[] array) {

        this.arrays = array;
    }

    interface NumericFunc {
        int func(int n);
    }
    @Override
    public void run() {
            NumericFunc factorial = (n) -> {
                        int result = 1;

                        for (int i = 1; i <= n; i++)
                            result = i * result;

                        return result;
                    };
        for (Integer array : arrays) {
            System.out.println("Факториал " + array + " равен " + factorial.func(array));
        }
    }
}
