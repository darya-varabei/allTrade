package com.example.alltrade;

import animatefx.animation.*;
import javafx.fxml.FXML;
import javafx.scene.chart.AreaChart;
import javafx.scene.chart.PieChart;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.event.ActionEvent;

public class MainScreenController {

    @FXML
    private Pane pnUsersView;

    @FXML
    private Pane pnSettingsView;

    @FXML
    private Pane pnMainView;

    @FXML
    private Pane pnMain;

    @FXML
    private ImageView imgLogo;

    @FXML
    private VBox vbButtons;

    @FXML
    private Button btnMain;

    @FXML
    private Button btnCountries;

    @FXML
    private Button btnCategories;

    @FXML
    private Button btnSettings;

    @FXML
    private Button btnUsers;

    @FXML
    private Pane pnCountryView;

    @FXML
    private Label lblTitle;

    @FXML
    private Pane pnCountryInfo;

    @FXML
    private Label lblGDP;

    @FXML
    private ImageView imgFlag;

    @FXML
    private Label lblCountry;

    @FXML
    private Label lblArea;

    @FXML
    private Label lblPopulation;

    @FXML
    private Label lblAreaValue;

    @FXML
    private Label lblPopValue;

    @FXML
    private Label lblGDPValue;

    @FXML
    private ComboBox<?> cmbChooseCountry;

    @FXML
    private Pane pnDataView;

    @FXML
    private Pane pnChooseData;

    @FXML
    private HBox hbTableGraph;

    @FXML
    private Button btnTablePaneCountry;

    @FXML
    private Button btnPlotPaneCountry;

    @FXML
    private Pane pnChooseTableCountry;

    @FXML
    private VBox vbTables1;

    @FXML
    private Button btnImageTable1;

    @FXML
    private Button btnImageTable2;

    @FXML
    private Pane pnChoosePlotCountry;

    @FXML
    private VBox vbPlots;

    @FXML
    private Button btnImagePlot1;

    @FXML
    private Button btnImagePlot2;

    @FXML
    private Button btnCountryPlot3;

    @FXML
    private Pane pnExpImpPlot;

    @FXML
    private Label lblCommonExpImpPlot;

    @FXML
    private AreaChart<?, ?> pltCommonExpImpPlot;

    @FXML
    private Button btnExportPDF;

    @FXML
    private Pane pnCategoryView;

    @FXML
    private Pane pnDataViewCat;

    @FXML
    private Pane pnChooseDataCat;

    @FXML
    private HBox hbTableGraph1;

    @FXML
    private Button btnTableCat;

    @FXML
    private Button btnPlotCat;

    @FXML
    private Pane pnChoosePlotCat;

    @FXML
    private VBox vbPlots1;

    @FXML
    private Button btnImagePlot4;

    @FXML
    private Button btnImagePlot5;

    @FXML
    private Button btnCountryPlot6;

    @FXML
    private Pane pnChooseTableCat;

    @FXML
    private VBox vbPlots11;

    @FXML
    private Button btnImageTable4;

    @FXML
    private Pane pnExpImpPlot1;

    @FXML
    private Label lblCommonExpImpPlot1;

    @FXML
    private AreaChart<?, ?> categoryAreaChart;

    @FXML
    private PieChart categoryPieChart;

    @FXML
    private Button btnExportPDF1;

    @FXML
    private Label lblTitle1;

    @FXML
    private Label lblArea1;

    @FXML
    private Label lblPopulation1;

    @FXML
    private Label lblAreaValue1;

    @FXML
    private Label lblPopValue1;

    @FXML
    private ComboBox<?> cmbChooseCountry1;

    @FXML
    void chowCategories(ActionEvent event) {
        pnCategoryView.setVisible(true);
        new FadeInUp(pnCategoryView).play();
        pnCountryView.setVisible(false);
        pnUsersView.setVisible(false);
        pnMainView.setVisible(false);
        pnSettingsView.setVisible(false);
        btnCategories.setStyle("-fx-text-fill: linear-gradient(from 0px 0px to 43px 15px, #50D5A8, #B3DE83)");
        btnCountries.setStyle("-fx-text-fill: #fafafa");
        btnMain.setStyle("-fx-text-fill: #fafafa");
        btnUsers.setStyle("-fx-text-fill: #fafafa");
        btnSettings.setStyle("-fx-text-fill: #fafafa");
        pnCategoryView.toFront();
    }

    @FXML
    void exportToPDF(ActionEvent event) {

    }

    @FXML
    void showCountry(ActionEvent event) {
        pnCountryView.setVisible(true);
        new FadeInUp(pnCountryView).play();
        pnCountryView.toFront();
        pnUsersView.setVisible(false);
        pnCategoryView.setVisible(false);
        pnMainView.setVisible(false);
        pnSettingsView.setVisible(false);
        btnCountries.setStyle("-fx-text-fill: linear-gradient(from 0px 0px to 43px 15px, #50D5A8, #B3DE83)");
        btnCategories.setStyle("-fx-text-fill: #fafafa");
        btnMain.setStyle("-fx-text-fill: #fafafa");
        btnUsers.setStyle("-fx-text-fill: #fafafa");
        btnSettings.setStyle("-fx-text-fill: #fafafa");
    }

