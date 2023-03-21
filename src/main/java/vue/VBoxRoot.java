package vue;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
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
        HBoxNavigation controls = new HBoxNavigation();
        title.getChildren().add(controls);
        controls.setNextAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent arg0) {
                next();
            }
        });
        controls.setPrevAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent arg0) {
                prev();
            }
        });
        stackPaneMois = new StackPaneAnnee(date);

        getChildren().addAll(title, stackPaneMois);
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
