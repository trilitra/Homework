package ru.unnopolis.university.homework.task2.Spisok;

import java.util.Comparator;

public class FullComparator implements Comparator<Person> {

    @Override
    public int compare(Person person1, Person person2) {

        int sexCompare = person1.getSex().compareTo(person2.getSex());
        int ageCompare = Integer.valueOf(person2.getAge()).compareTo(Integer.valueOf(person1.getAge()));
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


