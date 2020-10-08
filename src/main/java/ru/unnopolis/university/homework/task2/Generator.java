package ru.unnopolis.university.homework.task2;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Generator {
    public static void main(String[] args) {
        System.out.println("Введите количество чисел, которое хотите сгенерировать");
        int n = 0;
        try {
            Scanner sc = new Scanner(System.in);
            n = Math.abs(sc.nextInt());
        } catch (InputMismatchException e) {
            System.out.println("Введите целое положительное число");
            main(null);
        }
        for (int i = 0; i < n; i++) {
            int k = (int) (Math.random() * (200 + 1)) - 100;
            try {
                if (k < 0) {
                    throw new Exception();
                }
            } catch (Exception e) {
                System.out.println("Было сгенерировано отрицательное число!");
            }
            double q = Math.sqrt(k);
            long a = (long) q;
            if ((a * a) == k) {
                System.out.println(k);
            }
        }

    }
}
