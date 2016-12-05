package gameplayer.model.tower;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Observable;

import gameplayer.model.Cell;
import gameplayer.model.GamePlayData;
import gameplayer.model.weapon.Gun;
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
	private HashMap<Integer, engine.tower.Tower> allTowerTypes;
	private HashMap<Integer, engine.tower.Tower> availableTowerTpyes;
	private List<gameplayer.model.tower.Tower> towersOnGrid; // fix naming
	private int uniqueTowerID;
	

	public TowerManager(GamePlayData gameData) {
		this.gameData = gameData;
		this.allTowerTypes = this.gameData.getFactory().getTowers();
		this.towersOnGrid = new ArrayList<>();
		this.uniqueTowerID = 0;
	}
	
	public HashMap<Integer, engine.tower.Tower> getAvailableTower(){
		return this.availableTowerTpyes;
	}
	

	private void updateAvailableTower(){
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
		System.out.println("Placetower in pixel coord: x:" + x + ",y:" + y);

		// add error checking later to see if no such type available
		engine.tower.Tower towerType = availableTowerTpyes.get(type);
		int x1 = (int) (x / this.gameData.getCellWidth());
		int y1 = (int) (y / this.gameData.getCellHeight());
		if (!canPlaceTower(x1, y1, towerType.getCost())) {
			return false;
		}

		gameplayer.model.tower.Tower newlyPlaced = null;
		List<Integer> weaponTypes = towerType.getWeapons();
		ArrayList<Gun> gunsForTower = new ArrayList<Gun>();
		// System.out.println("all the int weapons: " + gunsForTower.size());
		for (int i : weaponTypes) {
			engine.weapon.Weapon weaponForGun = this.weaponMap.get(i);
			gunsForTower.add(new Gun(weaponForGun.getFireRate(), weaponForGun, weaponForGun.getRange(), newlyPlaced));

		}

		// System.out.println("all the gun s: " + gunsForTower.size());

		newlyPlaced = new gameplayer.model.tower.Tower(type, this.uniqueTowerID, towerType.getCost(), gunsForTower,
				towerType.getImagePath(), towerType.getName());
		newlyPlaced.setCoordinates(x1, y1);
		uniqueTowerID++;

		this.towersOnGrid.add(newlyPlaced);

		this.gameData.setGold(this.gameData.getGold() - newlyPlaced.getCost());
		// System.out.println("Calculation time: x:"+x+", Grid width:
		// "+GridGUI.GRID_WIDTH+", cellwidth:
		// "+this.getCellWidth()+",cellheight:"+this.getCellHeight());

		this.gameData.getGrid().placeTower(newlyPlaced, (int) x, (int) y, (int) x1, (int) y1);
		// grid.placeTower(newlyPlaced, (int) (GridGUI.GRID_WIDTH / x), (int)
		// (GridGUI.GRID_HEIGHT / y));

		// System.out.println("towers on grid: " + this.towersOnGrid.size());

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
		
		//Cell current = this.gameData.getGrid().getStartPoint();
		/*
		 * System.out.println("xcoord: "+xcoord);
		 * System.out.println("yccord: "+ycoord);
		 * if(this.gridArray[xcoord][ycoord].getNext() != null){ return false; }
		 */

		/*
		System.out.println("starting cell x: " + current.getX() + "; y: " + current.getY());
		while (current != null) {
			double x_min = current.getX() * GridGUI.GRID_WIDTH / this.getColumns();
			double x = current.getX() * GridGUI.GRID_WIDTH / this.getColumns() + this.getCellWidth()
					+ this.getCellWidth();
			double y = current.getY() * GridGUI.GRID_WIDTH / this.getRow() + this.getCellHeight();
			double y_min = current.getY() * GridGUI.GRID_WIDTH / this.getRow();
			current = current.getNext();
			// System.out.println("Startcell: " + x + "," + y + ". Candropimage:
			// " + xcoord + "," + ycoord);
			if (xcoord < x && xcoord > x_min && ycoord < y && ycoord > y_min) {
				// System.out.println("CAN'T ADD TOWER IN CANPLACETOWER");
				return false;
			}
		}
		*/

	}

	
	

}
