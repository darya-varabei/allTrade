package com.example.alltrade.model.country;

import com.example.alltrade.connector.Connection;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.io.Serializable;
import java.util.Objects;

public class CountryCategory extends CountryMain implements Serializable {
    private String category;

    public CountryCategory(Integer year, Double importValue, Double exportValue, String category) {

        super(year, importValue, exportValue);
        this.category = category;
    }

    public CountryCategory() {

    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String netExport) {
        this.category = category;
    };

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CountryCategory countryData = (CountryCategory) o;
        return year == super.year &&
                importValue == super.importValue && exportValue == super.exportValue &&
                category == countryData.category;

    }

    @Override
    public int hashCode() {
        return Objects.hash(year, importValue, exportValue, category);
    }

    public static ObservableList<CountryCategory> setupTableData() {
        ObservableList<CountryCategory> data;
        data = FXCollections.observableArrayList(Connection.connectionManager.getCountryCategory(CountryConstants.country));
        return data;
    }
}
