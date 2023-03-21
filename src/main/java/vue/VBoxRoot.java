package vue;

import javafx.scene.layout.VBox;
import modele.DateCalendrier;

public class VBoxRoot extends VBox {
    private DateCalendrier date;
    private StackPaneAnnee stackPaneMois;
    private HBoxTitle title;

    public VBoxRoot() {
        super(10);
        date = new DateCalendrier();

        title = new HBoxTitle(date);
        stackPaneMois = new StackPaneAnnee(date);

        getChildren().addAll(title, stackPaneMois);
        prev();
    }

    private void next() {
        date = new DateCalendrier(date.getJour(), date.getMois() == 12 ? 1 : date.getMois() + 1, date.getAnnee());
        stackPaneMois.next();
        title.setDate(date);
    }

    private void prev() {
        date = new DateCalendrier(date.getJour(), date.getMois() == 1 ? 12 : date.getMois() - 1, date.getAnnee());
        stackPaneMois.prev();
        title.setDate(date);
    }
}
