package authoring.editorview.path.subviews;



import java.util.List;

import authoring.editorview.path.PathEditorViewDelegate;
import engine.path.Coordinate;
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
	//private PathCell[][] grid ;
	private ImageView[][] grid;
	
	private List<Coordinate<Integer>> pathCoordinates;
	private PathEditorViewDelegate delegate;
	
	private Group root;
	private Group gridRoot;
	private Group backgroundRoot;
	
	
	public PathGrid(int height, int width){
		this.gridHeight = height;
		this.gridWidth = width;
		this.root = new Group();
		this.gridRoot = new Group();
		this.backgroundRoot = new Group();
		root.getChildren().addAll(backgroundRoot, gridRoot);
		setBackground();		
		setPath();
	}

	private void setPathUpdater() {
		gridRoot.setOnMouseClicked(new EventHandler<MouseEvent>() {  //http://stackoverflow.com/questions/27785917/javafx-mouseposition
		    @Override
		    public void handle(MouseEvent event) {
		        double x = event.getSceneX();
		        double y = event.getSceneY();
		        updatePath(x, y);
		    }
		});
	}
	
	public Node getInstanceAsNode(){
		return root;
	}
	
	public void setDelegate(PathEditorViewDelegate delegate){
		this.delegate = delegate;
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
	
	
	private void setBackground(){
		for (int i = 0; i < numColumns; i++){
			for (int j = 0; j < numRows; j++){
				Rectangle rect = new Rectangle();			
				rect = formatRectangle(i, j, rect);
				backgroundRoot.getChildren().add(rect);
			}
		}
	}
	
	private void clearBackground(){
		backgroundRoot.getChildren().clear();
	}
	
	
	private void setPath(){
		
		//grid = new PathCell[numColumns][numRows];
		grid = new ImageView[numColumns][numRows];
		
		for (int i = 0; i < numColumns; i++){
			for (int j = 0; j < numRows; j++){
				setCell(i, j);
				
				
				
//				setCell(i, j);
//				fillCell(i, j);
				
				
				
			}			
		}
	}
	
	
	private void setCell(int x, int y){		
		boolean inPath = setInPath(x, y);
		setNode(x, y, inPath);
		
		
	}

	private boolean setInPath(int x, int y) {
		boolean inPath = false;	
		for (Coordinate<Integer> coordinate : pathCoordinates){
			if (coordinate.getX() == x && coordinate.getY() == y){
				inPath = true;
				break;
			}
		}
		return inPath;
	}
	
	private void setNode(int x, int y, boolean inPath){
		ImageView iv = new ImageView(cellImage);
		iv = formatImageView(x, y, iv);
		if (!inPath){
			iv.setVisible(false);
		}
		grid[x][y] = iv;
		gridRoot.getChildren().add(grid[x][y]);
	}

	
	private ImageView formatImageView(int x, int y, ImageView iv) {
		iv.setFitHeight(cellHeight);
		iv.setFitWidth(cellWidth);
		iv.setX(x*cellWidth);
		iv.setY(y*cellHeight);
		return iv;
	}
	
	private Rectangle formatRectangle(int x, int y, Rectangle rect) {
		rect.setHeight(cellHeight);
		rect.setWidth(cellWidth);
		rect.setX(x*cellWidth);
		rect.setY(y*cellHeight);
		rect.setFill(Color.WHITE);
		rect.setStroke(Color.BLACK);
		return rect;
	}
	
	public void setCellImage(Image image){
		cellImage = image;
	}
	
	private void updatePath(double x, double y){
		int i = (int) x/cellWidth;
		int j = (int) y/cellHeight;
		if (grid[i][j].isVisible()){
			grid[i][j].setVisible(false);
		}
		else {
			grid[i][j].setVisible(true);
		}
	}
	
	
	private void addCellToPath(int x, int y){

	}
	
	private void removeCellFromPath(int x, int y){
		
	}
	
//	private void setCell(int x, int y){
//		PathCell cell = new PathCell();
//		for (Coordinate<Integer> coordinate : pathCoordinates){
//			if (coordinate.getX() == x && coordinate.getY() == y){
//				cell.setInPath(true);
//				break;
//			}
//		}
//		grid[x][y] = cell;
//		
//	}
//	
//	private void fillCell(int x, int y){
//		if (grid[x][y].getInPathBoolean()){
//			ImageView iv = new ImageView(cellImage);
//			iv.setFitHeight(cellHeight);
//			iv.setFitWidth(cellWidth);
//			iv.setX(x*cellWidth);
//			iv.setY(y*cellHeight);
//			gridRoot.getChildren().add(iv);
//			
//		}	
//		else {
//			Rectangle rect = new Rectangle();			
//			formatRectangle(x, y, rect);
//			gridRoot.getChildren().add(rect);
//		}
//		
//		
//	}

	
	
	

}
