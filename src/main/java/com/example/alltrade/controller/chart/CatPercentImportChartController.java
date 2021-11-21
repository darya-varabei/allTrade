package com.example.alltrade.controller.chart;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.chart.PieChart;

import java.net.URL;
import java.util.ResourceBundle;

public class CatPercentImportChartController  implements Initializable {
    @FXML
    private PieChart chartImportShare;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        ObservableList<PieChart.Data> pieChartData = FXCollections.observableArrayList(
                new PieChart.Data("Italy", 123),
                new PieChart.Data("Spain", 123),
                new PieChart.Data("France", 123),
                new PieChart.Data("Belgium", 123),
                new PieChart.Data("Sweden", 123)
        );
        chartImportShare.setData(pieChartData);
    }
}