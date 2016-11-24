package authoring.editorview.path.subviews;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.ResourceBundle;

import javax.imageio.ImageIO;

import authoring.editorview.PhotoFileChooser;
import authoring.utilityfactories.ButtonFactory;
import javafx.embed.swing.SwingFXUtils;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.FileChooser;


public class BackgroundImageView extends PhotoFileChooser{
	
	private VBox root;
	private String backgroundImagePath;
	
	private static final String RESOURCE_FILE_NAME = "resources/GameAuthoringPath";	
	private ResourceBundle pathResource = ResourceBundle.getBundle(RESOURCE_FILE_NAME);
	
	private static final String DEFAULT_IMAGE_FILE_NAME = "greensquare.png";
	
	
	
	public BackgroundImageView(){
		root = new VBox();
		makeSetImageButton();
		
	}
	
	
	public Node getInstanceAsNode(){
		
		return root;
		
	}
	
	public String getBackgroundImagePath(){
		return backgroundImagePath;
	}

	private void makeSetImageButton(){
		Button setBackgroundImageButton = ButtonFactory.makeButton(pathResource.getString("BackgroundImageButton"), 
				e -> selectFile("Photos: ", "Select new background image"));
		root.getChildren().add(setBackgroundImageButton);
	}


	@Override
	public void openFileChooser(FileChooser chooseFile) {
		// TODO Auto-generated method stub
		
	}
	
	private ImageView loadBackgroundImage(){
		ImageView backgroundImageView = new ImageView();
		
		try {
			
		}
		catch (Exception e){
			
		}
		
		return backgroundImageView;
		
	}
	
//	
//	private ImageView loadWeaponImage () throws IOException {
//        
//        try {
//            Image image = ImageIO.read(getClass().getClassLoader().getResourceAsStream(imagePath));
//            Image image2 = SwingFXUtils.toFXImage(imageRead, null);
//            myImageView.setImage(image2);
//            delegate.onUserEnteredWeaponImage(imagePath);
//        }
//        catch (Exception e) {
//            imageRead =
//                    ImageIO.read(getClass().getClassLoader()
//                            .getResourceAsStream(labelsResource.getString("DefaultImagePath")));
//            Image image2 = SwingFXUtils.toFXImage(imageRead, null);
//            myImageView.setImage(image2);
//            System.out.println("Unable to find picture in files");
//        }
//        return myImageView;
//    }
	
}
