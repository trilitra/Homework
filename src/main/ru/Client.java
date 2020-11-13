package task07;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

/**
 * В классе Client реализуем подключение к серверу
 */
public class Client {
    private BufferedReader in = null;
    private PrintWriter out = null;
    private Socket socket;

    /**
     * В методе Client реализован следующий алгоритм действий программы:
     * Запрашиваем IP компьютера пользователя. Считываем ответ с консоли. Создаем новый Socket, при этом
     * сразу же происходит подключаемся к серверу. Создаем входной(in) и выходной (out) потоки для процесса обмена
     * информацией с сервером. Метод println() объекта out отправляет данные на сервер, а метод readLine() объекта in –
     * считывает полученные данные. Для одновременного считывания сообщений из консоли (от пользователя) и
     * сообщений из потока (от сервера) создаем дополнительную нить, путем создания объекта класса Resender
     * и запуска потока этого класса (start()). Пока  не произойдет  считывания с консоли сообщения "quit" от
     * пользователя, программа будет считывать все сообщения сервера и выводит их в консоль, также  параллельно
     * считывать сообщения от пользователя и отправлять их на сервер. При вводе пользователем "quit"  с помощью
     * метода close() происходитостановка и закрытия потоков и подключения к серверу.
     *
     */
    public Client() {

        Scanner scan = new Scanner(System.in);

        System.out.println("Введите IP для подключения к серверу");
        System.out.println("Формат: xxx.xxx.xxx.xxx");
        String ip = scan.nextLine();
        System.out.println("Команда для отправки личного сообщения \"NickName= текст сообщения\"");

        try {
            socket = new Socket(ip, Server.port);
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
            resend.setStop();
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            close();
        }
    }

    private void close()  {
        try{
            in.close();
            out.close();
            socket.close();
        } catch (IOException e) {
            e.getStackTrace();
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
