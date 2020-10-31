package ru;


import java.io.*;

public class Bonus {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream("TextFile0.txt")));
        OutputStream outputStream = new FileOutputStream("TextFile0_UTF-16.txt");
        OutputStreamWriter outputStreamWriter = new OutputStreamWriter(outputStream, "UTF-16");
        while(reader.ready()){
            String string = reader.readLine();
            outputStreamWriter.write(string + "\n");
        }
    }
}
