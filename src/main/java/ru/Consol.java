package ru;

import java.io.*;

public class Consol {
    public  void reader() {
        System.out.println("Введите код метода doWork");
        try(BufferedReader br = new BufferedReader (new InputStreamReader(System.in));
            BufferedWriter bw = new BufferedWriter(new FileWriter("C:\\Users\\efano\\IdeaProjects\\Homework\\target\\classes\\ru\\SomeClass.java")))
        {
            bw.write("package ru;\n" +
                    "public class SomeClass  {" +
                    "    public void doWork() {");
            String text;
            while(!(text=br.readLine()).isEmpty()){
                bw.write(text + "\n");
            }
            bw.write( " }" +
                    "}");
            bw.flush();
        }
        catch(IOException ex){
            System.out.println(ex.getMessage());
        }
    }
}

