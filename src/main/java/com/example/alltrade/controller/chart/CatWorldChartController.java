package com.example.alltrade.controller.chart;

import com.example.alltrade.connector.Connection;
import com.example.alltrade.model.category.CategoryValue;
import com.example.alltrade.model.country.CountryConstants;
import com.example.alltrade.model.country.CountryImportExport;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.chart.AreaChart;
import javafx.scene.chart.XYChart;

import java.net.URL;
import java.util.ResourceBundle;

public class CatWorldChartController implements Initializable {
    @FXML
    private AreaChart<?, ?> CountryChart;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        CountryChart.getData().removeAll(CountryChart.getData());

        ObservableList<CategoryValue> data;
        data = FXCollections.observableArrayList(Connection.categoryManager.getCategoryValueList(CountryConstants.category));
        XYChart.Series seriesImport = new XYChart.Series();

        seriesImport.setName("Import");

        data.forEach((year) -> {
            seriesImport.getData().add(new XYChart.Data(String.valueOf(year.getYear()), year.getImportValue()));
        });

        CountryChart.getData().addAll(seriesImport);
    }
}
