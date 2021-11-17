package com.example.alltrade.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import animatefx.animation.*;
import javafx.stage.Stage;

public class LoginController {

    @FXML
    private ImageView image;

    @FXML
    private Button registButton;

    @FXML
    private Button authoButton;

    @FXML
    private Pane loginPane;

    @FXML
    private TextField login;

    @FXML
    private PasswordField loPassword;

    @FXML
    private Button btnEnter;

    @FXML
    private Pane authoPane;

    @FXML
    private TextField emailField;

    @FXML
    private TextField loginField;

    @FXML
    private PasswordField passField;

    @FXML
    private PasswordField repPasswordField;

    @FXML
    private Button btnRegist;

    private Scene secondScene;

    public void setSecondScene(Scene scene) {
        secondScene = scene;
    }

    @FXML
    void AuthoAction(ActionEvent event) {
        authoButton.setStyle("-fx-background-color: #fafafa; -fx-background-radius: 20;  -fx-text-fill: #013243");
        registButton.setStyle("-fx-background-color: #013243; -fx-background-radius: 20; -fx-text-fill: #fafafa");
        new SlideInRight(loginPane).play();
        new SlideOutRight(authoPane).play();
        authoPane.toBack();
        loginPane.toFront();
    }

    @FXML
    void RegistAction(ActionEvent event) {
        registButton.setStyle("-fx-background-color: #fafafa; -fx-background-radius: 20; -fx-text-fill: #013243");
        authoButton.setStyle("-fx-background-color: #013243; -fx-background-radius: 20;  -fx-text-fill: #fafafa");
        new SlideOutLeft(loginPane).play();
        new SlideInLeft(authoPane).play();
        loginPane.toBack();
        authoPane.toFront();
    }

    @FXML
    public void EnterMainScreen(ActionEvent event) {
        Stage primaryStage = (Stage)((Node)event.getSource()).getScene().getWindow();
        primaryStage.setScene(secondScene);
    }
}
