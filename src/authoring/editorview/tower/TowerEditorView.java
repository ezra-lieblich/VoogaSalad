package authoring.editorview.tower;

import authoring.editorview.tower.subviews.InitNewTowerView;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.layout.BorderPane;

public class TowerEditorView implements ITowerEditorView {

	
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