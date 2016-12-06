package gameplayer.controller;

import java.util.ArrayList;

import engine.weapon.WeaponType;
import gameplayer.model.tower.Tower;
import gameplayer.model.tower.TowerManager;
import gameplayer.model.weapon.Weapon;

public class TowerController {
	private TowerManager towerManager;
	
	// create back end code for firing a weapon
	/**
	 * get all weaponTypes from all towers on the grid
	 * check on fire rate and do math to fire weapon to map
	 * create all the newly fired weapon into an arraylist<weapon>
	 * then call weaponManager's method
	 * updateWeapon(ArrayList<Weapon> newlyGeneratedWeapons)
	 * the method above will both updated current weapon on map and add the new weapons
	 * on the position of the tower
	 * 
	 */

	public TowerController(TowerManager towerManager) {
		this.towerManager = towerManager;		
	}
	

	
	
	/**
	 * migrate placing tower to here
	 */

}
