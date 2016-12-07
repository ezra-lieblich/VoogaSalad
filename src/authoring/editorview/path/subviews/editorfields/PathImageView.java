package authoring.editorview.path.subviews.editorfields;

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


public class PathImageView extends PhotoFileChooser{

	private HBox root;
	private String pathImagePath;
	private ImageView pathImageView;
	private PathEditorViewDelegate delegate;
	
	private static final String RESOURCE_FILE_NAME = "resources/GameAuthoringPath";	
	private ResourceBundle pathResource = ResourceBundle.getBundle(RESOURCE_FILE_NAME);
	
	public PathImageView(){
		root = new HBox(10);
		makeChooseImageButton();
		formatPathImageView();
	}
	
	public Node getInstanceAsNode(){		
		return root;
		
	}
	
	
	private void makeChooseImageButton(){
		Button setPathImageButton = ButtonFactory.makeButton(pathResource.getString("PathImageButton"), 
				e -> {
					try {
						selectFile("Photos: ", "Select new path image");
					} catch (IOException e1) {
						Alert errorDialogueBox = DialogueBoxFactory.createErrorDialogueBox("Invalid File", "Error With File");
						errorDialogueBox.show();
					}
				});
		setPathImageButton.setTranslateY(5);
		root.getChildren().add(setPathImageButton);
	}

	@Override
	public void openFileChooser(FileChooser chooseFile) throws IOException {
		File chosenFile = chooseFile.showOpenDialog(new Stage());
		if (chosenFile != null){
			BufferedImage image = ImageIO.read(chosenFile) ;
			pathImagePath = chosenFile.toURI().toString();
			delegate.onUserEnteredPathImage(pathImagePath);
				
			
		}
	}
	
	
	public String getPathImagePath(){
		return pathImagePath;
	}
	
	public void setPathImagePath(String imagePath){
		this.pathImagePath = imagePath;
		addImageView();
		
	}
	
	private void formatPathImageView() {
		pathImageView = new ImageView();
		pathImageView.setFitHeight(100);
		pathImageView.setFitWidth(100);
	}	
	
	private void addImageView() {
		
		Image image;
		if (root.getChildren().contains(pathImageView)){
			root.getChildren().remove(pathImageView);
		}
		
		if (!pathImagePath.contains("file:") && !pathImagePath.contains("http:")) {
			image = new Image (getClass().getClassLoader().getResourceAsStream(pathImagePath));		
		}
		
		else {
			image = new Image(pathImagePath);
		}
			
		pathImageView.setImage(image);
		root.getChildren().add(pathImageView);
	
		
	}
	
	
	public void setDelegate(PathEditorViewDelegate delegate){
		this.delegate = delegate;
	}


//	private void loadPathImage() {	
//		try {
//			Image image = new Image(pathImagePath);
//			pathImageView.setImage(image);
//			delegate.onUserEnteredPathImage(activePathID, pathImagePath);			
//		}
//		catch (Exception e){
//			Alert errorDialogueBox = DialogueBoxFactory.createErrorDialogueBox("Invalid image.", "Error With Image");
//			errorDialogueBox.show();
//		}		
//		
//	}
	
	
}
