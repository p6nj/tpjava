package vue;

import java.util.TreeMap;
import java.util.TreeSet;

import javafx.scene.layout.StackPane;

public class StackPaneTableViewReservation extends StackPane {
    private TreeSet<TableViewReservation> semaines;

    public StackPaneTableViewReservation() {
        super();
    }

    public boolean add(TableViewReservation semaine) {
        return semaines.add(semaine);
    }
}
