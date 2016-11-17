package gameauthoringenvironment.view.tower;

import gameauthoringenvironment.view.tower.towercomponents.InitNewTowerView;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.layout.BorderPane;

public class TowerView implements ITowerView {

	
	private BorderPane root;
	private InitNewTowerView newTower;
	
	public TowerView(){
		root = new BorderPane();
		newTower = new InitNewTowerView(this);
		root.setCenter(newTower.getRoot());
		
	}

	
    @Override
    public Node getNodeAsInstance () {      
    	return root;
    }
    
    public void getTowerSetter(){
    	Group designTower = new Group();
    	root.setCenter(designTower);
    }

}
