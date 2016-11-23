package authoring.utilityfactories;

import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.ComboBox;


/**
 * Factory to create comboboxes required by view components
 * 
 * @author Kayla Schulz
 *
 */
public class ComboBoxFactory {

    public ComboBoxFactory () {

    }

    /**
     * 
     * @param promptText
     * @param event (ActionEvent)
     * @param options
     * @return generic comboBox with promptText, corresponding event, and list options
     */
    public static ComboBox<Object> makeComboBox (String promptText,
                                                 EventHandler<ActionEvent> event,
                                                 ObservableList<Object> options) {
        ComboBox<Object> combobox = new ComboBox<Object>(options);
        combobox.setOnAction(event);
        combobox.setPromptText(promptText);
        return combobox;
    }

}
