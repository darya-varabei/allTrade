package com.example.alltrade.controller;

import com.example.alltrade.connector.Connection;
import com.example.alltrade.connector.ConnectionManager;
import com.example.alltrade.model.user.CurrentUser;
import com.example.alltrade.model.user.User;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
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

        @FXML
        private Pane connectionPane;

        @FXML
        private TextField txtAdress;

        @FXML
        private TextField txtPort;

        @FXML
        private Button btnSetConnection;

        @FXML
        private Label lblRegistrationError;

    @FXML
    private Label lblLoginError;

    @FXML
    private Label lblConnectionError;

    private Scene secondScene;
    private ConnectionManager manager;

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

    @FXML private void completeRegistration(ActionEvent event) {
        if (loPassword.getText() == repPasswordField.getText()) {
            lblRegistrationError.setText("Введенные пароли не совпадают");
            lblRegistrationError.setVisible(true);
            return;
        }
        manager.sendObject("regist", new User(login.getText(), loPassword.getText()));
        if(CurrentUser.getInstance((CurrentUser) manager.readObject()) != null) {
            Stage primaryStage = (Stage)((Node)event.getSource()).getScene().getWindow();
            primaryStage.setScene(secondScene);
        }
        else {
            CurrentUser.nullInstance();
            if (manager.readString() == "exists") {
                lblLoginError.setText("Данный логин уже существует");
                lblLoginError.setVisible(true);
            }
            else {
                CurrentUser.nullInstance();
                lblLoginError.setVisible(true);
            }
        }
    }

    @FXML private void completeLogin(ActionEvent event) {
        manager.sendObject("authorize", new User(login.getText(), loPassword.getText()));
        if(CurrentUser.getInstance((CurrentUser) manager.readObject()) != null) {
            Stage primaryStage = (Stage)((Node)event.getSource()).getScene().getWindow();
            primaryStage.setScene(secondScene);
        }
        else {
            CurrentUser.nullInstance();
            lblLoginError.setVisible(true);
        }
    }

    @FXML
    private void connect() {
//        var connection = new Connection();
//        if (txtPort.getText().isEmpty() == false && txtAdress.getText().isEmpty() == false && txtPort.getText().matches("[1-9]+")) {
//            connection.connectToServer(
//                    txtAdress.getText(), Integer.parseInt(txtPort.getText())
//            );
//            manager = connection.connectionManager;
//
//            if (manager != null) {
//                lblInvalidConnection.setVisible(false);
                new SlideOutLeft(connectionPane).play();
                new SlideInLeft(authoPane).play();
                connectionPane.toBack();
                authoPane.toFront();
                registButton.setDisable(false);
                authoButton.setDisable(false);
//            } else {
//        lblConnectionError.setVisible(true);
//                lblInvalidConnection.setVisible(true);
//                lblInvalidConnection.toFront();
//            }
//        }
//        else {
//        lblConnectionError.setVisible(true);
//            lblInvalidConnection.setVisible(true);
//            lblInvalidConnection.toFront();
//        }
    }
}
