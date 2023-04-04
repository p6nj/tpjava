package vue;

import controleur.Controleur;
import javafx.scene.layout.HBox;

public class HBoxRoot extends HBox {
    private VBoxCalendrier vbc;
    private GridPaneFormulaireRéservation gpfr;

    public HBoxRoot() {
        super(10);
        vbc = new VBoxCalendrier();
        gpfr = new GridPaneFormulaireRéservation();
        getChildren().addAll(vbc, gpfr);
        new Controleur(this);
    }

    public VBoxCalendrier getVbc() {
        return vbc;
    }

    public void setVbc(VBoxCalendrier vbc) {
        this.vbc = vbc;
    }

    public GridPaneFormulaireRéservation getGpfr() {
        return gpfr;
    }

    public void setGpfr(GridPaneFormulaireRéservation gpfr) {
        this.gpfr = gpfr;
    }

}
