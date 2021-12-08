package com.example.alltrade.controller.table;

import com.example.alltrade.connector.Connection;
import com.example.alltrade.model.country.CountryAdd;
import com.example.alltrade.model.country.CountryConstants;
import com.example.alltrade.model.country.CountryImportExport;
import com.example.alltrade.model.user.CurrentUser;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;

import java.net.URL;
import java.util.ResourceBundle;

public class CountryTableController implements Initializable {

    @FXML
    private TableView<CountryImportExport> tableCountry;

    @FXML
    private TableColumn<CountryImportExport, Integer> yearColumn;

    @FXML
    private TableColumn<CountryImportExport, Double> importColumn;

    @FXML
    private TableColumn<CountryImportExport, Double> ExportColumn;

    @FXML
    private TableColumn<CountryImportExport, Double> netExportColumn;

    @FXML
    private Label lblSearch;

    @FXML
    private TextField predicateField;

    private final ObservableList<CountryImportExport> dataList = FXCollections.observableArrayList();
    private CountryImportExport model = new CountryImportExport();

    @FXML
    private TextField txtCountry;

    @FXML
    private TextField txtExport;

    @FXML
    private ComboBox<Integer> cmbChooseYear;

    @FXML
    private TextField txtImport;

    @FXML
    private Button btnAddData;

    @FXML
    private Button updateDataButton;

    @FXML
    private Button deleteDataButton;

    @FXML
    private Button clearDataButton;

    @FXML private Label lblInvalidInput;

    CurrentUser user;

    @FXML
    void addData(ActionEvent event) {
        if (txtCountry.getText() != "" && txtImport.getText() != "" && txtExport.getText() != "") {
            CountryImportExport dataAdd = new CountryAdd(txtCountry.getText(), 2021, Double.parseDouble(txtImport.getText()), Double.parseDouble(txtExport.getText()), Double.parseDouble(txtExport.getText()) - Double.parseDouble(txtImport.getText()));
            Connection.connectionManager.sendObject("addCountry", dataAdd);
            lblInvalidInput.setVisible(false);
        }
        else {
            lblInvalidInput.setVisible(true);
        }
    }

    @FXML
    void clearData(ActionEvent event) {
        txtCountry.clear();
        txtImport.clear();
        txtExport.clear();
        cmbChooseYear.setValue(2019);
    }

    @FXML
    void deleteData(ActionEvent event) {
        if (cmbChooseYear.getValue() != 2020 && txtImport.getText() != "" && txtExport.getText() != "" && txtCountry.getText() != "") {
            CountryImportExport dataUpd = new CountryAdd( txtCountry.getText(), cmbChooseYear.getValue(), Double.parseDouble(txtImport.getText()), Double.parseDouble(txtExport.getText()), Double.parseDouble(txtExport.getText()) - Double.parseDouble(txtImport.getText()));
            Connection.connectionManager.sendObject("deleteCountry", dataUpd);
             lblInvalidInput.setVisible(false);
        }
        else {
             lblInvalidInput.setVisible(true);
        }
    }

    @FXML
    void updateData(ActionEvent event) {
        if (txtImport.getText() != "" && txtExport.getText() != "" && txtCountry.getText() != "") {
            CountryImportExport dataUpd = new CountryAdd(txtCountry.getText(), cmbChooseYear.getValue(), Double.parseDouble(txtImport.getText()), Double.parseDouble(txtExport.getText()), Double.parseDouble(txtExport.getText()) - Double.parseDouble(txtImport.getText()));
            Connection.connectionManager.sendObject("editCountry", dataUpd);
            lblInvalidInput.setVisible(false);
        }
        else {
            lblInvalidInput.setVisible(true);
        }
    }

    @FXML
    private void clickItem(MouseEvent event) {
        if (event.getClickCount() == 2) {
            model = tableCountry.getSelectionModel().getSelectedItem();
            txtCountry.setText(CountryConstants.country);
            txtImport.setText(String.valueOf(model.getImportValue()));
            txtExport.setText(String.valueOf(model.getExportValue()));
            cmbChooseYear.setValue(model.getYear());
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
       // setupAccess();
        ObservableList<Integer> years;
        years = FXCollections.observableArrayList(Connection.connectionManager.getYears());
        cmbChooseYear.setItems(years);
        yearColumn.setCellValueFactory(new PropertyValueFactory<>("year"));
        importColumn.setCellValueFactory(new PropertyValueFactory<>("importValue"));
        ExportColumn.setCellValueFactory(new PropertyValueFactory<>("ExportValue"));
        netExportColumn.setCellValueFactory(new PropertyValueFactory<>("netExport"));
//        ObservableList<CountryImportExport> data;
//        data = FXCollections.observableArrayList(Connection.countryManager.getCountryImportExport(CountryConstants.country));
//
//        dataList.addAll(data);

  FilteredList<CountryImportExport> filteredData = new FilteredList<>(dataList, b -> true);
  predicateField.textProperty().addListener((observable, oldValue, newvalue) -> {
      filteredData.setPredicate(caseCase -> {
          if (newvalue == null || newvalue.isEmpty()) {
              return true;
          }

          String lowerCaseFilter = newvalue.toLowerCase();

          if (String.valueOf(caseCase.getYear()).indexOf(lowerCaseFilter) != -1) {
              return true;
          }
          else if (String.valueOf(caseCase.getImportValue()).indexOf(lowerCaseFilter) != -1) {
              return true;
          }
          else if (String.valueOf(caseCase.getExportValue()).indexOf(lowerCaseFilter) != -1) {
              return true;
          }
          else if(String.valueOf(caseCase.getNetExport()).indexOf(lowerCaseFilter) != -1) {
              return true;
          }
          else {
              return false;
          }
      });
  });

        SortedList<CountryImportExport> sortedData = new SortedList<>(filteredData);
        sortedData.comparatorProperty().bind((tableCountry.comparatorProperty()));
        tableCountry.setItems(sortedData);
    }

    private void setupAccess() {
        if (user.getRole() == "Пользователь") {
            btnAddData.setVisible(false);
            updateDataButton.setVisible(false);
            deleteDataButton.setVisible(false);
            clearDataButton.setVisible(false);
            txtCountry.setVisible(false);
            txtImport.setVisible(false);
            txtExport.setVisible(false);
            cmbChooseYear.setVisible(false);
        }
    }
}

