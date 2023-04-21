package controleur;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Toggle;
import javafx.scene.control.ToggleButton;
import vue.GridPaneFormulaireRéservation;
import vue.HBoxRoot;
import vue.StackPaneAnnee;

public class Controleur implements EventHandler<ActionEvent> {
    @Override
    public void handle(ActionEvent e) {
        if (e.getSource() instanceof ToggleButton) {
<<<<<<< HEAD
            int index = StackPaneAnnee.getSelection().getNumeroSemaine();
=======
            int index = StackPaneAnnee.getSelectedToggleIndexByValue((Toggle) e.getSource()) / 7;
>>>>>>> f528c091c4b113b89ca7cdfb966949d5aca4bf14
            GridPaneFormulaireRéservation.setSemaine(index == 0 ? 52 : index);
        } else
            try {
                System.out.println(HBoxRoot.getReservation());
                HBoxRoot.addTableElement(HBoxRoot.getReservation());
            } catch (Exception e1) {
                System.err.println("Impossible de récupérer la réservation (pointeur vide).");
            }
    }
}
