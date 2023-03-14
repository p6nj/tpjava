package date;

import java.util.Arrays;

public class ClientDateCalendrier {
  public static void main() {
    System.out.println(new DateCalendrier().dateDeLaVeille());
    DateCalendrier[] table = { new DateCalendrier(1, 2, 2020), new DateCalendrier(), new DateCalendrier(7, 12, 1948) };
    System.out.println(table[0]);
    Arrays.sort(table);
    System.out.println(table[0]);
  }
}
