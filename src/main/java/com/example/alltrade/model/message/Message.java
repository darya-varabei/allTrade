package com.example.alltrade.model.message;

import java.io.Serializable;

public class Message implements Serializable {
    private int id;
    private String message;

    public Message(Integer id, String message) {
        this.id = id;
        this.message = message;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

}
