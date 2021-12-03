package com.example.alltrade.connector;

import com.example.alltrade.model.user.UserInfo;

import java.io.IOException;
import java.net.Socket;
import java.util.LinkedList;

public class MessageManager extends ConnectionManager{

    public MessageManager(Socket clientSocket) {
        super(clientSocket);
    }

    public LinkedList<String> getMessages() {
        sendString("messages");
        try {
            return (LinkedList<String>) readMessage.readObject();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }
}
