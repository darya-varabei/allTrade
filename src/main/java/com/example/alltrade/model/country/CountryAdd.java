package com.example.alltrade.model.country;

import java.io.Serializable;

public class CountryAdd extends CountryImportExport  implements Serializable {
    private String country;

    public CountryAdd(String country, Integer year, Double importValue, Double exportValue, Double netExport) {
        super(year, importValue, exportValue, netExport);
        this.country = country;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }
}
