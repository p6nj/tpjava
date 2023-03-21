package vue;

import javafx.scene.layout.StackPane;
import modele.DateCalendrier;

public class StackPaneAnnee extends StackPane {
  public StackPaneAnnee(DateCalendrier date) {
    super();
    for (int i = 1; i < 13; i++)
      getChildren().add(new ScrollPaneMois(date, i));
    do
      next();
    while (((ScrollPaneMois) getChildren().get(0)).getMois() != date.getMois() + 1);

  }

  public void next() {
    getChildren().get(0).toFront();
  }

  public void prev() {
    getChildren().get(getChildren().size() - 1).toBack();
  }
}
