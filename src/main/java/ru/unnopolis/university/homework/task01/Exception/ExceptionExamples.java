package ru.unnopolis.university.homework.task01.Exception;

/**
 * Класс демонстрирует возникновение ошибки NullPointerException, ArrayIndexOutOfBoundsException, а также
 * пользовательскую ошибку MyCustomNameSampleException
 */
public class ExceptionExamples {
    private static String s = null;
    private static int n = 11;

    /**
     * Главный метод, необходмый для запуска методов вызывающих ошибки
     *
     * @param args принимаемый параметр массив String
     */
    public static void main(String[] args) throws MyCustomNameSampleException {
        getNPE(s);
        getArrayIndexOutOfBoundsException(n);
        getMyCustomNameSampleException(s);
    }

    /**
     * Метод "getNPE" при вызове которого, возникает ошибка NullPointerException
     *
     * @param s принимаемый параметр типа String
     */
    private static void getNPE(String s) {
        try {
            System.out.println(s.equals("null"));
        } catch (NullPointerException e) {
            System.out.println("Вызвали и обработали ошибку " + e.getClass());
        }
    }

    /**
     * Метод "getArrayIndexOutOfBoundsException" при вызове которого, возникает ошибка ArrayIndexOutOfBoundsException
     *
     * @param n принимаемый параметр типа Integer
     */
    private static void  getArrayIndexOutOfBoundsException(int n) {
        try {
            int[] a = new int[10];
            System.out.println(a[n]);
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Вызвали ошибку и обработали " + e.getClass());
        }
    }

    /**
     * Метод "getMyCustomNameSampleException" при вызове которого, возникает моя ошибка getMyCustomNameSampleException
     *
     * @param s принимаемый параметр типа String
     */
    private static void getMyCustomNameSampleException(String s) throws MyCustomNameSampleException {
        throw new MyCustomNameSampleException("Вызвали  и пробросили " +
                "пользовательскую ошибку MyCustomNameSampleException");
    }
}