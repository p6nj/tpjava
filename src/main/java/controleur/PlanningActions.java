package controleur;

import modele.DateCalendrier;
import vue.VBoxCalendrier;

public class PlanningActions {
    private VBoxCalendrier cal;

    public PlanningActions(VBoxCalendrier calendrier) {
        cal = calendrier;
    }

    public void next() {
        DateCalendrier date = cal.getDate();
        date = new DateCalendrier(date.getJour(), date.getMois() == 12 ? 1 : date.getMois() + 1, date.getAnnee());
        cal.setDate(date);
        cal.getStackPane().next();
        cal.getTitle().setDate(date);
    }

    public void prev() {
        DateCalendrier date = cal.getDate();
        date = new DateCalendrier(date.getJour(), date.getMois() == 1 ? 12 : date.getMois() - 1, date.getAnnee());
        cal.setDate(date);
        cal.getStackPane().prev();
        cal.getTitle().setDate(date);
    }

    public void first() {
        DateCalendrier date = cal.getDate();
        date = new DateCalendrier(date.getJour(), 1, date.getAnnee());
        cal.setDate(date);
        cal.getStackPane().show(1);
        cal.getTitle().setDate(date);
    }

    public void last() {
        DateCalendrier date = cal.getDate();
        date = new DateCalendrier(date.getJour(), 12, date.getAnnee());
        cal.setDate(date);
        cal.getStackPane().show(12);
        cal.getTitle().setDate(date);
    }
}
