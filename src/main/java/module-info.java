module com.stardew.stardewvalley {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.media;
    requires javafx.swing;

    opens com.stardew.stardewvalley to javafx.fxml;
    exports com.stardew.stardewvalley;
}