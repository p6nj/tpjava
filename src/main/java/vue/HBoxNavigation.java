package vue;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;

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

  public void setPrevAction(EventHandler<ActionEvent> action) {
    prev.setOnAction(action);
  }

  public void setNextAction(EventHandler<ActionEvent> action) {
    next.setOnAction(action);
  }

  public void setFirstAction(EventHandler<ActionEvent> action) {
    first.setOnAction(action);
  }

  public void setLastAction(EventHandler<ActionEvent> action) {
    last.setOnAction(action);
  }
}
