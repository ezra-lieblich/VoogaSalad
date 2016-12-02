package gameplayer.model;

import java.util.ArrayList;
import java.util.List;

public class Cell {

	List<Enemy> enemies;
	List<Weapon> weapons;
	private int  xCoordinate;
	private int yCoordinate;
	private Cell next;
	private Tower tower;

	public Cell(int x, int y) {
		enemies = new ArrayList<Enemy>();
		weapons = new ArrayList<Weapon>();
		this.xCoordinate = x;
		this.yCoordinate = y;
		this.next = null;
		this.tower = null;
	}
	
	
	public void setNext(Cell cell){
		this.next = cell;
	}

	public Cell getNext(){
		return this.next;
	}
	
	/**
	 * remove all the following methods
	 * @param obj
	
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
	
	 */
	
	public void addTower(Tower t){
		this.tower = t;
	}
	
	public int fireWeapon(){
		
		//+++++++++++++++++++++++++++++++++++++++++need to be fixed+++++++++++++++++++++++
		//if (this.tower != null && tower.isFiring()){
			//return this.tower.getWeaponType();
		//}
		return -1;
	}
	

	public Tower getTower(){
		return this.tower;
	}
	
	
	
	public int getX(){
		return xCoordinate;		
	}
	
	public int getY(){
		return yCoordinate;
	}
	
	
	/*
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
	*/
	
}
