package gameplayer.view;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import engine.path.PathManager;
import gameplayer.model.Cell;
import gameplayer.model.Grid;
import gameplayer.model.Path;
import gameplayer.model.tower.Tower;
import gameplayer.view.helper.GraphicsLibrary;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;

/**
 * 
 * Responsible for creating the grid in which the towers and enemies are placed
 * 
 * @author lucyzhang
 *
 */
public class GridGUI {

	private Pane grid;
	//private Pane pathGrid;
	public static final int GRID_WIDTH = 600;
	public static final int GRID_HEIGHT = 600;
	private double rows;
	private double cols;
	private double cellWidth;
	private double cellHeight;
	private GraphicsLibrary graphicsLib;
	private List<int[]> path;
	private List<ImageView> imagePath;

	public static final String TEST_URL = "../../../Images/BalloonBackground.jpg"; 
																										// dummy
																																							// url

	public GridGUI(int rows, int columns/*, List<int[]> path*/) {
		//System.out.println("Rows: "+rows+"; columns: "+columns);
		this.grid = new Pane();
		this.grid.getStyleClass().add("gridGUI"); //for setting background in css file
		//this.pathGrid = new Pane();
		this.graphicsLib = new GraphicsLibrary();
		this.rows = rows;
		this.cols = columns;
		this.cellWidth = GRID_WIDTH / cols;
		this.cellHeight = GRID_HEIGHT / this.rows;
		this.imagePath = new ArrayList<ImageView>();
		//System.out.println("Cell width: "+cellWidth+", "+cellHeight);
		//this.path = path;
	}
	
	public double getCellWidth(){
		return this.cellWidth;
	}
	
	public double getCellHeight(){
		return this.cellHeight;
	}

	public List<ImageView> getPathImages(){
		return this.imagePath;
	}
	//for testing

	
	public void init(){
		//initDummyPath(); //TODO: get rid of
		styleGrid(TEST_URL);
		//populatePath(this.path);
		
	}
	public Pane getGrid() {
		return this.grid;
	}
	

	private void styleGrid(String terrainURL) {
		setTerrain(terrainURL);
		grid.getStyleClass().add("grid");
		grid.setMinWidth(GRID_WIDTH);
		grid.setMinHeight(GRID_HEIGHT);
		
	}

	//right now, background is set in the css file
	private void setTerrain(String imageURL) {
		//grid.setStyle("-fx-background-image: url(" + imageURL + "); " + "-fx-background-position: center center;"
				//+ "-fx-background-repeat: stretch;");
	}

	private void addTowerToGrid(Tower tower, int row, int col) {
		ImageView towerImage = graphicsLib.createImageView(graphicsLib.createImage(tower.getImage()));
		graphicsLib.setImageViewParams(towerImage, cellWidth * col, cellHeight * row, cellWidth, cellHeight);
		this.grid.getChildren().addAll(towerImage, tower.getInfoBox());
	}

	public void populatePath(HashMap<Integer,Path>allPaths, PathManager pathManager){
		//System.out.println("populate path!");
		for(Integer uniquePath: allPaths.keySet()){
			engine.path.Path currentPath = pathManager.getEntity(uniquePath);
			String pathPicture = currentPath.getImagePath();
			Cell current = allPaths.get(uniquePath).getPathStart();
			while (current != null){
				ImageView pathImage = graphicsLib.createImageView(graphicsLib.createImage(pathPicture));
				double x =current.getX();
				double y = current.getY();
				//System.out.println("path cell x: "+x+"; y: "+y);
				graphicsLib.setImageViewParams(pathImage, x*cellWidth, y*cellHeight,cellWidth, cellHeight);
				this.grid.getChildren().add(pathImage);
				this.imagePath.add(pathImage);
				current = current.getNext();
			}
		}
	}

	public void populateGrid(Grid grid) {
		//populatePath(grid, gri)
		/*
		Cell[][] gridArr = grid.getGrid();
		for (int row = 0; row < gridArr.length; row++) {
			for (int col = 0; col < gridArr[row].length; col++) {

			}
		}
		*/
	}

}
