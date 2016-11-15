package gameplayer.view;


import javafx.scene.layout.Pane;

/**
 * Responsible for creating the grid in which the towers and enemies are placed
 * @author lucyzhang
 *
 */
public class GridGUI {
	
	private Pane grid;
	public static final int GRID_WIDTH = 800;
	public static final int GRID_HEIGHT = 600;
	
	
	public GridGUI(){
		this.grid = new Pane();
		styleGrid();
	}
	
	public Pane getGrid(){
		return this.grid;
	}
	
	private void styleGrid(){
		grid.getStyleClass().add("grid");
		grid.setMaxWidth(GRID_WIDTH);
		grid.setMaxHeight(GRID_HEIGHT);
	}
	
	public void populateGrid(){
		
	}

}
