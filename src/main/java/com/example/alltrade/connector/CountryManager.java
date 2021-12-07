package com.example.alltrade.connector;

import com.example.alltrade.model.country.CountryCategory;
import com.example.alltrade.model.country.CountryImportExport;
import com.example.alltrade.model.country.CountryShare;

import java.io.IOException;
import java.net.Socket;
import java.util.LinkedList;

public class CountryManager  extends ConnectionManager {

    public CountryManager(Socket clientSocket) {
        super(clientSocket);
    }

//    public LinkedList<CountryImportExport> getCountryImportExport(String country) {
//        sendString("countryTable");
//        sendString(country);
//        try {
//            return (LinkedList<CountryImportExport>) readMessage.readObject();
//        } catch (IOException | ClassNotFoundException e) {
//            e.printStackTrace();
//        }
//        return null;
//    }

//    public LinkedList<CountryCategory> getCountryCategory(String country) {
//        sendString("countryTable2");
//        sendString(country);
//        try {
//            return (LinkedList<CountryCategory>) readMessage.readObject();
//        } catch (IOException | ClassNotFoundException e) {
//            e.printStackTrace();
//        }
//        return null;
//    }

    public LinkedList<CountryCategory> getCountryShare(String country, Integer year) {
        sendString("countryShare + " + country + " " + year);
        try {
            return (LinkedList<CountryCategory>) readMessage.readObject();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }
}
