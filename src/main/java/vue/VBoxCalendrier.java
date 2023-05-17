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

    public DateCalendrier getDate() {
        return date;
    }

    public void setDate(DateCalendrier newdate) {
        date = newdate;
    }

    public HBoxTitle getTitle() {
        return title;
    }

    public void next() {
        stackPaneMois.next();
    }

    public void prev() {
        stackPaneMois.prev();
    }

    public void show(int mois) {
        stackPaneMois.show(mois);
    }
}
