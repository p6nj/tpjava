package modele;

public class ExceptionPlanning extends Exception implements ConstantesErreur {
  private int chCodeErreur;

  /**
   * Constructs the exception from the error code.
   * @param error code
   */
  public ExceptionPlanning(int code) {
    super();
    chCodeErreur = code;
  }

  /**
   * @return error code
   */
  public int getCodeErreur() {
    return chCodeErreur;
  }

  /**
   * Interprets the error message from the error code.
   * @return error message
   * @see ConstantesErreur#ERREURS_PLANNING
   */
  @Override
  public String toString() {
    return ERREURS_PLANNING[chCodeErreur];
  }
}
