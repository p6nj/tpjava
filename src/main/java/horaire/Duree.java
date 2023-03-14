package horaire;

public class Duree extends Horaire {

  /**
   * Detailed Duree constructor
   * 
   * @param heure
   * @param quartHeure
   */
  public Duree(int heure, int quartHeure) {
    super(heure, quartHeure);
  }

  /**
   * Minimal Duree constructor
   * 
   * @param minutes
   */
  public Duree(int minutes) {
    super((int) (minutes / 60), minutes % 60);
  }

  /**
   * Stringifies the Duree instance.
   * Format: "HhMM" if the hour is not 0 else "M".
   * 
   * @return String
   */
  @Override
  public String toString() {
    if (super.getHeure() == 0)
      return String.format("%dmn", super.getQuartHeure());
    if (super.getQuartHeure() == 0)
      return String.format("%dh", super.getHeure());
    return String.format("%dh%02dmn", super.getHeure(), super.getQuartHeure());
  }

  /**
   * Simple validation tests for the quartHeure field
   * 
   * @return Boolean
   */
  @Override // All we want is this not to be zero or less
  public Boolean quartEstValide() {
    if (super.getQuartHeure() < 0)
      return false;
    return true;
  }

  /**
   * Simple validation tests for the heure field
   */
  @Override // All we want is this not being zero or less
  public Boolean heureEstValide() {
    if (super.getHeure() < 0)
      return false;
    return true;
  }

}
