package gameplayer.model;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Observable;
import java.util.ResourceBundle;
import java.util.stream.Collectors;
import engine.effect.EffectManager;
import engine.effect.EffectMethod;
import gameplayer.loader.*;
import gameplayer.model.effect.GameEffect;
import gameplayer.model.effect.WinEffectFactory;
import gameplayer.view.GridGUI;
import javafx.beans.property.DoubleProperty;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleIntegerProperty;
import statswrapper.Wrapper;



//This entire file is part of my masterpiece.
//my name : Yumin Zhang

/**
 * the main purpose of this data manager is to manage all the current game status
 * when we save the game progress, we serialize this class 
 * and then reload to construct this class and we are able to restart as the current level
 * with all the game progress saved
 * 
 * the class is divided into three major functionality modules
 * 1. the status storing, 2. Groovy annotated methods, 3. utility functions 
 * 
 * this is working as a singleton class for now, but ideally with multi-game, multi-player
 * this could not be a singleton class
 * 
 * this class is entirely encapsulated in the back end of game play
 * all the back end classes would have access to this data class
 * so the utility functions are created in data, mean to be shared
 * most of the methods are package friendly for gameplay back end to use only
 * however the Groovy annotated methods have to be public in order to let authoring end 
 * to use or do error checking when user inputs a groovy string
 * 
 * @author yuminzhang
 *
 */
public class DataManager extends Observable{
	private GamePlayerFactory factory;
	private IntegerProperty currentLevel = new SimpleIntegerProperty();
	private Grid grid;
	private Cell[][] gridArray;
	private DoubleProperty gold = new SimpleDoubleProperty();
	private DoubleProperty lives = new SimpleDoubleProperty();
	private DoubleProperty numLevels = new SimpleDoubleProperty(); 
	private DoubleProperty score = new SimpleDoubleProperty();	
	private Boolean lose;
	private Boolean win;
	private Map<Integer, GameEffect> allEffects;
	private ResourceBundle myResources; 
	private final String TOTAL_NUMBER_OF_LEVEL = "totalNumberOfLevels";
	private final String GOLD = "gold";
	private final String LIVES  = "lives";
	private final String LEVEL_NUMBER = "levelnumber";
	private final String SCORE_ERROR_MESSAGE = "cannot update score";
	private final String GOLD_ERROR_MESSAGE = "cannot update gold";
	private final String LIVE_ERROR_MESSAGE = "cannot update live";


	/**
	 * created by game play model, and most back end classes have access
	 * to this data manager to allow them change the status of the game
	 * @param factory initialize the info from xml
	 * @param language get the language property file
	 */
	public DataManager(GamePlayerFactory factory, String language){
		myResources = ResourceBundle.getBundle(language);
		this.factory = factory;			
	}


	/**
	 * called when start a new game
	 * @param factory
	 */
	void initializeGameSetting() {
		initializeEffects();
		initilaizeGameStatus();
	}

	/**
	 * this is the Groovy set up method
	 * which gets all the all the user defined Groovy effects from effectManager
	 * then user the factory class to turn the generic Groovy effects into specific type
	 * which is game effect
	 * set up listeners on the values which those game effect's conditions
	 * are constantly checking, so it will notify the effect when the conditions is met
	 * and trigger effect, for win effect, triggers setWin()
	 */
	private void initializeEffects(){		
		WinEffectFactory winFactory = new WinEffectFactory(new GamePlayData(factory));
		EffectManager effectManager = this.factory.getWinEffectManager(); 
		this.allEffects = effectManager.getEntities().entrySet().stream().collect(Collectors.toMap(e-> e.getKey(), e->winFactory.create(e.getValue())));
		allEffects.keySet().forEach(s -> { addListener(allEffects.get(s), this.score); 
											addListener(allEffects.get(s), this.gold);
											this.currentLevel.addListener((Observable, oldValue, newValue) -> allEffects.get(s));;
											});
	}

	/**
	 * helper method for initializeEffects()
	 * ideally the second parameter would be a generic parameter
	 * but did not work in implementation
	 * @param ge is a game effect
	 * @param value is the value to add listener to
	 */
	private void addListener(GameEffect ge, DoubleProperty value){
		value.addListener((Observable, oldValue, newValue) -> ge.execute());

	}

	/**
	 * initialize the game status when start a game or reload a game
	 */
	private void initilaizeGameStatus(){
		HashMap<String, Double> settingInfo = this.factory.getGameSetting();
		this.numLevels.set(settingInfo.get(this.myResources.getString(TOTAL_NUMBER_OF_LEVEL)));  
		this.gold.set(settingInfo.get(this.myResources.getString(GOLD)));
		this.lives.set(settingInfo.get(this.myResources.getString(LIVES)).intValue());
		this.currentLevel.set(settingInfo.get(this.myResources.getString(LEVEL_NUMBER)).intValue()); 
		this.score.set(0);
		this.lose = false;
		this.win = false;
	}


