package vue;

import date.ConstantesCalendrier;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import modele.CalendrierDuMois;
import modele.Capitalize;
import modele.DateCalendrier;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

public class HBoxTitle extends HBox implements ConstantesCalendrier {
  private Label labelTitle;

  public HBoxTitle(DateCalendrier date, VBoxRoot sup) {
    super();
    HBoxNavigation controls = new HBoxNavigation();
    HBox.setHgrow(controls, Priority.ALWAYS);
    getChildren().add(controls);
    controls.setAlignment(Pos.TOP_LEFT);
    controls.setNextAction(new EventHandler<ActionEvent>() {
      @Override
      public void handle(ActionEvent arg0) {
        sup.next();
      }
    });
    controls.setPrevAction(new EventHandler<ActionEvent>() {
      @Override
      public void handle(ActionEvent arg0) {
        sup.prev();
      }
    });
    controls.setFirstAction(new EventHandler<ActionEvent>() {
      @Override
      public void handle(ActionEvent arg0) {
        sup.first();
      }
    });
    controls.setLastAction(new EventHandler<ActionEvent>() {
      @Override
      public void handle(ActionEvent arg0) {
        sup.last();
      }
    });
    CalendrierDuMois mois = new CalendrierDuMois(date.getMois(), date.getAnnee());
    labelTitle = new Label(
        String.format("%s %d", Capitalize.toTitleCase(MOIS[mois.getMois() - 1]), mois.getAnnee()));
    setMargin(labelTitle, new Insets(14));
    labelTitle.setId("title");
    setHgrow(labelTitle, Priority.ALWAYS);
    getChildren().add(labelTitle);
  }

  public void setDate(DateCalendrier date) {
    CalendrierDuMois mois = new CalendrierDuMois(date.getMois(), date.getAnnee());
    labelTitle.setText(String.format("%s %d", Capitalize.toTitleCase(MOIS[mois.getMois() - 1]), mois.getAnnee()));
  }
}
