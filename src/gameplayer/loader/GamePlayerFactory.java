package gameplayer.loader;

import java.util.ArrayList;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Observable;
import java.util.Queue;
import engine.enemy.EnemyType;
import engine.level.Level;
import engine.level.LevelManager;
import engine.level.LevelTypeManager;
import engine.level.wave.Wave;
import engine.path.Coordinate;
import engine.path.Path;
import engine.path.PathManager;
import engine.path.PathTypeManager;
import engine.settings.GameMode;
import engine.tower.Tower;
import engine.tower.TowerType;
import engine.weapon.WeaponTypeBuilder;
import engine.weapon.Weapon;
import gameplayer.model.Cell;
import gameplayer.model.Grid;
import gameplayer.model.enemy.Enemy;

public class GamePlayerFactory{
	
	public static final int DEFAULT_GRID_WIDTH = 10;
	public static final int DEFAULT_GRID_HEIGHT = 10;

	XMLParser authoringFileReader;	

	public GamePlayerFactory(XMLParser parser){
		this.authoringFileReader = parser;
	}
	
	public boolean xmlIsValid() {
		return authoringFileReader.isValid();
	}
	
	public HashMap<Integer, engine.weapon.Weapon> getWeaponBank() {
		return (HashMap<Integer, Weapon>) authoringFileReader.getWeaponTypes();
		
	}
	 
	public double getLevelRewardScore(int levelNumber) {
		LevelManager levelManager = authoringFileReader.getLevelManager();
		return levelManager.getEntity(levelNumber).getRewardScore();
	}
	
	public double getLevelRewardMoney(int levelNumber) {
		LevelManager levelManager = authoringFileReader.getLevelManager();
		return levelManager.getEntity(levelNumber).getRewardMoney();
	}
	
	public double getLevelRewardLives(int levelNumber) {
		LevelManager levelManager = authoringFileReader.getLevelManager();
		return levelManager.getEntity(levelNumber).getRewardHealth();
	}

	
	public HashMap<String, Double> getGameSetting(){
		HashMap<String,Double>settings = new HashMap<>(); 
		GameMode gameSettings = authoringFileReader.getGameMode();
		LevelManager levelManager = authoringFileReader.getLevelManager();
		settings.put("levelnumber", 0.0); 
		settings.put("lives", 5.0);
		settings.put("gold", 1000000.0);
		settings.put("totalNumberOfLevels", 3.0);

		return settings; 
	}
	
	public Map<Integer, Tower> getTowerUpgrades() {
		return authoringFileReader.getTowerUpgrades();
	}
	
	
	
	public Grid getGrid(int levelNumber){
		Level level = authoringFileReader.getLevelManager().getEntity(levelNumber);
		List<Integer> levelPaths = level.getPaths();
		if (levelPaths.isEmpty()) {//no path
			Grid emptyGrid = new Grid(DEFAULT_GRID_WIDTH, DEFAULT_GRID_HEIGHT);
			emptyGrid.setNoPath(true); 
			return emptyGrid;
		}
		HashMap<Integer, gameplayer.model.Path> allPaths = new HashMap<Integer, gameplayer.model.Path>(); //TODO: REFACTOR NAME
		Grid levelGrid = new Grid(DEFAULT_GRID_WIDTH, DEFAULT_GRID_HEIGHT); //width and height will be from game authoring
		PathManager pathManager = authoringFileReader.getPathManager();
		Map<Integer, Path> paths = pathManager.getEntities();
		for (int i = 0; i < levelPaths.size(); i++) {
			Path currPath = paths.get(i);
			List<Coordinate<Integer>> coordinates = currPath.getCoordinates();
			ArrayList<Cell> cells = new ArrayList<Cell>();
			coordinates.forEach(c -> {
				Cell currCell = new Cell(c.getX(), c.getY());
				cells.add(currCell);
			});
			gameplayer.model.Path newPath = new gameplayer.model.Path(cells, levelGrid.getGrid());
			allPaths.put(i, newPath);
		}
		
		levelGrid.setAllPath(allPaths);
		return levelGrid;
	}
	
	
	
