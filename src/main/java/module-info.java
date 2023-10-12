module com.example.pronouncer {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.kordamp.bootstrapfx.core;
    requires com.github.kwhat.jnativehook;

    opens com.example.pronouncer to javafx.fxml;
    exports com.example.pronouncer;
}