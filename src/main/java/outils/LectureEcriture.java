package outils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class LectureEcriture {
    /**
     * Lit un objet d'un fichier.
     * 
     * @param file
     * @return read object
     */
    public static Object lecture(File file) {
        ObjectInputStream flux;
        Object readObject = null;
        try {
            flux = new ObjectInputStream(new FileInputStream(file));
            readObject = flux.readObject();
            flux.close();
        } catch (ClassNotFoundException parException) {
            System.err.println(parException.toString());
            System.exit(1);
        } catch (IOException exception) {
            System.err.println("Erreur lecture du fichier " + exception.toString());
            System.exit(1);

        }
        return readObject;
    }

    /**
     * Ecrit un objet dans un fichier.
     * 
     * @param file
     * @param object
     */
    public static void ecriture(File file, Object object) {
        ObjectOutputStream flux = null;
        try {
            flux = new ObjectOutputStream(new FileOutputStream(file));
            flux.writeObject(object);
            flux.flush();
            flux.close();
        } catch (IOException parException) {
            System.err.println("Problème à l'écriture\n" + parException.toString());
            System.exit(1);
        }
    }
}
