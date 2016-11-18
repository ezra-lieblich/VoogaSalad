package gameauthoringenvironment.view.enemy;

import gameauthoringenvironment.view.enemy.enemycomponents.InitNewEnemyView;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.layout.BorderPane;


public class EnemyView implements IEnemyView {

	private BorderPane root;
	private InitNewEnemyView newEnemy;
	
	public EnemyView(){
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
