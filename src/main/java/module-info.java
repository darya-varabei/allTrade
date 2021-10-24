module com.example.alltrade {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires org.kordamp.bootstrapfx.core;
    requires AnimateFX;

    opens com.example.alltrade to javafx.fxml;
    exports com.example.alltrade;
}