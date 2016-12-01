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
import gameplayer.loader.GamePlayerFactory;
import gameplayer.view.GridGUI;
import gameplayer.view.helper.GraphicsLibrary;
import javafx.scene.image.ImageView;

public class GamePlayModel extends Observable {

	private int cellSize;
	private Grid grid;
	private int gridX;
	private int gridY;

	private List<Enemy> enemyOnGrid;
	private List<Weapon> weaponOnGrid;
	private List<gameplayer.model.Tower> towersOnGrid; //fix naming
	private int hitBuffer = 10; // initialize from xml
	private HashMap<Integer, engine.tower.Tower> towerTypes;
	private Cell[][] gridArray;
	private Enemy nextEnteringEnemy;
	private Queue<Enemy> packOfEnemyComing;
	private List<Queue<Enemy>> enemyAtCurrentLevel;
	private GamePlayerFactory factory;
	private double gold;
	private double lives;
	private double numLevels; // reach level number winning the game
	private int currentLevel;
	private int waveOfEnemy;
	private String gameTitle;
	private int uniqueTowerID, uniqueEnemyID, uniqueWeaponID;
	private HashMap<Integer, engine.weapon.Weapon> weaponMap;
	private GraphicsLibrary graphicLib;


	// private EnemyModel enemyModel;
	
	

	public GamePlayModel(GamePlayerFactory factory) {
		graphicLib = new GraphicsLibrary();
		initializeGameSetting(factory);
		// this.enemyModel = new EnemyModel(this);
	}
	
	
	public void createDummyEnemies(){
		Queue<Enemy> myQueue = new LinkedList<Enemy>();
		Queue<Enemy> myQueue1 = new LinkedList<Enemy>();
		Enemy enem1 = new Enemy(1,"Izaya", 4, 7, "questionmark.png", 50.0, 50.0);
		enem1.setCurrentCell(this.getGrid().getCell(0, 0));
		Enemy enem2 = new Enemy(2,"Shizuo", 4, 7, "questionmark.png", 50.0, 50.0);
		enem2.setCurrentCell(this.getGrid().getCell(0, 0));
		Enemy enem3 = new Enemy(3,"Mikado", 4, 7, "kaneki.jpg", 50.0, 50.0);
		enem3.setCurrentCell(this.getGrid().getCell(0, 0));
		Enemy enem4 = new Enemy(4,"Kanra", 4, 7, "penguin.jpg", 50.0, 50.0);
		enem4.setCurrentCell(this.getGrid().getCell(0, 0));
		myQueue.add(enem1);
		myQueue.add(enem2);
		myQueue.add(enem3);
		myQueue.add(enem4);
		myQueue1.add(enem1);
		myQueue1.add(enem2);
		myQueue1.add(enem3);
		myQueue1.add(enem4);
		List<Queue<Enemy>> stuff = new ArrayList<Queue<Enemy>>();
		stuff.add(myQueue);
		stuff.add(myQueue1);
		this.enemyAtCurrentLevel = stuff;
		setPackOfEnemyComing(myQueue);
		System.out.println("Enemy at current level: "+enemyAtCurrentLevel);
	}

	
	public  HashMap<Integer, engine.tower.Tower> getAllTowerTypes(){
		return this.towerTypes;
	}
	
	public List<Weapon> getWeaponOnGrid() {
		return this.weaponOnGrid;
	}

	public Queue<Enemy> getPackOfEnemyComing() {
		return packOfEnemyComing;
	}

	public void setPackOfEnemyComing(Queue<Enemy> packOfEnemyComing) {
		this.packOfEnemyComing = packOfEnemyComing;
	}

	public List<Queue<Enemy>> getEnemyAtCurrentLevel() {
		return enemyAtCurrentLevel;
	}

	public void setEnemyAtCurrentLevel(List<Queue<Enemy>> enemyAtCurrentLevel) {
		this.enemyAtCurrentLevel = enemyAtCurrentLevel;
	}

	public int getWaveOfEnemy() {
		return waveOfEnemy;
	}

	public void setWaveOfEnemy(int waveOfEnemy) {
		this.waveOfEnemy = waveOfEnemy;
	}

	public void setNextEnteringEnemy(Enemy nextEnteringEnemy) {
		this.nextEnteringEnemy = nextEnteringEnemy;
	}

