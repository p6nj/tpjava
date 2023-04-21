package modele;

import java.util.Calendar;

public class DateCalendrier extends Date implements ConstantesCalendrier, Comparable<Date> {
  private int chJourSem;
  private int chNumSem;

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

  @Override
  public DateCalendrier dateDuLendemain() {
    Date sup = new Date(chJour, chMois, chAnnee).dateDuLendemain();
    return new DateCalendrier(sup.chJour, sup.chMois, sup.chAnnee);
  }

  @Override
  public DateCalendrier dateDeLaVeille() {
    Date sup = super.dateDeLaVeille();
    return new DateCalendrier(sup.chJour, sup.chMois, sup.chAnnee);
  }

  public int getJourSemaine() {
    return chJourSem;
  }

  public int getNumeroSemaine() {
    return chNumSem;
  }
}
