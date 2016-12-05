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
	 * check all the weaponTypes of each Tower
	 */
	private ArrayList<Weapon> generateNewWeapons(){
		ArrayList<Weapon> newlyFired = new ArrayList<Weapon>();
		
		for(Tower t: this.towerManager.getTowerOnGrid()){
			for(WeaponType w:t.getAllWeaponTypes()){
				w.getFireRate();
				
				// do some math to fire rate to decide if fire at the moment
				// add to newlyFired list
			}
		}
		return newlyFired;
	}
	
	
	/**
	 * migrate placing tower to here
	 */

}
