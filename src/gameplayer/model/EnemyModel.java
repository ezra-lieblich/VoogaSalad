package gameplayer.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Observable;
import java.util.Queue;

import gameplayer.loader.GamePlayerFactory;
import gameplayer.view.GridGUI;

public class EnemyModel extends Observable {
	private List<Enemy> enemyOnGrid;
	private GamePlayModel gamePlayModel;
	private Grid grid;

	public EnemyModel(GamePlayModel model, GamePlayerFactory factory) {
		this.enemyOnGrid = new ArrayList<Enemy>();
		this.gamePlayModel = model;
		this.grid = this.gamePlayModel.getGrid();

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

		if (this.gamePlayModel.getPackOfEnemyComing().isEmpty() && enemyOnGrid.isEmpty()) {
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
	
	public void update(){
		updateEnemy();
	}

}
