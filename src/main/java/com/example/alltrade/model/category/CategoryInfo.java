package com.example.alltrade.model.category;

public class CategoryInfo {
    private Double totalExport;
    private Integer numOfExporters;

    public CategoryInfo(Double totalExport, Integer numOfExporters) {
        this.totalExport = totalExport;
        this.numOfExporters = numOfExporters;
    }

    public int getNumOfExporters() {
        return numOfExporters;
    }

    public void setNumOfExporters(Integer numOfExporters) {
        this.numOfExporters = numOfExporters;
    }

    public double getTotalExport() {
        return totalExport;
    }

    public void setTotalExport(double totalExport) {
        this.totalExport = totalExport;
    }
}
