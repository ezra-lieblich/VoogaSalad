package gameplayer.model.collision;

import gameplayer.model.enemy.Enemy;
import gameplayer.model.weapon.Weapon;

public class Collision {
	
	private Enemy enemy;
	private Weapon weapon;
	
	public Collision(Weapon shootingWeapon, Enemy targetEnemy) {
		enemy = targetEnemy;
		weapon = shootingWeapon;
	}
	
	public void processCollision() {
		enemy.setHealth(enemy.getHealth()-weapon.getDamage());
		System.out.println("PROCESSED COLLISION:::::: ");
	}
	
	
}
