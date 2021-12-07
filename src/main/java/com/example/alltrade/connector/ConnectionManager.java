package com.example.alltrade.connector;

import com.example.alltrade.model.category.Category;
import com.example.alltrade.model.category.CategoryValue;
import com.example.alltrade.model.country.CountryCategory;
import com.example.alltrade.model.country.CountryImportExport;
import com.example.alltrade.model.country.CountryShare;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.LinkedList;

public class ConnectionManager {
    protected ObjectOutputStream sendMessage;
    protected ObjectInputStream readMessage;


    public ConnectionManager(Socket clientSocket) {
        try {
            sendMessage = new ObjectOutputStream(clientSocket.getOutputStream());
            readMessage = new ObjectInputStream(clientSocket.getInputStream());

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void closeConnection() throws IOException {
        try {
            sendString("close");
            sendMessage.close();
            readMessage.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void sendObject(String code, Object object) {
        try {
            sendString(code);
            sendMessage.writeObject(object);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void sendString(String text) {
        try {
            sendMessage.writeObject(text);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public Object readObject() {
        try {
            return readMessage.readObject();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }

    public String readString() {
        try {
            return (String)readMessage.readObject();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }

    public Double readValue() {
        try {
            return (Double)readMessage.readObject();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }

    public LinkedList<String> getStrings(String code) {
        sendString(code);
        try {
            return (LinkedList<String>) readMessage.readObject();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }

    public LinkedList<Integer> getYears() {
        sendString("years");
        try {
            return (LinkedList<Integer>) readMessage.readObject();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }

    public LinkedList<CountryImportExport> getCountryImportExport(String country) {
        sendString("countryTable");
        sendString(country);
        try {
            return (LinkedList<CountryImportExport>) readMessage.readObject();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }

    public LinkedList<CountryCategory> getCountryCategory(String country) {
        sendString("countryTable2");
        sendString(country);
        try {
            return (LinkedList<CountryCategory>) readMessage.readObject();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }

//    public LinkedList<Category> getCategoryList(String constituent, Integer year) {
//        sendString(constituent + "" + String.valueOf(year));
//        try {
//            return (LinkedList<Category>) readMessage.readObject();
//        } catch (IOException | ClassNotFoundException e) {
//            e.printStackTrace();
//        }
//        return null;
//    }
//
//    public LinkedList<CategoryValue> getCategoryValueList(String constituent) {
//        sendString(constituent);
//        try {
//            return (LinkedList<CategoryValue>) readMessage.readObject();
//        } catch (IOException | ClassNotFoundException e) {
//            e.printStackTrace();
//        }
//        return null;
//    }
//
//    public LinkedList<CountryShare> getCountryCategory(String constituent) {
//        sendString(constituent);
//        try {
//            return (LinkedList<CountryShare>) readMessage.readObject();
//        } catch (IOException | ClassNotFoundException e) {
//            e.printStackTrace();
//        }
//        return null;
//    }
//
//    public LinkedList<CountryShare> getCountryShare(String constituent, Integer year) {
//        sendString(constituent + " " + year);
//        try {
//            return (LinkedList<CountryShare>) readMessage.readObject();
//        } catch (IOException | ClassNotFoundException e) {
//            e.printStackTrace();
//        }
//        return null;
//    }
//    public LinkedList<CountryImportExport> getCountryImportExport(String country) {
//        sendString("countryCommon + " + country);
//        try {
//            return (LinkedList<CountryImportExport>) readMessage.readObject();
//        } catch (IOException | ClassNotFoundException e) {
//            e.printStackTrace();
//        }
//        return null;
//    }
//
//    public LinkedList<CountryCategory> getCountryCategory(String country) {
//        sendString("countryCategory + " + country);
//        try {
//            return (LinkedList<CountryCategory>) readMessage.readObject();
//        } catch (IOException | ClassNotFoundException e) {
//            e.printStackTrace();
//        }
//        return null;
//    }
//
//    public LinkedList<CountryCategory> getCountryShare(String country, Integer year) {
//        sendString("countryShare + " + country + " " + year);
//        try {
//            return (LinkedList<CountryCategory>) readMessage.readObject();
//        } catch (IOException | ClassNotFoundException e) {
//            e.printStackTrace();
//        }
//        return null;
//    }


}
