package view.dragdrop;

import javafx.scene.Node;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;

/**
 * Responsible for the tab pane that holds all of the defensive structures that can be dragged onto the 
 * grid
 * @author lucyzhang
 *
 */
public class DragDropView {
	
	private TabPane dragDropPane;
	
	public DragDropView(){
		this.dragDropPane = new TabPane();
		
	}
	
	public Tab createWeaponTab(){
		Tab newTab = new Tab();
		this.dragDropPane.getTabs().add(newTab);
		return newTab;
	}
	
	public void populateTab(Node content){
		
		 
	}
	
	

}
