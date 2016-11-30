package gameplayer.view;

import java.util.List;

import gameplayer.model.IDrawable;
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
import javafx.scene.control.Button;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Modality;
import javafx.stage.Stage;

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
	
	/**
	 * Call this method when new level needs to be triggered
	 * @param e
	 */
	public void newLevelPopUp(EventHandler<ActionEvent> e){
		this.grid.getGrid().getChildren().clear();
		Button btn = graphics.createButton("Next level", e);
		ImageView stuff = graphics.createImageView(graphics.createImage("newlevel.png"));
		graphics.setImageViewParams(stuff, GridGUI.GRID_WIDTH, GridGUI.GRID_HEIGHT);
		this.grid.getGrid().getChildren().add(stuff);
		this.grid.getGrid().getChildren().add(btn);
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
	public void reRenderTower(List<IDrawable> redraw){//should be interface of drawables
		for(IDrawable entity:redraw){
			ImageView image = new ImageView(entity.getImage());
			image.setX(entity.getX()+ this.dragDrop.getDragDrop().getxError());
			image.setY(entity.getY()+this.dragDrop.getDragDrop().getyError());
			graphics.setImageViewParams(image, DragDropView.DEFENSIVEWIDTH, DragDropView.DEFENSIVEHEIGHT);
			this.grid.getGrid().getChildren().add(image);
		}
	}
	
	public void reRender(List<IDrawable> redraw){//should be interface of drawables
		for(IDrawable entity:redraw){
			ImageView image = new ImageView(entity.getImage());
			image.setX(entity.getX());
			image.setY(entity.getY());
			graphics.setImageViewParams(image, DragDropView.DEFENSIVEWIDTH, DragDropView.DEFENSIVEHEIGHT);
			this.grid.getGrid().getChildren().add(image);
		}
	}
	
	
	
	
}
