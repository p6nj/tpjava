package planning;

import date.Date;
import date.DateCalendrier;
import horaire.Horaire;
import horaire.PlageHoraire;
import reservation.Reservation;

public class ClientPlanningCollections {
    public static void main() {
        PlanningCollections p = new PlanningCollections();
        try {
            p.ajout(new Reservation(new Date(1, 1, 2022), new PlageHoraire(new Horaire(0, 0), new Horaire(1, 0)),
                    "test le test oui c'est le trdest"));
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println(p);
        System.out.println(p.getReservations(new DateCalendrier(1, 1, 2022)));
        System.out.println(p.getReservations("test"));
    }
}
