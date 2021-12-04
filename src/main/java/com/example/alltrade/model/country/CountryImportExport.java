package com.example.alltrade.model.country;

import com.example.alltrade.connector.Connection;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.io.Serializable;
import java.util.Objects;

public class CountryImportExport extends CountryMain implements Serializable {

    private String country;
    private Double netExport;

    public CountryImportExport(Integer countryId, String country, Integer year, Double importValue, Double exportValue, Double netExport) {
        super(countryId, year, importValue, exportValue);
        this.country = country;
        this.netExport = netExport;
    }

    public CountryImportExport() { }

    public CountryImportExport(Integer countryId) { super(countryId); }

    public Double getNetExport() {
        return netExport;
    }

    public void setNetExport(double netExport) {
        this.netExport = netExport;
    };

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    };

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CountryImportExport countryData = (CountryImportExport) o;
        return countryId == super.countryId && year == super.year &&
                importValue == super.importValue && exportValue == super.exportValue &&
                netExport == countryData.netExport;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.countryId, super.year, super.importValue, super.exportValue, netExport);
    }

    public static ObservableList<CountryImportExport> setupTableData() {
        ObservableList<CountryImportExport> data;
        data = FXCollections.observableArrayList(Connection.countryManager.getCountryImportExport(CountryConstants.country));
        return data;
    }
}
