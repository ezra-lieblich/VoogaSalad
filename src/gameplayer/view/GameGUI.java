package gameplayer.view;

import java.util.List;

import gameplayer.model.Enemy;
import gameplayer.view.buttonPanel.ButtonPanel;
import gameplayer.view.buttonPanel.GamePlayButtonPanel;
import gameplayer.view.helper.GraphicsLibrary;
import gameplayer.view.helper.dragdrop.DragDrop;
import gameplayer.view.helper.dragdrop.DragDropView;
import gameplayer.view.statsdisplay.StatsDisplay;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.image.ImageView;
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
	public static final double xError = -20;
	public static final double yError = -60;
	
	private BorderPane mainScreen;
	private Scene scene;
	private VBox leftPane;
	private GraphicsLibrary graphics;
	private GridGUI grid;
	private DragDropView dragDrop;
	private GamePlayButtonPanel buttonPanel;
	private StatsDisplay statsDisplay;
	private double numLevels;
	private double currentLevel;
	private List path;
	private EventHandler animationBind;
	
	public GameGUI(int rows, int columns){
		this.mainScreen = new BorderPane();
		this.graphics = new GraphicsLibrary();
		this.grid = new GridGUI(rows, columns/*, path*/); 
		this.dragDrop = new DragDropView(xError, yError); 
		this.buttonPanel = new GamePlayButtonPanel();
		this.currentLevel = 0;
	}
	
	public Scene init(double gold, double lives, double level, List<String> imagePaths){
		this.numLevels = level;
		createScene();
		createGrid();
		initDragDropPane(imagePaths);
		addButtonPanel();
		initStatsDisplay(gold, lives, currentLevel);
		return this.scene;
	}
	
	/**
	 * MIGHT NOT BE NECESSARY
	 * Update the current level in the stats display only
	 * @param newLevel
	 */
	public void updateCurrentLevelStats(double newLevel){
		this.currentLevel = newLevel;
		this.statsDisplay.updateLevel(newLevel);
	}
	
	public void setPath(List<int[]> path){
		this.path = path;
	}
	
	public GridGUI getGrid(){
		return this.grid;
	}
	
	public DragDrop getDragDrop(){
		return this.dragDrop.getDragDrop();
	}
	
	public void bindAnimationStart(EventHandler<ActionEvent> handle){
		this.buttonPanel.bindAnimationStart(handle);
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
		this.mainScreen.setLeft(grid.getGrid());
		grid.init();
	}
	
	private void styleGrid(){
		BorderPane.setAlignment(this.grid.getGrid(), Pos.CENTER);
		//BorderPane.setMargin(this.grid.getGrid(), new Insets(10,50,10,0));
	}
	
	private void initDragDropPane(List<String> imagePaths){
		dragDrop.setDragTarget(grid.getGrid());
		String[] testImages = {"butterfly.png","kaneki.jpg","penguin.jpg"};//TODO: get rid of 
		String[] testImages2 = {"butterfly.png","kaneki.jpg"};//TODO: get rid of 
		mainScreen.setRight(dragDrop.getDragDropPane());
		Tab tab = dragDrop.createTab("Blah test");
		dragDrop.populateImageViewsToTab(tab, imagePaths);
	}
	
	private void initStatsDisplay(double gold, double lives, double level){
		this.statsDisplay = new StatsDisplay(gold,lives,level);
		statsDisplay.init();
		this.mainScreen.setBottom(statsDisplay.getScorePane());
	}
	
	public void updateStatsDisplay(double gold, double lives, double level){
		this.statsDisplay.updateLevelUI(gold, lives, level);
	}
	
	//not sure if this goes here
	public void reRender(List<Enemy> redraw){//should be interface of drawables
		for(Enemy enemy:redraw){
			ImageView image = new ImageView(enemy.getImage());
			image.setX(enemy.getX());
			image.setY(enemy.getY());
			this.grid.getGrid().getChildren().add(image);
		}
	}
	
	
	
	
	
}
