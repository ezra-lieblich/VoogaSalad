package gameauthoringenvironment.view.tower;

import gameauthoringenvironment.view.tower.subviews.InitNewTowerView;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.layout.BorderPane;

public class TowerEditorView implements ITowerView {

	
	private BorderPane root;
	private InitNewTowerView newTower;
	
	public TowerEditorView(){
		root = new BorderPane();
		newTower = new InitNewTowerView(this);
		root.setCenter(newTower.getRoot());
		
	}

	
    @Override
    public Node getInstanceAsNode () {      
    	return root;
    }
    
    public void getTowerSetter(){
    	Group designTower = new Group();
    	root.setCenter(designTower);
    }

}
