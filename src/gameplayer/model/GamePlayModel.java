package gameplayer.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Observable;
import java.util.Queue;
import engine.tower.Tower;
import engine.weapon.*;
import engine.weapon.WeaponManager;
import gameplayer.loader.GamePlayerFactory;
import gameplayer.model.collision.CollisionManager;
import gameplayer.model.enemy.Enemy;
import gameplayer.model.enemy.EnemyManager;
import gameplayer.model.tower.TowerManager;
import gameplayer.model.weapon.Weapon;
import gameplayer.view.GridGUI;
import gameplayer.view.helper.GraphicsLibrary;
import javafx.scene.image.ImageView;
import gameplayer.model.weapon.*;

public class GamePlayModel extends Observable {
	private GamePlayerFactory factory;
	private String gameTitle;
	private GamePlayData gameData;

	//private int hitBuffer = 10; // initialize from xml


	private HashMap<Integer, engine.weapon.Weapon> weaponMap;
	private GraphicsLibrary graphicLib;
	private TowerManager towerManager;
	private gameplayer.model.weapon.WeaponManager weaponManager;
	private EnemyManager enemyManager;
	private CollisionManager collisionManager;
	// private EnemyModel enemyModel;




	public GamePlayModel(GamePlayerFactory factory) {
		graphicLib = new GraphicsLibrary();
		this.gameData = new GamePlayData(factory);
		this.gameData.initializeGameSetting();
		this.enemyManager = new EnemyManager(this.gameData);
		this.towerManager = new TowerManager(gameData, this.enemyManager);
		this.weaponManager = new gameplayer.model.weapon.WeaponManager(this.gameData, this.towerManager);
		this.collisionManager = new CollisionManager(gameData, this.weaponManager, this.enemyManager);
		initializeGameSetting(factory);
	}

	/**
	 * could be used when start another game
	 * 
	 * @param factory
	 */
	public void initializeGameSetting(GamePlayerFactory factory) {
		this.factory = factory;
		this.gameTitle = this.factory.getGameTitle();
		initializeLevelInfo();
	}

	public GamePlayData getData(){
		return this.gameData;
	}
	
	public TowerManager getTowerManager(){
		return this.towerManager;
	}
	
	public EnemyManager getEnemyManager(){
		return this.enemyManager;
	}
	
	public CollisionManager getCollisionManager() {
		return this.collisionManager;
	}
	
	public gameplayer.model.weapon.WeaponManager getWeaponManager(){
		return this.weaponManager;
	}


	public HashMap<Integer, engine.tower.Tower> getAvailableTower(){
		return this.towerManager.getAvailableTower();
	}

	public HashMap<Integer, Weapon> getWeaponOnGrid() {
		return this.weaponManager.getWeaponOnGrid();
	}


	public void initializeLevelInfo() {
		this.gameData.initializeLevelInfo();
		this.weaponManager.initializeNewLevel();
		this.towerManager.updateAvailableTower();
		this.enemyManager.initializeNewLevel();
		
	}


	/*
	 * should just get this in towerController
	 */
	public Map<Integer,gameplayer.model.tower.Tower> getTowerOnGrid() { // fix naming
		return this.towerManager.getTowerOnGrid();
	}




	public Boolean placeTower(int type, int x, int y) {
		return this.towerManager.placeTower(type, x, y);
	}






	/*
	public void singleCollision(Enemy e, Weapon w) {
		if (Math.abs(w.getX() - e.getX()) < hitBuffer && Math.abs(w.getY() - e.getY()) < hitBuffer) {
			e.setHealth(e.getHealth() - w.getDamage());
		}
	}

	 */

	// Moved to EnemyModel
	/*
	 * private void checkCollision() { for (Enemy e :
	 * this.enemyModel.getEnemyList()) { for (Weapon w : weaponOnGrid) {
	 * singleCollision(e, w); } if (e.getHealth() < 0)
	 * this.enemyModel.getEnemyList().remove(e); } setChanged();
	 * notifyObservers(); }
	 */




