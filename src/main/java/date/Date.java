package date;

import java.util.Scanner;

public class Date {
  public int chJour, chMois, chAnnee;

  /**
   * Detailed Date constructor
   * 
   * @param jour
   * @param mois
   * @param annee
   */
  public Date(int jour, int mois, int annee) {
    chJour = jour;
    chMois = mois;
    chAnnee = annee;
  }

  /**
   * Minimal Date constructor
   * 
   * @param annee
   */
  public Date(int annee) {
    chJour = 1;
    chMois = 1;
    chAnnee = annee;
  }

  /**
   * Stringifies the date instance.
   * Format: DD/MM/YYYY
   * 
   * @return String
   */
  public String toString() {
    return String.format("%02d/%02d/%04d", chJour, chMois, chAnnee);
  }

  /**
   * Computes the number of days in the current month.
   * 
   * @return int
   */
  private int nbJoursDansMois() {
    if (chMois == 2) {
      return chAnnee % 4 == 0 && chAnnee % 100 != 0 || chAnnee % 400 == 0 ? 28
          : 29;
    }
    if (chMois < 8) {
      return chMois % 2 == 0 ? 30 : 31;
    }
    return chMois % 2 == 0 ? 31 : 30;
  }

  /**
   * Computes the number of days in the chosen month chMois (using the instance
   * for other fields).
   * 
   * @param chMois
   * @return int
   */
  private int nbJoursDansMois(int chMois) {
    if (chMois == 2) {
      return chAnnee % 4 == 0 && chAnnee % 100 != 0 || chAnnee % 400 == 0 ? 28
          : 29;
    }
    if (chMois < 8) {
      return chMois % 2 == 0 ? 30 : 31;
    }
    return chMois % 2 == 0 ? 31 : 30;
  }

  /**
   * Validity test for the current date.
   * Checks:
   * chJour > 0,
   * chMois > 0,
   * chAnnee > 1582,
   * chJour <= nbJoursDansMois(),
   * chMois < 13,
   * chAnnee < 10000
   * 
   * @return boolean
   */
  public boolean estValide() {
    // checks to be made on the current instance
    boolean checks[] = {
        chJour > 0,
        chMois > 0,
        chAnnee > 1582,
        chJour <= nbJoursDansMois(),
        chMois < 13,
        chAnnee < 10000
    };
    for (boolean b : checks)
      if (!b)
        return false;
    return true;
  }

  /**
   * Digitizes the date instance.
   * 
   * @return int
   */
  private int toInt() {
    return chAnnee * 10000 + chMois * 100 + chJour;
  }

  /**
   * Comparison implementation for the Date object.
   * 
   * @param other Date object
   * @return int: negative if this is inferior, positive if this is posterior, 0
   *         if
   *         same.
   */
  public int compareTo(Date other) {
    return this.toInt() - other.toInt();
  }

  /**
   * @return Date of the next day
   */
  public Date dateDuLendemain() {
    if (chJour == nbJoursDansMois()) {
      if (chMois == 12)
        return new Date(1, 1, (chAnnee + 1));
      return new Date(1, (chMois + 1), chAnnee);
    }
    return new Date((chJour + 1), chMois, chAnnee);
  }

  /**
   * @return Date of the previous day
   */
  public Date dateDeLaVeille() {
    if (chJour == 1) {
      if (chMois == 1)
        return new Date(nbJoursDansMois((chMois - 1)), 12, (chAnnee - 1));
      return new Date(nbJoursDansMois((chMois - 1)), (chMois - 1), chAnnee);
    }
    return new Date((chJour - 1), chMois, chAnnee);
  }

  /**
   * Asks for date fields in the terminal and constructs a date from it (without
   * checks).
   * 
   * @return Date
   */
  public static Date lireDate() {
    int champs[] = { 0, 0, 0 };
    String desc[] = { "Jour", "Mois", "Année" };
    Scanner s = new Scanner(System.in);
    for (int x = 0; x < 3; x++) {
      System.out.printf("%s : ", desc[x]);
      champs[x] = s.nextInt();
    }
    s.close();
    return new Date(champs[0], champs[1], champs[2]);
  }
}
