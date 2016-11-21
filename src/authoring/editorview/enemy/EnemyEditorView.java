package authoring.editorview.enemy;

import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.layout.BorderPane;

/**
 * @author Diane Hadley
 */

public class EnemyEditorView implements IEnemyEditorView {

	private BorderPane root;
	
	public EnemyEditorView(){
		root = new BorderPane();
		
	}
	
    @Override
    public Node getInstanceAsNode () {      
    	return root;
    }
    
    public void getEnemySetter(){
    	Group designEnemy = new Group();
    	root.setCenter(designEnemy);
    }
    
    
    

}
