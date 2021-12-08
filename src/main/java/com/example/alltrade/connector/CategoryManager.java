package com.example.alltrade.connector;

import com.example.alltrade.model.category.Category;
import com.example.alltrade.model.category.CategoryValue;
import com.example.alltrade.model.category.WorldYearValue;
import com.example.alltrade.model.country.CountryCategory;
import com.example.alltrade.model.country.CountryShare;

import java.io.IOException;
import java.net.Socket;
import java.util.LinkedList;

public class CategoryManager extends ConnectionManager {
    public CategoryManager(Socket clientSocket) {
        super(clientSocket);
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

    public LinkedList<CountryShare> getCountryShare(String country, Integer year) {
        sendString("Share");
        sendString(country);
        sendString(year.toString());
        try {
            return (LinkedList<CountryShare>) readMessage.readObject();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }

    public LinkedList<CountryShare> getWorldShare(String constituent, Integer year) {
        sendString("world " + constituent + " " + year);
        try {
            return (LinkedList<CountryShare>) readMessage.readObject();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }
    public LinkedList<CountryShare> getCategoryShare(String code, String constituent, Integer year) {
        sendString("Share " + code);
        sendString(constituent);
        sendString(year.toString());
        try {
            return (LinkedList<CountryShare>) readMessage.readObject();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }

    public LinkedList<WorldYearValue> getWorldConstituentExport(String country) {
        sendString("worldCE");
        sendString(country);
        try {
            return (LinkedList<WorldYearValue>) readMessage.readObject();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }

    public LinkedList<CategoryValue> getConstituent(String constituent) {
        sendString("EIConstituent");
        sendString(constituent);
        try {
            return (LinkedList<CategoryValue>) readMessage.readObject();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }
}
