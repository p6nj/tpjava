package vue;

import java.io.File;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class PremiereApplication extends Application {

    public void start(Stage stage) {
        stage.setTitle("Sélectionnez une date");
        stage.setWidth(300);
        stage.setHeight(500);
        stage.centerOnScreen();
        stage.setResizable(false);
        Scene scene = new Scene(new VBoxRoot());
        stage.setScene(scene);

        File css = new File("css" + File.separator + "premiersStyles.css");
        scene.getStylesheets().add(css.toURI().toString());

        stage.show();
    }

    public static void main(String[] args) {
        Application.launch();
    }

}