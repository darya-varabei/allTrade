package com.example.alltrade;

import animatefx.animation.FadeIn;
import com.example.alltrade.controller.LoginController;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader firstPage = new FXMLLoader(HelloApplication.class.getResource("hello-view.fxml"));
        FXMLLoader secondPage = new FXMLLoader(HelloApplication.class.getResource("mainScreen.fxml"));
        Scene scene = new Scene(firstPage.load(), 970, 550);
        Parent secondPane = secondPage.load();
        Scene secondScene = new Scene(secondPane, 970, 650);

        LoginController firstPaneController = (LoginController) firstPage.getController();
        firstPaneController.setSecondScene(secondScene);

        stage.setTitle("AllTrade");
        stage.setScene(scene);
        stage.show();

        new FadeIn(scene.getRoot()).play();
        new FadeIn(secondScene.getRoot()).play();
    }

    public static void main(String[] args) {
        launch();
    }
}