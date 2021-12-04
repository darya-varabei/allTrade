package com.example.alltrade.model.category;

import com.example.alltrade.connector.Connection;
import com.example.alltrade.model.country.CountryConstants;
import com.example.alltrade.model.country.CountryImportExport;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class CategoryValue extends Category{
    protected double value;

    public CategoryValue(Integer countryId, String country, Integer year, double value) {
        super(countryId, year, country);
        this.value = value;
    }

    public double getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public static ObservableList<CategoryValue> setupTableData(String type) {
        ObservableList<CategoryValue> data;
        data = FXCollections.observableArrayList(Connection.categoryManager.getCategoryValueList(CountryConstants.category + " " + type));
        return data;
    }
}
