package ru;

public class Person {
    private Integer id;
    private String str;

    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", str='" + str + '\'' +
                '}';
    }

    public Person(Integer id, String str) {
        this.id = id;
        this.str = str;
    }
}
