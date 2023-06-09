package controleur;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.ToggleButton;
import modele.ExceptionPlanning;
import vue.GridPaneFormulaireRéservation;
import vue.HBoxRoot;
import vue.StackPaneAnnee;

public class Controleur implements EventHandler<ActionEvent> {
    @Override
    public void handle(ActionEvent e) {
        int semaine = StackPaneAnnee.getSelection().getNumeroSemaine();
        if (e.getSource() instanceof ToggleButton) {
            GridPaneFormulaireRéservation.setSemaine(semaine);
            HBoxRoot.addIfAbsentAndShow(semaine);
        } else
            try {
                System.out.println(HBoxRoot.getReservation());
                HBoxRoot.addTableElement(semaine, HBoxRoot.getReservation());
            } catch (NullPointerException e1) {
                System.err.println("Impossible de récupérer la réservation (pointeur vide).");
            } catch (ExceptionPlanning e2) {
                System.err.println("Réservation invalide.");
            } catch (Exception e3) {
                e3.printStackTrace();
            }
    }
}
