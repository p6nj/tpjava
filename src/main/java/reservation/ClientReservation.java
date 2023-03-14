package reservation;

import date.Date;
import horaire.Horaire;
import horaire.PlageHoraire;

public class ClientReservation {

  /**
   * Tests the Reservation toString method.
   */
  public static void main() {
    Reservation r;
    try {
      r = new Reservation(new Date(16, 5, 2022), new PlageHoraire(new Horaire(8, 0), new Horaire(9, 45)),
          "Musculation intensive");
    } catch (Exception e) {
      e.printStackTrace();
      return;
    }
    System.out.println(r.toString());
  }
}
