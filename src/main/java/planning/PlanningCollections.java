package planning;

import java.util.ArrayList;
import java.util.TreeMap;
import java.util.TreeSet;

import date.Date;
import date.DateCalendrier;
import reservation.Reservation;

public class PlanningCollections {
    private ArrayList<Reservation> arrl;
    private TreeSet<Reservation> tree;
    private TreeMap<Integer, Reservation> tmap;

    /**
     * Classic blank constructor
     */
    public PlanningCollections() {
        arrl = new ArrayList<Reservation>();
        tree = new TreeSet<Reservation>();
        tmap = new TreeMap<Integer, Reservation>();
    }

    /**
     * toString implementation for PlanningCollections. Format: ArrayList =
     * ARRAYLIST (SIZE), TreeSet = TREESET (SIZE), TreeMap = TREEMAP (SIZE)
     * 
     * @return String
     */
    public String toString() {
        return String.format("ArrayList = %s (%d), TreeSet = %s (%d), TreeMap = %s (%d)", arrl, arrl.size(), tree,
                tree.size(), tmap, tmap.size());
    }

    /**
     * Adds a Reservation (r) to the ArrayList, the TreeSet and the TreeMap objects.
     * 
     * @param r
     */
    public void ajout(Reservation r) {
        arrl.add(r);
        tree.add(r);
        Date d = r.getDate();
        DateCalendrier dc = new DateCalendrier(d.chJour, d.chMois, d.chAnnee);
        tmap.put(dc.chJourSem, r);
    }

    /**
     * Gets all the Reservations of the TreeSet where the Date corresponds to
     * parDate in another TreeSet.
     * 
     * @param parDate
     * @return TreeSet<Reservation>
     */
    public TreeSet<Reservation> getReservations(DateCalendrier parDate) {
        TreeSet<Reservation> result = new TreeSet<Reservation>();
        boolean ok = false;
        for (Reservation r : tree) {
            if (ok) {
                if (r.getDate().compareTo(parDate) != 0)
                    break;
                result.add(r);
            } else if (r.getDate().compareTo(parDate) == 0) {
                ok = true;
                result.add(r);
            }
        }
        if (result.isEmpty())
            result = null;
        return result;
    }

    /**
     * Gets all the Reservations of the TreeSet where the label corresponds to
     * parString in another TreeSet.
     * 
     * @param parString
     * @return TreeSet<Reservation>
     */
    public TreeSet<Reservation> getReservations(String parString) {
        TreeSet<Reservation> result = new TreeSet<Reservation>();
        for (Reservation r : tree) {
            if (r.getLabel().contains(parString))
                result.add(r);
        }
        return result;
    }
}