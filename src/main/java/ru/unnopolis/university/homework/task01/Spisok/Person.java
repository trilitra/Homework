package ru.unnopolis.university.homework.task01.Spisok;

/**
 * Класс описывающий объекты Person
 */
public class Person {
    private String name;
    private int age;
    private String sex;

    /**
     * Конструктор для создания экземпляра класса Person
     *
     * @param name принимает параметр "Имя"
     * @param age  принимает параметр "возраст"
     * @param sex  принимает параметр "пол"
     */
    Person(String name, int age, String sex) {
        this.name = name;
        this.age = age;
        this.sex = sex;
    }

    /**
     * Метод для получения параметра "Имя" объекта класса Person
     *
     * @return возвращает параметр "Имя" объекта класса Person
     */
    String getName() {
        return name;
    }

    /**
     * Метод для установки значения параметра "Имя" объекта класса Person
     *
     * @param name передается значение для инициализации параметра "Имя"
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Метод для получения параметра "Возраст" объекта класса Person
     *
     * @return возвращает параметр "Возраст" объекта класса Person
     */
    int getAge() {
        return age;
    }

    /**
     * Метод для установки значения параметра "Возраст" объекта класса Person
     *
     * @param age передается значение для инициализации параметра "Возраст"
     */
    public void setAge(int age) {
        this.age = age;
    }

    /**
     * Метод для получения параметра "Пол" объекта класса Person
     *
     * @return возвращает параметр "Пол" объекта класса Person
     */
    String getSex() {
        return sex;
    }

    /**
     * Метод для установки значения параметра "Пол" объекта класса Person
     *
     * @param sex передается значение для инициализации параметра "Пол"
     */
    public void setSex(String sex) {
        this.sex = sex;
    }

    /**
     * Метод для отображения объекта класса Person в текстовом виде
     *
     * @return возвращает текстовое описание объекта класса Person
     */
    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", sex='" + sex + '\'' +
                '}';
    }
}
