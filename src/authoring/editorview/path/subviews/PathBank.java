package authoring.editorview.path.subviews;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Node;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ScrollPane;
import javafx.stage.FileChooser;

import java.io.IOException;
import java.util.ResourceBundle;

import authoring.editorview.PhotoFileChooser;
import authoring.utilityfactories.DialogueBoxFactory;

public class PathBank extends PhotoFileChooser {
	
	private ScrollPane pathBank;
	
	
	private static final String RESOURCE_FILE_NAME = "resources/GameAuthoringPath";	
	private ResourceBundle pathResource = ResourceBundle.getBundle(RESOURCE_FILE_NAME);
	
	
	public PathBank(){
		this.pathBank = new ScrollPane();
		pathBank.setPrefHeight(640);
		pathBank.setPrefWidth(135);
		buildViewComponents();	   
	}


	private void buildViewComponents() {
		//TODO: Fix event
		Button createWeaponButton =
				createButton(pathResource.getString("NewPathButton"),
                 e -> {
					try {
						selectFile("Photos: ", "Select new path image");
					} catch (IOException e1) {
						Alert errorDialogueBox = 
								DialogueBoxFactory.createErrorDialogueBox("Invalid File", "Error With File");
						errorDialogueBox.show();
					}
				});
		
	    pathBank.setContent(createWeaponButton);
	    createWeaponButton.setTranslateY(5);
	    createWeaponButton.setTranslateX(5);
	    createWeaponButton.setFocusTraversable(false);
	}
	
	 
    private Button createButton (String label, EventHandler<ActionEvent> event) {
        Button button = new Button(label);
        button.setOnAction(event);
        return button;
    }
	
	public Node getInstanceAsNode () {
		return pathBank;
	}
	
	public void updatePathBank(){
		
	}


	@Override
	public void openFileChooser(FileChooser chooseFile) {
		// TODO Auto-generated method stub
		
	}

	
	
}
