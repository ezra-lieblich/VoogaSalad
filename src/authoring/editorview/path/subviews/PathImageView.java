package authoring.editorview.path.subviews;

import java.util.ResourceBundle;

import authoring.editorview.PhotoFileChooser;
import authoring.utilityfactories.ButtonFactory;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.stage.FileChooser;

public class PathImageView extends PhotoFileChooser{

	private VBox root;
	
	private static final String RESOURCE_FILE_NAME = "resources/GameAuthoringPath";	
	private ResourceBundle pathResource = ResourceBundle.getBundle(RESOURCE_FILE_NAME);
	
	public PathImageView(){
		root = new VBox();
		makeSetImageButton();
	}
	
	public Node getInstanceAsNode(){
		
		return root;
		
	}
	
	private void makeSetImageButton(){
		Button setBackgroundImageButton = ButtonFactory.makeButton(pathResource.getString("PathImageButton"), 
				e -> selectFile("Photos: ", "Select new path image"));
		root.getChildren().add(setBackgroundImageButton);
	}

	@Override
	public void openFileChooser(FileChooser chooseFile) {
		// TODO Auto-generated method stub
		
	}
}
