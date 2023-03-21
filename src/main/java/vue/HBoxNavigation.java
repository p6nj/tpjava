package vue;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;

public class HBoxNavigation extends HBox {
  private Button prev, next;

  public HBoxNavigation() {
    super();
    setAlignment(Pos.CENTER_RIGHT);
    prev = new Button("<");
    next = new Button(">");
    getChildren().addAll(prev, next);
  }

  public void setPrevAction(EventHandler<ActionEvent> action) {
    prev.setOnAction(action);
  }

  public void setNextAction(EventHandler<ActionEvent> action) {
    next.setOnAction(action);
  }
}
