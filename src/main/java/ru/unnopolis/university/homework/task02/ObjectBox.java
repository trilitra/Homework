package ru.unnopolis.university.homework.task02;

import java.util.ArrayList;

/**
 * Класс для работы  c объектами класса Object.
 */
public class ObjectBox {
    public ArrayList<Object> list;

    /**
     * Конструктор для создания экземпляра класса ObjectBox, запись  в массив ArrayList параметра экземпляра,
     * удаления дубликатов в параметре и вывод на экран параметра-массива объекта класса ObjectBox
     *
     * @param array принимаем параметр-массив Object
     */
    public ObjectBox(Object[] array) {
        ArrayList<Object> list = new ArrayList<>();
        for (int i = 0; i < array.length; i++) {
            while (!list.contains(array[i])) {
                list.add(array[i]);
            }
        }
        System.out.println("Создание экземпляра класса ( " + array.getClass() + " ) " + "\n" +
                "Параметр экземпляра класса - массив равен  " + list + "\n");
        this.list = list;
    }

    /**
     * Пустой конструктор
     */
    public ObjectBox() {

    }

    /**
     * Метод для добавления Object в параметр-массив экземпляра класса ObjectBox
     *
     * @param list   принимаем параметр-массив
     * @param object принимаем экземпляр класса Object для добавления в пармаетр-массив
     */
    public static void addObject(ArrayList<Object> list, Object object) {
        while (!list.contains(object)) {
            list.add(object);
        }
        System.out.println("Элементы массива после добавления указанного элемента " + list + "\n");
    }

    /**
     * Метод для удаления Object в параметре-массиве экземпляра класса ObjectBox
     *
     * @param list   принимаем параметр-массив
     * @param object принимаем экземпляр класса Object для удаления в параметре-массиве
     */
    public static void deleteObject(ArrayList<Object> list, Object object) {
        while (list.contains(object)) {
            list.remove(object);
        }
        System.out.println("Элементы массива после удаления указанного элемента " + list + "\n");
    }

    /**
     * Метод для вывода в консоль параметра-массива экземпляра класса ObjectBox
     *
     * @param list принимаем параметр-массив
     */
    public static void dump(ArrayList<Object> list) {
        System.out.println("Массив элементов класса Object равен " + list + "\n");
    }

    @Override
    public String toString() {
        return "ObjectBox{" +
                "list=" + list +
                '}';
    }
}



