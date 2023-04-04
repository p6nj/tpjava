package vue;

import java.io.File;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Projet2Application extends Application {

    public void start(Stage stage) {
        stage.setWidth(650);
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