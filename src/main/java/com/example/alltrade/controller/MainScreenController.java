package com.example.alltrade.controller;

import animatefx.animation.*;
import com.example.alltrade.FxmlLoader;
import com.example.alltrade.connector.Connection;
import com.example.alltrade.model.category.CategoryInfo;
import com.example.alltrade.model.country.Country;
import com.example.alltrade.model.country.CountryConstants;
import com.example.alltrade.model.country.CountryImportExport;
import com.example.alltrade.model.user.CurrentUser;
import com.example.alltrade.model.user.UserInfo;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.chart.AreaChart;
import javafx.scene.chart.PieChart;
import javafx.scene.control.*;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.*;
import javafx.stage.Stage;

import java.io.IOException;
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
    private Pane systemButtonsPane;

    @FXML private Button btnHide;
    @FXML private Button btnClose;

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
    private ComboBox<String> cmbChooseCountry;

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
    private Label lblCatTables;

    @FXML
    private AreaChart<?, ?> categoryAreaChart;

    @FXML
    private PieChart categoryPieChart;

    @FXML
    private Button btnExportPDF1;

    @FXML
    private Button btnCatExportTable;

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
    private Label lblAllExport;

    @FXML
    private Label lblNumOfCountries;

    @FXML
    private ComboBox<String> cmbChooseCategory;

    @FXML
    private ComboBox<Integer> cmbChooseYear;

    @FXML
    private ComboBox<Integer> cmbChooseCategoryYear;

    @FXML
    private Pane pnTablePane;

    @FXML
    private BorderPane mainPane;

    @FXML
    private BorderPane pnCatView;

    @FXML
    private BorderPane bPaneUsersApproval;

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

    @FXML
    private Button btnSendMessages;

    @FXML
    private TextArea txtMessage;

    private Connection connection;

    @FXML private Button btnCatTableExport;

    @FXML private Button btnCatTableImport;

    @FXML
    private Label lblUserName;
    @FXML
    private Label lblRole;
    @FXML
    private Label lblLastAccess;
    @FXML
    private ListView listMessages;
    private Boolean dataFlag = false;

    private UserInfo user = new UserInfo(0, "", "", "", "", "");

    @FXML private void setupData() {
        if (dataFlag == false) {
            fillUpComboBox();
            setupAccess();
            dataFlag = true;
        }
    }

    private void getCategoryData() {
        Connection.connectionManager.sendString("categoryData");

    }

    @FXML private void fillUpComboBox() {
        ObservableList<String> data;
        ObservableList<Integer> years;
        ObservableList<String> categories;
        data = FXCollections.observableArrayList(Connection.connectionManager.getStrings("countries"));
        years = FXCollections.observableArrayList(Connection.connectionManager.getYears());
        categories = FXCollections.observableArrayList(Connection.connectionManager.getStrings("categories"));
        cmbChooseCountry.setItems(data);
        cmbChooseCategory.setItems(categories);
        cmbChooseYear.setItems(years);
        cmbChooseCategoryYear.setItems(years);
        cmbChooseCategoryYear.setOnAction(e -> enableYearCategory());
        cmbChooseCategory.setOnAction(e -> enableCategory());
        cmbChooseCountry.setOnAction(e -> enableCountry());
        cmbChooseYear.setOnAction(e -> enableCountryAndYears());
    }

    private void enableYearCategory() {
        CountryConstants.categoryYear = cmbChooseCategoryYear.getValue();
        if (cmbChooseCategory.getValue() != "Выберите категорию") {
            btnExportShare.setDisable(false);
            btnImportShare.setDisable(false);
        }
    }

    private void enableCategory() {
        CountryConstants.category = cmbChooseCategory.getValue();
        CategoryInfo categoryInfo;
        btnWorldExport.setDisable(false);
        btnCatTableExport.setDisable(false);
        btnCatTableImport.setDisable(false);
        if (cmbChooseCategoryYear.getValue() != 0) {
            Connection.connectionManager.sendString(CountryConstants.category + " " + cmbChooseCategoryYear.getValue() + " " + "info");
            categoryInfo = (CategoryInfo)Connection.connectionManager.readObject();
            lblAllExport.setText(categoryInfo.getTotalExport() + " $млн");
            lblNumOfCountries.setText(categoryInfo.getNumOfExporters() + " стран");
            btnExportShare.setDisable(false);
            btnImportShare.setDisable(false);
        }
    }

    private void enableCountry() {
        showCountryInfo();
        CountryConstants.country = cmbChooseCountry.getValue();
        btnImageTable1.setDisable(false);
        btnImageTable2.setDisable(false);
        btnChartCountry.setDisable(false);
        if (cmbChooseYear.getValue() != 0) {
            btnImportStructure.setDisable(false);
            btnExportStructure.setDisable(false);
        }
    }

    @FXML private void showCountryInfo() {
        Connection.connectionManager.sendString(cmbChooseCountry.getValue());
        Country country = new Country();
        country = (Country)Connection.connectionManager.readObject();
        imgFlag.setImage(country.getFlag());
        lblCountry.setText(country.getName());
        lblAreaValue.setText(String.valueOf(country.getArea()));
        lblPopValue.setText(country.getPopulation() + "млн чел");
        lblGDPValue.setText(country.getJdp() + "$");
    }

    private void enableCountryAndYears() {
        if (cmbChooseCountry.getValue() != "Выберите страну") {
            btnImportStructure.setDisable(false);
            btnExportStructure.setDisable(false);
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
//        FxmlLoader object = new FxmlLoader();
//        Pane view = object.getPane("UserTable.fxml");
//        borderPnUsers.setCenter(view);
//        FxmlLoader object1 = new FxmlLoader();
//        Pane chart = object1.getPane("UserChart.fxml");
//        pnUserChart.setCenter(chart);
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
            systemButtonsPane.toFront();
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
            systemButtonsPane.toFront();
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
            systemButtonsPane.toFront();
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
            getAllMessages();
            lblUserName.setText(CurrentUser.getUser().getLogin());
            lblRole.setText(CurrentUser.getUser().getRole());

            cmbChooseUserCountry.setValue(CurrentUser.getUser().getCountry());
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
            systemButtonsPane.toFront();
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
            FxmlLoader object = new FxmlLoader();
            Pane view = object.getPane("UserTable.fxml");
            borderPnUsers.setCenter(view);
            showUsersToApprove();
            FxmlLoader object1 = new FxmlLoader();
            Pane chart = object1.getPane("UserChart.fxml");
            pnUserChart.setCenter(chart);
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
            systemButtonsPane.toFront();
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
        CountryConstants.country = cmbChooseCountry.getValue();
        lblCommonExpImpPlot.setText("Общая таблица импорта и экспорта");
        mainPane.setCenter(view);
    }

    public void showCountryCatTable() {
        FxmlLoader object = new FxmlLoader();
        Pane view = object.getPane("CountryCatTable.fxml");
        lblCommonExpImpPlot.setText("Таблица импорта и экспорта по категориям");
        mainPane.setCenter(view);
    }

    public void showCatImportTable() {
        FxmlLoader object = new FxmlLoader();
        Pane view = object.getPane("CategoryImportTable.fxml");
        lblCatTables.setText("Таблица импорта по категориям");
        pnCatView.setCenter(view);
    }

    public void showCatExport() {
        FxmlLoader object = new FxmlLoader();
        Pane view = object.getPane("CategoryExportTable.fxml");
        lblCatTables.setText("Таблица экспорта по категориям");
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

    public void showUsersToApprove() {
        FxmlLoader object = new FxmlLoader();
        Pane view = object.getPane("UserApproveRoleTable.fxml");
        bPaneUsersApproval.setCenter(view);
    }

    @FXML
    private void exitAccount() {
        CurrentUser.nullInstance();
    }

    @FXML
    private void sendMessage() {
        if (txtMessage.getText() != "") {
            listMessages.getItems().add(txtMessage.getText());
            listMessages.refresh();
            Connection.connectionManager.sendObject("error", txtMessage.getText());
        }
    }

    @FXML
    private void getAllMessages() {
        ObservableList<String> messages;
        messages = FXCollections.observableArrayList(Connection.messageManager.getMessages());
        listMessages.setItems(messages);
        listMessages.refresh();
    }

    @FXML
    private void hideScene(ActionEvent event) {
        Stage primaryStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        primaryStage.setIconified(true);
    }

    @FXML
    private void closeScene(ActionEvent event) throws IOException {
        Stage primaryStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        primaryStage.close();
        Connection.connectionManager.closeConnection();
    }

    @FXML void setupAccess() {
        if (user.getRole() == "Пользователь") {
            btnUsers.setVisible(false);
            listMessages.setVisible(false);
        }
    }
}