	public HashMap<Integer, Tower> getTowers() {
		for (Tower t : authoringFileReader.getTowerTypes().values()) {
			System.out.println("TOWER IMAGE PATH");
			System.out.println(t.getImagePath());
		}
		
		return (HashMap<Integer, Tower>) authoringFileReader.getTowerTypes(); 
	}
	
	/*
	public List<Queue<Enemy>> getEnemy(int levelNumber) {
		//System.out.println("Grid, is this empty? : ");
		//System.out.println(this.getGrid(0).getCell(0, 0));
		Queue<Enemy> myQueue = new LinkedList<Enemy>();
		Queue<Enemy> myQueue1 = new LinkedList<Enemy>();
		Enemy enem1 = new Enemy(1, "Izaya", 4, 7, "questionmark.png", 50.0, 50.0);
		System.out.println("enem1: ");
		System.out.println(enem1);
		enem1.setCurrentCell(this.getGrid(0).getStartPoint());
		Enemy enem2 = new Enemy(2, "Shizuo", 4, 7, "questionmark.png", 50.0, 50.0);
		enem2.setCurrentCell(this.getGrid(0).getStartPoint());
		Enemy enem3 = new Enemy(3, "Mikado", 4, 7, "kaneki.jpg", 50.0, 50.0);
		enem3.setCurrentCell(this.getGrid(0).getStartPoint());
		Enemy enem4 = new Enemy(4, "Kanra", 4, 7, "penguin.jpg", 50.0, 50.0);
		enem4.setCurrentCell(this.getGrid(0).getStartPoint());
		myQueue.add(enem1);
		// myQueue.add(enem2);
		// myQueue.add(enem3);
		myQueue.add(enem4);
		myQueue1.add(enem1);
		myQueue1.add(enem2);
		myQueue1.add(enem3);
		myQueue1.add(enem4);
		List<Queue<Enemy>> stuff = new ArrayList<Queue<Enemy>>();
		stuff.add(myQueue);
		stuff.add(myQueue1);
		return stuff;
	}
	*/
	public Queue<Wave> getWaves(int levelNumber) {
		Level level = this.authoringFileReader.getLevelManager().getEntity(levelNumber);
		List<Wave> waves = level.getWaves();
		Queue<Wave> ret = new LinkedList<Wave>();
		waves.forEach(w -> ret.add(w));
		return ret;
		/*
		Queue<Queue<Enemy>> ret = new LinkedList<Queue<Enemy>>();
		for (Wave wave : waves) {
			engine.enemy.Enemy enemyType = enemyTypes.get(wave.getEnemyID()); //refactor name
			Queue<Enemy> enemies = new LinkedList<Enemy>();
			for (int i = 0; i < wave.getEnemyCount(); i++) {
				Cell start = this.getGrid(levelNumber).getStartPoint();
				EnemyFactory enemyFactory = new EnemyFactory(enemyType, start);
				
				enemies.add(enemyFactory.createModelEnemy());
			}
			ret.add(enemies);
		}
		return ret;
		*/
	}
	
	public Queue<Enemy> getIndividualWaveQueue(Wave wave, int levelNumber) {
		Map<Integer, engine.enemy.Enemy> enemyTypes = this.authoringFileReader.getEnemyTypes(); //refactor name
		engine.enemy.Enemy enemyType = enemyTypes.get(wave.getEnemyID());
		Queue<Enemy> enemies = new LinkedList<Enemy>();
		int pathID = wave.getPathID();
		for (int i = 0; i < wave.getEnemyCount(); i++) {
			Cell start = this.getGrid(levelNumber).getPath(pathID).getPathStart();
			EnemyFactory enemyFactory = new EnemyFactory(enemyType, start);
			enemies.add(enemyFactory.createModelEnemy());
		}
		return enemies;
	}
	
	
	
	
	public String getGameTitle() {
		return this.authoringFileReader.getName();
	}
}
