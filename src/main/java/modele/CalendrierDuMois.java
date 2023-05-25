package modele;

import java.util.TreeSet;
import java.util.Collection;

/**
 * DateCalendrier collector for a specific month and year.
 * @author bferrari
 *
 */
public class CalendrierDuMois {

    private int mois;
    private int annee;
    private Collection<DateCalendrier> treeSetDate;

    public CalendrierDuMois(int mois, int annee) {
        this.mois = mois;
        this.annee = annee;
        treeSetDate = new TreeSet<DateCalendrier>();
        DateCalendrier date = new DateCalendrier(1, mois, annee);
        int indiceJour = date.getJourSemaine();
        for (int x = indiceJour; x != 0; x--) {
            treeSetDate.add(date);
            date = date.dateDeLaVeille();
        }
        date = new DateCalendrier(2, mois, annee);
        indiceJour = indiceJour % 7;
        while (date.getMois() == mois) {
            while (indiceJour < 7) {
                treeSetDate.add(date);
                date = date.dateDuLendemain();
                indiceJour++;
            }
            indiceJour = 0;
        }
    }

    /**
     * Classic getter.
     * @return dates of the month
     */
    public Collection<DateCalendrier> getDates() {
        return treeSetDate;
    }
    
    public String toString() {
        return treeSetDate.size() + " " + treeSetDate.toString();
    }

    /**
     * Classic getter.
     * @return month number
     */
    public int getMois() {
        return mois;
    }

    /**
     * Classic getter.
     * @return year
     */
    public int getAnnee() {
        return annee;
    }

}
