package com.example.alltrade.connector;

import com.example.alltrade.model.category.Category;
import com.example.alltrade.model.category.CategoryValue;
import com.example.alltrade.model.country.CountryCategory;
import com.example.alltrade.model.country.CountryShare;

import java.io.IOException;
import java.net.Socket;
import java.util.LinkedList;

public class CategoryManager extends ConnectionManager {
    public CategoryManager(Socket clientSocket) {
        super(clientSocket);
    }

    public LinkedList<Category> getCategoryList(String constituent, Integer year) {
        sendString(constituent + "" + String.valueOf(year));
        try {
            return (LinkedList<Category>) readMessage.readObject();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }

    public LinkedList<CategoryValue> getCategoryValueList(String constituent) {
        sendString(constituent);
        try {
            return (LinkedList<CategoryValue>) readMessage.readObject();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }

    public LinkedList<CountryShare> getCountryCategory(String constituent) {
        sendString(constituent);
        try {
            return (LinkedList<CountryShare>) readMessage.readObject();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }

    public LinkedList<CountryShare> getCountryShare(String constituent, Integer year) {
        sendString(constituent + " " + year);
        try {
            return (LinkedList<CountryShare>) readMessage.readObject();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }
}
