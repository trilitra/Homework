package ru.unnopolis.university.homework.task03;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

/**
 * Класс для сортировки картотеки
 */
public class SortAnimal {
    /**
     * Метод реализующий сортировку картотеки с помощью пользовательского класса Comparator
     * @param mapAnimal принимаемый параметр картотека питомцев
     */
    public static void newRequest (HashMap<Integer, Animal> mapAnimal){

        ArrayList<Animal> animalArrayList = new ArrayList<>(mapAnimal.values());
        AnimalComparator comparator = new AnimalComparator();
        Collections.sort(animalArrayList, comparator);
        System.out.println("\nКартотека отсортирована : ");
        for (int i = 0; i < animalArrayList.size(); i++) {
            System.out.println(animalArrayList.get(i));
        }
    }
}
