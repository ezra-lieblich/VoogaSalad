package authoring.editorview.path.subviews;

import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.image.Image;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;

public class PathBuilderView {
	
	private Pane root;
	private PathGrid grid;
	
	
	public PathBuilderView(){
		this.root = new Pane();
		this.grid = new PathGrid(400, 400);
		Node gridNode = grid.getInstanceAsNode();
		
		root.getChildren().add(gridNode);
		gridNode.setLayoutX(75);
		gridNode.setLayoutY(20);
	}
	
	public Node getInstanceAsNode(){
		return root;
		
	}

	
	public void setGridSize(int numColumns, int numRows){
		grid.setNumColumns(numColumns);
		grid.setNumRows(numRows);
	}
	
	public void setBackgroundImage(Image backgroundImage){
		grid.setBackgroundImage(backgroundImage);
	}
	
	
	
	
	//Make grid
	//Allow drag and drop
	//Store list of coordinates
	
}
