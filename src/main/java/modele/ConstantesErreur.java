package modele;

/**
 * String and integer representations for reservation errors.
 * @author bferrari
 *
 */
public interface ConstantesErreur {
  public final String[] ERREURS_PLANNING = {
      "Réservation invalide",
      "Réservation incompatible"
  };
  public final int ERRINV = 0, ERRINC = 1;
}
