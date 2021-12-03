package com.example.alltrade.connector;

import java.io.IOException;
import java.net.Socket;

public class Connection {
    public static ConnectionManager connectionManager;
    public static CountryManager countryManager;
    public static CategoryManager categoryManager;
    public static MessageManager messageManager;
    public static UsersManager usersManager;

    public void connectToServer(String host, int port) {
        try {
            Socket clientSocket = new Socket(host, port);
            connectionManager = new ConnectionManager(clientSocket);
            countryManager = new CountryManager(clientSocket);
            categoryManager = new CategoryManager(clientSocket);
            usersManager = new UsersManager(clientSocket);
            messageManager = new MessageManager(clientSocket);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
