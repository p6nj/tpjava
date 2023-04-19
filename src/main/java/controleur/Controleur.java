package controleur;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import vue.HBoxRoot;

public class Controleur implements EventHandler<ActionEvent> {
    @Override
    public void handle(ActionEvent e) {
        try {
            System.out.println(HBoxRoot.getReservation());
        } catch (Exception e1) {
            System.err.println("Impossible de récupérer la réservation: " + e1.toString());
        }
    }
}
