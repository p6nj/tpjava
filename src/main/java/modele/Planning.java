package modele;

import java.io.File;
import java.io.Serializable;
import java.nio.file.Paths;
import java.util.Vector;

import outils.LectureEcriture;

public class Planning implements ConstantesErreur, Serializable {
  private Vector<Reservation> reservations;
  private static final int SIZE = 100;

  public Planning() {
    reservations = new Vector<>();
  }

  /**
   * Stringifies the Planning instance using the Reservation toString method.
   * 
   * @return String
   */
  public String toString() {
    String resultat;
    if (!reservations.isEmpty()) {
      resultat = "---\n";
      for (Reservation r : reservations)
        resultat += "\t" + r.toString() + "\n";
      resultat += "---";
    } else
      resultat = "[]";
    return resultat;
  }

  /**
   * Add a reservation to the instance table.
   * 
   * @param Reservation
   */
  public void ajout(Reservation reservation) throws ExceptionPlanning {
    if (!reservation.estValide()) {
      throw new ExceptionPlanning(ERRINV);
    }
    for (Reservation r : reservations) {
      if (r.compareTo(reservation) == 0)
        throw new ExceptionPlanning(ERRINC);
    }
    reservations.add(reservation);
    save();
  }

  private void save() {
    File file = Paths.get(Planning.class.getResource("/sauvegarde/Planning.bin").getPath()).toFile();
    LectureEcriture.ecriture(file, this);
  }

  /**
   * Add multiple reservations to the instance table, short-circuiting if
   * something goes wrong.
   * 
   * @param Reservation[]
   */
  public void ajout(Reservation[] reservations) throws ExceptionPlanning {
    for (Reservation reservation : reservations) {
      ajout(reservation);
    }
  }

  /**
   * @param date
   * @return the first Reservation objects found in the table with the given date.
   */
  public Reservation getReservation(Date date) {
    for (Reservation reservation : reservations) {
      if (reservation == null)
        break;
      if (reservation.getDate().compareTo(date) == 0)
        return reservation;
    }
    return null;
  }

  /**
   * @param date
   * @return all the Reservation objects found in the table with the given date.
   */
  public Reservation[] getReservations(Date date) {
    Reservation[] reservations = new Reservation[SIZE];
    byte n = 0;
    for (Reservation reservation : this.reservations) {
      if (reservation == null)
        break;
      if (reservation.getDate().compareTo(date) == 0)
        reservations[n++] = reservation;
    }
    return reservations;
  }

  public Vector<Reservation> getAllReservations() {
    return reservations;
  }

  /**
   * @param debut
   * @param fin
   * @return the less recent Reservation object from the table within the two
   *         given indices.
   */
  public int plusAncienneReservation(int debut, int fin) {
    int resultat = debut;
    for (int i = debut + 1; !(i > fin); i++) {
      if (reservations.get(i).compareTo(reservations.get(resultat)) < 0)
        resultat = i;
    }
    return resultat;
  }

  /**
   * Sorts the Reservation table using the selection method.
   */
  public void triSelection() {
    int b;
    Reservation temp;
    for (int i = 0; i < reservations.size(); i++) {
      b = plusAncienneReservation(i, reservations.size() - 1);
      temp = reservations.get(i); // change self first
      reservations.set(i, reservations.get(b));
      reservations.set(b, temp);
    }
  }

  /**
   * Sorts the Reservation table using the insertion method.
   */
  public void triInsertion() {
    Reservation x;
    int j;
    for (int i = 0; i < reservations.size(); i++) {
      x = reservations.get(i);
      for (j = i; j > 0 && reservations.get(j - 1).compareTo(x) >= 0; j--) {
        reservations.set(j, reservations.get(j - 1));
      }
      reservations.set(j, x);
    }
  }

}
