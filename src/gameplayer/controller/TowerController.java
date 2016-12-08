package gameplayer.controller;

import java.util.ArrayList;
import java.util.Map;

import engine.weapon.WeaponType;
import gameplayer.model.tower.Tower;
import gameplayer.model.tower.TowerManager;
import gameplayer.model.weapon.Weapon;
import gameplayer.view.GridGUI;
import gameplayer.view.helper.GraphicsLibrary;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;

public class TowerController {
	private TowerManager towerManager;
	private GraphicsLibrary graphicsLib;

	// create back end code for firing a weapon
	/**
	 * get all weaponTypes from all towers on the grid check on fire rate and do
	 * math to fire weapon to map create all the newly fired weapon into an
	 * arraylist<weapon> then call weaponManager's method
	 * updateWeapon(ArrayList<Weapon> newlyGeneratedWeapons) the method above
	 * will both updated current weapon on map and add the new weapons on the
	 * position of the tower
	 * 
	 */

	public TowerController(TowerManager towerManager, GridGUI grid) {
		this.towerManager = towerManager;
		this.graphicsLib = new GraphicsLibrary();
	}
	

	private void sellTower(int id) {
		this.towerManager.sellTower(id);
	}

	public void handleSellTowerClick(double x, double y) {
		Map<Integer, Tower> towersOnGrid = towerManager.getTowerOnGrid();
		for (Map.Entry<Integer, Tower> entry : towersOnGrid.entrySet()) {
			Tower t = entry.getValue();
			if ((t.getX() <= x && t.getX() + GamePlayerController.ENTITY_SIZE >= x && t.getY() <= y - GamePlayerController.Y_OFFSET
					&& t.getY() + GamePlayerController.ENTITY_SIZE >= y - GamePlayerController.Y_OFFSET)) {
				System.out.println("----++++++++sell tower--------++++++++");
				sellTower(entry.getKey());
			}
		}
	}

	private void createButton() {
		Button sellTower = graphicsLib.createButton("Sell tower", e -> {

		});
	}

	/**
	 * migrate placing tower to here
	 */

}
