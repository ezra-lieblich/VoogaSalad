package authoringview.enemy;

import authoringview.enemy.subviews.InitNewEnemyView;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.layout.BorderPane;


public class EnemyEditorView implements IEnemyEditorView {

	private BorderPane root;
	private InitNewEnemyView newEnemy;
	
	public EnemyEditorView(){
		root = new BorderPane();
		newEnemy = new InitNewEnemyView(this);
		root.setCenter(newEnemy.getRoot());
		
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
