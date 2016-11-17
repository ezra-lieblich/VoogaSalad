package gameauthoringenvironment.view.tower.towercomponents;

import java.util.ResourceBundle;

import gameauthoringenvironment.view.tower.TowerView;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;

public class InitNewTowerView {
	private BorderPane root;
	private TowerView towerView;
	
	private static final String RESOURCE_FILE_NAME = "resources/GameAuthoringTower";	
	private ResourceBundle towerResources = ResourceBundle.getBundle(RESOURCE_FILE_NAME);
	
	public InitNewTowerView(TowerView towerView){
		root = new BorderPane();
		this.towerView = towerView;
		initRoot();
		
		
		
	}
	
	public Node getRoot(){	
		return root;		
	}
	
	private void initRoot(){
		Button newTower = new Button();
		newTower.setText(towerResources.getString("NewTower"));
		newTower.setOnAction((event) -> {
			towerView.getTowerSetter();
		});
		root.setCenter(newTower);
	}
}
