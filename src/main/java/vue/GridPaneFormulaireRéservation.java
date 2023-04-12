package vue;

import modele.Horaire;
import modele.PlageHoraire;

import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.Separator;
import javafx.scene.control.TextArea;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.GridPane;

public class GridPaneFormulaireRéservation extends GridPane {
    private static final boolean debug = false;
    private ToggleGroup gNiveau;
    private TextArea tCours;
    private ChoiceBox<Horaire> cHoraireDebut, cHoraireFin;
    private Button bAnnuler, bEnregistrer;

    public GridPaneFormulaireRéservation() {
        super();
        setWidth(300);
        setGridLinesVisible(debug);
        setHgap(10);
        setVgap(10);
        Label lcours = new Label("cours");
        Label lniveau = new Label("niveau");
        Label lhoraire = new Label("horaire");
        add(lcours, 1, 0);
        add(lniveau, 1, 1);
        add(lhoraire, 1, 3);
        tCours = new TextArea();
        tCours.setPromptText("Nom du cours...");
        tCours.setMaxHeight(30);
        tCours.setWrapText(true);
        add(tCours, 2, 0, 2, 1);
        gNiveau = new ToggleGroup();
        String[] choix = new String[] { "débutant", "moyen", "avancé", "expert" };
        for (int i = 0; i < choix.length; i++) {
            RadioButton b = new RadioButton("_" + choix[i]);
            b.setAccessibleText(choix[i]);
            b.setMnemonicParsing(true);
            b.setUserData(choix[i]);
            b.setToggleGroup(gNiveau);
            add(b, i % 2 + 2, i / 2 + 1);
        }
        gNiveau.selectToggle(gNiveau.getToggles().get(0));
        cHoraireDebut = new ChoiceBox<Horaire>(FXCollections.observableArrayList(getHoraireList()));
        cHoraireFin = new ChoiceBox<Horaire>(FXCollections.observableArrayList(getHoraireList()));
        cHoraireDebut.setValue(cHoraireDebut.getItems().get(0));
        cHoraireFin.setValue(cHoraireFin.getItems().get(1));
        add(cHoraireDebut, 2, 3);
        add(cHoraireFin, 3, 3);
        bAnnuler = new Button("Annuler");
        bEnregistrer = new Button("Enregistrer");
        Separator s = new Separator();
        add(s, 1, 4, 3, 1);
        add(bAnnuler, 2, 5);
        add(bEnregistrer, 3, 5);
    }

    private Horaire[] getHoraireList() {
        Horaire[] horaires = new Horaire[24 * 4];
        for (int i = 0; i < horaires.length; i++) {
            horaires[i] = new Horaire(i / 4, (i % 4) * 15);
        }
        return horaires;
    }

    public PlageHoraire getPlageHoraire() {
        try {
            return new PlageHoraire(cHoraireDebut.getValue(), cHoraireFin.getValue());
        } catch (Exception e) {
            System.err.println(e.toString());
            return null;
        }
    }

    public String getName() {
        return tCours.getText();
    }

    public void setCancelAction(EventHandler<ActionEvent> e) {
        bAnnuler.setOnAction(e);
    }

    public void setSaveAction(EventHandler<ActionEvent> e) {
        bEnregistrer.setOnAction(e);
    }
}
