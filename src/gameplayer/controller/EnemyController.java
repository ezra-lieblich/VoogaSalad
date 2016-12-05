package gameplayer.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Observable;
import java.util.Observer;

import gameplayer.model.GamePlayModel;
import gameplayer.model.enemy.Enemy;
import gameplayer.model.enemy.EnemyManager;
import gameplayer.view.GridGUI;
import gameplayer.view.entity.EnemyView;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;

public class EnemyController implements Observer{
	private EnemyManager model;
	//private List<EnemyView> enemyViews;
	private HashMap<Enemy, EnemyView> enemyToView;
	private GridGUI grid;
	
	
	//TODO: enemy model instead of GamePlayModel
	public EnemyController(EnemyManager model, GridGUI grid){
		this.model = model;
		this.model.addObserver(this);
		//this.enemyViews = new ArrayList<EnemyView>();
		this.grid = grid;
		this.enemyToView = new HashMap<Enemy, EnemyView>();
	}
	
	public EnemyManager getEnemyModel(){
		return this.model;
	}

	
	//called in timeline update
	public void updateEnemyViews(){
		ArrayList<Enemy> enemies = (ArrayList<Enemy>) this.getEnemyModel().getEnemyOnGrid();
		for (int i=0; i<enemies.size(); i++){ //ALERT TODO: I don't think any keys will be the same bc as soon as the enemy object is 
			//modified, it will no longer be the same key and no imageview will correspond to it, may need a unique id
			Enemy enemy = enemies.get(i);
			EnemyView enemyView = new EnemyView(enemy.getImage(), enemy.getWidth(), enemy.getHeight(), enemy.getHealth());
		
			((Pane) this.grid.getGrid()).getChildren().add(enemyView.getEnemyView());

		}

	}

	@Override
	public void update(Observable o, Object arg) {
		// TODO Auto-generated method stub
		if (o instanceof EnemyManager){
			//updateEnemyViews();
		}
		
	}
	

}
