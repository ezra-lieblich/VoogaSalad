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
		for (int w = 0; w < weaponManager.getWeaponOnGrid().size(); w++) {
			Weapon weapon = weaponManager.getWeaponOnGrid().get(w);
			int targetUniqueID = weapon.getTargetEnemyID();
			Enemy targetEnemy = enemyManager.getEnemyOnGrid().get(targetUniqueID);
			boolean xInRange = Math.abs(weapon.getX() - targetEnemy.getX()) <= targetEnemy.getWidth(); //make more robust
			boolean yInRange = Math.abs(weapon.getY() - targetEnemy.getY()) <= targetEnemy.getHealth(); //make more robust
			if (xInRange && yInRange) {
				Collision collision = new Collision(weapon, targetEnemy);
				collision.processCollision();
				weaponManager.getWeaponOnGrid().remove(weapon.getID()); //is this the right ID?
				if (targetEnemy.getHealth() <= 0) {
					enemyManager.getEnemyOnGrid().remove(targetUniqueID);
				}
			}
		}
	}
	
}
