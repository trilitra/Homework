package ru.unnopolis.university.homework.task02;
import java.util.Objects;

/**
 * Класс для работы  c объектами класса Number
 */
public class MathBox<T extends Number> extends ObjectBox {

    /**
     * Конструктор для создания экземпляра класса MathBox, запись  в массив ArrayList параметра экземпляра,
     * удаления дубликатов в параметре и вывод на экран параметра-массива объекта класса MathBox
     *
     * @param array принимаем параметр-массив Number
     */
    public MathBox(T[] array) {
        super(array);
    }

    /**
     * Метод для расчета и вывода в консоль суммы всех чисел параметра-массива объекта класса MathBox
     */
    public static void summator() {
        double summa = 0;
        for (Object element:  set) {
            summa +=  Double.parseDouble(String.valueOf(element));
        }
        System.out.println("Сумма элементов массива равна " + summa + "\n");
    }

    /**
     * Метод для расчета, записи в параметр-массив и вывода в консоль результата деления всех чисел параметра-массива
     * объекта класса MathBox на делитель передаваемый как аргумент
     */
    public static void splitter(double split) {
        double del;
        for (Object element : set) {
           del = Double.parseDouble(String.valueOf(element)) / split;
           set.add(del);
           set.remove(element);
        }
        System.out.println("Элементы массива после выполнения метода splitter " + set + "\n");
    }

    @Override
    public String toString() {
        return "MathBox{}";
    }
}

