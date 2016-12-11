package gameplayer.loader;

import engine.enemy.Enemy;
import gameplayer.model.Cell;

public class EnemyFactory {
	Enemy enemyType;
	Cell startingPoint;
	
	public EnemyFactory(Enemy engineEnemy, Cell start) {
		enemyType = engineEnemy;
		startingPoint = start;
	}
	
	public gameplayer.model.enemy.Enemy createModelEnemy() { //refactor name
		int ID = this.enemyType.getId();
		String name = this.enemyType.getName();
		double movingSpeed = this.enemyType.getSpeed();
		int health = (int) this.enemyType.getHealth();
		String image = this.enemyType.getImagePath();
		double height = this.enemyType.getSize();
		double width = this.enemyType.getSize();
		gameplayer.model.enemy.Enemy modelEnemy = new gameplayer.model.enemy.Enemy(ID, name, 
				movingSpeed, health, image, height, width);
		modelEnemy.setCurrentCell(startingPoint);
		return modelEnemy;
	}
}
