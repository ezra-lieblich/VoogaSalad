package authoring.utilityfactories;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.TextField;


public class TextFieldFactory {

    public TextFieldFactory () {

    }

    public static TextField makeTextField (String promptText, EventHandler<ActionEvent> event) {
        TextField textField = new TextField();
        textField.setPromptText(promptText);
        textField.setOnAction(event);
        return textField;
    }

}
