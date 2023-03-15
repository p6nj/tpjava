package vue;

import date.ConstantesCalendrier;
import javafx.geometry.Insets;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.VBox;
import modele.CalendrierDuMois;
import modele.Capitalize;
import modele.DateCalendrier;

public class VBoxRoot extends VBox implements ConstantesCalendrier {
    public VBoxRoot() {
        super(10);
        DateCalendrier date = new DateCalendrier();
        CalendrierDuMois mois = new CalendrierDuMois(date.getMois(), date.getAnnee());
        Label labelTitle = new Label(
                String.format("%s %d", Capitalize.toTitleCase(MOIS[mois.getMois() - 1]), mois.getAnnee()));
        setMargin(labelTitle, new Insets(14));
        labelTitle.setId("title");
        VBox boiteDates = new VBox();
        ScrollPane scrollPaneDates = new ScrollPane();
        scrollPaneDates.setContent(boiteDates);
        for (DateCalendrier d : mois.getDates()) {
            Label labelDate = new Label(d.toString());
            if (d.compareTo(date) == 0)
                labelDate.setId("today");
            else {
                labelDate.setId("date");
            }
            boiteDates.getChildren().add(labelDate);
        }
        getChildren().addAll(labelTitle, scrollPaneDates);
    }
}
