package vue;

import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.StackPane;
import modele.DateCalendrier;

public class StackPaneAnnee extends StackPane {
  public StackPaneAnnee(DateCalendrier date) {
    super();
    ToggleGroup group = new ToggleGroup();
    for (int i = 1; i < 13; i++)
      getChildren().add(new TilePaneMois(date, i, group));
    while (((TilePaneMois) getChildren().get(0)).getMois() != date.getMois() + 1)
      next();

  }

  public void next() {
    getChildren().get(0).toFront();
  }

  public void prev() {
    getChildren().get(getChildren().size() - 1).toBack();
  }

  public void show(int mois) {
    while (((TilePaneMois) getChildren().get(0)).getMois() != mois)
      next();
    next();
  }
}
