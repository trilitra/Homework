package ru.unnopolis.university.homework.task03;

/**
 * Класс-описание объектов Person
 */
public class Person {
    private String namePerson;
    private int agePerson;
    private String sexPerson;

    /**
     * Конструктор для создания экземпляра класса Person
     *
     * @param name принимаемый параметр Имя
     * @param age  принимаемый параметр Возраст
     * @param sex  принимаемый параметр Пол
     */
    public Person(String name, int age, String sex) {
        this.namePerson = name;
        this.agePerson = age;
        this.sexPerson = sex;
    }

    /**
     * Метод для получения имени хозяина
     *
     * @return возвращает имя хозяина
     */
    public String getNamePerson() {
        return namePerson;
    }

    /**
     * Метод для установки значения Имени хозяина
     *
     * @param namePerson передаваемый параметр Имя хозяина
     */
    public void setNamePerson(String namePerson) {
        this.namePerson = namePerson;
    }

    /**
     * Метод для получения возраста хозяина
     *
     * @return возвращает возраст хозяина
     */
    public int getAgePerson() {
        return agePerson;
    }

    /**
     * Метод для установки значения Возраста хозяина
     *
     * @param agePerson передаваемый параметр Возраст хозяина
     */
    public void setAgePerson(int agePerson) {
        this.agePerson = agePerson;
    }

    /**
     * Метод для получения пол хозяина
     *
     * @return возвращает пол хозяина
     */
    public String getSexPerson() {
        return sexPerson;
    }

    /**
     * Метод для установки значения Пол хозяина
     *
     * @param sexPerson передаваемый параметр Пол хозяина
     */
    public void setSexPerson(String sexPerson) {
        this.sexPerson = sexPerson;
    }

    /**
     * Переопределение метода toString
     *
     * @return возвращает строку-описание
     */
    @Override
    public String toString() {
        return "Хозяин{" +
                "имя - '" + namePerson + '\'' +
                ", возраст - " + agePerson +
                ", пол - '" + sexPerson + '\'' +
                '}';
    }

}
