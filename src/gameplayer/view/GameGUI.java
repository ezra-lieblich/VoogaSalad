package gameplayer.view;

import java.util.List;

import gameplayer.view.buttonPanel.ButtonPanel;
import gameplayer.view.buttonPanel.GamePlayButtonPanel;
import gameplayer.view.helper.GraphicsLibrary;
import gameplayer.view.helper.dragdrop.DragDropView;
import gameplayer.view.statsdisplay.StatsDisplay;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;

/**
 * Overseer of game GUI
 * @author lucyzhang
 *
 */
public class GameGUI {
	
	public static final int SCENE_WIDTH = 1200;
	public static final int SCENE_HEIGHT = 700;
	
	private BorderPane mainScreen;
	private Scene scene;
	private VBox leftPane;
	private GraphicsLibrary graphics;
	private GridGUI grid;
	private DragDropView dragDrop;
	private GamePlayButtonPanel buttonPanel;
	private StatsDisplay statsDisplay;
	private List path;
	
	public GameGUI(int rows, int columns){
		this.mainScreen = new BorderPane();
		this.graphics = new GraphicsLibrary();
		this.grid = new GridGUI(rows, columns/*, path*/); 
		this.dragDrop = new DragDropView(); 
		this.buttonPanel = new GamePlayButtonPanel();
	}
	
	public Scene init(double gold, double lives, double level){
		createScene();
		createGrid();
		initDragDropPane();
		addButtonPanel();
		initStatsDisplay(gold, lives, level);
		return this.scene;
	}
	
	public void setPath(List<int[]> path){
		this.path = path;
	}
	
	public GridGUI getGrid(){
		return this.grid;
	}
	
	private void addButtonPanel(){
		this.buttonPanel.init();
		mainScreen.setTop(this.buttonPanel.getPane());
	}
	
	private void createScene(){
		this.scene = new Scene(mainScreen, SCENE_WIDTH, SCENE_HEIGHT);
		this.scene.getStylesheets().add(this.getClass().getResource("/gameplayer/view/voogaStyle.css").toExternalForm());
	}
	
	
	private void createGrid(){
		styleGrid();
		this.mainScreen.setCenter(grid.getGrid());
		grid.init();
	}
	
	private void styleGrid(){
		BorderPane.setAlignment(this.grid.getGrid(), Pos.CENTER);
		BorderPane.setMargin(this.grid.getGrid(), new Insets(10,50,10,0));
	}
	
	private void initDragDropPane(){
		dragDrop.setDragTarget(grid.getGrid());
		String[] testImages = {"butterfly.png","kaneki.jpg","penguin.jpg"};//TODO: get rid of 
		String[] testImages2 = {"butterfly.png","kaneki.jpg"};//TODO: get rid of 
		mainScreen.setRight(dragDrop.getDragDropPane());
		Tab tab = dragDrop.createTab("Blah test");
		dragDrop.populateImageViewsToTab(tab, testImages);
		//Tab tab2 = dragDrop.createTab("Another text");
		//dragDrop.populateImageViewsToTab(tab2, testImages2);
	}
	
	private void initStatsDisplay(double gold, double lives, double level){
		this.statsDisplay = new StatsDisplay(gold,lives,level);
		statsDisplay.init();
		this.mainScreen.setBottom(statsDisplay.getScorePane());
	}
	
}
