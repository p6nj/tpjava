package vue;

import modele.DateCalendrier;
import date.ConstantesCalendrier;
import javafx.geometry.Insets;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.VBox;
import modele.CalendrierDuMois;

public class ScrollPaneMois extends ScrollPane implements ConstantesCalendrier {
  private int mois;

  public ScrollPaneMois(DateCalendrier date, int mois) {
    super();
    this.mois = mois;
    VBox boiteDates = new VBox();
    setContent(boiteDates);
    CalendrierDuMois calMois = new CalendrierDuMois(mois, date.getAnnee());
    for (DateCalendrier d : calMois.getDates()) {
      Label labelDate = new Label(d.toString());
      labelDate.setId(
          d.compareTo(date) == 0 ? "today" : d.getMois() != mois ? "dateHorsMois" : "date");
      VBox.setMargin(labelDate, new Insets(8));
      boiteDates.getChildren().add(labelDate);
    }
    setAccessibleText(MOIS[calMois.getMois() - 1]);
  }

  public int getMois() {
    return mois;
  }
}
