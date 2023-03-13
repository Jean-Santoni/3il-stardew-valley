module com.stardew.stardewvalley {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.stardew.stardewvalley to javafx.fxml;
    exports com.stardew.stardewvalley;
}