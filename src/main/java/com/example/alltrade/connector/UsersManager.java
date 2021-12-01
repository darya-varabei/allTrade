package com.example.alltrade.connector;

import com.example.alltrade.model.country.CountryImportExport;
import com.example.alltrade.model.user.UserInfo;

import java.io.IOException;
import java.net.Socket;
import java.util.LinkedList;

public class UsersManager  extends ConnectionManager {
    public UsersManager(Socket clientSocket) {
        super(clientSocket);
    }

    public LinkedList<UserInfo> getAllUsers(String country) {
        sendString("allUsers + " + country);
        try {
            return (LinkedList<UserInfo>) readMessage.readObject();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }
}
