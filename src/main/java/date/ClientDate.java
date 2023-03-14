package date;

public class ClientDate {
  /**
   * Testing toString method of the Date object
   */
  public static void main() {
    Date d = new Date(3, 11, 2004);
    Date dd = new Date(2004);
    System.out.println(d.toString());
    System.out.println(dd.toString());
  }
}
