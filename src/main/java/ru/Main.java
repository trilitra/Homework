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

    private static void JavacCreate() throws IOException, InterruptedException {
        Process proc = Runtime.getRuntime().exec("javac ./target/classes/ru/SomeClass.java");
        proc.waitFor();
        proc.destroy();
    }

    private void demoMyObj()
            throws IllegalAccessException, NoSuchMethodException, InvocationTargetException, ClassNotFoundException,
            InstantiationException {
        MyClassLoader myClassLoader = new MyClassLoader();
        final Class<?> targetClass = Class.forName("ru.SomeClass", true, myClassLoader);
        Object object = targetClass.newInstance();
        SomeClass myObject = (SomeClass) object;
        final Method setNewDoWork = targetClass.getDeclaredMethod("doWork");
        setNewDoWork.invoke(myObject);

    }
}
