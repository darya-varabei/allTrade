package com.example.alltrade.controller.chart;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.chart.PieChart;

import java.net.URL;
import java.util.ResourceBundle;

public class UserChartController   implements Initializable {
    @FXML
    private PieChart chartUsers;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        ObservableList<PieChart.Data> pieChartData = FXCollections.observableArrayList(
                new PieChart.Data("Admin", 5),
                new PieChart.Data("User", 48)
        );
        chartUsers.setData(pieChartData);
    }
}