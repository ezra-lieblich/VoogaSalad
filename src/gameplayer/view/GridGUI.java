package gameplayer.view;

import gameplayer.model.Cell;
import gameplayer.model.Grid;
import gameplayer.view.helper.GraphicsLibrary;
import javafx.scene.image.Image;
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

	// TOWER AND PATH ONLY
	public void populateGrid(Grid grid) {
		Cell[][] gridArr = grid.getGrid();
		for (Cell[] row : gridArr) {
			for (Cell col : row) {
				if (col.getTower()!=null){
					//add tower
					//col.getTower().get
				}
				
			}
		}
	}

}
