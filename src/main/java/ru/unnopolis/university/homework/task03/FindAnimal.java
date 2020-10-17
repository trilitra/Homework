package ru.unnopolis.university.homework.task03;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

/**
 * Класс для поиска питомца по вводимому в консоль имени
 */
public class FindAnimal {
    /**
     * Метод для поиска питомца по имени
     * @param mapAnimal принимаемый параметр картотека питомцев
     * @throws IOException может вызвать ошибку потока/вывода, пробрасывает её наверх
     */
    public static void newRequest (HashMap<Integer, Animal> mapAnimal) throws IOException {
        System.out.println("\nВведите кличку питомца, которого надо найти ");
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String request = reader.readLine();
        for (Map.Entry<Integer, Animal> entry : mapAnimal.entrySet()) {
            Animal animal = entry.getValue();
            if (animal.getNameAnimal().equalsIgnoreCase(request)) {
                System.out.println("\nПо Вашему запросу найден питомец: " + animal);
                return;
            }
        }
        System.out.println("\nПо Вашему запросу \"" + request + "\" ничего не найдено");
    }
}
