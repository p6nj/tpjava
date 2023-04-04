package vue;

import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;

public class GridPaneFormulaireRéservation extends GridPane {
    public GridPaneFormulaireRéservation() {
        super();
        Label lcours = new Label("cours");
        Label lniveau = new Label("niveau");
        Label lhoraire = new Label("horaire");
        add(lcours, 1, 0);
    }
}
