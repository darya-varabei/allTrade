package com.example.alltrade.model.country;

import java.io.Serializable;
import java.util.Objects;

public class CountryMain implements Serializable {
    protected Integer year;
    protected Double importValue;
    protected Double exportValue;

    public CountryMain(Integer year, Double importValue, Double exportValue) {
        this.year = year;
        this.importValue = importValue;
        this.exportValue = exportValue;
    }

    public CountryMain() {
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
        return year == countryData.year &&
                importValue == countryData.importValue && exportValue == countryData.exportValue;
    }

    @Override
    public int hashCode() {
        return Objects.hash(year, importValue, exportValue);
    }
}
