package authoring.editorview.path.subviews;

import javafx.scene.Node;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;

public class PathGrid {
	
	private int gridHeight;
	private int gridWidth;
	private int cellHeight;
	private int cellWidth;
	private Image backgroundImage;
	private Image cellImage;
	
	private Pane grid;
	
	
	public PathGrid(int height, int width){
		this.gridHeight = height;
		this.gridWidth = width;
		this.grid = new Pane();
		
	}
	
	public Node getInstanceAsNode(){
		return grid;
	}
	
	public void setNumColumns(int numColumns){
		cellWidth = gridWidth/numColumns;
	}
	
	public void setNumRows(int numRows){
		cellHeight = gridHeight/numRows;
		
	}
	
	public void setBackgroundImage(Image image){
		backgroundImage = image;
		//TODO: has to be removed each time;
		ImageView imageView = new ImageView(backgroundImage);
		imageView.setFitHeight(gridHeight);
		imageView.setFitWidth(gridWidth);
		grid.getChildren().add(imageView);
	}
	
	public void setCellImage(Image image){
		cellImage = image;
	}
	
	public void fillCell(int x, int y){
		
		//make cell always showing
	}
	

}
