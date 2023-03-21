package vue;

import javafx.scene.control.Button;
import javafx.scene.layout.HBox;

public class HBoxNavigation extends HBox {
  public HBoxNavigation() {
    super();
    Button testButton = new Button("what");
    getChildren().addAll(testButton);
  }
}
