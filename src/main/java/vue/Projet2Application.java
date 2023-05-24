package vue;

import java.io.File;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * Application launcher.
 * @author bferrari
 *
 */
public class Projet2Application extends Application {

	/**
	 * Starts the application.
	 */
    public void start(Stage stage) {
        stage.setWidth(1350);
        stage.setHeight(400);
        stage.centerOnScreen();
        Scene scene = new Scene(new HBoxRoot());
        stage.setScene(scene);
        stage.setTitle("Calendrier du mois");

        File css = new File("css" + File.separator + "premiersStyles.css");
        scene.getStylesheets().add(css.toURI().toString());

        stage.show();
    }

    public static void main(String[] args) {
        Application.launch(args);
    }

}