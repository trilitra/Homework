package ru.unnopolis.university.homework.task02;

/**
 *Задание 1. Написать класс MathBox, реализующий следующий функционал:
 *
 * Конструктор на вход получает массив Number. Элементы не могут повторяться. Элементы массива внутри объекта
 * раскладываются в подходящую коллекцию (выбрать самостоятельно).
 * Существует метод summator, возвращающий сумму всех элементов коллекции.
 * Существует метод splitter, выполняющий поочередное деление всех хранящихся в объекте элементов на делитель,
 * являющийся аргументом метода. Хранящиеся в объекте данные полностью заменяются результатами деления.
 * Необходимо правильно переопределить методы toString, hashCode, equals, чтобы можно было использовать MathBox
 * для вывода данных на экран и хранение объектов этого класса в коллекциях (например, hashMap).
 * Выполнение контракта обязательно!
 * Создать метод, который получает на вход Integer и если такое значение есть в коллекции, удаляет его.
 *
 * Задание 2. Создать класс ObjectBox, который будет хранить коллекцию Object.
 * У класса должен быть метод addObject, добавляющий объект в коллекцию.
 * У класса должен быть метод deleteObject, проверяющий наличие объекта в коллекции и при наличии удаляющий его.
 * Должен быть метод dump, выводящий содержимое коллекции в строку.
 *
 *
 * Задание 3. Доработать классы MathBox и ObjectBox таким образом, чтобы MathBox был наследником ObjectBox.
 * Необходимо сделать такую связь, правильно распределить поля и методы. Функциональность в целом должна сохраниться.
 * При попытке положить Object в MathBox должно создаваться исключение.
 */

public class Main {
    /**
     * Точка входа в программу.
     *
     * @param args принимаемый параметр массив строк
     */
    public static void main(String[] args) {
        startApp();
    }

    /**
     * Выполнения основных методов
     */
    private static void startApp() {

        Number[] array = getNumberArray(); // Генерируем массив чисел разных примитивных типов
        MathBox<Number> number = new MathBox<>(array); // Вызываем конструктор класса MathBox, передаем  сгенерированный массив
        MathBox.summator();
        MathBox.set.remove((long) 4);
        System.out.println("Коллекция после удаления элемента: " + number.set + "\n");
        MathBox.splitter(2.0);

        Object[] arrayObject = getObjectArray();// Генерируем массив Object
        ObjectBox object = new ObjectBox(arrayObject);// Вызываем конструктор класса ObjectBox,передаем  сгенерированный массив
        ObjectBox.set.add(2);
        System.out.println("Коллекция после добавления элемента: " + object + "\n");
        ObjectBox.set.remove(2);
        System.out.println("Коллекция после удаления элемента: " + object + "\n");
        MathBox<Number> number2 = new MathBox<>((Number[]) arrayObject);// Генерация исключения
    }

    /**
     * Генерация массива NUmber
     *
     * @return возвращаем массив Number
     */
    private static Number[] getNumberArray() {
        Number[] array = new Number[8];
        array[0] = (short) 5;
        array[1] = (byte) -2;
        array[2] = (long) 4;
        array[3] = (float) 1.4;
        array[4] = (double) 1;
        array[5] = (byte) -2;
        array[6] = (int) 6.0;
        array[7] = (int) 6.0;
        return array;
    }

    /**
     * Генерация массива Object
     *
     * @return возвращаем массив Object
     */
    private static Object[] getObjectArray() {
        Object[] arrayObject = new Object[3];
        arrayObject[0] =  "ss";
        arrayObject[1] = (double) -2;
        arrayObject[2] =  new Object();
        return arrayObject;
    }

}
