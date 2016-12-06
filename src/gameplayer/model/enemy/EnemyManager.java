package gameplayer.model.enemy;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Observable;
import java.util.Queue;

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
	private Grid grid;
	private Cell current;
	private Cell currentCopy;
	private Cell startCell;
	private GraphicsLibrary graphicLib;
	private int uniqueEnemyID;

	private List<Queue<Enemy>> allEnemyAtCurrentLevel;
	private Queue<Enemy> currentWave;
	private int waveNumber;
	private Enemy upComingEnemy;


	public EnemyManager(GamePlayData gameData) {
		this.gameData = gameData;
		initializeNewLevel();
		this.graphicLib = new GraphicsLibrary();
	}

	public void initializeNewLevel(){
		this.grid = this.gameData.getGrid();
		this.startCell = this.grid.getStartPoint();
		this.uniqueEnemyID = 0;
		this.enemyOnGrid = new HashMap<Integer, Enemy>();
		waveNumber = 0;
		this.allEnemyAtCurrentLevel = this.gameData.getFactory().getEnemy(this.gameData.getCurrentLevel());
		currentWave = this.allEnemyAtCurrentLevel.get(waveNumber);
		this.waveNumber++;
		upComingEnemy = this.currentWave.poll();

	}

	public void setCurrentCell(Cell cell) {
		System.out.println("CURRENT CELL SET: ");
		System.out.println(cell.getX() + ", " + cell.getY());
		this.current = cell;
		this.currentCopy = cell;
	}


	public HashMap<Integer, Enemy> getEnemyOnGrid() {
		System.out.println("are there enemies in enemymnager?");
		System.out.println(enemyOnGrid);
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
		//enemy.setX(enemy.getCurrentCell().);
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
			System.out.println(e.getCurrentCell().getX() + " currentCell " + e.getCurrentCell().getY()); //testing
			try {
				distToMove = (Math.abs(gameData.cellToCoordinate(e.getCurrentCell().getNext().getX()) - e.getX())
						+ Math.abs(gameData.cellToCoordinate(e.getCurrentCell().getNext().getY() - e.getY())));
			} catch (NullPointerException exception) { // enemy is currently at
				// last cell on path
				double destinationXpos = e.getCurrentCell().getX()
						+ e.getxDirection() * gameData.getCellSize() / 2; // midpoint
				// +
				// width/2
				// =
				// edge
				double destinationYpos = e.getCurrentCell().getY()
						+ e.getyDirection() * gameData.getCellSize() / 2;
				distToMove = Math.abs(destinationXpos - e.getX()) + Math.abs(destinationYpos - e.getY());
				onLastCell = true;
			}
			if (moveDist >= distToMove) { // can move to center of next cell
				e.setX(e.getX() + e.getxDirection() * distToMove);
				e.setY(e.getY() + e.getyDirection() * distToMove);
				if (onLastCell) {
					gameData.setLife(gameData.getLife() - 1);
				}
				if (onLastCell) return;
				e.setCurrentCell(e.getCurrentCell().getNext());
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
		// sub lives if enemy got into base
	}


	/*
	private void updateEnemy() {
		// move on Grid Enemy
		for (Enemy e : enemyOnGrid) {
			moveSingleEnemy(e);
			setChanged();
			notifyObservers();
		}

		// enter new enemy
		if (this.gameData.getFactory().getNextEnteringEnemy() != null) {
			enemyOnGrid.add(this.gamePlayModel.getNextEnteringEnemy());
			this.gameData.getNextEnteringEnemy().setCurrentCell(this.grid.getStartPoint());
			setChanged();
			notifyObservers();
		}

		if (this.gamePlayModel.getPackOfEnemyComing().isEmpty() && enemyOnGrid.isEmpty()
				&& this.gamePlayModel.getNextEnteringEnemy() == null) {
			if (this.gamePlayModel.getWaveOfEnemy() < this.gamePlayModel.getEnemyAtCurrentLevel().size()) {
				this.gamePlayModel.setPackOfEnemyComing(
						this.gamePlayModel.getEnemyAtCurrentLevel().get(this.gamePlayModel.getWaveOfEnemy()));
				this.gamePlayModel.setWaveOfEnemy(this.gamePlayModel.getWaveOfEnemy() + 1);
				setChanged();
				notifyObservers();
			} else {
				gamePlayModel.setLevel(gamePlayModel.getCurrentLevel() + 1);
				setChanged();
				notifyObservers();
			}

		}

		this.gamePlayModel.setNextEnteringEnemy(this.gamePlayModel.getPackOfEnemyComing().poll());

	}
	 */

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


		private void moveIndividualEnemy(Enemy enemy) {
			/*
			 * if (enemy.getUniqueID() != this.pastEnemyId){ this.current =
			 * currentCopy; //reset if a new enemy (prob won't work)
			 * this.pastEnemyId = enemy.getUniqueID(); }
			 */
			// System.out.println("Cell width: " +
			// this.gamePlayModel.getCellWidth());
			// System.out.println("Current.getX();" + this.current.getX() + ",
			// Current.getY(): " + this.current.getY());
			if (this.current != null) {
				if (enemy.getX() < (current.getX() * this.gameData.getCellWidth())
						&& (enemy.getY() /*+ this.gamePlayModel.getCellHeight()*/) < current.getY()
						* this.gameData.getCellHeight()) {
								// System.out.println("Both should move");
				enemy.setX(enemy.getX() + enemy.getMovingSpeed());
				enemy.setY(enemy.getY() + enemy.getMovingSpeed());
				/*
<<<<<<< HEAD:src/gameplayer/model/enemy/EnemyManager.java
				int[] coords = coordinateToCell(enemy.getX(),enemy.getY());
				enemy.setCell(this.gamePlayModel.getGrid().getCell(coords[0], coords[1]));
				 */
							} else if (enemy.getX() < (current.getX() * this.gameData.getCellWidth())
									&& !(enemy.getY() < (current.getY() * this.gameData.getCellHeight()))) {
								enemy.setX(enemy.getX() + enemy.getMovingSpeed());
								/*
				int[] coords = coordinateToCell(enemy.getX(),enemy.getY());
				enemy.setCell(this.gamePlayModel.getGrid().getCell(coords[0], coords[1]));
								 */
							} else if (enemy.getY() > (current.getY() * this.gameData.getCellHeight()) && enemy.getY()<(current.getY() * (this.gameData.getCellHeight()+1))
									&& !(enemy.getX() < (current.getX() * this.gameData.getCellWidth()))) {
							
									enemy.setY(enemy.getY() + enemy.getMovingSpeed());
							/*
							 * int[] coords = coordinateToCell(enemy.getX(),enemy.getY());
							 * enemy.setCell(this.gamePlayModel.getGrid().getCell(coords[0],
							 * coords[1]));
							 */
							}


					/*
					 * if (!(enemy.getX() + enemy.getMovingSpeed() >
					 * GridGUI.GRID_WIDTH)) { enemy.setX(enemy.getX() +
					 * enemy.getMovingSpeed()); }
					 */

							else {
								this.current = this.current.getNext();
							}
				} else {
					this.current = currentCopy;
				}

			}

			public Queue<Enemy> getPackOfEnemyComing() {
				return this.currentWave;
			}

		}
