module vue {
    requires transitive javafx.controls;
    requires javafx.fxml;

    opens vue to javafx.fxml;

    exports modele;
    exports vue;
}
