package ru.unnopolis.university.homework.task02;

import java.util.Arrays;
import java.util.HashSet;

/**
 * Класс для работы  c объектами класса Object
 */
public class ObjectBox {
    public static HashSet<Object> set;

    /**
     * Конструктор для создания экземпляра класса ObjectBox, запись  в массив ArrayList параметра экземпляра,
     * удаления дубликатов в параметре и вывод на экран параметра-массива объекта класса ObjectBox
     *
     * @param array принимаем параметр-массив Object
     */
    public ObjectBox(Object[] array) {
        HashSet<Object> set = new HashSet<>(Arrays.asList(array));
        System.out.println("Создание экземпляра класса ( " + array.getClass() + " ) " + "\n" +
                "Параметр экземпляра класса - массив равен  " + set + "\n");
        ObjectBox.set = set;
    }


    @Override
    public String toString() {
        return "ObjectBox{" +
                "set=" + set +
                '}';
    }
}



