package tp;

import horaire.ClientPlageHoraire;
import horaire.PlageHoraire;
import planning.ClientPlanning;
import planning.ClientPlanningCollections;
import date.ClientDateCalendrier;
import date.Date;

public class Main {

    private static void testDate() {
        System.out.println("Entrez une date ci-dessous.");
        Date d = Date.lireDate();
        if (!d.estValide()) {
            System.err.println("Date invalide.");
            return;
        }
        System.out.printf("Aujourd'hui on est le %s, demain on sera le %s et hier on était le %s.\n", d.toString(),
                d.dateDuLendemain().toString(), d.dateDeLaVeille().toString());
    }

    private static void testPlage() throws Exception {
        System.out.println("Entrez une plage horaire ci-dessous.");
        PlageHoraire p;
        try {
            p = PlageHoraire.lireHoraire();
        } catch (Exception e) {
            e.printStackTrace();
            return;
        }
        if (!p.estValide()) {
            System.err.println("Plage invalide.");
            return;
        }
        System.out.printf("Horaire généré : %s.\n", p.toString());
    }

    private static void testPlanning() {
        ClientPlanning.main();
    }

    private static void testPlanningCollections() {
        ClientPlanningCollections.main();
    }

    private static void testPlageAuto() {
        ClientPlageHoraire.main(null);
    }

    private static void testDateCalendrier() {
        ClientDateCalendrier.main();
    }

    /**
     * Main program. Used to test various objects.
     * 
     * @param args
     */
    public static void main(String[] args) {
        testPlanningCollections();
    }
}
