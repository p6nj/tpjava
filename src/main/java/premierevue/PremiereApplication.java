package premierevue;

import javafx.application.Application;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class PremiereApplication extends Application {

    public void start(Stage stage) {
        stage.setTitle("Hello JavaFX");
        stage.setWidth(400);
        stage.setHeight(150);
        stage.centerOnScreen();
        stage.setScene(new PremiereScene(new VBox()));
        stage.show();
    }

    public static void main(String[] args) {
        Application.launch();
    }

}