package com.example.alltrade.model.country;

import java.util.Objects;

public class CountryCategory extends CountryMain {
//    private Integer countryId;
//    private Integer year;
    private String category;
//    private Double importValue;
//    private Double exportValue;

    public CountryCategory(Integer countryId, Integer year, Double importValue, Double exportValue, String category) {
//        this.countryId = countryId;
//        this.year = year;
//        this.importValue = importValue;
//        this.exportValue = exportValue;
        super(countryId, year, importValue, exportValue);
        this.category = category;
    }

    public CountryCategory() {

    }

    public CountryCategory(Integer countryId) {
        super(countryId);

    }

//    public int getCountryId() {
//        return countryId;
//    }
//
//    public void setCountryId(int authorBook) {
//        this.countryId = countryId;
//    }
//
//    public int getYear() {
//        return year;
//    }
//
//    public void setYear(Integer year) {
//        this.year = year;
//    }
//
//    public double getImportValue() {
//        return importValue;
//    }
//
//    public void setImportValue(double importValue) {
//        this.importValue = importValue;
//    }
//
//    public double getExportValue() {
//        return exportValue;
//    }
//
//    public void setExportValue(double exportValue) {
//        this.exportValue = exportValue;
//    }

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
        return countryId == super.countryId && year == super.year &&
                importValue == super.importValue && exportValue == super.exportValue &&
                category == countryData.category;

    }

    @Override
    public int hashCode() {
        return Objects.hash(countryId, year, importValue, exportValue, category);
    }
}
