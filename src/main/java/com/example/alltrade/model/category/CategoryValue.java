package com.example.alltrade.model.category;

import com.example.alltrade.connector.Connection;
import com.example.alltrade.model.country.CountryConstants;
import com.example.alltrade.model.country.CountryImportExport;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class CategoryValue extends Category{
    private int year;
    private String constituent;
    private double exportValue;
    private double importValue;

    public CategoryValue(){}

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public double getExportValue() {
        return exportValue;
    }

    public void setExportValue(double exportValue) {
        this.exportValue = exportValue;
    }

    public double getImportValue() {
        return importValue;
    }

    public void setImportValue(double importValue) {
        this.importValue = importValue;
    }

    public String getConstituent() {
        return constituent;
    }

    public void setRole(String netExportValue) {
        this.constituent = constituent;
    }


    public static ObservableList<CategoryValue> setupTableData(String type) {
        ObservableList<CategoryValue> data;
        data = FXCollections.observableArrayList(Connection.categoryManager.getCategoryValueList(CountryConstants.category + " " + type));
        return data;
    }
}
