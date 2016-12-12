package authoring.editorview.gamesettings.subviews;

import java.io.File;

import authoring.editorview.INodeView;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class GameSettingsPreviewView implements INodeView {

	
	private Group root;
	private ImageView gameImageView;
	
	public GameSettingsPreviewView(int size){
		root = new Group();
		formatImageView(size);
	}


	private void formatImageView(int size) {
		gameImageView = new ImageView();
		gameImageView.setFitWidth(size);
		gameImageView.setFitHeight(size);
		root.getChildren().add(gameImageView);
	}
	
	
	@Override
	public Node getInstanceAsNode() {		
		return root;
	}
	
	public void updateGameImagePath(String imagePath){	
		Image image;
		if (root.getChildren().contains(gameImageView)){
			root.getChildren().remove(gameImageView);
		}
		
		File imageFile = new File(imagePath);
		image = new Image(imageFile.toURI().toString());
		gameImageView.setImage(image);
		root.getChildren().add(gameImageView);
	}
	
	public void updateGridDimensions(int size){
		
	}
	
	

	
	
}
