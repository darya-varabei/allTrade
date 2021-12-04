package com.example.alltrade.controller.table;

import com.example.alltrade.connector.Connection;
import com.example.alltrade.model.country.CountryConstants;
import com.example.alltrade.model.country.CountryImportExport;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;

import java.net.URL;
import java.util.ResourceBundle;

public class UsersToApproveController implements Initializable {

    @FXML
    private AnchorPane pnUsersApproval;

    @FXML
    private TableView<Integer> tableUsersToApprove;

    @FXML
    private TableColumn<Integer, Integer> loginColumn;

    @FXML
    private Button btnApprove;
    private ObservableList<Integer> data;

    @FXML
    void approveUser(ActionEvent event) {
        Connection.connectionManager.sendObject("approve", tableUsersToApprove.getSelectionModel());
        data.remove(tableUsersToApprove.getSelectionModel());
    }

    @FXML
    void selectUser(ActionEvent event) {

    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        loginColumn.setCellValueFactory(new PropertyValueFactory<>("id"));
        data = FXCollections.observableArrayList(Connection.usersManager.getUsersToApprove());
        tableUsersToApprove.setItems(data);
    }
}
