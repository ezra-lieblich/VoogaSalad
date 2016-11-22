package authoring.editorview.enemy;

import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.layout.BorderPane;

/**
 * @author Diane Hadley
 */

public class EnemyEditorView implements IEnemyEditorView {
	private EnemyEditorViewDelegate delegate;
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

	@Override
	public void setDelegate(EnemyEditorViewDelegate delegate) {
		this.delegate = delegate;
	}
    
    
    

}
