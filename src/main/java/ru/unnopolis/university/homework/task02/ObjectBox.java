package ru.unnopolis.university.homework.task02;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Objects;

/**
 * Класс для работы  c объектами класса Object
 */
public class ObjectBox {
    protected HashSet<Object> set;

    /**
     * Конструктор для создания экземпляра класса ObjectBox, запись  в массив ArrayList параметра экземпляра,
     * удаления дубликатов в параметре и вывод на экран параметра-массива объекта класса ObjectBox
     *
     * @param array принимаем параметр-массив Object
     */
    public ObjectBox(Object[] array) {
        set = new HashSet<>(Arrays.asList(array));
        System.out.println("Создание экземпляра класса ( " + array.getClass() + " ) " + "\n" +
                "Параметр экземпляра класса - массив равен  " + set + "\n");
    }

    public HashSet<Object> getSet() {
        return set;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ObjectBox objectBox = (ObjectBox) o;
        return Objects.equals(set, objectBox.set);
    }

    @Override
    public int hashCode() {
        return Objects.hash(set);
    }

    @Override
    public String toString() {
        return "ObjectBox{" +
                "set=" + set +
                '}';
    }
}



