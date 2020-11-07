package ru;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class Client {
    private BufferedReader in = null;
    private PrintWriter out = null;

    public Client() {

        Scanner scan = new Scanner(System.in);

        System.out.println("Введите IP для подключения к серверу");
        System.out.println("Формат: xxx.xxx.xxx.xxx");

        String ip = scan.nextLine();

        try {
            Socket socket = new Socket(ip, Constant.port);
            in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            out = new PrintWriter(socket.getOutputStream(), true);

            Resender resend = new Resender();
            resend.start();

            System.out.println("Введите свой ник:");
            out.println(scan.nextLine());
            String str = "";
            while (!str.equals("quit")) {
                str = scan.nextLine();
                out.println(str);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private class Resender extends Thread {
        private boolean stoped;

        public void setStop() {
            stoped = true;
        }

        @Override
        public void run() {
            try {
                while (!stoped) {
                    String str = in.readLine();
                    System.out.println(str);
                }
            } catch (IOException e) {
                System.err.println("Ошибка при получении сообщения");
                e.printStackTrace();
            }
        }
    }
}


