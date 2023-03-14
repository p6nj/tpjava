package horaire;

public class Horaire implements Comparable<Horaire> {
    private int heure, quartHeure;

    /**
     * Detailed Horaire constructor
     * 
     * @param heure
     * @param quartHeure
     */
    public Horaire(int heure, int quartHeure) {
        this.heure = heure;
        this.quartHeure = quartHeure;
    }

    /**
     * Merge the heure and quartHeure fields into a single variable of the total
     * length in minutes.
     * 
     * @return int
     */
    public int toMinutes() {
        return heure * 60 + quartHeure;
    }

    /**
     * @return int (heure field)
     */
    public int getHeure() {
        return heure;
    }

    /**
     * @return int (quartHeure field)
     */
    public int getQuartHeure() {
        return quartHeure;
    }

    /**
     * heure field modifier
     * 
     * @param heure
     */
    public void setHeure(int heure) {
        this.heure = heure;
    }

    /**
     * quartHeure field modifier
     * 
     * @param quartHeure
     */
    public void setQuartHeure(int quartHeure) {
        this.quartHeure = quartHeure;
    }

    /**
     * Stringifies the Horaire instance.
     * 
     * @return String (format: "%02dh%02d", heure, quartHeure)
     */
    public String toString() {
        return String.format("%02dh%02d", heure, quartHeure);
    }

    /**
     * Validity test for the quartHeure field.
     * Checks:
     * quartHeure % 15 == 0,
     * quartHeure < 60,
     * quartHeure >= 0
     * 
     * @return
     */
    protected Boolean quartEstValide() {
        Boolean tests[] = {
                quartHeure % 15 == 0,
                quartHeure < 60,
                quartHeure >= 0
        };
        for (Boolean test : tests) {
            if (!test)
                return false;
        }
        return true;
    }

    /**
     * Validity test for the heure field.
     * Checks:
     * heure < 24,
     * heure >= 0
     * 
     * @return
     */
    protected Boolean heureEstValide() {
        Boolean tests[] = {
                heure < 24,
                heure >= 0
        };
        for (Boolean test : tests) {
            if (!test)
                return false;
        }
        return true;
    }

    /**
     * Validity check for the Horaire instance using heureEstValide() and
     * quartEstValide().
     * Checks:
     * quartHeure % 15 == 0,
     * quartHeure < 60,
     * quartHeure >= 0,
     * heure < 24,
     * heure >= 0
     * 
     * @return
     */
    public Boolean estValide() {
        return quartEstValide() && heureEstValide();
    }

    /**
     * Comparison implementation for the Date object.
     * 
     * @param other Horaire object
     * @return int: negative if the other is posterior, positive if inferior, 0 if
     *         same.
     */
    public int compareTo(Horaire other) {
        return this.toMinutes() - other.toMinutes();
    }
}
