package com.example.alltrade.model.category;

import java.io.Serializable;

public class WorldYearValue implements Serializable {
    private int year;
    private double value;

    public WorldYearValue() {
    }

    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }
}
