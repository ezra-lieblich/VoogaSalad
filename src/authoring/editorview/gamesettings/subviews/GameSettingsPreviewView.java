package authoring.editorview.gamesettings.subviews;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import authoring.editorview.INodeView;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class GameSettingsPreviewView implements INodeView {

	
	private Group root;
	private ImageView gameImageView;
	private List<Integer> pathList;
	
	public GameSettingsPreviewView(int size){
		root = new Group();
		pathList = new ArrayList<Integer>();
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
		
		if (root.getChildren().contains(gameImageView)){
			root.getChildren().remove(gameImageView);
		}
		
		File file = new File(imagePath);
		Image image = new Image(file.toURI().toString());
		gameImageView.setImage(image);
			
		gameImageView.setImage(image);
		root.getChildren().add(gameImageView);
	}
	
	public void updateGridDimensions(int size){
		
	}
	
	public void updatePathList(List<Integer> pathList){
		this.pathList = pathList;
	}
	
	

	
	
}
