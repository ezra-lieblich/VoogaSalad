package authoring.editorview.path.subviews;



import java.util.List;

import engine.path.Coordinate;
import engine.path.GridCoordinate;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class PathGrid {
	
	private int gridHeight;
	private int gridWidth;
	private int numColumns;
	private int numRows;
	private int cellHeight;
	private int cellWidth;
	private int activePathID;
	private Image cellImage;
	private List<Coordinate<Integer>> pathCoordinates;
	
	private Group grid;
	
	
	public PathGrid(int height, int width){
		this.gridHeight = height;
		this.gridWidth = width;
		this.grid = new Group();
		setEmptyGrid();
		setPathUpdater();
	}

	private void setPathUpdater() {
		grid.setOnMouseClicked(new EventHandler<MouseEvent>() {  //http://stackoverflow.com/questions/27785917/javafx-mouseposition
		    @Override
		    public void handle(MouseEvent event) {
		        event.getSceneX();
		        event.getSceneY();
		    }
		});
	}
	
	public Node getInstanceAsNode(){
		return grid;
	}
	
	public void setNumColumns(int numColumns){
		cellWidth = gridWidth/numColumns;
		this.numColumns = numColumns;
	}
	
	public void setNumRows(int numRows){
		cellHeight = gridHeight/numRows;
		this.numRows = numRows;
		
	}
	
	public void setActivePathId(int pathID){
		this.activePathID = pathID;
	}
	
	public List<Coordinate<Integer>> getPathCoordinates(){
		return pathCoordinates;
	}
	
	public void setPathCoordinates(List<Coordinate<Integer>> pathCoordinates){
		this.pathCoordinates = pathCoordinates;
	}
	
	private void setEmptyGrid(){
		
		for (int i = 0; i < numColumns; i++){
			for (int j = 0; j < numRows; j++){
				Rectangle rect = new Rectangle();
				rect.setHeight(cellHeight);
				rect.setWidth(cellWidth);
				rect.setX(i*cellWidth);
				rect.setY(j*cellHeight);
				rect.setFill(Color.WHITE);
				rect.setStroke(Color.BLACK);
				grid.getChildren().add(rect);
			}			
		}
	}
	
	public void setCellImage(Image image){
		cellImage = image;
	}
	
	
	private void addCellToPath(int x, int y){

	}
	
	private void removeCellFromPath(int x, int y){
		
	}
	

}
