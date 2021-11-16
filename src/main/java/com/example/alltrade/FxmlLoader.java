package com.example.alltrade;

import javafx.fxml.FXMLLoader;
import javafx.scene.layout.Pane;

import java.io.File;
import java.net.URL;

public class FxmlLoader {
    private Pane view;

    public Pane getPane(String filename) {
        try {
            System.out.println("EEEEEEEEEEEEEEEEEEEEEEEEEEEE");
            URL fileUrl = new /*HelloApplication.class.getResource*/ File("/Users/dariavarabei/IdeaProjects/allTrade/src/main/resources/com/example/alltrade/CountryTable.fxml").toURI().toURL();

            if (fileUrl == null) {
                throw new java.io.FileNotFoundException("not found");
            }
            view = new FXMLLoader().load(fileUrl);
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("AAAaaaaaaaaaaaaaaaaaaaaaaaa");
        }
        return view;
    }
}
