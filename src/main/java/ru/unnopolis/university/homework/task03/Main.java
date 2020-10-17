package ru.unnopolis.university.homework.task03;

import java.io.IOException;
import java.util.HashMap;

/**
 * Разработать программу – картотеку домашних животных. У каждого животного есть уникальный идентификационный номер,
 * кличка, хозяин (объект класс Person с полями – имя, возраст, пол), вес.
 * <p>
 * Реализовать:
 * метод добавления животного в общий список (добавление дубликатов должно приводить к исключительной ситуации)
 * поиск животного по его кличке (поиск должен быть эффективным)
 * изменение данных животного по его идентификатору
 * вывод на экран списка животных в отсортированном порядке. Поля для сортировки –  хозяин, кличка животного, вес.
 */
public class Main {
    static HashMap<Integer, Animal> mapAnimal = new HashMap<>();

    /**
     * Точка входа в программу.
     *
     * @param args принимаемый параметр массив строк
     */
    public static void main(String[] args) {

        startApp();
    }

    /**
     * Выполнение основных методов.
     */
    private static void startApp() {
        try {
            AddAnimals.getHashMapAnimals(mapAnimal); //Создание HashMap питомцев
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        try {
            FindAnimal.newRequest(mapAnimal); //Поиск питомца по имени
            ChangeAnimal.newRequest(mapAnimal);//Изменение информации о питомце
        } catch (NullPointerException e) {
            System.out.println("Такого идентификационного номера не существует!");
            main(null);
        } catch (IOException e) {
            System.out.println(e.getMessage());
            main(null);
        }

        SortAnimal.newRequest(mapAnimal);//Сортировка картотеки и вывод результата на экран
    }
}

