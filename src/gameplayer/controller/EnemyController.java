package gameplayer.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Observable;
import java.util.Observer;

import gameplayer.model.Enemy;
import gameplayer.model.GamePlayModel;
import gameplayer.view.GridGUI;
import gameplayer.view.entity.EnemyView;

public class EnemyController implements Observer{
	private GamePlayModel model;
	private List<EnemyView> enemyViews;
	private GridGUI grid;
	
	public EnemyController(GamePlayModel model, GridGUI grid){
		this.model = model;
		this.enemyViews = new ArrayList<EnemyView>();
		this.grid = grid;
	}
	
	private void createEnemyViews(){
		ArrayList<Enemy> enemies = (ArrayList<Enemy>) this.model.getEnemyList();
		for (int i=0; i<enemies.size(); i++){
			Enemy enemy = enemies.get(i);
			EnemyView enemyView = new EnemyView(enemy.getImage(), width, height, enemy.getHealth());
			this.enemyViews.add(enemyView);
		}
	}
	
	private void addEnemyViews(){
		ArrayList<Enemy> enemies = (ArrayList<Enemy>) this.model.getEnemyList();
		for (int i=0; i<enemies.size(); i++){
			Enemy enemy = enemies.get(i);
			EnemyView enemyView = new EnemyView(enemy.getImage(), width, height, enemy.getHealth());
			this.grid.getGrid().getChildren().add(enemyView.getEnemyView());
		}
	}

	@Override
	public void update(Observable o, Object arg) {
		// TODO Auto-generated method stub
		
	}
	

}
