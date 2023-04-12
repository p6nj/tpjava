package modele;

import java.util.Scanner;

public class PlageHoraire implements Comparable<PlageHoraire> {
    private final static int Minimum = 15;
    private Horaire start, end;

    public PlageHoraire(Horaire start, Horaire end) throws Exception {
        this.start = start;
        this.end = end;
        if (!estValide())
            throw new Exception("Horaire invalide.");
    }

    /**
     * Stringifies the PlageHoraire instance.
     * <p>
     * Format: START - END, durée : DUREE
     * <p>
     * START and END are formatted using horaire.Horaire.toString(), DUREE uses
     * horaire.Duree.toString().
     * 
     * @return String
     */
    public String toString() {
        return String.format("%s - %s (%s)", start.toString(), end.toString(), duree().toString());
    }

    /**
     * Validity test for the PlageHoraire instance calling the Horaire sub-class
     * estValide() function.
     * 
     * @return Boolean
     */
    public Boolean estValide() {
        return start.estValide() && end.estValide() && end.compareTo(start) > 0
                && end.toMinutes() - start.toMinutes() >= Minimum;
    }

    /**
     * @return Duree (length in minutes)
     */
    private Duree duree() {
        return new Duree(end.toMinutes() - start.toMinutes());
    }

    /**
     * @param other
     * @return int: <0 if this is inferior, >0 if this is superior, 0 if both have
     *         some time in common.
     */
    public int compareTo(PlageHoraire other) {
        return end.compareTo(other.start) < 0 ? -1 : start.compareTo(other.end) > 0 ? 1 : 0;
    }

    /**
     * Helps constructing a PlageHoraire object using a Scanner. Asks for a
     * beginning Horaire and an ending Horaire.
     * 
     * @return PlageHoraire
     */
    public static PlageHoraire lireHoraire() throws Exception {
        Horaire debut, fin;
        int h, m;
        Scanner s = new Scanner(System.in);
        System.out.printf("Heure de début : ");
        h = s.nextInt();
        System.out.printf("Quart d'heure de début : ");
        m = s.nextInt();
        debut = new Horaire(h, m);
        System.out.println(debut.toString());
        System.out.printf("Heure de fin : ");
        h = s.nextInt();
        System.out.printf("Quart d'heure de fin : ");
        m = s.nextInt();
        fin = new Horaire(h, m);
        System.out.println(fin.toString());
        s.close();
        try {
            return new PlageHoraire(debut, fin);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new PlageHoraire(debut, fin);
    }
}
