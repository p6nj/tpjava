package modele;

public class ExceptionPlanning extends Exception implements ConstantesErreur {
  private int chCodeErreur;

  public ExceptionPlanning(int code) {
    super();
    chCodeErreur = code;
  }

  public int getCodeErreur() {
    return chCodeErreur;
  }

  @Override
  public String toString() {
    return ERREURS_PLANNING[chCodeErreur];
  }
}
