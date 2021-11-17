package com.example.alltrade.model.country;

import java.util.Objects;

public class CountryImportExport extends CountryMain {
//    private Integer countryId;
//    private Integer year;
//    private Double importValue;
//    private Double exportValue;
    private Double netExport;

    public CountryImportExport(Integer countryId, Integer year, Double importValue, Double exportValue, Double netExport) {
//        this.countryId = countryId;
//        this.year = year;
//        this.importValue = importValue;
//        this.exportValue = exportValue;
        super(countryId, year, importValue, exportValue);
        this.netExport = netExport;
    }

    public CountryImportExport() {

    }

    public CountryImportExport(Integer countryId) {
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

    public Double getNetExport() {
        return netExport;
    }

    public void setNetExport(double netExport) {
        this.netExport = netExport;
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
}
