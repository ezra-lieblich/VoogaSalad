package authoring.editorview.gamesettings.subviews;

import authoring.editorview.IEditorView;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class GameSettingsPreviewView implements IEditorView {

	
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
		Image image = new Image(imagePath);
		gameImageView.setImage(image);
	}
	
	

	
	
}
