package com.example.alltrade.controller.chart;

import com.example.alltrade.connector.Connection;
import com.example.alltrade.model.country.CountryConstants;
import com.example.alltrade.model.country.CountryShare;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.chart.PieChart;

import java.net.URL;
import java.util.LinkedList;
import java.util.ResourceBundle;

public class CatPercentExportChartController  implements Initializable {
    @FXML
    private PieChart chartExportShare;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
//        ObservableList<PieChart.Data> pieChartData = FXCollections.observableArrayList(
//                new PieChart.Data("Italy", 123),
//                new PieChart.Data("Spain", 123),
//                new PieChart.Data("France", 123),
//                new PieChart.Data("Belgium", 123),
//                new PieChart.Data("Sweden", 123)
//        );
//        chartExportShare.setData(pieChartData);

        ObservableList<CountryShare> data;
        data = FXCollections.observableArrayList(Connection.categoryManager.getCountryShare(CountryConstants.country, CountryConstants.year));
        var pieChartData = new LinkedList<PieChart.Data>();

        data.forEach((category) -> {
                    pieChartData.add(new PieChart.Data(category.getCategory(), category.getValue()));
                }
        );
        chartExportShare.setData(FXCollections.observableArrayList(pieChartData));
    }
}
