package ru;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class Server {
    private  final List<Connection> connections = Collections.synchronizedList(new ArrayList<>());
    private ServerSocket server;

    @SuppressWarnings("InfiniteLoopStatement")
    public Server() {

        try {
            server = new ServerSocket(Constant.port);

            while (true) {
                Socket socket = server.accept();

                Connection con = new Connection(socket);
                connections.add(con);
                con.start();

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

            synchronized (connections) {
                Iterator<Connection> iter = connections.iterator();
                while (iter.hasNext()) {
                    iter.next().close();
                }
            }
        } catch (Exception e) {
            e.getStackTrace();
        }
    }


    private class Connection extends Thread {
        private BufferedReader in;
        private PrintWriter out;
        private Socket socket;

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

                for (Connection c : connections) {
                    c.out.println(name + " зашел в чат");
                }

                String str;
                while (true) {
                    str = in.readLine();
                    if (str.equals("quit")) break;

                    for (Connection c : connections) {
                        c.out.println(name + ": " + str);
                    }
                }

                for (Connection c : connections) {
                    c.out.println(name + " покинул чат");
                }
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                close();
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

