package com.example.alltrade.connector;

import java.net.Socket;

public class UsersManager  extends ConnectionManager {
    public UsersManager(Socket clientSocket) {
        super(clientSocket);
    }
}
