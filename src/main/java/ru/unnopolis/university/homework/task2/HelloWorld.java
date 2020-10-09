package ru.unnopolis.university.homework.task2;

/**
 * Class User Example Exception
 */
public class HelloWorld {
    public static void main(String[] args) {
        try {
            System.out.println("Hello, world!");
            throw new NullPointerException();
        } catch (NullPointerException exception) {
            try {
                System.out.println("Перехватываю NullPointerException");
                throw new ArrayIndexOutOfBoundsException();
            } catch (ArrayIndexOutOfBoundsException exception1) {
                try {
                    System.out.println("Перехватываю ArrayIndexOutOfBoundsException");
                    throw new ArithmeticException();
                } catch (ArithmeticException exception2) {
                    System.out.println("Перехватываю ArithmeticException");
                }
            }
        }
    }
}
