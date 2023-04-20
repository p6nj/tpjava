package vue;

import javafx.scene.control.Toggle;
import javafx.scene.control.ToggleButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.StackPane;
import modele.DateCalendrier;

public class StackPaneAnnee extends StackPane {
  private static ToggleGroup group;

  public StackPaneAnnee(DateCalendrier date) {
    super();
    group = new ToggleGroup();
    for (int i = 1; i < 13; i++)
      getChildren().add(new TilePaneMois(date, i, group));
    group.selectToggle(group.getToggles().get(0));
    while (((TilePaneMois) getChildren().get(0)).getMois() != date.getMois() + 1)
      next();
    group.selectToggle(findToggleById("today"));
  }

  private ToggleButton findToggleById(String id) {
    for (Toggle toggle : group.getToggles())
      if (((ToggleButton) toggle).getId().equals(id))
        return (ToggleButton) toggle;
    return new ToggleButton();
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

  public DateCalendrier getSelection() {
    return (DateCalendrier) group.getSelectedToggle().getUserData();
  }

  public static int getSelectedToggleIndex() {
    return group.getToggles().indexOf(group.getSelectedToggle());
  }
}
