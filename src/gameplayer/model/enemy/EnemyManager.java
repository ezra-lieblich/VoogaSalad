package gameplayer.model.enemy;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Observable;
import java.util.Queue;

import engine.level.wave.Wave;
import gameplayer.loader.EnemyFactory;
import gameplayer.loader.GamePlayerFactory;
import gameplayer.model.Cell;
import gameplayer.model.GamePlayData;
import gameplayer.model.Grid;
import gameplayer.model.weapon.Weapon;
import gameplayer.view.GridGUI;
import gameplayer.view.helper.GraphicsLibrary;
import javafx.scene.image.ImageView;

public class EnemyManager extends Observable {

	private HashMap<Integer, Enemy> enemyOnGrid; 
	private GamePlayData gameData;
	private GamePlayerFactory gameFactory;
	private Grid grid;
	private Cell current;
	private Cell currentCopy;
	private Cell startCell;
	private GraphicsLibrary graphicLib;
	private int uniqueEnemyID;

	private Queue<Wave> allWaves;
	private Queue<Double> allWaveStartTimes;
	private Queue<Double> allWaveFrequencies;
	


	public EnemyManager(GamePlayData gameData) {
		this.gameData = gameData;
		this.gameFactory = gameData.getFactory();
		this.graphicLib = new GraphicsLibrary();
		this.allWaveFrequencies = new LinkedList<Double>();
		this.allWaveStartTimes = new LinkedList<Double>();
		initializeNewLevel();
	}

	public void initializeNewLevel(){
		this.grid = this.gameData.getGrid();
		this.startCell = this.grid.getStartPoint();
		this.uniqueEnemyID = 0;
		this.enemyOnGrid = new HashMap<Integer, Enemy>();
		this.allWaves = this.gameFactory.getWaves(this.gameData.getCurrentLevel());
		initializeWaves();
	}
	
	private void initializeWaves() {

		System.out.println("Does all WaveStartTimes exist?");
		System.out.println(allWaveStartTimes);
		allWaves.forEach(w -> allWaveStartTimes.add(w.getStartTime()));
		allWaves.forEach(w -> allWaveFrequencies.add(w.getFrequency()));
	}

	public void setCurrentCell(Cell cell) {
		this.current = cell;
		this.currentCopy = cell;
	}


	public HashMap<Integer, Enemy> getEnemyOnGrid() {
		return this.enemyOnGrid;
	}
	
	public List<Enemy> getEnemyListOnGrid() {
		List<Enemy> enemies = new ArrayList<Enemy>();
		enemies.addAll(enemyOnGrid.values());
		return enemies;
	}

	public void spawnEnemy(Enemy enemy) {
		enemy.setxDirection(enemy.getCurrentCell().getNext().getX() - enemy.getCurrentCell().getX());
		enemy.setyDirection(enemy.getCurrentCell().getNext().getY() - enemy.getCurrentCell().getY());
		enemy.setX(gameData.cellToCoordinate(enemy.getCurrentCell().getX()));
		enemy.setY(gameData.cellToCoordinate(enemy.getCurrentCell().getY()));
		enemyOnGrid.put(enemy.getUniqueID(), enemy);

	}

	// this method not being called??????
	private void moveSingleEnemy(Enemy e) {
		// to make it easier, only updating enemy's current cell once it reaches
		// the center point of the next cell
		double distToMove;
		boolean onLastCell = false;

		double moveDist = e.getMovingSpeed();
		

		while (moveDist > 0) {
			try {
				double deltaX = Math.abs(gameData.cellToCoordinate(e.getCurrentCell().getNext().getX()) - e.getX());
				double deltaY = Math.abs(gameData.cellToCoordinate(e.getCurrentCell().getNext().getY()) - e.getY());
				distToMove = deltaX + deltaY;
			} catch (NullPointerException exception) { // enemy is currently at
				// last cell on path
				double destinationXpos = e.getCurrentCell().getX()
						+ e.getxDirection() * gameData.getCellWidth() / 2; // midpoint
				// +
				// width/2
				// =
				// edge
				double destinationYpos = e.getCurrentCell().getY()
						+ e.getyDirection() * gameData.getCellWidth() / 2;
				distToMove = Math.abs(destinationXpos - e.getX()) + Math.abs(destinationYpos - e.getY());
				onLastCell = true;
			}
			
			
			if (moveDist >= distToMove) { // can move to center of next cell
				e.setX(e.getX() + e.getxDirection() * distToMove);
				e.setY(e.getY() + e.getyDirection() * distToMove);
				e.setCurrentCell(e.getCurrentCell().getNext());
				if (e.getCurrentCell().getNext() == null) {
					gameData.setLife(gameData.getLife() - 1);
					handleEnemyEnteringBase(e);
					return;
				}
				e.setxDirection(e.getCurrentCell().getNext().getX() - e.getCurrentCell().getX()); // -1,
	
				
				// 0,
				// or
				// 1
				
				e.setyDirection(e.getCurrentCell().getNext().getY() - e.getCurrentCell().getY());
				moveDist -= distToMove;
			} else {
				e.setX(e.getX() + e.getxDirection() * moveDist);
				e.setY(e.getY() + e.getyDirection() * moveDist);
				moveDist -= moveDist;
			}
		}
		setChanged();
		notifyObservers();
	}
	
	private void handleEnemyEnteringBase(Enemy e){
		removeEnemyFromGrid(e);
	}
	
	private void removeEnemyFromGrid(Enemy e) {
		this.enemyOnGrid.remove(e.getUniqueID());
	}


	/*
	private void checkCollision() {
		for (Enemy e : getEnemyList()) {
			for (Weapon w : this.gamePlayModel.getWeaponOnGrid()) {
				gamePlayModel.singleCollision(e, w);
			}
			if (e.getHealth() < 0)
				getEnemyList().remove(e);
		}
		setChanged();
		notifyObservers();
	}
	 */




	public void update() {
		// updateEnemy();
		// checkCollision();
		moveEnemies();
	}

	
	private void moveEnemies() {
		for (Enemy enemy : enemyOnGrid.values()) {
			moveSingleEnemy(enemy);
		}
	}

	private void setEnemyImageSize(ImageView enemyImage){
		graphicLib.setImageViewParams(enemyImage, this.gameData.getCellWidth(),  this.gameData.getCellHeight());
	}

	public double getTimeOfNextWave() {
		double timeInSeconds = this.allWaveStartTimes.poll();
		double timeInMillis = timeInSeconds * 1000;
		return timeInMillis;
	}
	
	public double getFrequencyOfNextWave() {
		double timeInSeconds = this.allWaveFrequencies.poll();
		double timeInMillis = timeInSeconds * 1000;
		return timeInMillis;
	}
	
	public Queue<Enemy> getPackOfEnemyComing() {
		Wave wave = this.allWaves.poll();
		return this.gameFactory.getIndividualWaveQueue(wave, this.gameData.getCurrentLevel());
	}

}
