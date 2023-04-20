package vue;

import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import modele.DateCalendrier;
import modele.PlageHoraire;
import modele.Reservation;

public class TableViewReservation extends TableView<Reservation> {
    public TableViewReservation() {
        super();
        setMinWidth(650);
        TableColumn<Reservation, DateCalendrier> dateColumn = new TableColumn<>("Date");
        dateColumn.setCellValueFactory(new PropertyValueFactory<>("date"));
        dateColumn.setSortable(true);
        dateColumn.setMinWidth(200);
        TableColumn<Reservation, String> coursColumn = new TableColumn<>("Cours");
        coursColumn.setCellValueFactory(new PropertyValueFactory<>("label"));
        coursColumn.setSortable(true);
        coursColumn.setMinWidth(210);
        TableColumn<Reservation, String> niveauColumn = new TableColumn<>("Niveau");
        niveauColumn.setCellValueFactory(new PropertyValueFactory<>("niveau"));
        niveauColumn.setSortable(true);
        niveauColumn.setMinWidth(70);
        TableColumn<Reservation, PlageHoraire> horaireColumn = new TableColumn<>("Horaire");
        horaireColumn.setCellValueFactory(new PropertyValueFactory<>("plage"));
        horaireColumn.setSortable(true);
        horaireColumn.setMinWidth(120);
        TableColumn<Reservation, PlageHoraire> dureeColumn = new TableColumn<>("Durée");
        dureeColumn.setCellValueFactory(new PropertyValueFactory<>("duree"));
        dureeColumn.setSortable(true);
        dureeColumn.setMinWidth(50);
        getColumns().addAll(dateColumn, coursColumn, niveauColumn, horaireColumn, dureeColumn);
        getSortOrder().addAll(dateColumn, coursColumn, horaireColumn);
        sort();
    }
}