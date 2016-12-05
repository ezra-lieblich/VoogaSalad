package gameplayer.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Observable;
import java.util.Queue;

import gameplayer.loader.GamePlayerFactory;
import gameplayer.model.weapon.Weapon;
import gameplayer.view.GridGUI;
import gameplayer.view.helper.GraphicsLibrary;
import javafx.scene.image.ImageView;

public class EnemyManager extends Observable {
	private List<Enemy> enemyOnGrid;
	private GamePlayModel gamePlayModel;
	private Grid grid;
	private Cell current;
	private Cell currentCopy;
	private GraphicsLibrary graphicLib;
	private int pastEnemyId;

	public EnemyManager(GamePlayModel model) {
		this.enemyOnGrid = new ArrayList<Enemy>();
		this.gamePlayModel = model;
		this.grid = this.gamePlayModel.getGrid();
		this.graphicLib = new GraphicsLibrary();
		this.pastEnemyId = 0;

	}

	public void setCurrentCell(Cell cell) {
		System.out.println("CURRENT CELL SET: " + cell.getX() + ", " + cell.getY());
		this.current = cell;
		this.currentCopy = cell;
	}

	public List<Enemy> getEnemyOnGrid() {
		return enemyOnGrid;
	}

	public void spawnEnemy(Enemy enemy) {
		enemyOnGrid.add(enemy);
	}

	// TODO: move to EnemyModel
	private void moveSingleEnemy(Enemy e) {
		// to make it easier, only updating enemy's current cell once it reaches
		// the center point of the next cell
		double distToMove;
		boolean onLastCell = false;

		double moveDist = e.getMovingSpeed();

		while (moveDist > 0) {
			try {
				distToMove = (Math.abs(gamePlayModel.cellToCoordinate(e.getCurrentCell().getNext().getX()) - e.getX())
						+ Math.abs(gamePlayModel.cellToCoordinate(e.getCurrentCell().getNext().getY() - e.getY())));
			} catch (NullPointerException exception) { // enemy is currently at
														// last cell on path
				double destinationXpos = e.getCurrentCell().getX()
						+ e.getxDirection() * gamePlayModel.getCellSize() / 2; // midpoint
																				// +
																				// width/2
																				// =
																				// edge
				double destinationYpos = e.getCurrentCell().getY()
						+ e.getyDirection() * gamePlayModel.getCellSize() / 2;
				distToMove = Math.abs(destinationXpos - e.getX()) + Math.abs(destinationYpos - e.getY());
				onLastCell = true;
			}
			if (moveDist >= distToMove) { // can move to center of next cell
				e.setX(e.getX() + e.getxDirection() * distToMove);
				e.setY(e.getY() + e.getyDirection() * distToMove);
				if (onLastCell) {
					gamePlayModel.setLife(gamePlayModel.getLife() - 1);
				}
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

		// sub lives if enemy got into base
	}

	// TODO: move to EnemyModel
	private void updateEnemy() {
		// move on Grid Enemy
		for (Enemy e : enemyOnGrid) {
			moveSingleEnemy(e);
			setChanged();
			notifyObservers();
		}

		// enter new enemy
		if (this.gamePlayModel.getNextEnteringEnemy() != null) {
			enemyOnGrid.add(this.gamePlayModel.getNextEnteringEnemy());
			this.gamePlayModel.getNextEnteringEnemy().setCurrentCell(this.grid.getStartPoint());
			setChanged();
			notifyObservers();
		}

		if (this.gamePlayModel.getPackOfEnemyComing().isEmpty() && enemyOnGrid.isEmpty()&& this.gamePlayModel.getNextEnteringEnemy() == null  ) {
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

	// TODO: move to EnemyModel
	public List<Enemy> getEnemyList() {
		return this.enemyOnGrid;
	}

	public void update() {
		// updateEnemy();
		// checkCollision();

		moveEnemies();
	}

	private void moveEnemies() {
		for (Enemy enemy : enemyOnGrid) {
			moveIndividualEnemy(enemy);
		}
	}
	private void setEnemyImageSize(ImageView enemyImage){
		graphicLib.setImageViewParams(enemyImage, this.gamePlayModel.getCellWidth(),  this.gamePlayModel.getCellHeight());
	}
	
	private int[] coordinateToCell(double pixelx, double pixely){
		int x =(int)(this.gamePlayModel.getCellWidth()*pixelx/GridGUI.GRID_WIDTH);
		int y= (int)(this.gamePlayModel.getCellHeight()*pixely/GridGUI.GRID_HEIGHT);
		int[] cell  = {x,y};
		return cell;
	}
	
	
	private void moveIndividualEnemy(Enemy enemy) {
		/*
		if (enemy.getUniqueID() != this.pastEnemyId){
			this.current = currentCopy; //reset if a new enemy (prob won't work)
			this.pastEnemyId = enemy.getUniqueID();
		}
		*/
		//System.out.println("Cell width: " + this.gamePlayModel.getCellWidth());
		//System.out.println("Current.getX();" + this.current.getX() + ", Current.getY(): " + this.current.getY());
		if (this.current != null) {
			if (enemy.getX() < (current.getX() * this.gamePlayModel.getCellWidth())
					&& (enemy.getY() /*+ this.gamePlayModel.getCellHeight()*/) < current.getY()
							* this.gamePlayModel.getCellHeight()) {
				// System.out.println("Both should move");
				enemy.setX(enemy.getX() + enemy.getMovingSpeed());
				enemy.setY(enemy.getY() + enemy.getMovingSpeed());
				/*
				int[] coords = coordinateToCell(enemy.getX(),enemy.getY());
				enemy.setCell(this.gamePlayModel.getGrid().getCell(coords[0], coords[1]));
				*/
			} else if (enemy.getX() < (current.getX() * this.gamePlayModel.getCellWidth())
					&& !(enemy.getY() < (current.getY() * this.gamePlayModel.getCellHeight()))) {
				enemy.setX(enemy.getX() + enemy.getMovingSpeed());
				/*
				int[] coords = coordinateToCell(enemy.getX(),enemy.getY());
				enemy.setCell(this.gamePlayModel.getGrid().getCell(coords[0], coords[1]));
				*/
			} else if (enemy.getY() > (current.getY() * this.gamePlayModel.getCellHeight()) && enemy.getY()<(current.getY() * (this.gamePlayModel.getCellHeight()+1))
					&& !(enemy.getX() < (current.getX() * this.gamePlayModel.getCellWidth()))) {
				enemy.setY(enemy.getY() + enemy.getMovingSpeed());
				/*
				int[] coords = coordinateToCell(enemy.getX(),enemy.getY());
				enemy.setCell(this.gamePlayModel.getGrid().getCell(coords[0], coords[1]));
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

}
