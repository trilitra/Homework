package ru.unnopolis.university.homework.task01.Spisok;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

/**
 * Класс рандомно генерирующий массив из объектов класса Person
 */
class Massiv {
    /**
     * Method Generate Array
     *
     * @param length принимает переменную, которая задает длину генерируемого массива
     * @return massiv возвращает сгенерированный массив заданной длины
     * @throws PersonException пробрасывает исключение в клас Main если генерируются абсолютно одинаковые объекты Person
     */
    static Person[] generate(int length) throws PersonException {
        Random rand = new Random();
        List<String> listName = Arrays.asList("Александр(a)", "Евгений(я)", "Валентин(а)", "Влад(а)", "Виктор(ия)",
                "Антон(ина)", "Ярослав(а)", "Ян(а)", "Валерий(я)", "Василий(иса)", "Альберт(ина)", "Ангел(ина)",
                "Богдан(а)", "Виталий(ина)", "Дарий(ина)", "Иоанн(а)", "Константин(а)");
        List<String> listSex = Arrays.asList("MAN", "WOMAN");
        Person[] massiv = new Person[length];
        for (int i = 0; i < massiv.length; i++) {
            String name = listName.get(rand.nextInt(listName.size()));
            String sex = listSex.get(rand.nextInt(listSex.size()));
            massiv[i] = new Person(name, (int) (Math.random() * 100), sex);
        }
        for (int i = 0; i < massiv.length; i++) {
            for (int j = i + 1; j < massiv.length; j++) {
                if (massiv[i].getAge() == massiv[j].getAge()
                        & (massiv[i].getName()).equals(massiv[j].getName())
                        & (massiv[i].getSex()).equals(massiv[j].getSex())) {
                    throw new PersonException(" ");
                }
            }

        }
        return massiv;
    }
}



