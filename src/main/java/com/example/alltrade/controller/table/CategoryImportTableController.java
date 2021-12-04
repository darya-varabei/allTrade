package com.example.alltrade.controller.table;

import com.example.alltrade.model.category.CategoryValue;
import com.example.alltrade.model.country.CountryConstants;
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

public class CategoryImportTableController implements Initializable {
    @FXML
    private TableView<CategoryValue> tableCatImport;

    @FXML
    private TableColumn<CategoryValue, Integer> yearColumn;

    @FXML
    private TableColumn<CategoryValue, String> countryColumn;

    @FXML
    private TableColumn<CategoryValue, Double> importColumn;

    @FXML
    private Label lblSearch;

    @FXML
    private TextField predicateField;

    private final ObservableList<CategoryValue> dataList = FXCollections.observableArrayList();

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        yearColumn.setCellValueFactory(new PropertyValueFactory<>("year"));
        countryColumn.setCellValueFactory(new PropertyValueFactory<>("country"));
        importColumn.setCellValueFactory(new PropertyValueFactory<>("value"));

//        CategoryValue case1 = new CategoryValue(1, "Germany", 2009, 12456.9);
//        CategoryValue case2 = new CategoryValue(1, "UK", 2009, 12456.9);
//        CategoryValue case3 = new CategoryValue(1, "Netherlands", 2009, 12456.9);
//        CategoryValue case4 = new CategoryValue(1, "China", 2009, 12456.9);
//        CategoryValue case5 = new CategoryValue(1, "Poland", 2009, 12456.9);
        dataList.addAll(CategoryValue.setupTableData("import"));

        FilteredList<CategoryValue> filteredData = new FilteredList<>(dataList, b -> true);
        predicateField.textProperty().addListener((observable, oldValue, newvalue) -> {
            filteredData.setPredicate(caseCase -> {
                if (newvalue == null || newvalue.isEmpty()) {
                    return true;
                }

                String lowerCaseFilter = newvalue.toLowerCase();

                if (String.valueOf(caseCase.getYear()).indexOf(lowerCaseFilter) != -1) {
                    return true;
                }
                else if (String.valueOf(caseCase.getValue()).indexOf(lowerCaseFilter) != -1) {
                    return true;
                }
                else if (String.valueOf(caseCase.getCountry()).indexOf(lowerCaseFilter) != -1) {
                    return true;
                }
                else {
                    return false;
                }
            });
        });

        SortedList<CategoryValue> sortedData = new SortedList<>(filteredData);
        sortedData.comparatorProperty().bind((tableCatImport.comparatorProperty()));
        tableCatImport.setItems(sortedData);
    }
}
