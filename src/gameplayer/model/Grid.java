package gameplayer.model;

public class Grid {

	private Cell[][] grid;
	
	public Grid(int x, int y) {
		grid = new Cell[x][y];
	}
	
	public Cell[][] getGrid(){
		return grid;
	}

}
