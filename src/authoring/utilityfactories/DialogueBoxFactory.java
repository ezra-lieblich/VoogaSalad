package authoring.utilityfactories;

import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

/**
 * 
 * @author Diane Hadley
 *
 */

public class DialogueBoxFactory {
	
	
	
	/**
	 * Creates a dialogue box that describes the error
	 * 
	 * @param error
	 * @return Alert with error
	 * 
	 */
	public static Alert createErrorDialogueBox(String error, String title){
		Alert dialogueBox = new Alert(AlertType.ERROR);
		dialogueBox.setTitle(title);
		dialogueBox.setContentText(error);
		return dialogueBox;
		
	};

}
