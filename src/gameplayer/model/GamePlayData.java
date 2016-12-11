package gameplayer.model;
import java.io.IOException;
import java.util.HashMap;
import java.util.Observable;

import gameplayer.loader.*;
import gameplayer.view.GridGUI;
import statswrapper.Wrapper;

public class GamePlayData  extends Observable{
	private GamePlayerFactory factory;
	private int currentLevel;

	private Grid grid;
	private Cell[][] gridArray;
	private int gridX;
	private int gridY;
	private double gold;
	private double lives;
	private double numLevels; // reach level number winning the game
	private double score;
	

	//CELL SIZE MUST BE INITIATED

	public GamePlayData(GamePlayerFactory factory){
		this.factory = factory;
	}
	
	/**
	 * could be used when start another game
	 * 
	 * @param factory
	 */
	public void initializeGameSetting() {
		HashMap<String, Double> settingInfo = this.factory.getGameSetting();
		this.numLevels = settingInfo.get("totalNumberOfLevels");  // put into property file
		this.gold = settingInfo.get("gold");
		this.lives = settingInfo.get("lives");
		this.currentLevel = 0;
		this.score = 0;
	}
	
	public void initializeLevelInfo() {
		setLevel(this.currentLevel++);
		this.grid = this.factory.getGrid(this.currentLevel);
		gridArray = this.grid.getGrid();
		this.gridX = this.gridArray.length;
		this.gridY = this.gridArray[0].length;
		
		// get level rewards and change current score, life, gold according
	}

	public GamePlayerFactory getFactory(){
		return this.factory;
	}
	
	public int getRow() {
		return this.gridX;
	}

	public int getColumns() {
		return this.gridY;
	}


	public Grid getGrid() {
		//System.out.println("Successfully got grid");
		this.grid = this.factory.getGrid(this.currentLevel);
		return this.grid;
	}
	
	public Cell[][] getGridArray() {
		return this.gridArray;
	}

	public int getLevelNumber() {
		return (int) this.numLevels;
	}

	//@EffectMethod
	public double getGold() {
		return gold;
	}
	
	public double getScore(){
		return this.score;
	}
	
	public void setScore(double additionalScore){
		this.score += additionalScore;
		setChanged();
		notifyObservers();
	}

	public void setGold(double gold) {
		System.out.println("Setting gold");
		this.gold = gold;
		try {
			Wrapper.getInstance().updateGameScores("gold", Integer.toString((int)this.currentLevel), Double.toString(this.gold));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		setChanged();
		notifyObservers();
	}

	public double getLife() {
		return this.lives;
	}

	// used by enemymodel
	public void setLife(double life) {
		this.lives = life;
		try {
			Wrapper.getInstance().updateGameScores("lives", Integer.toString((int)this.currentLevel), Double.toString(this.lives));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		setChanged();
		notifyObservers();
	}

	public void setLevel(int d) {
		this.currentLevel = d;
		try {
			Wrapper.getInstance().updateGameScores("level", Integer.toString((int)this.currentLevel), Double.toString(this.currentLevel));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		setChanged();
		notifyObservers();
	}

	public int getCurrentLevel() {
		return this.currentLevel;
	}

	public double getCellWidth() {
		return GridGUI.GRID_WIDTH / this.getColumns();
	}

	public double getCellHeight() {
		return GridGUI.GRID_HEIGHT / this.getRow();
	}

	public double cellToCoordinate(double d) {
		return (d) * getCellWidth();
	}
	
	/**
	 * utility methods for each single classes
	 */
	public Boolean coordinateInBound(double x, double y) {
		return (x < GridGUI.GRID_WIDTH && y < GridGUI.GRID_HEIGHT && x > 0 && y > 0);
	}

	public double getDistance(double x1, double y1, double x2, double y2) {
		return Math.sqrt(Math.pow(x2 - x1, 2) + Math.pow(y2 - y1, 2));
	}
	
	private long gcd(long a, long b)
	{
	    while (b > 0)
	    {
	        long temp = b;
	        b = a % b; 
	        a = temp;
	    }
	    return a;
	}

	private long gcd(long[] input)
	{
	    long result = input[0];
	    for(int i = 1; i < input.length; i++) result = gcd(result, input[i]);
	    return result;
	}
	
	private long lcm(long a, long b)
	{
	    return a * (b / gcd(a, b));
	}

	public long lcm(Long[] allFireRates)
	{
	    long result = allFireRates[0];
	    for(int i = 1; i < allFireRates.length; i++) result = lcm(result, allFireRates[i]);
	    return result;
	}


}
