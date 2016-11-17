package gameplayer.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Observable;
import java.util.Queue;

import gameplayer.loader.GamePlayerFactory;
import javafx.beans.property.SimpleListProperty;
import javafx.collections.ObservableList;

public class GamePlayModel extends Observable{

	private int cellSize;
	private Grid grid;
	private int gridX;
	private int gridY;

	private List<Enemy> enemyOnGrid;
	private List<Weapon> weaponOnGrid;
	private int hitBuffer = 10; // initialize from xml
	
	private Map<Integer, Weapon> weaponTypes; // initialize in xml
	private Map<Integer, Tower> towerTypes;  // initialize in xml
	private Cell[][] gridArray;
	
	
	private Enemy nextEnteringEnemy; 
	private Queue<Enemy> packOfEnemyComing;
	
	private List<Queue<Enemy>> enemyAtCurrentLevel; 
	
	private GamePlayerFactory factory;
	
	private double gold;
	private double lives;
	private double levelnumber;  // reach level number winning the game
	private double currentLevel;
	private int waveOfEnemy;
	
	
	//number of gold
	

	public GamePlayModel(GamePlayerFactory factory){
		initializeGameSetting(factory);
	}
	
	
	/**
	 * could be used when start another game
	 * @param factory
	 */
	public void initializeGameSetting(GamePlayerFactory factory){	
		this.factory = factory;
		HashMap<String, Double> settingInfo = factory.getGameSetting();
		this.levelnumber = settingInfo.get("levelnumber");
		this.gold = settingInfo.get("gold");
		this.lives = settingInfo.get("lives");
	}
	
	
	public void initializeLevelInfo(){
		this.enemyAtCurrentLevel = this.factory.getEnemy();
		this.towerTypes = this.factory.getTowers();
		//this.weaponTypes = this.factory.getWeapon();
		this.waveOfEnemy = 0;
		
	}
	
	
	
	int[] getDimension(){
		int[] dimension = {this.gridX, this.gridY};
		return dimension;
	}
	

	double getGold() {
		return gold;
	}


	void setGold(double gold) {
		setChanged();
		notifyObservers();
		this.gold = gold;
	}


	public double getLife() {
		return this.lives;
	}


	void setLife(double life) {
		setChanged();
		notifyObservers();
		this.lives = life;
	}


	void setLevel(double d) {
		setChanged();
		notifyObservers();
		this.currentLevel = d;
	}

	
	public Boolean placeTower(int type, int x, int y){	
		//later check if is a valid location to place the tower
		Tower t  = towerTypes.get(type);
		if(this.gold - t.getCost() < 0){
			return false;
		}
		grid.placeTower(towerTypes.get(type), x, y);
		setGold(this.gold - t.getCost());
		return true;
	}
	
	private double cellToCoordinate(int cellNumber){
		return (cellNumber + 0.5) * cellSize;
	}
	
	
	private void singleCollision(Enemy e, Weapon w){		
		if(Math.abs(w.getX() -e.getX()) < hitBuffer && Math.abs(w.getY()- e.getY()) < hitBuffer){
			e.setHealth(e.getHealth() - w.getDemage());			
		}			
	}
	
	
	private void checkCollision(){
		for (Enemy e: enemyOnGrid){
			for (Weapon w : weaponOnGrid){
				singleCollision(e, w);
			}
			if(e.getHealth()< 0)
				enemyOnGrid.remove(e);
		}
		setChanged();
		notifyObservers();
	}
	
	private Boolean coordinateInBound(double d, double e){
		return (d < this.gridX * cellSize && e < this.gridY *cellSize);
	}
	
	
	private double getDistance(double x1, double y1, double x2, double y2){
		return Math.sqrt(Math.pow(x2-x1, 2) + Math.pow(y2-y1, 2));
	}
	
	private Boolean inShootingRange(Weapon w){
		Tower t = w.getShootingAgent();
		return getDistance(w.getX(), w.getY(), t.getCoordinate()[0], t.getCoordinate()[1]) <= t.getAttackingRange();	
		
	}
	
	private void updateWeapon(){
		for(Weapon w: weaponOnGrid){
			w.setX(w.getSpeedX() + w.getX());
			w.setY(w.getSpeedY() + w.getY());
			
			if(!coordinateInBound(w.getX(), w.getY()) && !inShootingRange(w)){
				this.weaponOnGrid.remove(w);
			}
		}
		
		for (int i = 0; i < gridX; i++){
			for(int j = 0; j < gridY; j++){
				int weaponType = gridArray[i][j].fireWeapon();
				if(weaponType != -1){
					Weapon toAdd = this.weaponTypes.get(weaponType);
					toAdd.setX(cellToCoordinate(i));
					toAdd.setY(cellToCoordinate(j));
					toAdd.setShootingAgent(gridArray[i][j].getTower());
					weaponOnGrid.add(toAdd);
				}
			}
		}
		
		setChanged();
		notifyObservers();
	}
	
	//get direction
	
	
	private void moveSingleEnemy(Enemy e) throws NullPointerException{
		//to make it easier, only updating enemy's current cell once it reaches the center point of the next cell
		double distToMove;
		try {
			distToMove = (Math.abs(cellToCoordinate(e.getCurrentCell().getNext().getX()) - e.getX()) + 
					Math.abs(cellToCoordinate(e.getCurrentCell().getNext().getY()) - e.getY()));
		}
		catch(NullPointerException exception) {
			distToMove = 0;//this needs to change
		}
		
		double moveDist = e.getMovingSpeed();
		
		while (moveDist > 0) {
			if (moveDist >= distToMove) { //can move to center of next cell
				e.setX(e.getX() + e.getxDirection() * distToMove);
				e.setY(e.getY() + e.getyDirection() * distToMove);
				e.setCurrentCell(e.getCurrentCell().getNext());
				e.setxDirection(e.getCurrentCell().getNext().getX() - e.getCurrentCell().getX()); //-1, 0, or 1
				e.setyDirection(e.getCurrentCell().getNext().getY() - e.getCurrentCell().getY());
				moveDist -= distToMove;
			}
			else {
				e.setX(e.getX() + e.getxDirection() * moveDist);
				e.setY(e.getY() + e.getyDirection() * moveDist);
				moveDist -= moveDist;
			}
			
		}
		
		
		//sub lives if enemy got into base
	}
	
	private void updateEnemy(){
		// move on Grid Enemy
		for (Enemy e: enemyOnGrid){
			try {
				moveSingleEnemy(e);
			}
			catch(NullPointerException exception) {
				lives -= 1;
				
				/*
				if (lives == 0) {
					//end game
				}
				*/
			}
		}
		
		
		//enter new enemy
		if(this.nextEnteringEnemy != null) {
			enemyOnGrid.add(this.nextEnteringEnemy);
			this.nextEnteringEnemy.setCurrentCell(this.grid.getStartPoint());
		}
		
		if(packOfEnemyComing.isEmpty() && enemyOnGrid.isEmpty() ){
			if(waveOfEnemy < enemyAtCurrentLevel.size()){
				packOfEnemyComing = enemyAtCurrentLevel.get(waveOfEnemy);
				waveOfEnemy++;
			}
			else{
				setLevel(this.currentLevel+1);  
			}
			
		}
		
		this.nextEnteringEnemy = packOfEnemyComing.poll();
		
		setChanged();
		notifyObservers();
		
	}
	



	public void updateInLevel(){
		checkCollision();
		updateWeapon();		
		updateEnemy();
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	

}
