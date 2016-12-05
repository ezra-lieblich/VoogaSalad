package gameplayer.model.weapon;

import java.util.ArrayList;
import java.util.List;
import java.util.Observable;

import gameplayer.model.GamePlayData;
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
	
	
	public void updateWeapon() {

		for (Weapon w : weaponOnGrid) {
			if (w.getX() < GridGUI.GRID_WIDTH) {
				w.setX(w.getSpeedX() + w.getX());
			}
			if (w.getY() < GridGUI.GRID_HEIGHT) {
				w.setY(w.getSpeedY() + w.getY());
			}

			if (!coordinateInBound(w.getX(), w.getY()) && !w.inRange()) {
				this.weaponOnGrid.remove(w);
			}
		}

		// creating all the new firing
		for (gameplayer.model.tower.Tower t : this.getTowerOnGrid()) {
			//System.out.println("Tower in weapon method: x:" + t.getX() + ", y:" + t.getY());
			// System.out.println("towerID: " + t.getID());
			ArrayList<Gun> guns = t.getGuns();
			// System.out.println("gun size: " + guns.size());

			for (Gun g : guns) {
				if (g.isFiring()) {
					Weapon currentWeapon = g.getWeapon();
					currentWeapon.setX(t.getX());
					currentWeapon.setY(t.getY());

					// System.out.println("x and y: " + currentWeapon.getX() + "
					// " + currentWeapon.getSpeedY());
					currentWeapon.setID(this.uniqueWeaponID);
					uniqueWeaponID++;
					this.weaponOnGrid.add(currentWeapon);
				}
			}

		}

		setChanged();
		notifyObservers();
	}
	

}
