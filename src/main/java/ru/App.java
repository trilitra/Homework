package ru;

public  class App {
    public static void main(String[] args) throws ClassNotFoundException {
        SomeClass e = new SomeClass();
        e.doWork();
        Consol.reader();
        e.doWork();
    }
}
