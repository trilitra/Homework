package ru.unnopolis.university.homework.task01.Spisok;

/**
 * Класс реализующий сортировку Arrays.sort и выводящий в консоль время работы алгоритма сортировки
 */

class BubbleSort implements sortContract {
    /**
     * Метод в котором реализуется сортировка Arrays.sort, и замер времени работы алгоритма сортировки
     *
     * @param massiv принимает для сортировки массив объектов класса Person
     */
    @Override
    public void sort(Person[] massiv) {

        long startTime = System.currentTimeMillis();
        try {
            Person temp;
            for (int j = 0; j < massiv.length; j++) {
                for (int i = j + 1; i < massiv.length; i++) {
                    FullComparator comparator = new FullComparator();
                    if (comparator.compare(massiv[i], massiv[j]) < 0) {
                        temp = massiv[j];
                        massiv[j] = massiv[i];
                        massiv[i] = temp;
                    } else {
                        if (comparator.compare(massiv[i], massiv[j]) == 0) {
                            System.out.println(i);
                            throw new PersonException(" ");
                        }
                    }
                }
            }
        } catch (PersonException e) {
            System.out.println("В сгенерированном массиве есть одинаковые элементы! Попробуйте еще раз");
        }
        for (Person i : massiv) {
            System.out.println(i);
        }

        long endTime = System.currentTimeMillis();
        long delta = endTime - startTime;
        System.out.println("Время выполнения сортировки методом пузырька = " + delta + " milliseconds");
    }
}
