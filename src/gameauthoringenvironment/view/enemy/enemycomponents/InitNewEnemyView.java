package gameauthoringenvironment.view.enemy.enemycomponents;

import java.util.ResourceBundle;

import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;

public class InitNewEnemyView {
	
	private BorderPane root;
	
	private static final String RESOURCE_FILE_NAME = "resources/GameAuthoringEnemy";	
	private ResourceBundle enemyResources = ResourceBundle.getBundle(RESOURCE_FILE_NAME);
	
	public InitNewEnemyView(){
		root = new BorderPane();
		initRoot();
		
		
		
	}
	
	public Node getRoot(){	
		return root;		
	}
	
	private void initRoot(){
		Button newEnemy = new Button();
		newEnemy.setText(enemyResources.getString("NewEnemy"));
//		newEnemy.setOnAction((event) -> {
//			
//		});
		root.setCenter(newEnemy);
	
		
	}

}
