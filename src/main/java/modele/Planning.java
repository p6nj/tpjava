package modele;

import java.io.File;
import java.io.IOException;
import java.io.Serializable;
import java.net.URISyntaxException;

import outils.LectureEcriture;

public class Planning implements ConstantesErreur, Serializable {
  private Reservation reservations[];
  private static final int SIZE = 100;

  public Planning() {
    reservations = new Reservation[SIZE];
  }

  /**
   * Stringifies the Planning instance using the Reservation toString method.
   * 
   * @return String
   */
  public String toString() {
    String resultat;
    if (reservations[0] != null) {
      resultat = "---\n";
      for (int i = 0; i < reservations.length && reservations[i] != null; i++)
        resultat += "\t" + reservations[i].toString() + "\n";
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
    for (int i = 0; i < reservations.length; i++) {
      if (reservations[i] == null) {
        reservations[i] = reservation;
        save();
        return;
      }
      if (reservations[i].compareTo(reservation) == 0)
        throw new ExceptionPlanning(ERRINC);
    }
    throw new ExceptionPlanning(ERRFUL);
  }

  private void save() {
    try {
      File file = new File(Planning.class.getResource("/sauvegarde/Planning.bin").toURI());
      LectureEcriture.ecriture(file, this);
    } catch (URISyntaxException e) {
      System.out.println("Erreur dans la syntaxe du chemin du fichier de sauvegarde.");
      System.exit(1);
    }
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

  /**
   * @param debut
   * @param fin
   * @return the less recent Reservation object from the table within the two
   *         given indices.
   */
  public int plusAncienneReservation(int debut, int fin) {
    int resultat = debut;
    for (int i = debut + 1; !(i > fin) && reservations[i] != null; i++) {
      if (reservations[i].compareTo(reservations[resultat]) < 0)
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
    for (int i = 0; i < reservations.length && reservations[i] != null; i++) {
      b = plusAncienneReservation(i, reservations.length - 1);
      temp = reservations[i]; // change self first
      reservations[i] = reservations[b];
      reservations[b] = temp;
    }
  }

  /**
   * Sorts the Reservation table using the insertion method.
   */
  public void triInsertion() {
    Reservation x;
    int j;
    for (int i = 0; i < reservations.length && reservations[i] != null; i++) {
      x = reservations[i];
      for (j = i; j > 0 && reservations[j - 1].compareTo(x) >= 0; j--) {
        reservations[j] = reservations[j - 1];
      }
      reservations[j] = x;
    }
  }

}
