package gameplayer.view;

import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;

/**
 * Responsible for creating the grid in which the towers and enemies are placed
 * @author lucyzhang
 *
 */
public class GridGUI {
	
	private Pane grid;
	
	public GridGUI(){
		this.grid = new Pane();
	}
	
	public Pane getGrid(){
		return this.grid;
	}
	
	public void populateGrid(){
		
	}

}
