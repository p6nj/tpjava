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

    /**
     * Setups window elements and restore reservations from the planning file.
     * 
     * @see #fileRestore()
     * @see #setDefaults()
     */
    public HBoxRoot() {
        super(10);
        setAlignment(Pos.TOP_LEFT);
        setDefaults();
        fileRestore();
    }

    /**
     * Restores reservations from the planning file /sauvegarde/Planning.bin
     * (resources) and add them to the local planning and to the window table.
     * 
     * @see #populateReservations()
     */
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
        else
            populateReservations();
    }

    /**
     * Add the restored reservations to the window table.
     * 
     * @see #addTableElement(int, Reservation)
     */
    public void populateReservations() {
        System.err.println(planning);
        for (Reservation r : planning.getAllReservations()) {
            try {
                addTableElement(new DateCalendrier(r.getDate().getJour(), r.getDate().getMois(), r.getDate().getAnnee())
                        .getNumeroSemaine(), r);
            } catch (ExceptionPlanning e) {
                System.err.println("Erreur dans les réservations sauvegardées (" + r + ") : " + e.toString());
            } catch (NullPointerException e) {
                System.out.println("Reservation " + r + " non ajoutée");
            }
        }
    }

    /**
     * Forms a reservation from the selected date of the tilepane and the schedule,
     * label and level of the gridpane form.
     * 
     * @return the resulting
     *         {@link modele.Reservation#Reservation(modele.Date, modele.PlageHoraire, String, String)
     *         Reservation}
     * @throws Exception
     */
    public static Reservation getReservation() throws Exception {
        return new Reservation(StackPaneAnnee.getSelection(), gpfr.getPlageHoraire(), gpfr.getName(),
                gpfr.getNiveau());
    }

    /**
     * Sets the "cancel" action on the window.
     * 
     * @see GridPaneFormulaireRéservation#setCancelAction(EventHandler)
     */
    public void setCancelAction(EventHandler<ActionEvent> e) {
        gpfr.setCancelAction(e);
    }

    /**
     * Sets the "save" action on the window.
     * 
     * @see GridPaneFormulaireRéservation#setSaveAction(EventHandler)
     */
    public void setSaveAction(EventHandler<ActionEvent> e) {
        gpfr.setSaveAction(e);
    }

    /**
     * Setups the window elements as at first launch.
     * 
     * @see VBoxCalendrier#VBoxCalendrier()
     * @see GridPaneFormulaireRéservation#GridPaneFormulaireRéservation()
     * @see controleur.Controleur#Controleur()
     * @see HBoxNavigation#setNextAction(EventHandler)
     * @see HBoxNavigation#setPrevAction(EventHandler)
     * @see HBoxNavigation#setFirstAction(EventHandler)
     * @see HBoxNavigation#setLastAction(EventHandler)
     */
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

    /**
     * Alter the window elements for the "next" action triggered by a button.
     * 
     * @see modele.DateCalendrier#DateCalendrier(int, int, int)
     * @see VBoxCalendrier#setDate(DateCalendrier)
     * @see VBoxCalendrier#next()
     * @see HBoxTitle#setDate(DateCalendrier)
     */
    public void next() {
        DateCalendrier date = vbc.getDate();
        date = new DateCalendrier(date.getJour(), date.getMois() == 12 ? 1 : date.getMois() + 1, date.getAnnee());
        vbc.setDate(date);
        vbc.next();
        vbc.getTitle().setDate(date);
    }

    /**
     * Alter the window elements for the "prev" action triggered by a button.
     * 
     * @see modele.DateCalendrier#DateCalendrier(int, int, int)
     * @see VBoxCalendrier#setDate(DateCalendrier)
     * @see VBoxCalendrier#prev()
     * @see HBoxTitle#setDate(DateCalendrier)
     */
    public void prev() {
        DateCalendrier date = vbc.getDate();
        date = new DateCalendrier(date.getJour(), date.getMois() == 1 ? 12 : date.getMois() - 1, date.getAnnee());
        vbc.setDate(date);
        vbc.prev();
        vbc.getTitle().setDate(date);
    }

    public void first() {
        DateCalendrier date = vbc.getDate();
        date = new DateCalendrier(date.getJour(), 1, date.getAnnee());
        vbc.setDate(date);
        vbc.show(1);
        vbc.getTitle().setDate(date);
    }

    public void last() {
        DateCalendrier date = vbc.getDate();
        date = new DateCalendrier(date.getJour(), 12, date.getAnnee());
        vbc.setDate(date);
        vbc.show(12);
        vbc.getTitle().setDate(date);
    }

    public static Controleur getControleur() {
        return c;
    }

    public static void addTableElement(int semaine, Reservation r) throws ExceptionPlanning {
        tableDesReservations.addIfAbsent(semaine);
        tableDesReservations.addReservation(semaine, r);
        planning.ajout(r);
    }

    public static void addIfAbsentAndShow(int n) {
        tableDesReservations.addIfAbsentAndShow(n);
    }

}
