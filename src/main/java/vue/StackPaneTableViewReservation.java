package vue;

import java.util.HashMap;

import javafx.scene.layout.StackPane;
import modele.Reservation;

public class StackPaneTableViewReservation extends StackPane {
    private HashMap<Integer, TableViewReservation> semaines;

    public StackPaneTableViewReservation() {
        super();
        semaines = new HashMap<>();
    }

    public void addIfAbsentAndShow(int n) {
        if (!semaines.containsKey(n)) {
            semaines.put(n, new TableViewReservation());
            getChildren().add(semaines.get(n));
        }
        semaines.get(n).toFront();
    }

    public void addReservation(int semaine, Reservation r) {
        semaines.get(semaine).add(r);
    }
}
