package ru.unnopolis.university.homework.task03;

import java.util.Comparator;

/**
 * Класс - Компаратор для сравнения питомцев
 */
public class AnimalComparator implements Comparator<Animal> {

    /**
     * Переопределение метода compare
     *
     * @param animal1 передаваемы параметр экземпляр класса Animal
     * @param animal2 передаваемы параметр экземпляр класса Animal
     * @return возвращает результат сравнения в виде Integer (-1, 0, 1)
     */
    @Override

    public int compare(Animal animal1, Animal animal2) {
        Person person1 = animal1.getPerson();
        Person person2 = animal2.getPerson();

        int personNameCompare = person1.getNamePerson().compareTo(person2.getNamePerson());

        int personAgeCompare = Integer.valueOf(person1.getAgePerson()).compareTo(person2.getAgePerson());

        int personSexCompare = person2.getSexPerson().compareTo(person1.getSexPerson());

        int nameAnimalCompare = animal1.getNameAnimal().compareTo(animal2.getNameAnimal());

        int weightAnimalCompare = Double.valueOf(animal2.getWeightAnimal()).compareTo(animal1.getWeightAnimal());


        if (personNameCompare != 0) {

            return personNameCompare;

        } else {

            if (personAgeCompare != 0) {

                return personAgeCompare;

            } else {
                if (personSexCompare != 0) {

                    return personSexCompare;
                } else {
                    if (nameAnimalCompare != 0) {

                        return nameAnimalCompare;

                    } else {

                        return weightAnimalCompare;

                    }
                }

            }

        }

    }

}



