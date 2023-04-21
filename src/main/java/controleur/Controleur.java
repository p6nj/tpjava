package controleur;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.ToggleButton;
import vue.GridPaneFormulaireRéservation;
import vue.HBoxRoot;
import vue.StackPaneAnnee;

public class Controleur implements EventHandler<ActionEvent> {
    @Override
    public void handle(ActionEvent e) {
        if (e.getSource() instanceof ToggleButton) {
            GridPaneFormulaireRéservation.setSemaine(StackPaneAnnee.getSelection().getNumeroSemaine());
        } else
            try {
                System.out.println(HBoxRoot.getReservation());
                HBoxRoot.addTableElement(HBoxRoot.getReservation());
            } catch (Exception e1) {
                System.err.println("Impossible de récupérer la réservation (pointeur vide).");
            }
    }
}