	/**
	 * could be used when start another game
	 * 
	 * @param factory
	 */
	public void initializeGameSetting(GamePlayerFactory factory) {
		this.factory = factory;
		HashMap<String, Double> settingInfo = factory.getGameSetting();

		this.currentLevel = settingInfo.get("levelnumber").intValue(); 
		this.numLevels = settingInfo.get("totalNumberOfLevels");
		this.gold = settingInfo.get("gold");
		this.lives = settingInfo.get("lives");
		this.towerTypes = this.factory.getTowers();
		this.gameTitle = this.factory.getGameTitle();
		this.towersOnGrid= new ArrayList<>();
		// this.weaponTypes = this.factory.getWeapon(); need from xml
	}

	public void initializeLevelInfo() {
		this.uniqueEnemyID = 0;
		this.uniqueTowerID = 0;
		this.uniqueWeaponID = 0;
		this.enemyAtCurrentLevel = this.factory.getEnemy(this.currentLevel);
		this.waveOfEnemy = 0;
		packOfEnemyComing = this.enemyAtCurrentLevel.get(waveOfEnemy);
		this.waveOfEnemy++;
		nextEnteringEnemy = this.packOfEnemyComing.poll();
		this.grid = this.factory.getGrid(this.currentLevel);
		gridArray = this.grid.getGrid();
		this.gridX = this.gridArray.length;
		this.gridY = this.gridArray[0].length;
		weaponOnGrid = new ArrayList<Weapon>();
		enemyOnGrid = new ArrayList<Enemy>();
		weaponMap = this.factory.getWeaponBank();
		System.out.println("weapon map" + weaponMap.get(0).getName());
		


	}

	public HashMap<Integer,engine.tower.Tower> getTowerTypes(){
		return this.towerTypes; 
	}
	
	public List<gameplayer.model.Tower> getTowerOnGrid(){ //fix naming
		return this.towersOnGrid;
	}
	
	public Enemy getNextEnteringEnemy() {
		return this.nextEnteringEnemy;
	}

	public void setCellSize(int size) {
		this.cellSize = size;
	}

	public int getCellSize() {
		return this.cellSize;
	}

	public int[] getDimension() {
		int[] dimension = { this.gridX, this.gridY };
		return dimension;
	}

	public int getRow() {
		int[] dimensions = this.getDimension();
		return dimensions[0];
	}

	public int getColumns() {
		int[] dimensions = this.getDimension();
		return dimensions[1];
	}

	public String getGameTitle() {
		return this.gameTitle;
	}

	public Grid getGrid() {
		return this.grid;
	}

	public int getLevelNumber() {
		return (int) this.numLevels;
	}

	public double getGold() {
		return gold;
	}

	private void setGold(double gold) {
		this.gold = gold;
		setChanged();
		notifyObservers();
	}

	public double getLife() {
		return this.lives;
	}

	// used by enemymodel
	public void setLife(double life) {
		this.lives = life;
		setChanged();
		notifyObservers();
	}

	public void setLevel(int d) {
		this.currentLevel = d;
		setChanged();
		notifyObservers();
	}

	public int getCurrentLevel() {
		return this.currentLevel;
	}

	// TODO: move to EnemyModel
	/*
	 * public List<Enemy> getEnemyList() { return this.enemyOnGrid; }
	 */

