package ru.FactorialStreamAPI;

import java.math.BigInteger;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;
import java.util.stream.IntStream;

/**
 * Демонстрация использования Stream API в методе streamedParallel(Integer n) классе Factorial
 */
public class Factorial {
    public Integer[] array = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
    private ExecutorService threadPool;
    private ThreadFactory threadFactory;

    public static void main(String[] args) {
       Factorial factorial = new Factorial();
       factorial.runThreadsPool();

    }

    public  void runThreadsPool() {
        threadFactory = Thread::new;
        threadPool = Executors.newFixedThreadPool(getAvialableCountTread(), threadFactory);
        Runnable threadsFactorial = new ThreadsFactorial(array);
        threadPool.execute(threadsFactorial);
        threadPool.shutdown();
    }

    private int getAvialableCountTread() {
        return Runtime.getRuntime().availableProcessors() * 2;
    }


    public static BigInteger streamedParallel(Integer n) {
        if(n < 2) return BigInteger.valueOf(1);
        return IntStream.rangeClosed(2, n).parallel().mapToObj(BigInteger::valueOf).reduce(BigInteger::multiply).get();
    }
}

class ThreadsFactorial implements Runnable {

    private Integer[] array;

    public ThreadsFactorial(Integer[] numberOfArray) {
        this.array = numberOfArray;
    }

    @Override
    public void run() {
        BigInteger f;
        for (int i = 0; i < array.length ; i++) {
            f = Factorial.streamedParallel(array[i]);
            System.out.println("Факториал " + array[i] + " равен " + f);
        }
    }
}

