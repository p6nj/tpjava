package vue;

import controleur.Controleur;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.control.ToggleButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.Priority;
import javafx.scene.layout.Region;
import javafx.scene.layout.TilePane;
import javafx.scene.layout.VBox;
import modele.CalendrierDuMois;
import modele.ConstantesCalendrier;
import modele.DateCalendrier;

public class TilePaneMois extends TilePane implements ConstantesCalendrier {
    private int mois;
    private static int i = 1;

    public TilePaneMois(DateCalendrier date, int mois, ToggleGroup group) {
        super();
        this.mois = mois;
        CalendrierDuMois calMois = new CalendrierDuMois(mois, date.getAnnee());
        setPrefColumns(8);
        setPrefRows(calMois.getDates().size() % 7 + 1);
        setMinSize(Region.USE_PREF_SIZE, Region.USE_PREF_SIZE);
        setId("opaque");
        setAlignment(Pos.TOP_CENTER);
        VBox.setVgrow(this, Priority.ALWAYS);
        Label l = new Label("N°");
        l.setId("labelcalendrier");
        getChildren().add(l);
        for (String j : JOURS_SEMAINE_ABR) {
            Label labelDate = new Label(j);
            labelDate.setId("labelcalendrier");
            getChildren().add(labelDate);
        }
        for (DateCalendrier d : calMois.getDates()) {
            ToggleButton boutonDate = new ToggleButton(Integer.toString(d.getJour()));
            boutonDate.setMinSize(42, 40);
            boutonDate.setToggleGroup(group);
            boutonDate.setOnAction(new Controleur());
            if (i++ % 7 == 1) {
                l = new Label(String.format("%d", i / 7));
                l.setId("labelcalendrier");
                getChildren().add(l);
            }
            getChildren().add(boutonDate);
            boutonDate.setUserData(d);
            boutonDate.setId(
                    d.compareTo(date) == 0 ? "today" : d.getMois() != mois ? "dateHorsMois" : "date");
        }
        setAccessibleText(MOIS[calMois.getMois() - 1]);
    }

    public int getMois() {
        return mois;
    }
}
