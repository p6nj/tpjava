package vue;

import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import modele.DateCalendrier;

public class VBoxRoot extends VBox {
    public VBoxRoot() {
        super();
        DateCalendrier date = new DateCalendrier();
        getChildren().addAll(new Label(date.toString()), new Label(date.dateDuLendemain().toString()));
    }
}
