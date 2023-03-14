package planning;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.InputMismatchException;
import java.util.NoSuchElementException;
import java.util.Scanner;

import date.Date;
import horaire.Horaire;
import horaire.PlageHoraire;
import reservation.Reservation;

public class ClientPlanning {
  /**
   * Tests various Reservation methods.
   */
  public static void main() {
    // Reservation r;
    // Reservation rr;
    // Reservation rrr;
    // Planning p;
    // try {
    // r = new Reservation(new Date(16, 5, 2022), new PlageHoraire(new Horaire(8,
    // 0), new Horaire(9, 45)),
    // "Musculation intensive");
    // rr = new Reservation(new Date(11, 5, 2022), new PlageHoraire(new Horaire(10,
    // 0), new Horaire(11, 00)),
    // "Maths");
    // rrr = new Reservation(new Date(16, 5, 2022), new PlageHoraire(new Horaire(7,
    // 0), new Horaire(7, 15)),
    // "Anglais");
    // p = new Planning();
    // } catch (Exception e) {
    // e.printStackTrace();
    // return;
    // }
    // Reservation rrrr[] = { r, rr, rrr };
    // try {
    // p.ajout(rrrr);
    // } catch (ExceptionPlanning e) {
    // System.err.println(e);
    // return;
    // }
    // System.out.println(r.compareTo(rrr));
    Scanner s;
    try {
      s = new Scanner(new File("data" + File.separator + "planning.txt")).useDelimiter(",");
    } catch (FileNotFoundException e) {
      System.err.println("Fichier introuvable");
      return;
    }
    String intitule;
    Date d;
    PlageHoraire p;
    Reservation r;
    try {
      while (s.hasNext()) {
        intitule = s.next();
        d = new Date(s.nextInt(), s.nextInt(), s.nextInt());
        try {
          p = new PlageHoraire(new Horaire(s.nextInt(), s.nextInt()), new Horaire(s.nextInt(), s.nextInt()));
        } catch (Exception e) {
          e.printStackTrace();
          s.close();
          return;
        }
        try {
          r = new Reservation(d, p, intitule);
        } catch (Exception e) {
          e.printStackTrace();
          s.close();
          return;
        }
        System.out.println(r);
      }
      s.close();
    } catch (InputMismatchException e) {
      e.printStackTrace();
      s.close();
      return;
    } catch (NoSuchElementException e) {
      e.printStackTrace();
      s.close();
      return;
    } catch (IllegalStateException e) {
      e.printStackTrace();
      s.close();
      return;
    }
  }
}
