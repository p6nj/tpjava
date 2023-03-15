package vue;

import date.ConstantesCalendrier;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.VBox;
import modele.CalendrierDuMois;
import modele.DateCalendrier;

public class VBoxRoot extends VBox implements ConstantesCalendrier {
    public VBoxRoot() {
        super(10);
        DateCalendrier date = new DateCalendrier();
        CalendrierDuMois mois = new CalendrierDuMois(date.getMois(), date.getAnnee());
        Label labelMoisChoisi = new Label(String.format("%s %d", MOIS[mois.getMois() - 1], mois.getAnnee()));
        VBox boiteDates = new VBox();
        ScrollPane scrollPaneDates = new ScrollPane();
        scrollPaneDates.setContent(boiteDates);
        for (DateCalendrier d : mois.getDates()) {
            boiteDates.getChildren().add(new Label(d.toString()));
        }
        getChildren().addAll(labelMoisChoisi, scrollPaneDates);
    }
}
