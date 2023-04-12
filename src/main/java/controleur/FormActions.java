package controleur;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import vue.HBoxRoot;

public class FormActions {
    public FormActions(HBoxRoot root) {
        root.setSaveAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
                try {
                    System.out.println(root.getReservation());
                } catch (Exception e1) {
                    System.err.println("Impossible de récupérer la réservation: " + e1.toString());
                }
            }
        });
        root.setCancelAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
                root.setDefaults();
            }
        });
    }
}
