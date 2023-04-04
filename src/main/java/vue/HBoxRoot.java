package vue;

import javafx.scene.layout.HBox;

public class HBoxRoot extends HBox {
    private VBoxCalendrier vbc;
    private GridPaneFormulaireRéservation gpfr;

    public HBoxRoot() {
        super(10);
        vbc = new VBoxCalendrier();
        gpfr = new GridPaneFormulaireRéservation();
        getChildren().addAll(vbc, gpfr);
    }
}
