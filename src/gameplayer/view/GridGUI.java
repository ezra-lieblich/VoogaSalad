package gameplayer.view;

import gameplayer.model.Cell;
import gameplayer.model.Grid;
import gameplayer.model.Tower;
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
	public static final int GRID_WIDTH = 700;
	public static final int GRID_HEIGHT = 700;
	private double rows;
	private double cols;
	private double cellWidth;
	private double cellHeight;
	private GraphicsLibrary graphicsLib;

	public static final String TEST_URL = "https://images.designtrends.com/wp-content/uploads/2016/03/30060819/Elegant-Night-Stay-Anime-Background.jpg"; // TODO:
																																							// dummy
																																							// url

	public GridGUI(int rows, int columns) {
		this.grid = new Pane();
		this.graphicsLib = new GraphicsLibrary();
		this.rows = rows;
		this.cols = columns;
		this.cellWidth = GRID_WIDTH / cols;
		this.cellHeight = GRID_HEIGHT / rows;
		styleGrid(TEST_URL);
	}

	public Pane getGrid() {
		return this.grid;
	}

	private void styleGrid(String terrainURL) {
		setTerrain(terrainURL);
		grid.getStyleClass().add("grid");
		grid.setMaxWidth(GRID_WIDTH);
		grid.setMaxHeight(GRID_HEIGHT);
	}

	private void setTerrain(String imageURL) {
		// Image background = graphicsLib.createImage("kaneki.jpg");
		// graphicsLib.createImageView(graphicsLib.createImage("kaneki.jpg"));

		// String image =
		// this.getClass().getResource("kaneki.jpg").toExternalForm();
		grid.setStyle("-fx-background-image: url('" + imageURL + "'); " + "-fx-background-position: center center; "
				+ "-fx-background-repeat: stretch;");
	}

	private void addTowerToGrid(Tower tower, int row, int col) {
		ImageView towerImage = graphicsLib.createImageView(graphicsLib.createImage(tower.getImage()));
		graphicsLib.setImageViewParams(towerImage, cellWidth * col, cellHeight * row, cellWidth, cellHeight);
		this.grid.getChildren().add(towerImage);
	}
	

	// TOWER AND PATH ONLY
	public void populateGrid(Grid grid) {
		Cell[][] gridArr = grid.getGrid();

		for (int row = 0; row < gridArr.length; row++) {
			for (int col = 0; col < gridArr[row].length; col++) {
				if (gridArr[col][row].getTower() != null) {
					// add tower
					addTowerToGrid(gridArr[col][row].getTower(), row, col);
				}
			}
		}

	}

}
