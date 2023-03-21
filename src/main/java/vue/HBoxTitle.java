package vue;

import date.ConstantesCalendrier;
import javafx.geometry.Insets;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import modele.CalendrierDuMois;
import modele.Capitalize;
import modele.DateCalendrier;

public class HBoxTitle extends HBox implements ConstantesCalendrier {
  private Label labelTitle;

  public HBoxTitle(DateCalendrier date) {
    super();
    CalendrierDuMois mois = new CalendrierDuMois(date.getMois(), date.getAnnee());
    labelTitle = new Label(
        String.format("%s %d", Capitalize.toTitleCase(MOIS[mois.getMois() - 1]), mois.getAnnee()));
    setMargin(labelTitle, new Insets(14));
    labelTitle.setId("title");
    getChildren().addAll(labelTitle, new HBoxNavigation());
  }

  public void setDate(DateCalendrier date) {
    CalendrierDuMois mois = new CalendrierDuMois(date.getMois(), date.getAnnee());
    labelTitle.setText(String.format("%s %d", Capitalize.toTitleCase(MOIS[mois.getMois() - 1]), mois.getAnnee()));
  }
}
