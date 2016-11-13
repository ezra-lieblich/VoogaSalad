package view.dragdrop;

import java.util.ArrayList;

import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import view.helper.GraphicsLibrary;

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

	public DragDropView() {
		this.dragDropPane = new TabPane();
		this.tabs = new ArrayList<Tab>();
		this.graphicLib = new GraphicsLibrary();

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

	private void populateTab(int tabIndex, Node content) {
		tabs.get(tabIndex).setContent(content);
	}

	/**
	 * Populates a tab with images to later drag and drop
	 * @param imageLocations Array of the image location names
	 */
	public void populateImageViewsToTab(Tab tab, String[] imageLocations) {
		Group root = new Group();
		GridPane grid = graphicLib.creatGridPane(root, 10, 10); //TODO: change
		int cIndex = 0;
		int rIndex = 0;
		for (String image:imageLocations){
			ImageView currentImage = graphicLib.createImageView(graphicLib.createImage(image));
			graphicLib.setImageViewParams(currentImage, DEFENSIVEWIDTH, DEFENSIVEHEIGHT);
			grid.add(currentImage ,cIndex, rIndex);
			rIndex++;
		}
		tab.setContent(root);
		

	}

}
