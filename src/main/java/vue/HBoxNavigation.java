package vue;

import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;

public class HBoxNavigation extends HBox {
  public HBoxNavigation() {
    super();
    setAlignment(Pos.CENTER_RIGHT);
    Button prev = new Button("<");
    Button next = new Button(">");
    getChildren().addAll(prev, next);
  }
}
