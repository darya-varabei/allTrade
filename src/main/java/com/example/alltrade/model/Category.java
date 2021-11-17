package com.example.alltrade.model;

import java.io.Serializable;
import java.util.Objects;

public class Category implements Serializable {
    protected Integer year;
    protected Double totalImport;
    protected Double totalExport;

    public Category(Integer year, Double totalImport, Double totalExport) {
        this.year = year;
        this.totalImport = totalImport;
        this.totalExport = totalExport;
    }

    public Category() {
    }

    public int getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public double getImportValue() {
        return totalImport;
    }

    public void setImportValue(double totalImport) {
        this.totalImport = totalImport;
    }

    public double getExportValue() {
        return totalExport;
    }

    public void setExportValue(double totalExport) {
        this.totalExport = totalExport;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Category categoryData = (Category) o;
        return year == categoryData.year &&
                totalImport == categoryData.totalImport && totalExport == categoryData.totalExport;
    }

    @Override
    public int hashCode() {
        return Objects.hash(year, totalImport, totalExport);
    }
}
