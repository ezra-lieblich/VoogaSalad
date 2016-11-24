package authoring.editorview.path.subviews;

import java.util.ResourceBundle;

import authoring.editorview.PhotoFileChooser;
import authoring.utilityfactories.ButtonFactory;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.layout.HBox;
import javafx.stage.FileChooser;


public class BackgroundImageView extends PhotoFileChooser{
	
	private HBox root;
	
	private static final String RESOURCE_FILE_NAME = "resources/GameAuthoringPath";	
	private ResourceBundle pathResource = ResourceBundle.getBundle(RESOURCE_FILE_NAME);
	
	public BackgroundImageView(){
		root = new HBox();
		makeSetImageButton();
	}
	
	
	public Node getInstanceAsNode(){
		
		return root;
		
	}
//	
//	public Image getBackgroundImage(){
//		Image i = new Image();
//		return i;
//	}

	private void makeSetImageButton(){
		Button setBackgroundImageButton = ButtonFactory.makeButton(pathResource.getString("BackgroundImageButton"), 
				e -> selectFile("Photos: ", "Select new background image"));
		root.getChildren().add(setBackgroundImageButton);
	}


	@Override
	public void openFileChooser(FileChooser chooseFile) {
		// TODO Auto-generated method stub
		
	}
	
}
