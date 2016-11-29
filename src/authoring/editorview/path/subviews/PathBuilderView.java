package authoring.editorview.path.subviews;

import java.util.ResourceBundle;

import authoring.editorview.path.PathEditorViewDelegate;
import javafx.scene.Node;
import javafx.scene.image.Image;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;

public class PathBuilderView {
	
	private VBox root;
	private PathGrid grid;
	private PathEditorViewDelegate delegate;
	
	private static final String RESOURCE_FILE_NAME = "resources/GameAuthoringPath";	
	private ResourceBundle pathResource = ResourceBundle.getBundle(RESOURCE_FILE_NAME);
	
	public PathBuilderView(){
		this.root = new VBox();
		addInstructionsText();
		this.grid = new PathGrid(400, 400);
		Node gridNode = grid.getInstanceAsNode();
		gridNode.setLayoutX(75);
		gridNode.setLayoutY(20);
		root.getChildren().add(gridNode);				
		
		
	}
	
	public Node getInstanceAsNode(){
		return root;
		
	}
	
	public void setDelegate(PathEditorViewDelegate delegate){
		this.delegate = delegate;
	}
	
	public void setActivePathId(int pathID){
		grid.setActivePathId(pathID);
	}
	
	private void addInstructionsText(){
		Text instructions = new Text(pathResource.getString("PathBuilderInstructions"));
		root.getChildren().add(instructions);
	}

	
	public void setGridSize(int numColumns, int numRows){
		grid.setNumColumns(numColumns);
		grid.setNumRows(numRows);
	}
	
	public void setPathImage(Image pathImage){
		grid.setCellImage(pathImage);
	}
	
	
}
