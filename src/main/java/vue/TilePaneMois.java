package vue;

import modele.ConstantesCalendrier;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.control.ToggleButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.Priority;
import javafx.scene.layout.Region;
import javafx.scene.layout.TilePane;
import javafx.scene.layout.VBox;
import modele.CalendrierDuMois;
import modele.DateCalendrier;

public class TilePaneMois extends TilePane implements ConstantesCalendrier {
    private int mois;

    public TilePaneMois(DateCalendrier date, int mois, ToggleGroup group) {
        super();
        this.mois = mois;
        CalendrierDuMois calMois = new CalendrierDuMois(mois, date.getAnnee());
        setPrefColumns(7);
        setPrefRows(calMois.getDates().size() % 7 + 1);
        setMinSize(Region.USE_PREF_SIZE, Region.USE_PREF_SIZE);
        setId("opaque");
        setAlignment(Pos.TOP_CENTER);
        VBox.setVgrow(this, Priority.ALWAYS);
        for (String j : JOURS_SEMAINE_ABR) {
            Label labelDate = new Label(j);
            getChildren().add(labelDate);
        }
        for (DateCalendrier d : calMois.getDates()) {
            ToggleButton boutonDate = new ToggleButton(Integer.toString(d.getJour()));
            boutonDate.setMinSize(42, 40);
            boutonDate.setToggleGroup(group);
            getChildren().add(boutonDate);
            boutonDate.setUserData(d);
            boutonDate.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent a) {
                    System.out.println(((Node) a.getSource()).getUserData());
                }
            });
            boutonDate.setId(
                    d.compareTo(date) == 0 ? "today" : d.getMois() != mois ? "dateHorsMois" : "date");
        }
        setAccessibleText(MOIS[calMois.getMois() - 1]);
    }

    public int getMois() {
        return mois;
    }
}
