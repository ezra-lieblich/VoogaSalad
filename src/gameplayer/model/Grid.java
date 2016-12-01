package gameplayer.model;

import java.util.List;

public class Grid {

	private Cell[][] grid;
	private Cell start;
	private int row;
	private int col;
	
	
	public Grid(int x, int y) {
		this.row = x;
		this.col = y;
		grid = new Cell[x][y];
		for(int i = 0; i < grid.length;i++){
			for(int j = 0; j < grid[0].length; j++){
				grid[i][j] = new Cell(i, j);
			}
		}	
	}
	
	//testing
	public void printGrid(){
		System.out.println("Grid");
		for(int i = 0; i < grid.length;i++){
			for(int j = 0; j < grid[0].length; j++){
				System.out.println(grid[i][j].getX()+","+grid[i][j].getY());
			}
		}
	}
	
	public int getRows(){
		return this.row;
	}
	
	public int getCol(){
		return this.col;
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
		t.setCoordinates(x, y);
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