	/*
	public void createDummyEnemies() {
		Queue<Enemy> myQueue = new LinkedList<Enemy>();
		Queue<Enemy> myQueue1 = new LinkedList<Enemy>();
		Enemy enem1 = new Enemy(1, "Izaya", 4, 7, "questionmark.png", 50.0, 50.0);
		enem1.setCurrentCell(this.getGrid().getCell(0, 0));
		Enemy enem2 = new Enemy(2, "Shizuo", 4, 7, "questionmark.png", 50.0, 50.0);
		enem2.setCurrentCell(this.getGrid().getCell(0, 0));
		Enemy enem3 = new Enemy(3, "Mikado", 4, 7, "kaneki.jpg", 50.0, 50.0);
		enem3.setCurrentCell(this.getGrid().getCell(0, 0));
		Enemy enem4 = new Enemy(4, "Kanra", 4, 7, "penguin.jpg", 50.0, 50.0);
		enem4.setCurrentCell(this.getGrid().getCell(0, 0));
		myQueue.add(enem1);
		// myQueue.add(enem2);
		// myQueue.add(enem3);
		myQueue.add(enem4);
		myQueue1.add(enem1);
		myQueue1.add(enem2);
		myQueue1.add(enem3);
		myQueue1.add(enem4);
		List<Queue<Enemy>> stuff = new ArrayList<Queue<Enemy>>();
		stuff.add(myQueue);
		// stuff.add(myQueue1);
		this.enemyAtCurrentLevel = stuff;
		setPackOfEnemyComing(myQueue);
		System.out.println("Enemy at current level: " + enemyAtCurrentLevel);
	}
	 */

	// get direction
	/*
	 * //TODO: move to EnemyModel private void moveSingleEnemy(Enemy e) { //to
	 * make it easier, only updating enemy's current cell once it reaches the
	 * center point of the next cell double distToMove; boolean onLastCell =
	 * false;
	 * 
	 * double moveDist = e.getMovingSpeed();
	 * 
	 * while (moveDist > 0) { try { distToMove =
	 * (Math.abs(cellToCoordinate(e.getCurrentCell().getNext().getX()) -
	 * e.getX()) +
	 * Math.abs(cellToCoordinate(e.getCurrentCell().getNext().getY()) -
	 * e.getY())); } catch(NullPointerException exception) { //enemy is
	 * currently at last cell on path double destinationXpos =
	 * e.getCurrentCell().getX() + e.getxDirection() * cellSize/2; //midpoint +
	 * width/2 = edge double destinationYpos = e.getCurrentCell().getY() +
	 * e.getyDirection() * cellSize/2; distToMove = Math.abs(destinationXpos -
	 * e.getX()) + Math.abs(destinationYpos - e.getY()); onLastCell = true; } if
	 * (moveDist >= distToMove) { //can move to center of next cell
	 * e.setX(e.getX() + e.getxDirection() * distToMove); e.setY(e.getY() +
	 * e.getyDirection() * distToMove); if (onLastCell) { setLife(this.lives-1);
	 * } e.setCurrentCell(e.getCurrentCell().getNext());
	 * e.setxDirection(e.getCurrentCell().getNext().getX() -
	 * e.getCurrentCell().getX()); //-1, 0, or 1
	 * e.setyDirection(e.getCurrentCell().getNext().getY() -
	 * e.getCurrentCell().getY()); moveDist -= distToMove; } else {
	 * e.setX(e.getX() + e.getxDirection() * moveDist); e.setY(e.getY() +
	 * e.getyDirection() * moveDist); moveDist -= moveDist; } }
	 * 
	 * 
	 * //sub lives if enemy got into base }
	 * 
	 * //TODO: move to EnemyModel private void updateEnemy(){ // move on Grid
	 * Enemy for (Enemy e: enemyOnGrid){ moveSingleEnemy(e); }
	 * 
	 * 
	 * //enter new enemy if(this.nextEnteringEnemy != null) {
	 * enemyOnGrid.add(this.nextEnteringEnemy);
	 * this.nextEnteringEnemy.setCurrentCell(this.grid.getStartPoint()); }
	 * 
	 * if(packOfEnemyComing.isEmpty() && enemyOnGrid.isEmpty() ){ if(waveOfEnemy
	 * < enemyAtCurrentLevel.size()){ packOfEnemyComing =
	 * enemyAtCurrentLevel.get(waveOfEnemy); waveOfEnemy++; } else{
	 * setLevel(this.currentLevel+1); }
	 * 
	 * }
	 * 
	 * this.nextEnteringEnemy = packOfEnemyComing.poll();
	 * 
	 * setChanged(); notifyObservers();
	 * 
	 * }
	 */

	public void updateInLevel() {
		// checkCollision();
		this.weaponManager.updateWeapon();
		this.towerManager.updateAvailableTower();
		this.enemyManager.update();
		// this.enemyModel.update();

	}

}