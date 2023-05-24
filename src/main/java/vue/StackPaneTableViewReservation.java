package vue;

import java.util.HashMap;

import javafx.scene.layout.StackPane;
import modele.Reservation;

/**
 * Stacks the reservation tables of each week.
 * @author bferrari
 * @see TableViewReservation
 */
public class StackPaneTableViewReservation extends StackPane {
    private HashMap<Integer, TableViewReservation> semaines;

    public StackPaneTableViewReservation() {
        super();
        semaines = new HashMap<>();
    }

    /**
     * Add a week to the tables if not already there.
     * @param n: week number
     */
    public void addIfAbsent(int n) {
        if (!semaines.containsKey(n)) {
            semaines.put(n, new TableViewReservation());
            getChildren().add(semaines.get(n));
        }
    }

    /**
     * #addIfAbsent(int) and show the week.
     * @param n: week number
     */
    public void addIfAbsentAndShow(int n) {
        addIfAbsent(n);
        semaines.get(n).toFront();
    }

    /**
     * Adds a reservation to a specific week.
     * @param semaine: week number
     * @param r: reservation
     */
    public void addReservation(int semaine, Reservation r) {
        semaines.get(semaine).add(r);
    }
}
