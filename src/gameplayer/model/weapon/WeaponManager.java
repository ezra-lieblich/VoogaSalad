package gameplayer.model.weapon;

import java.util.ArrayList;
import java.util.List;
import java.util.Observable;

import gameplayer.model.GamePlayData;
import gameplayer.model.tower.TowerManager;
import gameplayer.view.GridGUI;

public class WeaponManager extends Observable{
	private GamePlayData gameData;
	private List<Weapon> weaponOnGrid;
	private int uniqueWeaponID;



	public WeaponManager(GamePlayData gameData) {
		this.gameData = gameData;
		initializeNewLevel();
	}

	public void initializeNewLevel(){
		weaponOnGrid = new ArrayList<Weapon>();
		uniqueWeaponID = 0;
	}
	
	public List<Weapon> getWeaponOnGrid(){
		return this.weaponOnGrid;
	}


	public void updateWeapon(ArrayList<Weapon> newlyGeneratedWeapons) {

		for (Weapon w : weaponOnGrid) {
			if (w.getX() < GridGUI.GRID_WIDTH) {
				w.setX(w.getSpeedX() + w.getX());
			}
			if (w.getY() < GridGUI.GRID_HEIGHT) {
				w.setY(w.getSpeedY() + w.getY());
			}

			if (!this.gameData.coordinateInBound(w.getX(), w.getY()) || !w.inRange()) {
				this.weaponOnGrid.remove(w);
			}
		}

		// all all the new firing
		for (int i = 0; i <newlyGeneratedWeapons.size(); i++){
			newlyGeneratedWeapons.get(i).setID(this.uniqueWeaponID);
			uniqueWeaponID++;
			this.weaponOnGrid.add(newlyGeneratedWeapons.get(i));

		}

		setChanged();
		notifyObservers();
	}


}
