package vue;

import javafx.scene.layout.VBox;
import modele.DateCalendrier;

public class VBoxCalendrier extends VBox {
    private DateCalendrier date;
    private StackPaneAnnee stackPaneMois;
    private HBoxTitle title;

    public VBoxCalendrier() {
        super(10);
        date = new DateCalendrier();

        title = new HBoxTitle(date, this);
        stackPaneMois = new StackPaneAnnee(date);

        getChildren().addAll(title, stackPaneMois);
    }

    public void next() {
        date = new DateCalendrier(date.getJour(), date.getMois() == 12 ? 1 : date.getMois() + 1, date.getAnnee());
        stackPaneMois.next();
        title.setDate(date);
    }

    public void prev() {
        date = new DateCalendrier(date.getJour(), date.getMois() == 1 ? 12 : date.getMois() - 1, date.getAnnee());
        stackPaneMois.prev();
        title.setDate(date);
    }

    public void first() {
        date = new DateCalendrier(date.getJour(), 1, date.getAnnee());
        stackPaneMois.show(1);
        title.setDate(date);
    }

    public void last() {
        date = new DateCalendrier(date.getJour(), 12, date.getAnnee());
        stackPaneMois.show(12);
        title.setDate(date);
    }
}