	public Boolean placeTower(int type, int x, int y) {
		// later check if is a valid location to place the tower
			engine.tower.Tower towerType = towerTypes.get(type);
			if(!canPlaceTower(x, y, towerType.getCost())){
				return false;
			}
			gameplayer.model.Tower newlyPlaced = null;
			List<Integer> weaponTypes = towerType.getWeapons();
			ArrayList <Gun> gunsForTower = new ArrayList<Gun>();
			System.out.println("all the int weapons: " + gunsForTower.size());
			for (int i: weaponTypes){
				engine.weapon.Weapon weaponForGun = this.weaponMap.get(i);
				gunsForTower.add(new Gun(weaponForGun.getFireRate(), weaponForGun, weaponForGun.getRange(),newlyPlaced));

			}
			
			System.out.println("all the gun s: " + gunsForTower.size());

			newlyPlaced = new gameplayer.model.Tower(type,this.uniqueTowerID, towerType.getCost(),gunsForTower, towerType.getImagePath(),towerType.getName());
			newlyPlaced.setCoordinates(cellToCoordinate(x), cellToCoordinate(y));
			uniqueTowerID ++;
		
			this.towersOnGrid.add(newlyPlaced); 
			
			setGold(this.gold - newlyPlaced.getCost());
			System.out.println("Calculation time: x:"+x+", Grid width: "+GridGUI.GRID_WIDTH+", cellwidth: "+this.getCellWidth()+",cellheight:"+this.getCellHeight());
			grid.placeTower(newlyPlaced, (int)(GridGUI.GRID_WIDTH/x), (int)(GridGUI.GRID_HEIGHT/y));
			
			System.out.println("towers on grid: " + this.towersOnGrid.size()); 

		return true;
		// get weaponTypes
		// actually implement the firing counter into each weapon types

		// ++++++++++++++++++++++++++++fix this after weapon type is
		// done+++++++++++++++++++++++++
		/*
		 * Tower t = new Tower(type, tt.getCost(),
		 * tt.getWeapon(),tt.getImageLocation(),tt.getName()); if(this.gold -
		 * t.getCost() < 0){ return false; } t.setCoordinates(x, y);
		 * grid.placeTower(t, x, y); setGold(this.gold - t.getCost());
		 * 
		 * 
		 */
	}
	
	
	public boolean canPlaceTower(int xcoord, int ycoord, double cost){
		Cell current = this.grid.getStartPoint();
		//System.out.println("starting cell x: "+current.getX()+"; y: "+current.getY());
		while (current != null){
			double x =current.getX()* GridGUI.GRID_WIDTH/this.getColumns();
			double y = current.getY() * GridGUI.GRID_WIDTH/this.getRow() + GridGUI.GRID_WIDTH/this.getRow();
			current = current.getNext();
			//System.out.println("Startcell: "+x+","+y+". Candropimage: "+xcoord+","+ycoord);
			if (xcoord<x && ycoord<y){
				return false;
			}
		}
		
		if (this.gold - cost < 0)
			return false;
		
		return true;
	}
	
	public double getCellWidth(){
		return GridGUI.GRID_WIDTH/this.getColumns();
	}
	
	public double getCellHeight(){
		return GridGUI.GRID_WIDTH/this.getRow();
	}
	public double cellToCoordinate(double d) {
		return (d + 0.5) * cellSize;
	}

	public void singleCollision(Enemy e, Weapon w) {
		if (Math.abs(w.getX() - e.getX()) < hitBuffer && Math.abs(w.getY() - e.getY()) < hitBuffer) {
			e.setHealth(e.getHealth() - w.getDamage());
		}
	}

	// Moved to EnemyModel
	/*
	 * private void checkCollision() { for (Enemy e :
	 * this.enemyModel.getEnemyList()) { for (Weapon w : weaponOnGrid) {
	 * singleCollision(e, w); } if (e.getHealth() < 0)
	 * this.enemyModel.getEnemyList().remove(e); } setChanged();
	 * notifyObservers(); }
	 */
	private Boolean coordinateInBound(double d, double e) {
		return (d < this.gridX * cellSize && e < this.gridY * cellSize);
	}

	private double getDistance(double x1, double y1, double x2, double y2) {
		return Math.sqrt(Math.pow(x2 - x1, 2) + Math.pow(y2 - y1, 2));
	}



	private void updateWeapon() {
		System.out.println("+++++++++++++++++++++++++++++++++++");
		System.out.println("weapon number on grid: " + this.weaponOnGrid.size());
		for (Weapon w : weaponOnGrid) {
			//System.out.println("Weapon x: " + w.getX());
			w.setX(w.getSpeedX() + w.getX());
			w.setY(w.getSpeedY() + w.getY());

			// update distance travelled
			// update in shooting range function
			if (!coordinateInBound(w.getX(), w.getY()) && !w.inRange()) {
				this.weaponOnGrid.remove(w);
			}
		}

		//creating all the new firing
		for (gameplayer.model.Tower t: towersOnGrid){
			System.out.println("towerID: " + t.getID());
			ArrayList<Gun> guns = t.getGuns();
			System.out.println("gun size: " + guns.size());

			for (Gun g : guns){
				if(g.isFiring()){
					Weapon currentWeapon = g.getWeapon();
					currentWeapon.setX(t.getX());
					currentWeapon.setY(t.getY());
					currentWeapon.setID(this.uniqueWeaponID);
					uniqueWeaponID ++;
					this.weaponOnGrid.add(currentWeapon);
				}
			}
			
		}

		setChanged();
		notifyObservers();
	}

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
		 //updateWeapon();
		// this.enemyModel.update();

	}

}