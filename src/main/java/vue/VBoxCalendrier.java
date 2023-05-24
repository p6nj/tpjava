package vue;

import javafx.scene.layout.VBox;
import modele.DateCalendrier;

/**
 * Stack pane container that tracks the date.
 * @author bferrari
 * @see DateCalendrier
 * @see StackPaneAnnee
 * @see HBoxTitle
 */
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

    /**
     * Shows the next month on the stack pane.
     * @see StackPaneAnnee
     */
    public void next() {
        stackPaneMois.next();
    }

    /**
     * Shows the previous month on the stack pane.
     * @see StackPaneAnnee
     */
    public void prev() {
        stackPaneMois.prev();
    }

    /**
     * Shows the nth month on the stack pane.
     * @param mois: month number
     * @see StackPaneAnnee
     */
    public void show(int mois) {
        stackPaneMois.show(mois);
    }
}
