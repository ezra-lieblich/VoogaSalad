package gameplayer.model.collision;

import gameplayer.model.GamePlayData;
import gameplayer.model.enemy.Enemy;
import gameplayer.model.enemy.EnemyManager;
import gameplayer.model.weapon.Weapon;
import gameplayer.model.weapon.WeaponManager;

public class CollisionManager {
	EnemyManager enemyManager;
	WeaponManager weaponManager;
	
	public CollisionManager(GamePlayData gameData, WeaponManager wManager, EnemyManager eManager) {
		enemyManager = eManager;
		weaponManager = wManager;
	}
	
	public void handleCollisions() {
		for (Weapon weapon : weaponManager.getWeaponOnGrid().values()) {
			int targetUniqueID = weapon.getTargetEnemyID();
			boolean enemyOnGrid = enemyManager.getEnemyOnGrid().keySet().contains(targetUniqueID);
			boolean xInRange;
			boolean yInRange;
			if (!enemyOnGrid) {
				xInRange = false;
				yInRange = false;
			}
			else {
				Enemy targetEnemy = enemyManager.getEnemyOnGrid().get(targetUniqueID);
				
				xInRange = Math.abs(weapon.getX() - targetEnemy.getX()) <= 100; //make more robust
				System.out.println("weapon x " + weapon.getX());
				System.out.println("enemy x "+ targetEnemy.getX());
				System.out.println("weapon y " + weapon.getY());
				System.out.println("enemy y "+ targetEnemy.getY());
				yInRange = Math.abs(weapon.getY() - targetEnemy.getY()) <= 100; //make more robust
				
				if (xInRange && yInRange) {
					Collision collision = new Collision(weapon, targetEnemy);
					collision.processCollision();
					weaponManager.getWeaponOnGrid().remove(weapon.getUniqueID()); //is this the right ID?
					if (targetEnemy.getHealth() <= 0) {
						enemyManager.getEnemyOnGrid().remove(targetUniqueID);
					}
				}
			}
			
			
		}
	}
	
}
