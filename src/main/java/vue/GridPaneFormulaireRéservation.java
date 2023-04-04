package vue;

import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextArea;
import javafx.scene.layout.GridPane;

public class GridPaneFormulaireRéservation extends GridPane {
    private static final boolean debug = true;

    public GridPaneFormulaireRéservation() {
        super();
        setGridLinesVisible(debug);
        setHgap(10);
        setVgap(10);
        Label lcours = new Label("cours");
        Label lniveau = new Label("niveau");
        Label lhoraire = new Label("horaire");
        add(lcours, 1, 0);
        add(lniveau, 1, 1);
        add(lhoraire, 1, 3);
        TextArea tcours = new TextArea();
        tcours.setPromptText("Nom du cours...");
        tcours.setMaxWidth(200);
        add(tcours, 2, 0, 2, 1);
        String[] choix = new String[] { "débutant", "moyen", "avancé", "expert" };
        for (int i = 0; i < choix.length; i++) {
            RadioButton b = new RadioButton(choix[i]);
            b.setAccessibleText(choix[i]);
            b.setMnemonicParsing(true);
            b.setUserData(choix[i]);
            add(b, i % 2 + 2, i / 2 + 1);
        }
    }
}
