package com.example.alltrade.model.country;

import javafx.scene.image.Image;

import java.io.Serializable;
import java.util.Objects;

public class Country implements Serializable {
    private Integer countryId;
    private String name;
    private Double population;
    private Double area;
    private Image flag;
    private Double jdp;

    public Country(Integer countryId, String name, Double population, Double area, Image flag, Double jdp) {
        this.countryId = countryId;
        this.name = name;
        this.population = population;
        this.area = area;
        this.flag = flag;
        this.jdp = jdp;
    }

    public Country() {

    }

    public Country(Integer countryId) {
        this.countryId = countryId;

    }

    public int getCountryId() {
        return countryId;
    }

    public void setCountryId(int authorBook) {
        this.countryId = countryId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPopulation() {
        return population;
    }

    public void setPopulation(double population) {
        this.population = population;
    }

    public double getArea() {
        return area;
    }

    public void setArea(double area) {
        this.area = area;
    }

    public Image getFlag() {
        return flag;
    }

    public void setFlag(Image flag) {
        this.flag = flag;
    }

    public Double getJdp() {
        return jdp;
    }

    public void setJdp(double jdp) {
        this.jdp = jdp;
    };

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Country country = (Country) o;
        return countryId == country.countryId && population == country.population && area == country.area &&
                Objects.equals(countryId, country.countryId) &&
                Objects.equals(name, country.name) &&
                Objects.equals(flag, country.flag);
    }

    @Override
    public int hashCode() {
        return Objects.hash(countryId, name, population, area, flag, jdp);
    }
}
