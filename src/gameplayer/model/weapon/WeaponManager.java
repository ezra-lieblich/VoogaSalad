package gameplayer.model.weapon;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Observable;

import gameplayer.model.GamePlayData;
import gameplayer.model.tower.Gun;
import gameplayer.model.tower.TowerManager;
import gameplayer.view.GridGUI;

public class WeaponManager extends Observable{
	private GamePlayData gameData;
	private TowerManager towerManager;
	private HashMap<Integer, Weapon> weaponOnGrid;
	private int uniqueWeaponID;
	private long timeInterval;
	private int tempCountFix;


	public WeaponManager(GamePlayData gameData, TowerManager towerManager) {
		this.gameData = gameData;
		this.towerManager = towerManager;
		this.timeInterval = this.towerManager.getTimeInterval();
		this.tempCountFix = 1; 
		initializeNewLevel();
	}

	public void initializeNewLevel(){
		weaponOnGrid = new HashMap<Integer, Weapon>();
		uniqueWeaponID = 0;
	}
	
	public HashMap<Integer, Weapon> getWeaponOnGrid(){
		return this.weaponOnGrid;
	}
	
	public long timeInterval(){
		return this.timeInterval;
	}


	public void updateWeapon() {
		System.out.println("weaponsOnGrid Size: "+weaponOnGrid.size());

		//newly fired weapon
		if(this.tempCountFix % 20 == 0){//VERY TEMP FIX MAKE BULLETS ONCE PER SECOND
			ArrayList<Weapon> newlyGeneratedWeapons = this.towerManager.generateNewWeapons();
			for (int i = 0; i < newlyGeneratedWeapons.size(); i++){
				newlyGeneratedWeapons.get(i).setUniqueID(this.uniqueWeaponID);
				this.weaponOnGrid.put(uniqueWeaponID, newlyGeneratedWeapons.get(i));
				uniqueWeaponID++;
			}
			tempCountFix = 1; 
		}
		else{
			tempCountFix++; 
		}
		System.out.println("weaponsOnGrid Size: "+weaponOnGrid.size());

		
		for (int i : weaponOnGrid.keySet()) {
			Weapon w = weaponOnGrid.get(i);
			System.out.println("weaponsOnGrid Size: "+weaponOnGrid.size());
				
			if (w.getX() < GridGUI.GRID_WIDTH) {
				w.setX(w.getSpeedX() + w.getX());
			}
			if (w.getY() < GridGUI.GRID_HEIGHT) {
				w.setY(w.getSpeedY() + w.getY());
			}

//			if (!this.gameData.coordinateInBound(w.getX(), w.getY()) || !w.inRange()) {
//				this.weaponOnGrid.remove(i);
//			}
		}

		setChanged();
		notifyObservers();
	}


}
