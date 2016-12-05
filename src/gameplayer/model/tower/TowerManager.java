package gameplayer.model.tower;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Observable;

import engine.weapon.Weapon;
import gameplayer.model.Cell;
import gameplayer.model.GamePlayData;
import gameplayer.model.weapon.WeaponManager;
import gameplayer.view.GridGUI;


/**
 * FOR FRONT END: availableTowerTpyes would be changed by level changes
 * updateAvailableTower() is notify observer method
 * 
 * @author yuminzhang
 *
 */
public class TowerManager extends Observable{
	private GamePlayData gameData;
	private WeaponManager weaponManager;
	private HashMap<Integer, engine.tower.Tower> allTowerTypes;
	private HashMap<Integer, engine.tower.Tower> availableTowerTpyes;
	private HashMap<Integer, engine.weapon.Weapon> allWeapons;
	private List<gameplayer.model.tower.Tower> towersOnGrid; // fix naming
	private int uniqueTowerID;
	

	public TowerManager(GamePlayData gameData, WeaponManager weaponManager) {
		this.gameData = gameData;
		this.weaponManager = weaponManager;
		this.allTowerTypes = this.gameData.getFactory().getTowers();
		this.allWeapons = this.gameData.getFactory().getWeaponBank();
		this.towersOnGrid = new ArrayList<>();
		this.uniqueTowerID = 0;
	}
	
	public HashMap<Integer, engine.tower.Tower> getAvailableTower(){
		return this.availableTowerTpyes;
	}
	


	public void updateAvailableTower(){
		int level = gameData.getCurrentLevel();
		for(int i: allTowerTypes.keySet()){
			if(allTowerTypes.get(i).getUnlockLevel() == level){
				availableTowerTpyes.put(i, allTowerTypes.get(i));
			}
		}	
		setChanged();
		notifyObservers();

	}
	
	public List<gameplayer.model.tower.Tower> getTowerOnGrid() { // fix naming
		return this.towersOnGrid;
	}
	
	
	/**
	 * 
	 * @param type
	 * @param x y are in pixel coordinates
	 * @return
	 */
	public Boolean placeTower(int type, int x, int y) {
		//System.out.println("Placetower in pixel coord: x:" + x + ",y:" + y);

		// add error checking later to see if no such type available
		engine.tower.Tower towerType = availableTowerTpyes.get(type);
		int x1 = (int) (x / this.gameData.getCellWidth());
		int y1 = (int) (y / this.gameData.getCellHeight());
		if (!canPlaceTower(x1, y1, towerType.getCost())) {
			return false;
		}

	
		List<Integer> weaponTypes = towerType.getWeapons();
		ArrayList<engine.weapon.WeaponType> weaponTypeForTower = new ArrayList<engine.weapon.WeaponType>();
		// System.out.println("all the int weapons: " + gunsForTower.size());
		for (int i : weaponTypes) {
			engine.weapon.Weapon weaponForGun = this.allWeapons.get(i);
		}


		gameplayer.model.tower.Tower newlyPlaced  = new gameplayer.model.tower.Tower(towerType, weaponTypeForTower, this.uniqueTowerID);
		newlyPlaced.setCoordinates(x1, y1);
		uniqueTowerID++;

		this.towersOnGrid.add(newlyPlaced);

		this.gameData.setGold(this.gameData.getGold() - newlyPlaced.getCost());
		this.gameData.getGrid().placeTower(newlyPlaced, (int) x, (int) y, (int) x1, (int) y1);
		return true;

	}
	
	public boolean canPlaceTower(int xcood, int ycoord, double cost) {
		Cell placingLocation = this.gameData.getGridArray()[xcood][ycoord];
		if(placingLocation.getNext()!= null || placingLocation.equals(this.gameData.getGrid().getPathEndPoint())){
			return false;
		}
			
		if (this.gameData.getGold() - cost < 0)
			return false;

		return true;
	}
	


}
