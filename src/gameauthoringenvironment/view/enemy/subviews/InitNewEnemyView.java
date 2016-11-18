package gameauthoringenvironment.view.enemy.subviews;

import java.util.ResourceBundle;

import gameauthoringenvironment.view.enemy.EnemyEditorView;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;

public class InitNewEnemyView {
	
	private BorderPane root;
	private EnemyEditorView enemyView;
	
	private static final String RESOURCE_FILE_NAME = "resources/GameAuthoringEnemy";	
	private ResourceBundle enemyResources = ResourceBundle.getBundle(RESOURCE_FILE_NAME);
	
	public InitNewEnemyView(EnemyEditorView enemyView){
		root = new BorderPane();
		this.enemyView = enemyView;
		initRoot();
		
		
		
	}
	
	public Node getRoot(){	
		return root;		
	}
	
	private void initRoot(){
		Button newEnemy = new Button();
		newEnemy.setText(enemyResources.getString("NewEnemy"));
		newEnemy.setOnAction((event) -> {
			enemyView.getEnemySetter();
		});
		root.setCenter(newEnemy);
	
		
	}

}
