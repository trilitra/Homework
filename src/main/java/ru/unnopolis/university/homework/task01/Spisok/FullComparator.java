package ru.unnopolis.university.homework.task01.Spisok;

import java.util.Comparator;

/**
 * Компаратор созданный для классов SortArrays  и SortCollections
 */
public class FullComparator implements Comparator<Person> {
    /**
     * Метод переопределят метод compare(Object object1, Object object2), который сравнивает объекты класса Person
     * по трем параметрам sex, age, name. Это необходимо для выполнения алгоритмов сортировки
     *
     * @param person1 передается первый объект для сравнения
     * @param person2 передается второй объект для сравнения
     * @return возвращает результат сравнения
     */
    @Override
    public int compare(Person person1, Person person2) {

        int sexCompare = person1.getSex().compareTo(person2.getSex());
        int ageCompare = Integer.valueOf(person2.getAge()).compareTo(person1.getAge());
        int nameCompare = person1.getName().compareTo(person2.getName());

        if (sexCompare != 0) {
            return sexCompare;
        } else {
            if (ageCompare != 0) {
                return ageCompare;
            } else {
                return nameCompare;
            }
        }
    }
}


