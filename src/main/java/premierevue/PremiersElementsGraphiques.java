package premierevue;

import javafx.scene.control.Label;
import javafx.scene.layout.VBox;

public class PremiersElementsGraphiques extends PremiereScene {
    private VBox root;

    public PremiersElementsGraphiques(VBox root) {
        super(root);
        this.root = root;
        ajouteDeuxLabels();
    }

    private void ajouteDeuxLabels() {
        root.getChildren().addAll(new Label("Premier label"), new Label("Second label"));
    }
}
