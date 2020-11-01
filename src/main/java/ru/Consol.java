package ru;

import java.io.*;

public class Consol {
    public static void reader() {
        System.out.println("Введите код метода doWork");
        try(BufferedReader br = new BufferedReader (new InputStreamReader(System.in));
            BufferedWriter bw = new BufferedWriter(new FileWriter("C:\\Users\\efano\\IdeaProjects\\Homework\\src\\main\\java\\ru\\SomeClass.java")))
        {
            bw.write("package ru;\n" +
                    "\n" +
                    "public class SomeClass implements Worker {" +
                    " @Override\n" +
                    "    public void doWork() {");
            String text;
            while(!(text=br.readLine()).isEmpty()){
                bw.write(text + "\n");
            }
            bw.write(" }" +
                    "}");
            bw.flush();
        }
        catch(IOException ex){
            System.out.println(ex.getMessage());
        }
    }
}

