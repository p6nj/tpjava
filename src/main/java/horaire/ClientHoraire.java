package horaire;

public class ClientHoraire {

  /**
   * Tests the String conversion of a Horaire object.
   * 
   * @param args
   */
  public static void main(String[] args) {
    Horaire h = new Horaire(6, 45);
    System.out.println(h.toString());
    System.out.println(h.estValide().toString());
    Horaire hh = new Horaire(6, 46);
    System.out.println(hh.toString());
    System.out.println(hh.estValide().toString());
  }
}
