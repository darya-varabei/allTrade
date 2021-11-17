package com.example.alltrade.model.category;

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
}
