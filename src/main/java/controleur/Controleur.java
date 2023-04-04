package controleur;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import vue.HBoxNavigation;
import vue.HBoxRoot;

public class Controleur {
    public Controleur(HBoxRoot root) {
        PlanningActions actions = new PlanningActions(root.getVbc());
        HBoxNavigation planningControls = root.getVbc().getTitle().controls();
        planningControls.setNextAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent arg0) {
                actions.next();
            }
        });
        planningControls.setPrevAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent arg0) {
                actions.prev();
            }
        });
        planningControls.setFirstAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent arg0) {
                actions.first();
            }
        });
        planningControls.setLastAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent arg0) {
                actions.last();
            }
        });
    }
}
