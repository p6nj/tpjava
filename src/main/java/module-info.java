module premierevue {
    requires transitive javafx.controls;
    requires javafx.fxml;

    opens premierevue to javafx.fxml;

    exports premierevue;
    exports vue;
}
