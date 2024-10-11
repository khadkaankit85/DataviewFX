module com.example.dataviewfx {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.kordamp.bootstrapfx.core;
    requires java.sql;

    opens com.example.dataviewfx to javafx.fxml;
    exports com.example.dataviewfx;
}