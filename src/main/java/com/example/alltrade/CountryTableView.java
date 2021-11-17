package com.example.alltrade;

import com.example.alltrade.model.CommonExport;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class CountryTableView extends Application {
    @Override
    public void start(Stage stage) {

        TableView<CommonExport> table = new TableView<CommonExport>();

        // Create column UserName (Data type of String).
        TableColumn<CommonExport, String> userNameCol //
                = new TableColumn<CommonExport, String>("Year");

        // Create column Email (Data type of String).
        TableColumn<CommonExport, String> emailCol//
                = new TableColumn<CommonExport, String>("Import");

        // Create column FullName (Data type of String).
        TableColumn<CommonExport, String> fullNameCol//
                = new TableColumn<CommonExport, String>("Export");

        // Create 2 sub column for FullName.
        TableColumn<CommonExport, String> firstNameCol //
                = new TableColumn<CommonExport, String>("First Name");

        TableColumn<CommonExport, String> lastNameCol //
                = new TableColumn<CommonExport, String>("Last Name");

        // Add sub columns to the FullName
        fullNameCol.getColumns().addAll(firstNameCol, lastNameCol);

        // Active Column
        TableColumn<CommonExport, Boolean> activeCol//
                = new TableColumn<CommonExport, Boolean>("Active");

        table.getColumns().addAll(userNameCol, emailCol, fullNameCol, activeCol);

        StackPane root = new StackPane();
        root.setPadding(new Insets(5));
        root.getChildren().add(table);

        stage.setTitle("TableView (o7planning.org)");

        Scene scene = new Scene(root, 450, 300);
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
