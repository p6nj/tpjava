package vue;

import date.ConstantesCalendrier;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import modele.CalendrierDuMois;
import modele.Capitalize;
import modele.DateCalendrier;

/**
 * Window title with the month name and the navigation buttons.
 * @author bferrari
 *
 */
public class HBoxTitle extends HBox implements ConstantesCalendrier {
  private Label labelTitle;
  private HBoxNavigation controls;

  public HBoxTitle(DateCalendrier date, VBoxCalendrier sup) {
    super();
    controls = new HBoxNavigation();
    HBox.setHgrow(controls, Priority.ALWAYS);
    getChildren().add(controls);
    controls.setAlignment(Pos.TOP_LEFT);
    CalendrierDuMois mois = new CalendrierDuMois(date.getMois(), date.getAnnee());
    labelTitle = new Label(
        String.format("%s %d", Capitalize.toTitleCase(MOIS[mois.getMois() - 1]), mois.getAnnee()));
    setMargin(labelTitle, new Insets(14));
    labelTitle.setId("title");
    labelTitle.setAlignment(Pos.TOP_RIGHT);
    setHgrow(labelTitle, Priority.ALWAYS);
    getChildren().add(labelTitle);
  }

  /**
   * Modifies the month name in the title.
   * @param date
   */
  public void setDate(DateCalendrier date) {
    CalendrierDuMois mois = new CalendrierDuMois(date.getMois(), date.getAnnee());
    labelTitle.setText(String.format("%s %d", Capitalize.toTitleCase(MOIS[mois.getMois() - 1]), mois.getAnnee()));
  }

  /**
   * Control buttons getter.
   * @return controls
   * @see HBoxNavigation
   */
  public HBoxNavigation controls() {
    return controls;
  }

}
