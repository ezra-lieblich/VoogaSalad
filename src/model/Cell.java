package model;

import java.util.ArrayList;
import java.util.List;

public class Cell {

	List<Enemy> enemies;
	List<Weapon> weapons;

	public Cell() {
		enemies = new ArrayList<Enemy>();
		weapons = new ArrayList<Weapon>();
	}
	
	public void addEnemy(Enemy obj){
		enemies.add(obj);
	}
	
	public void addWeapon(Weapon obj){
		weapons.add(obj);
	}

	public void removeEnemy(Enemy obj){
		enemies.remove(obj);
	}
	
	public void removeWeapon(Weapon obj){
		weapons.remove(obj);
	}
	
	private void singleCollision(Enemy enemy, Weapon weapon){
		enemy.setHealth(enemy.getHealth() - weapon.getDemage());
	}
	
	public void manageCollision(){
		if(!enemies.isEmpty() && !weapons.isEmpty()){
			for(Enemy e: enemies){
				for (Weapon w: weapons){
					singleCollision(e, w);
				}
			}
		}
		
	}
}
