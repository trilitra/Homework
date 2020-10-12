package ru.unnopolis.university.homework.task01.Spisok;

/**
 * Класс реализующий сортировку методом пузырьков
 */

class BubbleSort implements SortContract {
    /**
     * Метод в котором реализуется сортировка методом Bubble
     *выводит в консоль отсортированный массив объектов класса Person
     *
     * @param massiv принимает для сортировки массив объектов класса Person
     */
    @Override
    public void sort(Person[] massiv) throws PersonException {

        Person temp;
        FullComparator comparator = new FullComparator();
        for (int j = 0; j < massiv.length; j++) {
            for (int i = j + 1; i < massiv.length; i++) {
                if (comparator.compare(massiv[i], massiv[j]) < 0) {
                    temp = massiv[j];
                    massiv[j] = massiv[i];
                    massiv[i] = temp;
                }else if (comparator.compare(massiv[i], massiv[j]) == 0){
                    throw new PersonException("\nВ сгенерированном массиве есть дубликаты!");
                }
            }
        }
        System.out.println("\n");
        for (Person i : massiv) {
            System.out.println(i);
        }
    }
}
