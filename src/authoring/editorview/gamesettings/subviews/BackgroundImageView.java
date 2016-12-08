package authoring.editorview.gamesettings.subviews;


import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
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
import javafx.scene.layout.HBox;
import javafx.stage.FileChooser;
import javafx.stage.Stage;


public class BackgroundImageView extends PhotoFileChooser{
	
	private HBox root;
	private String backgroundImagePath;
	private ImageView backgroundImageView;
	private Image backgroundImage;
	private PathEditorViewDelegate delegate;
	
	private static final String RESOURCE_FILE_NAME = "resources/GameAuthoringPath";	
	private ResourceBundle pathResource = ResourceBundle.getBundle(RESOURCE_FILE_NAME);
	
	private static final String DEFAULT_IMAGE_FILE_NAME = "greensquare.png";
	
	
	
	public BackgroundImageView(){
		root = new HBox(10);
		createBackgroundImage();
		makeChooseImageButton();
	}

	
	public Node getInstanceAsNode(){		
		return root;
		
	}
	
	public String getBackgroundImagePath(){
		return backgroundImagePath;
	}
	
	public Image getBackgroundImage(){
		return backgroundImage;
	}
	

	public void setDelegate(PathEditorViewDelegate delegate){
		this.delegate = delegate;
	}

	private void makeChooseImageButton(){
			Button setBackgroundImageButton = ButtonFactory.makeButton(pathResource.getString("BackgroundImageButton"), 
					e -> {
						try {
							selectFile("Photos: ", "Select new background image");
						} catch (IOException e1) {
							Alert errorDialogueBox = DialogueBoxFactory.createErrorDialogueBox("Invalid File", "Error With File");
							errorDialogueBox.show();
						}
					});
			root.getChildren().add(setBackgroundImageButton);
	}
	


	@Override
	public void openFileChooser(FileChooser chooseFile) throws IOException {
		File chosenFile = chooseFile.showOpenDialog(new Stage());
		if (chosenFile != null){
			BufferedImage image = ImageIO.read(chosenFile) ;
			backgroundImagePath = chosenFile.getPath();	
			createBackgroundImage();
		}	
	}
	
	
	private void createBackgroundImage() {	
		try {
			backgroundImage = new Image(backgroundImagePath);
					
		}
		catch (Exception e){
			backgroundImage = new Image(getClass().getClassLoader().getResourceAsStream(DEFAULT_IMAGE_FILE_NAME));
		}		
		
		
	}

	
}
