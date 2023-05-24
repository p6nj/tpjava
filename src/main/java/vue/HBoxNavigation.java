package vue;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;

/**
 * Navigation horizontal box found at the top left of the window, containing month navigation buttons.
 * @author bferrari
 *
 */
public class HBoxNavigation extends HBox {
  private Button prev, next, first, last;

  public HBoxNavigation() {
    super();
    setAlignment(Pos.CENTER_RIGHT);
    first = new Button("<<");
    first.setId("first");
    prev = new Button("<");
    prev.setId("prev");
    last = new Button(">>");
    last.setId("last");
    next = new Button(">");
    next.setId("next");
    getChildren().addAll(first, prev, next, last);
  }

  /**
   * Sets the "previous" button action ("<").
   * @param action (event handler)
   */
  public void setPrevAction(EventHandler<ActionEvent> action) {
    prev.setOnAction(action);
  }

  /**
   * Sets the "next" button action (">").
   * @param action (event handler)
   */
  public void setNextAction(EventHandler<ActionEvent> action) {
    next.setOnAction(action);
  }

  /**
   * Sets the "first" button action ("<<").
   * @param action (event handler)
   */
  public void setFirstAction(EventHandler<ActionEvent> action) {
    first.setOnAction(action);
  }

  /**
   * Sets the "last" button action (">>").
   * @param action (event handler)
   */
  public void setLastAction(EventHandler<ActionEvent> action) {
    last.setOnAction(action);
  }
}
