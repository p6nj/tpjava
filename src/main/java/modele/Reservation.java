package modele;

public class Reservation implements Comparable<Reservation> {
  private Date date;
  private PlageHoraire plage;
  private String label;

  /**
   * Detailed Reservation constructor.
   * 
   * @param date
   * @param plage
   * @param label
   */
  public Reservation(Date date, PlageHoraire plage, String label) throws Exception {
    this.date = date;
    this.plage = plage;
    this.label = label;
    if (!estValide())
      throw new Exception();
  }

  /**
   * Stringifies the Reservation instance.
   * 
   * @return String (format: "%s le %s : %s.", label, date.toString(),
   *         plage.toString())
   */
  public String toString() {
    return String.format("%s le %s, %s.", label.isBlank() ? "[SANS NOM]" : label, date.toString(), plage.toString());
  }

  /**
   * compareTo implementation for Reservation using Date.compareTo and
   * PlageHoraire.compareTo.
   * 
   * @param other
   * @return int (<0 if this is inferior, >0 if this is superior, 0 if same)
   */
  public int compareTo(Reservation other) {
    return date.compareTo(other.date) == 0 ? plage.compareTo(other.plage) : date.compareTo(other.date);
  }

  /**
   * Validity test for the Reservation instance using PlageHoraire.estValide and
   * Date.estValide.
   * Also checks if the label isn't empty.
   * 
   * @return
   */
  public boolean estValide() {
    return plage.estValide() && label != "" && date.estValide();
  }

  /**
   * @return the date field
   */
  public Date getDate() {
    return date;
  }

  public String getLabel() {
    return label;
  }
}
