package ru.unnopolis.university.homework.task2.Spisok;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class Massiv {
    public static Person[] generate(int length) throws PersonException {
        Random rand = new Random();
        List<String> listName = Arrays.asList("Александр(a)", "Евгений(я)", "Валентин(а)", "Влад(а)", "Виктор(ия)",
                "Антон(ина)", "Ярослав(а)", "Ян(а)", "Валерий(я)", "Василий(иса)", "Альберт(ина)", "Ангел(ина)",
                "Богдан(а)", "Виталий(ина)", "Дарий(ина)", "Иоанн(а)", "Константин(а)");
        List<String> listSex = Arrays.asList("MAN", "WOMAN");
        Person[] massiv = new Person[length];
        for (int i = 0; i < massiv.length; i++) {
            String name = listName.get(rand.nextInt(listName.size()));
            String sex = listSex.get(rand.nextInt(listSex.size()));
            massiv[i] = new Person(name, (int) (Math.random() * 1000), sex);
        }
        for (int i = 0; i < massiv.length; i++) {
            for (int j = i + 1; j < massiv.length; j++) {
                if (massiv[i].getAge() == massiv[j].getAge()
                        & massiv[i].getName() == massiv[j].getName()
                        & massiv[i].getSex() == massiv[j].getSex()) {
                    throw new PersonException(" ");
                }
            }

        }
        return massiv;
    }
}



