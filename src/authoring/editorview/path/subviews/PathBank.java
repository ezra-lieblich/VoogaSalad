package authoring.editorview.path.subviews;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.ScrollPane;
import javafx.stage.FileChooser;

import java.util.ResourceBundle;

import authoring.editorview.PhotoFileChooser;

public class PathBank extends PhotoFileChooser {
	
	private ScrollPane pathBank;
	private ResourceBundle pathResource;
	
	
	
	
	public PathBank(ResourceBundle pathResource){
		this.pathBank = new ScrollPane();
		this.pathResource = pathResource;
		buildViewComponents();	   
	}


	private void buildViewComponents() {
		//TODO: Fix event
		Button createWeaponButton =
	                createButton(pathResource.getString("NewPathButton"),
	                             e -> selectFile("Photos: ", "Select new path image"));
		
	    pathBank.setContent(createWeaponButton);
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
