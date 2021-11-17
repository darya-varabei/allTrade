package com.example.alltrade;

import javafx.fxml.FXMLLoader;
import javafx.scene.layout.Pane;

import java.io.File;
import java.net.URL;

public class FxmlLoader {
    private Pane view;

    public Pane getPane(String filename) {
        try {
            URL fileUrl = new File("/Users/dariavarabei/IdeaProjects/allTrade/src/main/resources/com/example/alltrade/" + filename).toURI().toURL();
            if (fileUrl == null) {
                throw new java.io.FileNotFoundException("not found");
            }
            view = new FXMLLoader().load(fileUrl);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return view;
    }
}
