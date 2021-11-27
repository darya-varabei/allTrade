package com.example.alltrade.connector;

import java.io.IOException;
import java.net.Socket;

public class Connection {
    public static ConnectionManager connectionManager;

    public void connectToServer(String host, int port) {
        try {
            Socket clientSocket = new Socket(host, port);
            connectionManager = new ConnectionManager(clientSocket);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
