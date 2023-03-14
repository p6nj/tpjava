package horaire;

public class ClientPlageHoraire {

  /**
   * Tests the String conversion of a PlageHoraire object.
   * 
   * @param args
   */
  public static void main(String[] args) {
    try {
      Horaire h = new Horaire(8, 30);
      Horaire hh = new Horaire(10, 30);
      PlageHoraire hhh = new PlageHoraire(h, hh);
      System.out.println(hhh.toString());

      Horaire h2 = new Horaire(11, 0);
      Horaire hh2 = new Horaire(11, 30);
      PlageHoraire hhh2 = new PlageHoraire(h2, hh2);
      System.out.println(hhh2.toString());

      System.out.println(hhh.compareTo(hhh2));
    } catch (Exception e) {
      e.printStackTrace();
    }
  }
}