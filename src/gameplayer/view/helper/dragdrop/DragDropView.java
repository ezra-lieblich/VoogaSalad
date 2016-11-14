package gameplayer.view.helper.dragdrop;

import java.util.ArrayList;

import gameplayer.view.GameGUI;
import gameplayer.view.GridGUI;
import gameplayer.view.helper.GraphicsLibrary;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;

/**
 * Responsible for the tab pane that holds all of the defensive structures that
 * can be dragged onto the grid
 * 
 * @author lucyzhang
 *
 */
public class DragDropView {

	private TabPane dragDropPane;
	private ArrayList<Tab> tabs;
	private GraphicsLibrary graphicLib;
	public static final int DEFENSIVEWIDTH = 50;
	public static final int DEFENSIVEHEIGHT = 50;
	private Pane target;

	public DragDropView(/*GridGUI game*/) {
		this.dragDropPane = new TabPane();
		this.tabs = new ArrayList<Tab>();
		this.graphicLib = new GraphicsLibrary();
		//this.game = game;

	}
	
	public void setDragTarget(Pane target){
		this.target = target; 
	}
	
	public TabPane getDragDropPane(){
		return this.dragDropPane;
	}
	
	/**
	 * Creates a new tab and adds it to the main tabpane
	 * @param title
	 * @return
	 */
	public Tab createTab(String title) {
		Tab newTab = new Tab();
		newTab.setText(title);
		this.dragDropPane.getTabs().add(newTab);
		tabs.add(newTab);
		return newTab;
	}


	/**
	 * Populates a tab with images to later drag and drop
	 * @param imageLocations Array of the image location names
	 */
	public void populateImageViewsToTab(Tab tab, String[] imageLocations) {
		Group root = new Group();
		GridPane grid = graphicLib.creatGridPane(root, 20, 20); //TODO: change, would be set by the xml file
		int cIndex = 0;
		int rIndex = 0;
		for (String image:imageLocations){
			ImageView currentImage = graphicLib.createImageView(graphicLib.createImage(image));
			DragDrop dragger = new DragDrop(currentImage, /*this.game.getGrid()*/target);
			dragger.detectDrag();
			graphicLib.setImageViewParams(currentImage, DEFENSIVEWIDTH, DEFENSIVEHEIGHT);
			grid.add(currentImage ,cIndex, rIndex);
			rIndex++;
		}
		tab.setContent(root);
		

	}

}
