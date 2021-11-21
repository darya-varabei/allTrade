package com.example.alltrade.controller.table;

import com.example.alltrade.model.country.CountryImportExport;
import com.example.alltrade.model.user.UserInfo;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

import java.net.URL;
import java.util.Date;
import java.util.ResourceBundle;

public class UserTableController implements Initializable {

    @FXML
    private TableView<UserInfo> userTable;

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
    private TextField predicateField;

    private final ObservableList<UserInfo> dataList = FXCollections.observableArrayList();

    @Override
    public void initialize(URL url, ResourceBundle rb) {
       idColumn.setCellValueFactory(new PropertyValueFactory<>("id"));
        loginColumn.setCellValueFactory(new PropertyValueFactory<>("login"));
        countryColumn.setCellValueFactory(new PropertyValueFactory<>("country"));
        lastAccessColumn.setCellValueFactory(new PropertyValueFactory<>("lastAccessDate"));
        roleColumn.setCellValueFactory(new PropertyValueFactory<>("role"));
        Date date1 = new Date();
        UserInfo case1 = new UserInfo(1, "jerfhg", "Italy", date1,"User");
        UserInfo case2 = new UserInfo(1, "gtyr", "Italy", date1,"User");
        UserInfo case3 = new UserInfo(1, "uytgc", "Italy", date1,"User");
        UserInfo case4 = new UserInfo(1, "uiyut", "Italy", date1,"User");
        UserInfo case5 = new UserInfo(1, "uyewt", "Italy", date1,"User");
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
}

