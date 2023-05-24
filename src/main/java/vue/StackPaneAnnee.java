package vue;

import javafx.scene.control.Toggle;
import javafx.scene.control.ToggleButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.StackPane;
import modele.DateCalendrier;

/**
 * Stacks months as {@link TilePaneMois#TilePaneMois(DateCalendrier, int, ToggleGroup) custom tile panes}.
 * @author bferrari
 * @see TilePaneMois
 */
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

  /**
   * Makes the next month tile pane visible.
   */
  public void next() {
    getChildren().get(0).toFront();
  }

  /**
   * Makes the previous month tile pane visible.
   */
  public void prev() {
    getChildren().get(getChildren().size() - 1).toBack();
  }

  /**
   * Makes the nth month tile pane visible.
   * @param mois (month number)
   */
  public void show(int mois) {
    while (((TilePaneMois) getChildren().get(0)).getMois() != mois)
      next();
    next();
  }

  /**
   * Selection getter.
   * @return selected DateCalendrier
   * @see DateCalendrier
   */
  public static DateCalendrier getSelection() {
    return (DateCalendrier) group.getSelectedToggle().getUserData();
  }
}
