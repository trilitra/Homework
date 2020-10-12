package ru.unnopolis.university.homework.task01.Spisok;

/**
 * Ошибка, возникающая ри создании дубликатов объектов Person
 */
class PersonException extends Exception {
    PersonException(String message) {
        super(message);
    }
}
