package gameplayer.model.collision;

import gameplayer.model.GamePlayData;
import gameplayer.model.enemy.Enemy;
import gameplayer.model.weapon.Weapon;

public class Collision {
	
	private Enemy enemy;
	private Weapon weapon;
	private GamePlayData data;
	
	public Collision(Weapon shootingWeapon, Enemy targetEnemy, GamePlayData data) {
		enemy = targetEnemy;
		weapon = shootingWeapon;
		this.data = data;
	}
	
	public void processCollision() {
		this.weapon.triggerEffect(this.enemy);
		this.data.setGold(this.data.getGold() + this.enemy.getGoldReward());
		this.data.setGold(this.data.getScore() + this.enemy.getScoreReward());

		//enemy.setHealth(enemy.getHealth()-weapon.getDamage());
		//enemy.setHealth(enemy.getHealth()-weapon.getDamage());
//		System.out.println("PROCESSED COLLISION:::::: ");
	}
	
	
}
