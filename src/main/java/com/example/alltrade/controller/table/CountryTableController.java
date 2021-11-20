package com.example.alltrade.controller.table;

import com.example.alltrade.model.country.CountryImportExport;
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

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        yearColumn.setCellValueFactory(new PropertyValueFactory<>("year"));
        importColumn.setCellValueFactory(new PropertyValueFactory<>("importValue"));
        ExportColumn.setCellValueFactory(new PropertyValueFactory<>("ExportValue"));
        netExportColumn.setCellValueFactory(new PropertyValueFactory<>("netExport"));

        CountryImportExport case1 = new CountryImportExport(1, 2009, 2345.89, 12456.9,3256.0);
        CountryImportExport case2 = new CountryImportExport(1, 2009, 2345.89, 12456.9,3256.0);
        CountryImportExport case3 = new CountryImportExport(1, 2009, 2345.89, 12456.9,3256.0);
        CountryImportExport case4 = new CountryImportExport(1, 2009, 2345.89, 12456.9,3256.0);
        CountryImportExport case5 = new CountryImportExport(1, 2009, 2345.89, 12456.9,3256.0);
  dataList.addAll(case1, case2, case3, case4, case5);

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
}

