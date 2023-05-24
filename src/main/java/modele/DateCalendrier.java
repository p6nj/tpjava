package modele;

import java.io.Serializable;
import java.util.Calendar;

public class DateCalendrier extends Date implements ConstantesCalendrier, Comparable<Date>, Serializable {
  private int chJourSem;
  private int chNumSem;

  /**
   * Sets the date as the current date.
   */
  public DateCalendrier() {
    super(0);
    Calendar today = Calendar.getInstance();
    chAnnee = today.get(Calendar.YEAR);
    chMois = today.get(Calendar.MONTH) + 1;
    chJour = today.get(Calendar.DAY_OF_MONTH);
    chNumSem = today.get(Calendar.WEEK_OF_YEAR);
    if ((chJourSem = today.get(Calendar.DAY_OF_WEEK) - 1) == 0)
      chJourSem = 7;
  }

  /**
   * Main constructor.
   * @param parJ: day of the month 
   * @param parM: month
   * @param parA: year
   */
  public DateCalendrier(int parJ, int parM, int parA) {
    super(parJ, parM, parA);
    Calendar day = Calendar.getInstance();
    day.set(parA, parM - 1, parJ);
    if ((chJourSem = day.get(Calendar.DAY_OF_WEEK) - 1) == 0)
      chJourSem = 7;
    chNumSem = day.get(Calendar.WEEK_OF_YEAR);
  }

  @Override
  public String toString() {
    return String.format("%s %d %s %d", JOURS_SEMAINE[chJourSem - 1], chJour, MOIS[chMois - 1], chAnnee);
  }

  /**
   * @return tomorrow's date
   */
  @Override
  public DateCalendrier dateDuLendemain() {
    Date sup = new Date(chJour, chMois, chAnnee).dateDuLendemain();
    return new DateCalendrier(sup.chJour, sup.chMois, sup.chAnnee);
  }

  /**
   * @return yesterday's date
   */
  @Override
  public DateCalendrier dateDeLaVeille() {
    Date sup = super.dateDeLaVeille();
    return new DateCalendrier(sup.chJour, sup.chMois, sup.chAnnee);
  }

  /**
   * Classic getter.
   * @return day of the week (from 1)
   */
  public int getJourSemaine() {
    return chJourSem;
  }

  /**
   * Classic getter.
   * @return week number
   */
  public int getNumeroSemaine() {
    return chNumSem;
  }
}
