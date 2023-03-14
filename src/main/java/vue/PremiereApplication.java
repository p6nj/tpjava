package vue;

import java.io.File;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class PremiereApplication extends Application {

    public void start(Stage stage) {
        stage.setTitle("Hello JavaFX");
        stage.setWidth(400);
        stage.setHeight(150);
        stage.centerOnScreen();
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