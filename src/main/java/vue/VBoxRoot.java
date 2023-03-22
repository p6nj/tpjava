package vue;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
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
        HBox.setHgrow(controls, Priority.ALWAYS);
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
        controls.setFirstAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent arg0) {
                first();
            }
        });
        controls.setLastAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent arg0) {
                last();
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

    private void first() {
        date = new DateCalendrier(date.getJour(), 1, date.getAnnee());
        stackPaneMois.show(1);
        title.setDate(date);
    }

    private void last() {
        date = new DateCalendrier(date.getJour(), 12, date.getAnnee());
        stackPaneMois.show(12);
        title.setDate(date);
    }
}
