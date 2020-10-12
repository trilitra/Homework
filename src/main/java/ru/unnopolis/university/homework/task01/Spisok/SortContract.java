package ru.unnopolis.university.homework.task01.Spisok;

/**
 * Интерфейс для переопределения метода sort в методах сортировки
 */
public interface SortContract {
    void sort(Person[] massiv) throws PersonException;
}
