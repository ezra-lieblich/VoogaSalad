package gameplayer.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

public class GamePlayModel {

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
	
	private int numberOfLife;  //initialize in xml
	
	private Enemy nextEnteringEnemy; // decide how each wave of enemy comes either in pack or one at a time
	private Cell startPoint;    // get from xml 
	private Queue<Enemy> packOfEnemyComing;
	
	
	
	
	public GamePlayModel(int cellSize, int gridX, int gridY,int numberOfLife) {	
		this.cellSize = cellSize;	
		this.grid = new Grid(gridX, gridY);
		gridArray = this.grid.getGrid();
		enemyOnGrid = new ArrayList<Enemy>();
		weaponOnGrid = new ArrayList<Weapon>();
		this.gridX = gridX;
		this.gridY = gridY;
		this.numberOfLife = numberOfLife;
		
		//this.iterations = 0;
		
		//initialize path in xml
	}
	
	
	public void placeTower(int type, int x, int y){		
		grid.placeTower(towerTypes.get(type), x, y);	
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
	}
	
	//get direction
	
	
	private void moveSingleEnemy(Enemy e){
		//to make it easier, only updating enemy's current cell once it reaches the center point of the next cell
		double moveDist = e.getMovingSpeed();
		double distToMove = (Math.abs(cellToCoordinate(e.getCurrentCell().getNext().getX()) - e.getX()) + 
				Math.abs(cellToCoordinate(e.getCurrentCell().getNext().getY()) - e.getY()));
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
			}
			
		}
		
		
		// sub life when enter the end
	}
	
	private void updateEnemy(){
		// move on Grid Enemy
		for (Enemy e: enemyOnGrid){
			moveSingleEnemy(e);
		}
		
		
		//enter new enemy
		if(this.nextEnteringEnemy != null) {
			enemyOnGrid.add(this.nextEnteringEnemy);
			this.nextEnteringEnemy.setCurrentCell(this.startPoint);
		}
		this.nextEnteringEnemy = packOfEnemyComing.poll();
		
		
	}
	
	
	public void update(){
		checkCollision();
		updateWeapon();		
		updateEnemy();
		
		
	}
	
	
	
	
	
	
	
	
	
	
	

}
