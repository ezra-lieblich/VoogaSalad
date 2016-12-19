package authoring.utilityfactories;

import java.util.ResourceBundle;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.WritableObjectValue;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.TextField;


/**
 * Factory to create textFields required by view components
 * 
 * @author Kayla Schulz
 *
 */
public final class TextFieldFactory {

    private TextFieldFactory () {

    }

    /**
     * 
     * @param promptText
     * @param event (ActionEvent)
     * @return TextField with promptText and corresponding ActionEvent
     */
    public static TextField makeTextField (String promptText, EventHandler<ActionEvent> event) {
        TextField textField = new TextField();
        textField.setPromptText(promptText);
        textField.setOnAction(event);
        return textField;
    }

    public static TextField makeNumberTextField (String promptText,
                                                 EventHandler<ActionEvent> event) {
        TextField textField = new TextField();
        textField.setPromptText(promptText);
        textField.setOnAction(event);
        textField.textProperty().addListener( (observable, oldValue, newValue) -> {
            textField.addEventHandler(ActionEvent.ACTION, e -> testInput(textField, oldValue));
        });

        return textField;
    }

    private static void testInput (TextField textField, String oldVal) {
        try {
            Double.parseDouble(textField.getText());
        }
        catch (NumberFormatException e) {
            createDialogueBox();
            textField.setText(oldVal);
        }
    }

    private static void createDialogueBox () {
        ResourceBundle dialogueBoxResource = ResourceBundle.getBundle("resources/DialogueBox");
        DialogueBoxFactory.createErrorDialogueBox(dialogueBoxResource.getString("Integer"),
                                                  dialogueBoxResource.getString("CheckInput"));
    }

}
