package modele;

public class Capitalize {
    public static String toTitleCase(String str) {
        StringBuilder sb = new StringBuilder(str.length());
        sb.append(str.substring(0, 1).toUpperCase())
                .append(str.substring(1).toLowerCase());
        return sb.toString();
    }
}
