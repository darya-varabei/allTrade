package com.example.alltrade.countryInfo;

import java.io.Serializable;
import java.util.Objects;

public class CountryMain implements Serializable {
    protected Integer countryId;
    protected Integer year;
    protected Double importValue;
    protected Double exportValue;

    public CountryMain(Integer countryId, Integer year, Double importValue, Double exportValue) {
        this.countryId = countryId;
        this.year = year;
        this.importValue = importValue;
        this.exportValue = exportValue;
    }

    public CountryMain() {
    }

    public CountryMain(Integer countryId) {
        this.countryId = countryId;
    }

    public int getCountryId() {
        return countryId;
    }

    public void setCountryId(int authorBook) {
        this.countryId = countryId;
    }

    public int getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public double getImportValue() {
        return importValue;
    }

    public void setImportValue(double importValue) {
        this.importValue = importValue;
    }

    public double getExportValue() {
        return exportValue;
    }

    public void setExportValue(double exportValue) {
        this.exportValue = exportValue;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CountryMain countryData = (CountryMain) o;
        return countryId == countryData.countryId && year == countryData.year &&
                importValue == countryData.importValue && exportValue == countryData.exportValue;
    }

    @Override
    public int hashCode() {
        return Objects.hash(countryId, year, importValue, exportValue);
    }
}
