package com.example.alltrade.controller.table;

import com.example.alltrade.connector.Connection;
import com.example.alltrade.model.user.UserInfo;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;

import java.net.URL;
import java.util.Date;
import java.util.ResourceBundle;

public class UserTableController implements Initializable {

    @FXML
    public TableView<UserInfo> userTable;

    @FXML
    private TableColumn<UserInfo, Integer> idColumn;

    @FXML
    private TableColumn<UserInfo, String> loginColumn;

    @FXML
    private TableColumn<UserInfo, String> countryColumn;

    @FXML
    private TableColumn<UserInfo, Date> lastAccessColumn;

    @FXML
    private TableColumn<UserInfo, String> roleColumn;

    @FXML
    private Label lblSearch;

    @FXML
    private Button addUserButton;

    @FXML
    private Button updateUserButton;

    @FXML
    private Button deleteUserButton;

    @FXML
    private Button clearUserDataButton;

    @FXML
    private TextField txtLogin = new TextField();

    @FXML
    private TextField txtPassword = new TextField();

    @FXML
    private ComboBox<String> cmbChooseUserCountry = new ComboBox<>();

    @FXML
    private ComboBox<String> cmbChooseRole = new ComboBox<>();

    @FXML
    private TextField predicateField;

    private UserInfo user;

    public final ObservableList<UserInfo> dataList = FXCollections.observableArrayList();

    @Override
    public void initialize(URL url, ResourceBundle rb) {
       idColumn.setCellValueFactory(new PropertyValueFactory<>("id"));
        loginColumn.setCellValueFactory(new PropertyValueFactory<>("login"));
        countryColumn.setCellValueFactory(new PropertyValueFactory<>("country"));
        lastAccessColumn.setCellValueFactory(new PropertyValueFactory<>("lastAccessDate"));
        roleColumn.setCellValueFactory(new PropertyValueFactory<>("role"));
        Date date1 = new Date();
        UserInfo case1 = new UserInfo(1, "jerfhg","e4tgh", "Italy", "date1","User");
        UserInfo case2 = new UserInfo(1, "gtyr","tg4e", "Italy", "date1","User");
        UserInfo case3 = new UserInfo(1, "uytgc","rtgb4w", "Italy", "","User");
        UserInfo case4 = new UserInfo(1, "uiyut","4gwtrbrt", "Italy", "date1","User");
        UserInfo case5 = new UserInfo(1, "uyewt","45htwgy", "Italy"," date1","User");
        dataList.addAll(case1, case2, case3, case4, case5);

        FilteredList<UserInfo> filteredData = new FilteredList<>(dataList, b -> true);
        predicateField.textProperty().addListener((observable, oldValue, newvalue) -> {
            filteredData.setPredicate(caseCase -> {
                if (newvalue == null || newvalue.isEmpty()) {
                    return true;
                }

                String lowerCaseFilter = newvalue.toLowerCase();

                if (String.valueOf(caseCase.getId()).indexOf(lowerCaseFilter) != -1) {
                    return true;
                }
                else if (String.valueOf(caseCase.getLogin()).indexOf(lowerCaseFilter) != -1) {
                    return true;
                }
                else if (String.valueOf(caseCase.getCountry()).indexOf(lowerCaseFilter) != -1) {
                    return true;
                }
                else if(String.valueOf(caseCase.getLastAccessDate()).indexOf(lowerCaseFilter) != -1) {
                    return true;
                }
                else if(String.valueOf(caseCase.getRole()).indexOf(lowerCaseFilter) != -1) {
                    return true;
                }
                else {
                    return false;
                }
            });
        });

        SortedList<UserInfo> sortedData = new SortedList<>(filteredData);
        sortedData.comparatorProperty().bind((userTable.comparatorProperty()));
        userTable.setItems(sortedData);
    }

    @FXML
    private void clickItem(MouseEvent event) {
        if (event.getClickCount() == 2) {
            user = userTable.getSelectionModel().getSelectedItem();
            txtLogin.setText(user.getLogin());
            txtPassword.setText(user.getPassword());
            cmbChooseUserCountry.setValue(user.getCountry());
            cmbChooseRole.setValue(user.getRole());
        }
    }

    @FXML private void addUser() {
        String response = "";
        UserInfo userAdd = new UserInfo(0, txtLogin.getText(), txtPassword.getText(), cmbChooseUserCountry.getValue(), "", cmbChooseRole.getValue());
        Connection.usersManager.sendObject("addUser", userAdd);
        if ((response = Connection.connectionManager.readString()) == "success") {
            dataList.add(userAdd);
            userTable.refresh();
        }
    }

    @FXML private void updateUser() {
        String response = "";
        user = userTable.getSelectionModel().getSelectedItem();
        user.setLogin(txtLogin.getText());
        user.setPassword(txtPassword.getText());
        user.setCountry(cmbChooseUserCountry.getValue());
        user.setCountry(cmbChooseRole.getValue());
        Connection.connectionManager.sendObject("updateUser", user);
        if ((response = Connection.connectionManager.readString()) == "success") {
            removeUser(user.getId());
            dataList.add(user);
        }
    }

    @FXML private void deleteUser() {
        user = userTable.getSelectionModel().getSelectedItem();
        removeUser(user.getId());
        Connection.connectionManager.sendObject("deleteUser", String.valueOf(user.getId()));
        userTable.refresh();
    }

    private void removeUser(int id) {
        dataList.forEach((tab) -> {
            if (tab.getId() == id) {
                dataList.remove(tab);
            }
        });
    }

    @FXML private void clearUser() {
        txtLogin.clear();
        txtPassword.clear();
        cmbChooseUserCountry.setValue("Выберите страну");
        cmbChooseRole.setValue("Выберите роль");
    }
}

