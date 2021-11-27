package com.example.alltrade.controller;

import animatefx.animation.*;
import com.example.alltrade.FxmlLoader;
import com.example.alltrade.model.user.UserInfo;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.chart.AreaChart;
import javafx.scene.chart.PieChart;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;

import java.net.URL;
import java.util.ResourceBundle;

public class MainScreenController implements Initializable {

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
    private Pane pnCategoryTable;

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
    private Pane pnTablePane;

    @FXML
    private BorderPane mainPane;

    @FXML
    private BorderPane pnCatView;

    @FXML
    private TextField txtLogin = new TextField();

    @FXML
    private TextField txtPassword = new TextField();

    @FXML
    private ComboBox<String> cmbChooseUserCountry = new ComboBox<>();

    @FXML
    private ComboBox<String> cmbChooseRole = new ComboBox<>();

    @FXML
    private Pane pnUsers;

    @FXML
    private BorderPane borderPnUsers;

    @FXML
    private BorderPane pnUserChart;

    @FXML
    private Button btnChartCountry;

    @FXML
    private Button btnImportStructure;

    @FXML
    private Button btnExportStructure;

    @FXML
    private Button btnWorldExport;

    @FXML
    private Button btnExportShare;

    @FXML
    private Button btnImportShare;

    private UserInfo user = new UserInfo(0, "", "", "", "", "");
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        FxmlLoader object = new FxmlLoader();
        Pane view = object.getPane("UserTable.fxml");
        borderPnUsers.setCenter(view);
        FxmlLoader object1 = new FxmlLoader();
        Pane chart = object1.getPane("UserChart.fxml");
        pnUserChart.setCenter(chart);
    }

    @FXML
    void chowCategories() {
        if (pnCategoryView.isVisible() == false) {
            pnCategoryView.setVisible(true);
            new FadeInUp(pnCategoryView).play();
            pnCountryView.setVisible(false);
            pnUsersView.setVisible(false);
            pnMainView.setVisible(false);
            pnSettingsView.setVisible(false);
            btnCategories.setStyle("-fx-background-color: #2F3763; -fx-text-fill: linear-gradient(from 0px 0px to 43px 15px, #50D5A8, #B3DE83)");
            btnCountries.setStyle("-fx-background-color: #3B4576; -fx-text-fill: #fafafa");
            btnMain.setStyle("-fx-background-color: #3B4576; -fx-text-fill: #fafafa");
            btnUsers.setStyle("-fx-background-color: #3B4576; -fx-text-fill: #fafafa");
            btnSettings.setStyle("-fx-background-color: #3B4576; -fx-text-fill: #fafafa");
            pnCategoryView.toFront();
        }
    }

    @FXML
    void exportToPDF() {

    }

    @FXML
    void showCountry() {
        if (pnCountryView.isVisible() == false) {
            pnCountryView.setVisible(true);
            new FadeInUp(pnCountryView).play();
            pnCountryView.toFront();
            pnUsersView.setVisible(false);
            pnCategoryView.setVisible(false);
            pnMainView.setVisible(false);
            pnSettingsView.setVisible(false);
            btnCountries.setStyle("-fx-background-color: #2F3763; -fx-text-fill: linear-gradient(from 0px 0px to 43px 15px, #50D5A8, #B3DE83)");
            btnCategories.setStyle("-fx-background-color: #3B4576; -fx-text-fill: #fafafa");
            btnMain.setStyle("-fx-background-color: #3B4576; -fx-text-fill: #fafafa");
            btnUsers.setStyle("-fx-background-color: #3B4576; -fx-text-fill: #fafafa");
            btnSettings.setStyle("-fx-background-color: #3B4576; -fx-text-fill: #fafafa");
        }
    }



    @FXML
    void showMainPage() {
        if (pnMainView.isVisible() == false) {
            pnMainView.setVisible(true);
            new FadeInUp(pnMainView).play();
            pnMainView.toFront();
            pnCountryView.setVisible(false);
            pnCategoryView.setVisible(false);
            pnUsersView.setVisible(false);
            pnSettingsView.setVisible(false);
            btnMain.setStyle("-fx-background-color: #2F3763; -fx-text-fill: linear-gradient(from 0px 0px to 43px 15px, #50D5A8, #B3DE83)");
            btnCategories.setStyle("-fx-background-color: #3B4576; -fx-text-fill: #fafafa");
            btnCountries.setStyle("-fx-background-color: #3B4576; -fx-text-fill: #fafafa");
            btnUsers.setStyle("-fx-background-color: #3B4576; -fx-text-fill: #fafafa");
            btnSettings.setStyle("-fx-background-color: #3B4576; -fx-text-fill: #fafafa");
        }
    }

    @FXML
    void showPlots() {
        btnTableCat.setStyle("-fx-background-color: #FAFAFA; -fx-background-radius: 5;  -fx-text-fill: #2F3763");
        btnPlotCat.setStyle("-fx-background-color: #2F3763; -fx-background-radius: 5; -fx-text-fill: #fafafa");
        new FadeInUp(pnChoosePlotCat).play();
        pnChoosePlotCat.toFront();
    }

    @FXML
    void showSettings() {
        if (pnSettingsView.isVisible() == false) {
            pnSettingsView.setVisible(true);
            new FadeInDown(pnSettingsView).play();
            pnCountryView.setVisible(false);
            pnCategoryView.setVisible(false);
            pnMainView.setVisible(false);
            pnUsersView.setVisible(false);
            pnSettingsView.toFront();
            btnSettings.setStyle("-fx-background-color: #2F3763; -fx-text-fill: linear-gradient(from 0px 0px to 43px 15px, #50D5A8, #B3DE83)");
            btnCategories.setStyle("-fx-background-color: #3B4576; -fx-text-fill: #fafafa");
            btnMain.setStyle("-fx-background-color: #3B4576; -fx-text-fill: #fafafa");
            btnUsers.setStyle("-fx-background-color: #3B4576; -fx-text-fill: #fafafa");
            btnCountries.setStyle("-fx-background-color: #3B4576; -fx-text-fill: #fafafa");
        }
    }

    @FXML
    void showTablesCountry() {
            btnTablePaneCountry.setStyle("-fx-background-color: #2F3763; -fx-background-radius: 5;  -fx-text-fill: #FAFAFA");
            btnPlotPaneCountry.setStyle("-fx-background-color: #fafafa; -fx-background-radius: 5; -fx-text-fill: #2F3763");
            new FadeInUp(pnChooseTableCountry).play();
            pnChooseTableCountry.toFront();
    }

    @FXML
    void showTablesCat() {
        btnTableCat.setStyle("-fx-background-color: #013243; -fx-background-radius: 5;  -fx-text-fill: #FAFAFA");
        btnPlotCat.setStyle("-fx-background-color: #fafafa; -fx-background-radius: 5; -fx-text-fill: #013243");
        new FadeInUp(pnChooseTableCat).play();
        pnChooseTableCat.toFront();
    }

    @FXML
    void showPlotsCountry() {
        btnPlotPaneCountry.setStyle("-fx-background-color: #2F3763; -fx-background-radius: 5;  -fx-text-fill: #FAFAFA");
        btnTablePaneCountry.setStyle("-fx-background-color: #fafafa; -fx-background-radius: 5; -fx-text-fill: #2F3763");
        new FadeInUp(pnChoosePlotCountry).play();
        pnChoosePlotCountry.toFront();
    }

    @FXML
    void showUsers() {
        if (pnUsersView.isVisible() == false) {
            pnUsersView.setVisible(true);
            new FadeInDown(pnUsersView).play();
            pnUsersView.toFront();
            pnCountryView.setVisible(false);
            pnCategoryView.setVisible(false);
            pnMainView.setVisible(false);
            pnSettingsView.setVisible(false);
            btnUsers.setStyle("-fx-background-color: #2F3763; -fx-text-fill: linear-gradient(from 0px 0px to 43px 15px, #50D5A8, #B3DE83)");
            btnCategories.setStyle("-fx-background-color: #3B4576; -fx-text-fill: #fafafa");
            btnMain.setStyle("-fx-background-color: #3B4576; -fx-text-fill: #fafafa");
            btnSettings.setStyle("-fx-background-color: #3B4576; -fx-text-fill: #fafafa");
            btnCountries.setStyle("-fx-background-color: #3B4576; -fx-text-fill: #fafafa");
        }
    }

    @FXML
    void menuEndHover(MouseEvent event) {
        ((Button)event.getSource()).setUnderline(false);
    }

    @FXML
    void menuOnHover(MouseEvent event) {
        ((Button)event.getSource()).setUnderline(true);
    }

    public void showCountryCommonTable() {
        FxmlLoader object = new FxmlLoader();
        Pane view = object.getPane("CountryTable.fxml");
        mainPane.setCenter(view);
    }

    public void showCountryCatTable() {
        FxmlLoader object = new FxmlLoader();
        Pane view = object.getPane("CountryCatTable.fxml");
        mainPane.setCenter(view);
    }

    public void showCatImportTable() {
        FxmlLoader object = new FxmlLoader();
        Pane view = object.getPane("CategoryImportTable.fxml");
        pnCatView.setCenter(view);
    }

    public void showCatExport() {
        FxmlLoader object = new FxmlLoader();
        Pane view = object.getPane("CategoryExportTable.fxml");
        pnCatView.setCenter(view);
    }

    @FXML
    void showCountryChart() {
        FxmlLoader object = new FxmlLoader();
        Pane view = object.getPane("CountryCommonChart.fxml");
        mainPane.setCenter(view);
    }

    @FXML
    void showExportStructure() {
        FxmlLoader object = new FxmlLoader();
        Pane view = object.getPane("CountryExportPercentChart.fxml");
        mainPane.setCenter(view);
    }

    @FXML
    void showImportStructure() {
        FxmlLoader object = new FxmlLoader();
        Pane view = object.getPane("CountryExportPercentChart.fxml");
        mainPane.setCenter(view);
    }

    @FXML
    void showPlotWorldExport() {
        FxmlLoader object = new FxmlLoader();
        Pane view = object.getPane("CatWorldChart.fxml");
        pnCatView.setCenter(view);
    }

    @FXML
    void showChartCatShare() {
        FxmlLoader object = new FxmlLoader();
        Pane view = object.getPane("CatPercentImportChart.fxml");
        pnCatView.setCenter(view);
    }

    @FXML
    void showChartExportShare() {
        FxmlLoader object = new FxmlLoader();
        Pane view = object.getPane("CatPercentExportChart.fxml");
        pnCatView.setCenter(view);
    }
}
