package authoring.utilityfactories;

import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.ComboBox;


public class ComboBoxFactory {

    public ComboBoxFactory () {

    }

    public static ComboBox<Object> makeComboBox (String name,
                                          EventHandler<ActionEvent> event,
                                          ObservableList<Object> options) {
        ComboBox<Object> combobox = new ComboBox<Object>(options);
        combobox.setOnAction(event);
        combobox.setPromptText(name);
        return combobox;
    }

}
