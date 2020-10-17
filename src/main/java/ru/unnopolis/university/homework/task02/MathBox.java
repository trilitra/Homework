package ru.unnopolis.university.homework.task02;

import java.util.ArrayList;
import java.util.Objects;

/**
 * Класс для работы  c объектами класса Number
 */
public class MathBox extends ObjectBox {

    /**
     * Конструктор для создания экземпляра класса MathBox, запись  в массив ArrayList параметра экземпляра,
     * удаления дубликатов в параметре и вывод на экран параметра-массива объекта класса MathBox
     *
     * @param array принимаем параметр-массив Number
     */
    public MathBox(Number[] array) {
        super(array);
    }

    /**
     * Метод для расчета и вывода в консоль суммы всех чисел параметра-массива объекта класса MathBox
     *
     * @param list принимаем параметр-массив объекта класса MathBox
     */
    public static void summator(ArrayList<Object> list) {
        double summaElements = 0;
        for (int i = 0; i < list.size(); i++) {
            Number element = (Number) list.get(i);
            summaElements += element.doubleValue();
        }
        System.out.println("Сумма элементов массива равна " + summaElements + "\n");
    }

    /**
     * Метод для расчета, записи в параметр-массив и вывода в консоль резултата деления всех чисел параметра-массива
     * объекта класса MathBox на делитель передаваемый как параметр
     *
     * @param list  принимаем параметр-массив объекта класса MathBox
     * @param split принимаем делитель
     */
    public static void splitter(ArrayList<Object> list, Number split) {
        for (int i = 0; i < list.size(); i++) {
            Number element = (Number) list.get(i);
            double splitElement = element.doubleValue() / split.doubleValue();
            list.set(i, splitElement);
        }
        System.out.println("Элементы массива после выполнения метода splitter " + list + "\n");
    }

    /**
     * Метод для удаления Number в параметре-массиве экземпляра класса MathBox.
     *
     * @param list принимаем параметр-массив
     * @param del  принимаем экземпляр класса Number для удаления в параметре-массиве
     */
    public static void remove(ArrayList<Object> list, Number del) {
        deleteObject(list, del);
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        MathBox mathBox = (MathBox) o;
        return list.equals(mathBox.list);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), list);
    }

    @Override
    public String toString() {
        return "NumberArray " +
                list;
    }
}

