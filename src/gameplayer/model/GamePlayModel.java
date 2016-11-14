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
	
	private int numberOfLife; 
	
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
		return (cellNumber - 0.5) * cellSize;
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
	
	private void updateWeapon(){
		for(Weapon w: weaponOnGrid){
			w.setX(w.getSpeedX() + w.getX());
			w.setY(w.getSpeedY() + w.getY());
			
			if(!coordinateInBound(w.getX(), w.getY())){
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
					weaponOnGrid.add(toAdd);
				}
			}
		}
		
	}
	
	//get direction
	
	
	private void moveSingleEnemy(Enemy e){
		
		
		// sub life when enter the end
	}
	
	private void updateEnemy(){
		// move on Grid Enemy
		for (Enemy e: enemyOnGrid){
			moveSingleEnemy(e);
		}
		
		
		//enter new enemy
		if(this.nextEnteringEnemy != null)
			enemyOnGrid.add(this.nextEnteringEnemy);
		this.nextEnteringEnemy = packOfEnemyComing.poll();
		
		
	}
	
	
	public void update(){
		checkCollision();
		updateWeapon();		
		updateEnemy();
		
		
	}
	
	
	
	
	
	
	
	
	
	
	

}
