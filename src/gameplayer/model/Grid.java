package gameplayer.model;

import java.util.HashMap;
import java.util.List;

import gameplayer.model.tower.Tower;

public class Grid {

	private Cell[][] grid;
	private Cell start, end;
	private int row;
	private int col;
	private boolean noPath;
	private HashMap<Integer, Path> allPath;

	//boolean value noPath,or path encoded 


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
		Cell current = this.start;
		while (current != null) {
			System.out.println(current.getX() + ", " + current.getY());
			current = current.getNext();
		}
	}


	public void setAllPath(HashMap<Integer, Path> allPath){
		this.allPath = allPath;
	}
	

	public void setNoPath(boolean isPathEmpty) {
		this.noPath = isPathEmpty;
	}
	
	public HashMap<Integer,Path> getAllPaths(){
		return this.allPath;
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
	
	public void setEnd(Cell cell){
		this.end = cell;
	}

	public Cell getStartPoint(){
		System.out.println("start point:");
		System.out.println(this.start);
		return this.start;
	}
	
	public Path getPath(int id){
		return this.allPath.get(id);
		
	}

	public Cell getPathEndPoint(){
		if(this.noPath){
			Cell current = this.start;
			while(current.getNext() != null){
				current = current.getNext();
			}

			this.end = current;
			return current;

		}
		else{
			return this.end;
		}
	}

	public Cell[][] getGrid(){
		return this.grid;
	}

	public void placeTower(Tower t,  int coordx, int coordy){
		grid[coordx][coordy].addTower(t);
	}

	public void removeTower(int xcoord, int ycoord){
		grid[xcoord][ycoord].removeTower();
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
