package vue;

import modele.Horaire;
import modele.PlageHoraire;

import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.Separator;
import javafx.scene.control.TextArea;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.GridPane;

/**
 * Reservation form seen at the center of the window.
 * @author bferrari
 *
 */
public class GridPaneFormulaireRéservation extends GridPane {
    private static final boolean debug = false;
    private ToggleGroup gNiveau;
    private TextArea tCours;
    private ChoiceBox<Horaire> cHoraireDebut, cHoraireFin;
    private Button bAnnuler, bEnregistrer;
    private static Label semaine = new Label();

    public GridPaneFormulaireRéservation() {
        super();
        setWidth(300);
        setGridLinesVisible(debug);
        setHgap(10);
        setVgap(15);
        setSemaine(StackPaneAnnee.getSelection().getNumeroSemaine());
        semaine.setId("title");
        setPadding(new Insets(50, 0, 0, 0));
        int i = 0;
        add(semaine, 1, i++, 3, 1);
        add(new Separator(), 1, i++, 3, 1);
        Label lcours = new Label("cours");
        Label lniveau = new Label("niveau");
        Label lhoraire = new Label("horaire");
        add(lcours, 1, i++);
        add(lniveau, 1, i++);
        add(lhoraire, 1, ++i);
        tCours = new TextArea();
        tCours.setPromptText("Nom du cours...");
        tCours.setMaxHeight(30);
        tCours.setWrapText(true);
        add(tCours, 2, 2, 2, 1);
        gNiveau = new ToggleGroup();
        String[] choix = new String[] { "débutant", "moyen", "avancé", "expert" };
        for (i = 0; i < choix.length; i++) {
            RadioButton b = new RadioButton("_" + choix[i]);
            b.setAccessibleText(choix[i]);
            b.setMnemonicParsing(true);
            b.setUserData(choix[i]);
            b.setToggleGroup(gNiveau);
            b.getStyleClass().remove("radio-button");
            b.getStyleClass().add("button");
            b.setId("niveau");
            add(b, i % 2 + 2, i / 2 + 3);
        }
        gNiveau.selectToggle(gNiveau.getToggles().get(0));
        cHoraireDebut = new ChoiceBox<Horaire>(FXCollections.observableArrayList(getHoraireList(0)));
        cHoraireFin = new ChoiceBox<Horaire>(FXCollections.observableArrayList(getHoraireList(1)));
        cHoraireDebut.setValue(cHoraireDebut.getItems().get(7));
        cHoraireFin.setValue(cHoraireFin.getItems().get(11));
        i = 5;
        add(cHoraireDebut, 2, i);
        add(cHoraireFin, 3, i++);
        bAnnuler = new Button("Annuler");
        bEnregistrer = new Button("Enregistrer");
        Separator s = new Separator();
        add(s, 1, i++, 3, 1);
        add(bAnnuler, 2, i);
        add(bEnregistrer, 3, i);
    }
    
    /**
     * Constructs a table of times to choose in the time slot choice boxes. 
     * @param offset to start the time list with
     * @return table of times
     */
    private Horaire[] getHoraireList(int offset) {
        Horaire[] horaires = new Horaire[24 * 4];
        for (int i = offset; i < horaires.length; i++) {
            horaires[i] = new Horaire(i / 4, (i % 4) * 15);
        }
        return horaires;
    }

    /**
     * Constructs a PlageHoraire object from both of the choice boxes.
     * @return time slot
     * @see modele.PlageHoraire
     */
    public PlageHoraire getPlageHoraire() {
        try {
            return new PlageHoraire(cHoraireDebut.getValue(), cHoraireFin.getValue());
        } catch (Exception e) {
            System.err.println(e.toString());
            return null;
        }
    }

    /**
     * Classic getter.
     * @return label (name) of the Reservation
     */
    public String getName() {
        return tCours.getText();
    }

    /**
     * Set the "Cancel" action when clicking on the corresponding button (bottom of the form).
     * @param e (event handler)
     */
    public void setCancelAction(EventHandler<ActionEvent> e) {
        bAnnuler.setOnAction(e);
    }

    /**
     * Set the "Save" action when clicking on the corresponding button (bottom of the form).
     * @param e (event handler)
     */
    public void setSaveAction(EventHandler<ActionEvent> e) {
        bEnregistrer.setOnAction(e);
    }

    /**
     * Classic setter. Modifies the week number in the form title.
     * @param n (week number)
     */
    public static void setSemaine(int n) {
        semaine.setText(String.format("Semaine %d", n));
    }

    /**
     * Classic getter.
     * @return level
     */
    public String getNiveau() {
        return (String) gNiveau.getSelectedToggle().getUserData();
    }
}
