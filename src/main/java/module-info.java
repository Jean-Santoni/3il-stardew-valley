module com.stardew.stardewvalley {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.media;


    opens com.stardew.stardewvalley to javafx.fxml;
    exports com.stardew.stardewvalley;
}