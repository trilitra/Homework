package ru.unnopolis.university.homework.task02;

import java.util.ArrayList;
import java.util.Iterator;
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
    public void summator() {
        double summa = 0;
        for (Object element : set) {
            summa += Double.parseDouble(String.valueOf(element));
        }
        System.out.println("Сумма элементов массива равна " + summa + "\n");
    }

    /**
     * Метод для расчета, записи в параметр-массив и вывода в консоль результата деления всех чисел параметра-массива
     * объекта класса MathBox на делитель передаваемый как аргумент
     */
    public void splitter(double split) {
        ArrayList<Double> list = new ArrayList<>();
        /*
          В методе возникало исключение ConcurrentModificationException, возникает когда добавляю или удаляю
          элементы из коллекции во время использолвания итератора.Так как в этом случае появляется неопределенность,
          откуда итератор должен продолжать и какие последующие элементы должен пройти.
          Решил обойти это исключение создав дополнительно ArrayList  и скопировав туда элементы HashSet поделенные на
          аргумент, после прохода по всем элементам очищаю HashSet и заново перезаписываю из ArrayList
         */
        double del;
        Iterator<Object> iterator = set.iterator();
        while (iterator.hasNext()) {
            del = Double.parseDouble(String.valueOf(iterator.next())) / split;
            list.add(del);
        }
        set.clear();
        set.addAll(list);
        System.out.println("Элементы массива после выполнения метода splitter " + set + "\n");
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        MathBox mathBox = (MathBox) o;
        return set.equals(mathBox.set);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), set);
    }

    @Override
    public String toString() {
        return "MathBox{}";
    }
}

