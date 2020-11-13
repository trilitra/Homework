package ru;

import java.util.*;

public class MemoryTest {

    private static List objects = new ArrayList();
    private static boolean cont = true;
    private static int i;

    public static void main(String[] args) {
        while (cont) {
            i++;
            System.out.println(
                    "I have " + objects.size() + " objects in use, about " +
                            (objects.size() * 10) + " MB.");
            System.out.println("Round " + i + " Free Memory: " + Runtime.getRuntime().freeMemory());
            createObjects();
            if (i % 4 == 0) {
                removeObjects();
            }
        }
    }

    private static void createObjects() {
        System.out.println("Creating objects");
        for (int i = 0; i < 2; i++) {
            objects.add(new byte[10 * 1024 * 1024]);
        }
    }

    private static void removeObjects() {
        System.out.println("Removing objects");
        int start = objects.size() - 1;
        int end = start - 2;
        for (int i = start; ((i >= 0) && (i > end)); i--) {
            objects.remove(i);
        }
    }
}