package com.example.alltrade.model.category;

import java.io.Serializable;
import java.util.Objects;

public class Category implements Serializable {
    protected Integer countryId;
    protected String country;
    protected Integer year;

    public Category(Integer year, Integer countryId, String country) {
        this.year = year;
        this.countryId = countryId;
        this.country = country;
    }

    public Category() {
    }

    public int getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public int getCountryId() {
        return countryId;
    }

    public void setCountryId(int countryId) {
        this.countryId = countryId;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Category categoryData = (Category) o;
        return year == categoryData.year &&
                countryId == categoryData.countryId && country == categoryData.country;
    }

    @Override
    public int hashCode() {
        return Objects.hash(year, countryId, country);
    }
}
