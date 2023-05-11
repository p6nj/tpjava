package modele;

public interface ConstantesErreur {
  public final String[] ERREURS_PLANNING = {
      "Réservation invalide",
      "Planning complet",
      "Réservation incompatible"
  };
  public final int ERRINV = 0, ERRFUL = 1, ERRINC = 2;
}
