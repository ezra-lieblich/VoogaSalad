package gameauthoringenvironment.view.enemy;

import gameauthoringenvironment.view.enemy.enemycomponents.InitNewEnemyView;
import javafx.scene.Node;
import javafx.scene.layout.BorderPane;

public class EnemyView implements IEnemyView {

	private BorderPane root;
	private InitNewEnemyView newEnemy;
	
	public EnemyView(){
		root = new BorderPane();
		newEnemy = new InitNewEnemyView();
		root.setCenter(newEnemy.getRoot());
		
	}
	
    @Override
    public Node getNodeAsInstance () {      
    	return root;
    }
    
    
    

}
