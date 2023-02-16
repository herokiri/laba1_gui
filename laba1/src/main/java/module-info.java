module com.example.laba1 {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires net.synedra.validatorfx;
    requires com.almasb.fxgl.all;

    opens com.example.laba1 to javafx.fxml;
    exports com.example.laba1;
}