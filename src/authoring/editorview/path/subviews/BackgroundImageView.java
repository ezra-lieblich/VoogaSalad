package authoring.editorview.path.subviews;


import java.io.IOException;
import java.util.ResourceBundle;

import authoring.editorview.PhotoFileChooser;
import authoring.editorview.path.PathEditorViewDelegate;
import authoring.utilityfactories.ButtonFactory;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;
import javafx.stage.FileChooser;


public class BackgroundImageView extends PhotoFileChooser{
	
	private VBox root;
	private String backgroundImagePath;
	private PathEditorViewDelegate delegate;
	
	private static final String RESOURCE_FILE_NAME = "resources/GameAuthoringPath";	
	private ResourceBundle pathResource = ResourceBundle.getBundle(RESOURCE_FILE_NAME);
	
	private static final String DEFAULT_IMAGE_FILE_NAME = "greensquare.png";
	
	
	
	public BackgroundImageView(){
		root = new VBox();
		makeChooseImageButton();
		
		
		
	}	
	
	public Node getInstanceAsNode(){		
		return root;
		
	}
	
	public String getBackgroundImagePath(){
		return backgroundImagePath;
	}
	
	public void setDelegate(PathEditorViewDelegate delegate){
		this.delegate = delegate;
	}

	private void makeChooseImageButton(){
		Button setBackgroundImageButton = ButtonFactory.makeButton(pathResource.getString("BackgroundImageButton"), 
				e -> selectFile("Photos: ", "Select new background image"));
		root.getChildren().add(setBackgroundImageButton);
	}


	@Override
	public void openFileChooser(FileChooser chooseFile) {
		// TODO Auto-generated method stub
		
	}
	
	private ImageView loadBackgroundImage() throws IOException{
		ImageView backgroundImageView = new ImageView();		
		try {
			Image image = new Image(getClass().getClassLoader().getResourceAsStream(backgroundImagePath));
			backgroundImageView.setImage(image);
			delegate.setPathBackgroundImage(backgroundImagePath);			
		}
		catch (Exception e){
			Image defaultImage = new Image(getClass().getClassLoader().getResourceAsStream(DEFAULT_IMAGE_FILE_NAME));
			backgroundImageView.setImage(defaultImage);	
		}		
		return backgroundImageView;
		
	}

	
}
