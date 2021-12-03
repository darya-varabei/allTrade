package com.example.alltrade.controller.table;

import com.example.alltrade.model.country.CountryCategory;
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

public class CountryCatTableController implements Initializable {
    @FXML
    private TableView<CountryCategory> tableCatCountry;

    @FXML
    private TableColumn<CountryCategory, Integer> yearColumn;

    @FXML
    private TableColumn<CountryCategory, String> categoryColumn;

    @FXML
    private TableColumn<CountryCategory, Double> exportColumn;

    @FXML
    private TableColumn<CountryCategory, Double> importColumn;

    @FXML
    private Label lblSearch;

    @FXML
    private TextField predicateField;

    private final ObservableList<CountryCategory> dataList = FXCollections.observableArrayList();

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        yearColumn.setCellValueFactory(new PropertyValueFactory<>("year"));
        categoryColumn.setCellValueFactory(new PropertyValueFactory<>("category"));
        exportColumn.setCellValueFactory(new PropertyValueFactory<>("exportValue"));
        importColumn.setCellValueFactory(new PropertyValueFactory<>("importValue"));

        CountryCategory case1 = new CountryCategory(1, 2009, 2345.89, 12456.9,"Food");
        CountryCategory case2 = new CountryCategory(1, 2009, 2345.89, 12456.9,"Food");
        CountryCategory case3 = new CountryCategory(1, 2009, 2345.89, 12456.9,"Food");
        CountryCategory case4 = new CountryCategory(1, 2009, 2345.89, 12456.9,"Food");
        CountryCategory case5 = new CountryCategory(1, 2009, 2345.89, 12456.9,"Food");
        dataList.addAll(case1, case2, case3, case4, case5);

        FilteredList<CountryCategory> filteredData = new FilteredList<>(dataList, b -> true);
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
                else if(String.valueOf(caseCase.getCategory()).indexOf(lowerCaseFilter) != -1) {
                    return true;
                }
                else {
                    return false;
                }
            });
        });

        SortedList<CountryCategory> sortedData = new SortedList<>(filteredData);
        sortedData.comparatorProperty().bind((tableCatCountry.comparatorProperty()));
        tableCatCountry.setItems(sortedData);
    }

    @FXML private void saveData() {

    }
}