	/**
	 * called by model when initialize a new level
	 * have parallel methods in tower, enemy and weapon managers
	 */
	void initializeLevelInfo() {
		setLevel(this.currentLevel.get());
		this.grid = this.factory.getGrid(this.currentLevel.get());
		gridArray = this.grid.getGrid();

	}

	
//+++++++++++++++++++++ METHODS ALLOWING GROOVY EFFECTS ++++++++++++++++++++
	/**
	 * all the following methods are annotated with Groovy annotation
	 * which means user could create a Groovy effect to access 
	 * all the game stats data to create a very flexible winning and losing condition
	 * the condition could be a complicated one, such as 
	 * let condition to be data.getScore() > 40 && data.getLife() < 5 && data.getLevel() = totalNumberofLevel
	 * when condition is met, trigger data.getWin() or data.setLose()
	 */
	
	
	/**
	 * front end has a observer on those observable values
	 * @param additionalScore
	 * @throws Exception
	 */
	@EffectMethod
	public void setScore(double additionalScore) throws Exception{
		this.score.set(this.score.get() + additionalScore );
		try {
			Wrapper.getInstance().logScore(Double.toString(this.score.get()));
		} catch (IOException e) {
			throw new Exception(myResources.getString(SCORE_ERROR_MESSAGE));
		}
		setChanged();
		notifyObservers();
	}

	@EffectMethod
	public void setGold(double gold) throws Exception {
		this.gold.set(gold);
		try {
			Wrapper.getInstance().updateGameScores(this.myResources.getString(GOLD), Integer.toString((int)this.currentLevel.get()), Double.toString(this.gold.get()));
		} catch (IOException e) {
			throw new Exception(myResources.getString(GOLD_ERROR_MESSAGE));
		}
		setChanged();
		notifyObservers();
	}	
	@EffectMethod
	public double getLevelNumber() {
		return this.numLevels.get();
	}

	@EffectMethod
	public double getGold() {
		return gold.get();
	}

	@EffectMethod
	public double getScore(){
		return this.score.get();
	}
	
	

	@EffectMethod
	public double getLife() {
		return this.lives.get();
	}

	@EffectMethod
	public void setLife(double life) throws Exception {
		this.lives.set((int)life);
		try {
			Wrapper.getInstance().updateGameScores(myResources.getString(LIVES), Integer.toString(this.currentLevel.get()), Double.toString(this.lives.get()));
		} catch (IOException e) {
			throw new Exception(myResources.getString(LIVE_ERROR_MESSAGE)); 
		}
		setChanged();
		notifyObservers();
	}

	@EffectMethod
	public void setLevel(int d) {
		this.currentLevel.set(d);;
		setChanged();
		notifyObservers();
	}

	@EffectMethod
	public int getCurrentLevel() {
		return this.currentLevel.get();
	}

	@EffectMethod
	public int getTotalLevel() {
		return (int)this.numLevels.get();
	}


	@EffectMethod
	public void setWin(){
		this.win = true;
		setChanged();
		notifyObservers();
	}

	@EffectMethod
	public void setLose() {
		this.lose= true;
	}

	@EffectMethod
	public boolean won(){
		return this.win;
	}


	@EffectMethod
	public GamePlayerFactory getFactory(){
		return this.factory;
	}

	@EffectMethod
	public Grid getGrid() {
		return this.grid;
	}

	@EffectMethod
	public Cell[][] getGridArray() {
		return this.gridArray;
	}

	
//++++++++++++++++++++++++++ Utility Functions ++++++++++++++++++++++++++++++

	/**
	 * utility function for converting from cell coordinate
	 * to pixel coordinate
	 * @param d cell coordinate
	 * @return the corresponding pixel coordinate
	 */
	double cellToCoordinate(double d) {
		return d * GridGUI.GRID_WIDTH / this.getGrid().getRows();
	}


	/**
	 * utility methods for checking if the objects is on grid
	 * @param x coordinate of the object
	 * @param y coordinate
	 * @return true means object in bound, false otherwise
	 */
	Boolean coordinateInBound(double x, double y) {
		return (x < GridGUI.GRID_WIDTH && y < GridGUI.GRID_HEIGHT && x > 0 && y > 0);
	}

	/**
	 * utility method for getting the distance between two coordinates
	 * used for checking collision, and checking if object is in attacking range
	 * @param x1, y1 coordinates for the first object
	 * @param x2, y2 coordinates for the second object
	 */
	double getDistance(double x1, double y1, double x2, double y2) {
		return Math.sqrt(Math.pow(x2 - x1, 2) + Math.pow(y2 - y1, 2));
	}



	/**
	 * utility method for getting the greatest common divisor
	 * used for calculating the frames per second based on 
	 * firing rate and moving speed of all the entities 
	 * @param a list of integer value
	 * @return the greatest common divisor for the input
	 */
	public long gcd(Long[] allFireRates)
	{
		long result = allFireRates[0];
		for(int i = 1; i < allFireRates.length; i++) result = gcd(result, allFireRates[i]);
		return result;
	}

	/**
	 * helper method for gcd(long[] input)
	 */
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

}
