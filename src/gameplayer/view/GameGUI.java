package gameplayer.view;

import gameplayer.view.helper.GraphicsLibrary;
import gameplayer.view.helper.dragdrop.DragDropView;
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
	
	public GameGUI(){
		this.mainScreen = new BorderPane();
		this.graphics = new GraphicsLibrary();
		this.grid = new GridGUI();
		this.dragDrop = new DragDropView(); 


	}
	
	public Scene init(){
		createScene();
		createGrid();
		initDragDropPane();
		return this.scene;
	}
	
	public GridGUI getGrid(){
		return this.grid;
	}
	
	private void createScene(){
		this.scene = new Scene(mainScreen, SCENE_WIDTH, SCENE_HEIGHT);
		this.scene.getStylesheets().add(this.getClass().getResource("/gameplayer/view/voogaStyle.css").toExternalForm());
	}
	
	
	private void createGrid(){
		//this.leftPane = graphics.createVBoxPane(SCENE_WIDTH/2, SCENE_HEIGHT*.75);
		//this.leftPane.getStyleClass().add("grid");
		//this.leftPane.getChildren().addAll(grid.getGrid());	
		//this.mainScreen.setLeft(leftPane);
		this.mainScreen.setCenter(grid.getGrid());
	}
	
	
	private void initDragDropPane(){
		dragDrop.setDragTarget(grid.getGrid());
		String[] testImages = {"butterfly.png","kaneki.jpg","penguin.jpg"};//TODO: get rid of 
		String[] testImages2 = {"butterfly.png","kaneki.jpg"};//TODO: get rid of 
		mainScreen.setRight(dragDrop.getDragDropPane());
		System.out.println(dragDrop);
		
		Tab tab = dragDrop.createTab("Blah test");
		dragDrop.populateImageViewsToTab(tab, testImages);
		Tab tab2 = dragDrop.createTab("Another text");
		dragDrop.populateImageViewsToTab(tab2, testImages2);
	}
	
}
