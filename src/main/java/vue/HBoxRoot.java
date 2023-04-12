package vue;

import controleur.Controleur;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.layout.HBox;
import modele.Reservation;

public class HBoxRoot extends HBox {
    private VBoxCalendrier vbc;
    private GridPaneFormulaireRéservation gpfr;
    private Controleur c;

    public HBoxRoot() {
        super(10);
        vbc = new VBoxCalendrier();
        gpfr = new GridPaneFormulaireRéservation();
        getChildren().addAll(vbc, gpfr);
        c = new Controleur(this);
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

    public Reservation getReservation() throws Exception {
        return new Reservation(vbc.getStackPane().getSelection(), gpfr.getPlageHoraire(), gpfr.getName());
    }

    public void setCancelAction(EventHandler<ActionEvent> e) {
        gpfr.setCancelAction(e);
    }

    public void setSaveAction(EventHandler<ActionEvent> e) {
        gpfr.setSaveAction(e);
    }

    public void setDefaults() {
        getChildren().clear();
        vbc = new VBoxCalendrier();
        gpfr = new GridPaneFormulaireRéservation();
        getChildren().addAll(vbc, gpfr);
        c = new Controleur(this);
    }

}
