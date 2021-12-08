package com.example.alltrade.model.country;

import java.io.Serializable;

public class CountryShare  implements Serializable {
    private String category;
    private Double value;

    public CountryShare(String category, Double value) {
        this.category = category;
        this.value = value;
    }

    public String getCategory() {
        return category;
    }

    public void setCCategory(String category) {
        this.category = category;
    }

    public double getValue() {
        return value;
    }

    public void setValue(Double value) {
        this.value = value;
    }

}
