package ru;


import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * Дан интерфейс
 *
 * public interface Worker
 * {
 * void doWork();
 * }
 * Необходимо написать программу, выполняющую следующее:
 *
 * Программа с консоли построчно считывает код метода doWork. Код не должен требовать импорта дополнительных классов.
 * После ввода пустой строки считывание прекращается и считанные строки добавляются в тело метода public void doWork()
 * в файле SomeClass.java.
 * Файл SomeClass.java компилируется программой (в рантайме) в файл SomeClass.class.
 * Полученный файл подгружается в программу с помощью кастомного загрузчика
 * Метод, введенный с консоли, исполняется в рантайме (вызывается у экземпляра объекта подгруженного класса)
 */
public class Main {

    public static void main(String[] args) throws IOException, InterruptedException, InvocationTargetException,
            NoSuchMethodException, ClassNotFoundException, InstantiationException, IllegalAccessException {
        Consol consol = new Consol();
        Main object = new Main();
        consol.reader();
        JavacCreate();
        object.demoMyObj();


    }

    /**
     * Метод для выполнения команды  JVM "javac" для класса SomeClass
     * @throws IOException
     * @throws InterruptedException
     */
    private static void JavacCreate() throws IOException, InterruptedException {
        Process proc = Runtime.getRuntime().exec("javac ./SomeClass.java");
        proc.waitFor();
        proc.destroy();
    }

    /**
     * Метод для вызова метода doWork() класса SomeClass используя кастомный загрузчик классов MyClassLoader
     * @throws IllegalAccessException
     * @throws NoSuchMethodException
     * @throws InvocationTargetException
     * @throws ClassNotFoundException
     * @throws InstantiationException
     */
    private void demoMyObj()
            throws IllegalAccessException, NoSuchMethodException, InvocationTargetException, ClassNotFoundException,
            InstantiationException {
        MyClassLoader myClassLoader = new MyClassLoader();
        final Class<?> targetClass = Class.forName("SomeClass", true, myClassLoader);
        Object object = targetClass.newInstance();
        final Method setNewDoWork = targetClass.getDeclaredMethod("doWork");
        setNewDoWork.invoke(object);

    }
}