    @FXML
    void showCountryPlot1(ActionEvent event) {

    }

    @FXML
    void showCountryPlot2(ActionEvent event) {

    }

    @FXML
    void showCountryPlot3(ActionEvent event) {

    }

    @FXML
    void showCountryPlot4(ActionEvent event) {

    }

    @FXML
    void showCountryPlot5(ActionEvent event) {

    }

    @FXML
    void showCountryPlot6(ActionEvent event) {

    }

    @FXML
    void showMainPage(ActionEvent event) {
        pnMainView.setVisible(true);
        new FadeInUp(pnMainView).play();
        pnMainView.toFront();
        pnCountryView.setVisible(false);
        pnCategoryView.setVisible(false);
        pnUsersView.setVisible(false);
        pnSettingsView.setVisible(false);
        btnMain.setStyle("-fx-text-fill: linear-gradient(from 0px 0px to 43px 15px, #50D5A8, #B3DE83)");
        btnCategories.setStyle("-fx-text-fill: #fafafa");
        btnCountries.setStyle("-fx-text-fill: #fafafa");
        btnUsers.setStyle("-fx-text-fill: #fafafa");
        btnSettings.setStyle("-fx-text-fill: #fafafa");
    }

    @FXML
    void showPlots(ActionEvent event) {
        btnTableCat.setStyle("-fx-background-color: #FAFAFA; -fx-background-radius: 5;  -fx-text-fill: #2F3763");
        btnPlotCat.setStyle("-fx-background-color: #2F3763; -fx-background-radius: 5; -fx-text-fill: #fafafa");
        new FadeInUp(pnChoosePlotCat).play();
        pnChoosePlotCat.toFront();
    }

    @FXML
    void showSettings(ActionEvent event) {
        pnSettingsView.setVisible(true);
        new FadeInDown(pnSettingsView).play();
        pnCountryView.setVisible(false);
        pnCategoryView.setVisible(false);
        pnMainView.setVisible(false);
        pnUsersView.setVisible(false);
        pnSettingsView.toFront();
        btnSettings.setStyle("-fx-text-fill: linear-gradient(from 0px 0px to 43px 15px, #50D5A8, #B3DE83)");
        btnCategories.setStyle("-fx-text-fill: #fafafa");
        btnMain.setStyle("-fx-text-fill: #fafafa");
        btnUsers.setStyle("-fx-text-fill: #fafafa");
        btnCountries.setStyle("-fx-text-fill: #fafafa");
    }

    @FXML
    void showTablesCountry(ActionEvent event) {

        btnTablePaneCountry.setStyle("-fx-background-color: #2F3763; -fx-background-radius: 5;  -fx-text-fill: #FAFAFA");
        btnPlotPaneCountry.setStyle("-fx-background-color: #fafafa; -fx-background-radius: 5; -fx-text-fill: #2F3763");
        new FadeInUp(pnChooseTableCountry).play();
        pnChooseTableCountry.toFront();
    }

    @FXML
    void showTablesCat(ActionEvent event) {

        btnTableCat.setStyle("-fx-background-color: #013243; -fx-background-radius: 5;  -fx-text-fill: #FAFAFA");
        btnPlotCat.setStyle("-fx-background-color: #fafafa; -fx-background-radius: 5; -fx-text-fill: #013243");
        new FadeInUp(pnChooseTableCat).play();
        pnChooseTableCat.toFront();
    }

    @FXML
    void showPlotsCountry(ActionEvent event) {
        btnPlotPaneCountry.setStyle("-fx-background-color: #2F3763; -fx-background-radius: 5;  -fx-text-fill: #FAFAFA");
        btnTablePaneCountry.setStyle("-fx-background-color: #fafafa; -fx-background-radius: 5; -fx-text-fill: #2F3763");
        new FadeInUp(pnChoosePlotCountry).play();
        pnChoosePlotCountry.toFront();
    }

    @FXML
    void showUsers(ActionEvent event) {
        pnUsersView.setVisible(true);
        new FadeInDown(pnUsersView).play();
        pnUsersView.toFront();
        pnCountryView.setVisible(false);
        pnCategoryView.setVisible(false);
        pnMainView.setVisible(false);
        pnSettingsView.setVisible(false);
        btnUsers.setStyle("-fx-text-fill: linear-gradient(from 0px 0px to 43px 15px, #50D5A8, #B3DE83)");
        btnCategories.setStyle("-fx-text-fill: 0");
        btnMain.setStyle("-fx-text-fill: 0");
        btnSettings.setStyle("-fx-text-fill: 0");
        btnCountries.setStyle("-fx-text-fill: 0");
    }

    @FXML
    void menuEndHover(MouseEvent event) {
            ((Button) event.getSource()).setStyle("-fx-background-color: 0;");
    }

    @FXML
    void menuOnHover(MouseEvent event) {
            ((Button) event.getSource()).setStyle("-fx-background-color: #C1CED6;");
    }
}
