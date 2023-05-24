package modele;

import java.io.Serializable;

public class Reservation implements Comparable<Reservation>, Serializable {
  private Date date;
  private PlageHoraire plage;
  private String label;
  private String niveau;

  /**
   * Detailed Reservation constructor.
   * 
   * @param date
   * @param plage
   * @param label
   */
  public Reservation(Date date, PlageHoraire plage, String label, String niveau) throws Exception {
    this.date = date;
    this.plage = plage;
    this.label = label;
    this.niveau = niveau;
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
   * Classic getter.
   * @return the date field
   */
  public Date getDate() {
    return date;
  }

  /**
   * Classic getter.
   * @return the label field
   */
  public String getLabel() {
    return label;
  }

  /**
   * Classic getter.
   * @return the level field
   */
  public String getNiveau() {
    return niveau;
  }

  /**
   * Classic getter.
   * @return the plage field (time slots)
   */
  public PlageHoraire getPlage() {
    return plage;
  }

  /**
   * Classic getter.
   * @return the duree field (duration)
   */
  public Duree getDuree() {
    return plage.duree();
  }
}
