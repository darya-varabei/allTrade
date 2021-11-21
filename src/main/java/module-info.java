module com.example.alltrade {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires org.kordamp.bootstrapfx.core;
    requires AnimateFX;

    opens com.example.alltrade to javafx.fxml;
    exports com.example.alltrade;
    exports com.example.alltrade.model;
    opens com.example.alltrade.model to javafx.fxml;
    exports com.example.alltrade.controller;
    opens com.example.alltrade.controller to javafx.fxml;
    exports com.example.alltrade.model.category;
    opens com.example.alltrade.model.category to javafx.fxml;
    exports com.example.alltrade.model.country;
    opens com.example.alltrade.model.country to javafx.fxml;
    exports com.example.alltrade.controller.table;
    opens com.example.alltrade.controller.table to javafx.fxml;
    exports com.example.alltrade.controller.chart;
    opens com.example.alltrade.controller.chart to javafx.fxml;
}