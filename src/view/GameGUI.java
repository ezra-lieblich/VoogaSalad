package view;

import javafx.scene.Scene;
import javafx.scene.control.TabPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import view.helper.GraphicsLibrary;

/**
 * Overseer of all of the games made, able to create multiple/have them 
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
	
	public GameGUI(){
		this.mainScreen = new BorderPane();
		this.graphics = new GraphicsLibrary();
		this.grid = new GridGUI();
		
	}
	
	public Scene init(){
		createScene();
		createGrid();
		return this.scene;
	}
	
	private void createScene(){
		this.scene = new Scene(mainScreen, SCENE_WIDTH, SCENE_HEIGHT);
		this.scene.getStylesheets().add(this.getClass().getResource("/view/voogaStyle.css").toExternalForm());
	}
	
	
	private void createGrid(){
		this.leftPane = graphics.createVBoxPane(SCENE_WIDTH/2, SCENE_HEIGHT*.75);
		this.leftPane.getStyleClass().add("grid");
		this.leftPane.getChildren().addAll(grid.getGrid());	
		this.mainScreen.setLeft(leftPane);
	}
	
}
