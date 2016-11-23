package authoring.utilityfactories;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;

public class ButtonFactory {
    
    public ButtonFactory () {
        
    }

    public static Button makeButton (String buttonText, EventHandler<ActionEvent> event) {
        Button button = new Button(buttonText);
        button.setOnAction(event);
        return button;
    }
    
}
