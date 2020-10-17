package ru.unnopolis.university.homework.task02;

/**
 *
 */

public class Main {
    /**
     * Точка входа в программу
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

        MathBox number = new MathBox(array); // Вызываем конструктор класса MathBox, передаем  сгенерированный массив
        MathBox.summator(number.list); // Вычисляем сумму элементов массива - параметра объекта number класса MathBox
        MathBox.remove(number.list, 4); //Удаляем указанный элемент массива
        MathBox.splitter(number.list,  2); //Делим элементы массива на указанный делитель, результат фиксируем


        Object[] arrayObject = getObjectArray();// Генерируем массив Object

        ObjectBox object = new ObjectBox(arrayObject);// Вызываем конструктор класса ObjectBox, передаем  сгенерированный массив
        ObjectBox.addObject(object.list,  2); // Добавляем элемент в массив
        ObjectBox.deleteObject(object.list,  2);// Удаляем элемент массива
        ObjectBox.dump(object.list); // Выводим массив в строчку
        MathBox.summator(object.list);// Генерация исключения

    }

    /**
     * Генерация массива NUmber
     *
     * @return возвращаем массив Number
     */
    private static Number[] getNumberArray() {
        Number[] array = new Number[7];
        array[0] = (short) 4;
        array[1] = (byte) -2;
        array[2] = (long) 4;
        array[3] = (float) 1.4;
        array[4] = (double) 1;
        array[5] = (byte) -2;
        array[6] = (int) 4.0;
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
