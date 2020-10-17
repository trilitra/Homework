package ru.unnopolis.university.homework.task03;

/**
 * Класс-описание питомцев
 */
public class Animal {

    public int id;
    private String nameAnimal;
    private Person person;
    private double weightAnimal;

    /**
     * Конструктор для создания экземпляра класса Animal
     *
     * @param name   передаваемый параметр Имя
     * @param person передаваемый параметр Хозяин
     * @param weight передаваемый параметр Вес
     */
    public Animal(String name, Person person, double weight) {
        this.nameAnimal = name;
        this.person = person;
        this.weightAnimal = weight;
    }

    /**
     * Метод для получения объекта класа Person
     *
     * @return возвращает объект класса Person
     */
    public Person getPerson() {
        return person;
    }

    /**
     * Метод для получения веса питомца
     *
     * @return возвращает вес питомца
     */
    public double getWeightAnimal() {
        return weightAnimal;
    }

    /**
     * Метод для установки веса питомца
     *
     * @param weightAnimal передаваемый параметр вес питомца
     */
    public void setWeightAnimal(double weightAnimal) {
        this.weightAnimal = weightAnimal;
    }

    /**
     * Метод для получения Имени питомца
     *
     * @return возвращает Имя питомца
     */
    public String getNameAnimal() {
        return nameAnimal;
    }

    /**
     * Метод для установки Имени питомца
     *
     * @param nameAnimal передаваемый параметр Имя питомца
     */
    public void setNameAnimal(String nameAnimal) {
        this.nameAnimal = nameAnimal;
    }

    /**
     * Переопределение метода toString
     *
     * @return возвращает строку-описание
     */
    @Override
    public String toString() {
        return "кличка '" + nameAnimal + '\'' +
                ", вес =" + weightAnimal + "кг" +
                ", " + person;
    }


}
