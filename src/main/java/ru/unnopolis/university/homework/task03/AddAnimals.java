package ru.unnopolis.university.homework.task03;

import java.util.HashMap;

/**
 * Класс для создания картотеки питомцев
 */
public class AddAnimals {
    /**
     * Создание и внесение в картотеку питомцев и хозяев
     *
     * @param mapAnimal принимаемы параметр пустая HashMap
     * @throws Exception может вызвать пользовательское исключение при создании дубликатов, прокидывает ошибку выше
     */
    static void getHashMapAnimals(HashMap<Integer, Animal> mapAnimal) throws Exception {
        Person alex = new Person("Alex", 32, "MAN");
        Person misha = new Person("Misha", 26, "MAN");
        Person ksenia = new Person("Ksenia", 23, "WOMAN");

        Animal cat = new Animal("Pirog", alex, 4.5);
        Animal dog = new Animal("Max", misha, 3.5);
        Animal dog1 = new Animal("Timosha", ksenia, 20);

        addNewAnimal(mapAnimal, cat);
        addNewAnimal(mapAnimal, dog);
        addNewAnimal(mapAnimal, dog1);
        addNewAnimal(mapAnimal, dog);

    }

    /**
     * Запись в картотеку питомцев
     *
     * @param mapAnimal принимаемый параметр пустая HashMap
     * @param animal    принимаемый параметр вновь созданный питомец
     * @throws Exception может вызвать пользовательское исключение при создании дубликатов, прокидывает ошибку выше
     */
    public static void addNewAnimal(HashMap<Integer, Animal> mapAnimal, Animal animal) throws Exception {
        if (!mapAnimal.containsValue(animal)) {
            mapAnimal.put(mapAnimal.size(), animal);
        } else {
            throw new Exception("\nВы попробовали добавить питомца  " + animal.id + " - " + animal.getNameAnimal() +
                    " который уже есть в базе");
        }
        animal.id = mapAnimal.size() - 1;
        System.out.println("\nВы добавили нового питомца по кличке " + animal.getNameAnimal() + " , " +
                "его идентификационный номер " + animal.id);
    }
}

