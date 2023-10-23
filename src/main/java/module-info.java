module com.example.pronouncer {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.kordamp.bootstrapfx.core;
    requires com.github.kwhat.jnativehook;
    requires javafx.media;
    requires org.jsoup;

    opens com.example.pronouncer to javafx.fxml;
    exports com.example.pronouncer;
    exports com.example.pronouncer.scene;
    opens com.example.pronouncer.scene to javafx.fxml;
}