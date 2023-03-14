module premierevue {
    requires javafx.controls;
    requires javafx.fxml;

    opens premierevue to javafx.fxml;
    exports premierevue;
}
