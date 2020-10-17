package ru.unnopolis.university.homework.task03;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * Класс для изменения информации о питомце
 */
public class ChangeAnimal {
    static private Animal animal;
    static private Person person;

    /**
     * Выполнение основных методов
     *
     * @param mapAnimal передаваемый параметр картотека питомцев
     * @throws IOException может вызвать ошибку потока/вывода, пробрасывает её наверх
     */
    public static void newRequest(HashMap<Integer, Animal> mapAnimal) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        findAnimal(mapAnimal, reader);

        setNameAnimal(reader);

        try {
            setWeightAnimal(reader);
        } catch (NumberFormatException e) {
            System.out.println("Введите числов формате \"х.х\" Например 2.6");
            newRequest(mapAnimal);
        }

        setNamePerson(reader);

        try {
            setAgePerson(reader);
        } catch (NumberFormatException e) {
            System.out.println("Возраст это целое число!");
            newRequest(mapAnimal);
        }

        setSexPerson(reader);

        System.out.println("Результат изменения информации о питомце под идентификационым номером " +
                animal.id + " :  " + animal);
    }

    /**
     * Метод для поиска питомца по индентификационому номеру, информацию о котором необходимо перезаписать в картотеке
     *
     * @param mapAnimal принимаемый параметр картотека питомцев
     * @param reader    передаваемый параметр поток ввода
     * @throws IOException может вызвать ошибку потока/вывода, пробрасывает её наверх
     */
    private static void findAnimal(HashMap<Integer, Animal> mapAnimal, BufferedReader reader) throws IOException {
        System.out.println("\nВведите идентификационный номер питомца, данные которого хотите изменить");
        Integer requestID = Integer.parseInt(reader.readLine());
        animal = mapAnimal.get(requestID);
        person = animal.getPerson();
    }

    /**
     * Метод перезаписывающий информацию о половой принадлежности хозяина
     *
     * @param reader передаваемый параметр поток ввода
     * @throws IOException может вызвать ошибку потока/вывода, пробрасывает её наверх
     */
    private static void setSexPerson(BufferedReader reader) throws IOException {
        System.out.println("\nСейчас пол хозяина  " + person.getNamePerson() + " \"" +
                person.getSexPerson() + "\"" + ". Введите новый пол хозяина. MAN или WOMAN");
        person.setSexPerson(reader.readLine());
    }

    /**
     * Метод перезаписывающий информацию о возрасте хозяина
     *
     * @param reader передаваемый параметр поток ввода
     * @throws IOException может вызвать ошибку потока/вывода, пробрасывает её наверх
     */
    private static void setAgePerson(BufferedReader reader) throws IOException {
        System.out.println("\nСейчас возраст хозяина  " + person.getNamePerson() + " равен " +
                person.getAgePerson() + " лет. Введите новый возраст хозяина");
        person.setAgePerson(Integer.parseInt(reader.readLine()));
    }

    /**
     * Метод перезаписывающий информацию о имени хозяина
     *
     * @param reader передаваемый параметр поток ввода
     * @throws IOException может вызвать ошибку потока/вывода, пробрасывает её наверх
     */
    private static void setNamePerson(BufferedReader reader) throws IOException {
        System.out.println("\nСейчас имя хозяина \"" + person.getNamePerson() + "\". Введите новое имя хозяина");
        person.setNamePerson(reader.readLine());
    }

    /**
     * Метод перезаписывающий информацию о весе питомца
     *
     * @param reader передаваемый параметр поток ввода
     * @throws IOException может вызвать ошибку потока/вывода, пробрасывает её наверх
     */
    private static void setWeightAnimal(BufferedReader reader) throws IOException {
        System.out.println("\nСейчас вес питомца " + animal.getNameAnimal() + " равен " +
                animal.getWeightAnimal() + " кг. Введите новый вес питомца в формате х.x");
        animal.setWeightAnimal(Double.parseDouble(reader.readLine()));
    }

    /**
     * Метод перезаписывающий информацию о имени питомца
     *
     * @param reader передаваемый параметр поток ввода
     * @throws IOException может вызвать ошибку потока/вывода, пробрасывает её наверх
     */
    private static void setNameAnimal(BufferedReader reader) throws IOException {
        System.out.println("\nСейчас имя питомца \"" + animal.getNameAnimal() + "\". Введите новое имя питомца");
        animal.setNameAnimal(reader.readLine());
    }
}
