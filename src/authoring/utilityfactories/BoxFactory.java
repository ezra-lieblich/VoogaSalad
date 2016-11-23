package authoring.utilityfactories;

import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;


public class BoxFactory {

    public BoxFactory () {

    }

    public static HBox createHBox (String labelString, TextField textField) {
        HBox box = new HBox(5);
        Label label = new Label(labelString);
        box.getChildren().addAll(label, textField);
        return box;
    }

}
