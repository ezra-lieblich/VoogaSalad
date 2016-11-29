package authoring.editorview.path.subviews;

import java.util.ResourceBundle;

import authoring.editorview.path.PathEditorViewDelegate;
import authoring.utilityfactories.ButtonFactory;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;

public class PathBuilderView {
	
	private VBox root;
	private HBox pathRoot;
	private PathGrid grid;
	private PathEditorViewDelegate delegate;
	private int activePathID;
	
	private static final String RESOURCE_FILE_NAME = "resources/GameAuthoringPath";	
	private ResourceBundle pathResource = ResourceBundle.getBundle(RESOURCE_FILE_NAME);
	
	public PathBuilderView(){
		this.root = new VBox();
		addInstructionsText();
		this.pathRoot = new HBox();
		this.grid = new PathGrid(400, 400);
		Node gridNode = grid.getInstanceAsNode();
		gridNode.setLayoutX(75);
		gridNode.setLayoutY(20);
		pathRoot.getChildren().add(gridNode);				
		makeSubmitPathButton();
		
	}
	
	public Node getInstanceAsNode(){
		return root;
		
	}
	
	public void setDelegate(PathEditorViewDelegate delegate){
		this.delegate = delegate;
	}
	
	public void setActivePathId(int pathID){
		this.activePathID = pathID;
	}
	
	private void makeSubmitPathButton(){
//		Button submitPathButton = ButtonFactory.makeButton(
//				pathResource.getString("PathBuilderInstructions"), 
////				e -> delegate.onUserEnteredPathCoordinates(activePathID, grid.getPathCoordinates()));
//		pathRoot.getChildren().add(submitPathButton);
//		root.getChildren().add(pathRoot);
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
