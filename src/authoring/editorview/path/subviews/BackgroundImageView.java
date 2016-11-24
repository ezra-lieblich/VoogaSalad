package authoring.editorview.path.subviews;


import java.awt.image.BufferedImage;
import java.io.File;
import java.util.ResourceBundle;
import javax.imageio.ImageIO;

import authoring.editorview.PhotoFileChooser;
import authoring.editorview.path.PathEditorViewDelegate;
import authoring.utilityfactories.ButtonFactory;
import authoring.utilityfactories.DialogueBoxFactory;
import javafx.scene.Node;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;
import javafx.stage.FileChooser;
import javafx.stage.Stage;


public class BackgroundImageView extends PhotoFileChooser{
	
	private VBox root;
	private String backgroundImagePath;
	private ImageView backgroundImageView;
	private PathEditorViewDelegate delegate;
	
	private static final String RESOURCE_FILE_NAME = "resources/GameAuthoringPath";	
	private ResourceBundle pathResource = ResourceBundle.getBundle(RESOURCE_FILE_NAME);
	
	private static final String DEFAULT_IMAGE_FILE_NAME = "greensquare.png";
	
	
	
	public BackgroundImageView(){
		root = new VBox(10);
		makeChooseImageButton();
		formatBackgroundImageView();
		addBackgroundImageView();	
	}

	private void formatBackgroundImageView() {
		backgroundImageView = new ImageView();
		backgroundImageView.setFitHeight(100);
		backgroundImageView.setFitWidth(100);
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
		File chosenFile = chooseFile.showOpenDialog(new Stage());
		if (chosenFile != null){
			try {
				BufferedImage image = ImageIO.read(chosenFile) ;
				backgroundImagePath = chosenFile.getPath();
				addBackgroundImageView();
				
			}
			catch(Exception e){
				Alert errorDialogueBox = DialogueBoxFactory.displayErrorDialogueBox("Invalid File", "Error With File");
				errorDialogueBox.show();
			}
		}
		
		
	}
	
	
	private void addBackgroundImageView() {
		if (root.getChildren().contains(backgroundImageView)){
			root.getChildren().remove(backgroundImageView);
		}
		backgroundImageView = loadBackgroundImage();
		root.getChildren().add(backgroundImageView);
	}
	
	private ImageView loadBackgroundImage() {	
		try {
			Image image = new Image(backgroundImagePath);
			backgroundImageView.setImage(image);
			delegate.onUserEnteredBackgroundImage(backgroundImagePath);			
		}
		catch (Exception e){
			Image defaultImage = new Image(getClass().getClassLoader().getResourceAsStream(DEFAULT_IMAGE_FILE_NAME));
			backgroundImageView.setImage(defaultImage);	
		}		
		return backgroundImageView;
		
	}

	
}
