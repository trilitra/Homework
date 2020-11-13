package task07;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.*;
import java.util.regex.Pattern;

/**
 * В классе Server и подклассе Connection релизована следующая логика выполнения действий программы:
 * В методе Server() создаем сервер на порту переданному в метод как аргумент с помощью java класса ServerSocket.
 * Также в этом методе программа принимает подключения и запускает поток класса Сonnection для работы с принимаемым
 * в качестве аргумента с каждым новым подключением. Класс Connection принимает сообщение от пользователя и рассылает
 * сообщение всем другим подключениям или только одному выбранному пользователем подключению (личное сообщение).
 * Рассылка сообщения и выбор адресатов для рассылки происходит в методе createMessages() класса Connection.
 * Для закрытия потоков и подключений реализованы методы closeAll() и close().
 */
public class Server {
    private static Connection connection;
    private HashMap<String, Connection> connections = new HashMap<>();
    private ServerSocket server;
    public static final int port = 8283;

    @SuppressWarnings("InfiniteLoopStatement")
    public Server() {

        try {
            server = new ServerSocket(port);

            while (true) {
                Socket socket = server.accept();
                connection = new Connection(socket);
                connection.start();

            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            closeAll();
        }
    }

    private void closeAll() {
        try {
            server.close();

            for (Map.Entry<String, Connection> entry : connections.entrySet()) {
                Connection value = entry.getValue();
                value.close();
            }
        } catch (Exception e) {
            e.getStackTrace();
        }
    }

    private class Connection extends Thread {
        private BufferedReader in;
        private PrintWriter out;
        private Socket socket;
        private List<String> list = new ArrayList<>();
        private String name = "";

        public Connection(Socket socket) {
            this.socket = socket;

            try {
                in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                out = new PrintWriter(socket.getOutputStream(), true);

            } catch (IOException e) {
                e.printStackTrace();
                close();
            }
        }

        public void run() {
            try {
                name = in.readLine();
                connections.put(name, Server.connection);

                for (Map.Entry<String, Connection> entry : connections.entrySet()) {
                    Connection value = entry.getValue();
                    value.out.println(name + " зашел в чат");
                }
                createMessages();
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                close();
            }
        }

        private void createMessages() throws IOException {
            String str;

            while (true) {
                str = in.readLine();

                Pattern p = Pattern.compile("=");
                String[] array = p.split(str);
                if (connections.containsKey(array[0])) {
                    Connection value = connections.get(array[0]);
                    value.out.println("Личное сообщение от " + name + ": " + array[1]);
                    createMessages();
                }

                if (str.equals("quit")) break;

                for (Map.Entry<String, Connection> entry : connections.entrySet()) {
                    Connection value = entry.getValue();
                    value.out.println(name + ": " + str);
                }
            }
            for (Map.Entry<String, Connection> entry : connections.entrySet()) {
                Connection value = entry.getValue();
                value.out.println(name + " вышел из чата");
            }
        }

        public void close() {
            try {
                in.close();
                out.close();
                socket.close();

                connections.remove(this);
                if (connections.size() == 0) {
                    Server.this.closeAll();
                    System.exit(0);
                }
            } catch (Exception e) {
                e.getStackTrace();
            }
        }
    }
}
