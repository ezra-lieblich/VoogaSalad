package gameplayer.model;

import java.util.List;

public class Grid {

	private Cell[][] grid;
	private Cell start;
	//private List<Enemy> enemyOnGrid;
	
	
	public Grid(int x, int y) {
		grid = new Cell[x][y];
		for(int i = 0; i < grid.length;i++){
			for(int j = 0; j < grid[0].length; j++){
				grid[i][j] = new Cell(i, j);
			}
		}	
	}
	
	public Cell getCell(int x, int y){
		return grid[x][y];
	}
	
	public void setStart(Cell cell){
		this.start = cell;
	}
	
	public Cell getStartPoint(){
		return this.start;
	}
	
	
	public Cell[][] getGrid(){
		return this.grid;
	}
	
	public void placeTower(Tower t, int x, int y){
		grid[x][y].addTower(t);
	}
	
	/*
	public void updateGrid(){
		for(int i = 0; i < grid.length;i++){
			for(int j = 0; j < grid[0].length; j++){
				//grid[i][j].manageCollision();
			}
		}
		
				
	}

	*/
}
