package vue;

import java.io.File;
import java.io.IOException;
import java.nio.file.Paths;

import controleur.Controleur;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.layout.HBox;
import modele.DateCalendrier;
import modele.ExceptionPlanning;
import modele.Planning;
import modele.Reservation;
import outils.LectureEcriture;

public class HBoxRoot extends HBox {
    private static VBoxCalendrier vbc;
    private static GridPaneFormulaireRéservation gpfr;
    private static StackPaneTableViewReservation tableDesReservations;
    private static Controleur c;
    private static Planning planning;

    public HBoxRoot() {
        super(10);
        setAlignment(Pos.TOP_LEFT);
        fileRestore();
        setDefaults();
    }

    public void fileRestore() {
        File file = Paths.get(Planning.class.getResource("/sauvegarde/Planning.bin").getPath()).toFile();
        try {
            file.createNewFile();
        } catch (IOException e) {
            System.err.println("Création du fichier de sauvegarde impossible.");
            System.exit(1);
        }
        planning = (Planning) LectureEcriture.lecture(file);
        if (planning == null)
            planning = new Planning();
    }

    public static Reservation getReservation() throws Exception {
        vbc.getStackPane();
        return new Reservation(StackPaneAnnee.getSelection(), gpfr.getPlageHoraire(), gpfr.getName(),
                gpfr.getNiveau());
    }

    public void setCancelAction(EventHandler<ActionEvent> e) {
        gpfr.setCancelAction(e);
    }

    public void setSaveAction(EventHandler<ActionEvent> e) {
        gpfr.setSaveAction(e);
    }

    public void setDefaults() {
        getChildren().clear();
        c = new Controleur();
        vbc = new VBoxCalendrier();
        gpfr = new GridPaneFormulaireRéservation();
        if (tableDesReservations == null)
            tableDesReservations = new StackPaneTableViewReservation();
        tableDesReservations.addIfAbsentAndShow(StackPaneAnnee.getSelection().getNumeroSemaine());
        getChildren().addAll(vbc, gpfr, tableDesReservations);
        HBoxNavigation planningControls = vbc.getTitle().controls();
        planningControls.setNextAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent arg0) {
                next();
            }
        });
        planningControls.setPrevAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent arg0) {
                prev();
            }
        });
        planningControls.setFirstAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent arg0) {
                first();
            }
        });
        planningControls.setLastAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent arg0) {
                last();
            }
        });
        setSaveAction(c);
        setCancelAction(e -> setDefaults());
    }

    public void next() {
        DateCalendrier date = vbc.getDate();
        date = new DateCalendrier(date.getJour(), date.getMois() == 12 ? 1 : date.getMois() + 1, date.getAnnee());
        vbc.setDate(date);
        vbc.getStackPane().next();
        vbc.getTitle().setDate(date);
    }

    public void prev() {
        DateCalendrier date = vbc.getDate();
        date = new DateCalendrier(date.getJour(), date.getMois() == 1 ? 12 : date.getMois() - 1, date.getAnnee());
        vbc.setDate(date);
        vbc.getStackPane().prev();
        vbc.getTitle().setDate(date);
    }

    public void first() {
        DateCalendrier date = vbc.getDate();
        date = new DateCalendrier(date.getJour(), 1, date.getAnnee());
        vbc.setDate(date);
        vbc.getStackPane().show(1);
        vbc.getTitle().setDate(date);
    }

    public void last() {
        DateCalendrier date = vbc.getDate();
        date = new DateCalendrier(date.getJour(), 12, date.getAnnee());
        vbc.setDate(date);
        vbc.getStackPane().show(12);
        vbc.getTitle().setDate(date);
    }

    public static Controleur getControleur() {
        return c;
    }

    public static void addTableElement(int semaine, Reservation r) throws ExceptionPlanning {
        tableDesReservations.addReservation(semaine, r);
        planning.ajout(r);
    }

    public static void addIfAbsentAndShow(int n) {
        tableDesReservations.addIfAbsentAndShow(n);
    }

}
