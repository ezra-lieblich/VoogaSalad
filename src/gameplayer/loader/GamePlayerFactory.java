package gameplayer.loader;

import java.util.ArrayList;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Observable;
import java.util.Queue;

import engine.effect.EffectManager;
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

	private EnemyFactory enemyFactory;

	XMLParser authoringFileReader;	

	public GamePlayerFactory(XMLParser parser){
		this.authoringFileReader = parser;
		this.enemyFactory = new EnemyFactory();
	}

	public boolean xmlIsValid() {
		return authoringFileReader.isValid();
	}

	public Map<Integer, engine.weapon.Weapon> getWeaponBank() {
		return (Map<Integer, Weapon>) authoringFileReader.getWeaponTypes();

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
		settings.put("lives",(double) gameSettings.getInitalLives());
		settings.put("gold", (double)gameSettings.getInitialMoney());
		settings.put("totalNumberOfLevels", (double)levelManager.getEntities().size());

		return settings; 
	}

	public Map<Integer, Tower> getTowerUpgrades() {
		System.out.println("size of UPGRADESSSSSSS"+authoringFileReader.getTowerUpgrades().size());
		return authoringFileReader.getTowerUpgrades();
	}



	public Grid getGrid(int levelNumber){
		
		Level level = authoringFileReader.getLevelManager().getEntity(levelNumber);//REMEMBER TO CHANGE
		String pathType = authoringFileReader.getGameMode().getPathType();
		System.out.println("lev num: " +levelNumber);
		List<Integer> levelPaths = level.getPaths();


		if (levelPaths.isEmpty()) {
			System.out.println("Level path is empty!!!");

			//no path
			Grid emptyGrid = new Grid(DEFAULT_GRID_WIDTH, DEFAULT_GRID_HEIGHT);
			emptyGrid.setNoPath(true); 
			return emptyGrid;
		}
		HashMap<Integer, gameplayer.model.Path> allPaths = new HashMap<Integer, gameplayer.model.Path>(); //TODO: REFACTOR NAME
		Grid levelGrid = new Grid(DEFAULT_GRID_WIDTH, DEFAULT_GRID_HEIGHT); //width and height will be from game authoring
		PathManager pathManager = authoringFileReader.getPathManager();
		Map<Integer, Path> paths = pathManager.getEntities();
		/*
		//hard coding
		Cell start = new Cell(0,2);
		Cell end = new Cell(10, 8);
		levelGrid.setStart(start);
		levelGrid.setEnd(end);
		levelGrid.setNoPath(true);
		return levelGrid;
		 */

		if(pathType.equals("Free")){
			System.out.println("Paths list in game mode" +authoringFileReader.getGameMode().getPaths().size());
			List<Integer> hardCodedPathIDs = new ArrayList<Integer>();
			hardCodedPathIDs.add(0);
			for (Integer index : hardCodedPathIDs) {
			//for (Integer index : levelPaths) {
				Path currPath = paths.get(index);
				List<Coordinate<Integer>> coordinates = currPath.getCoordinates();
				System.out.println("coordinates size: " + coordinates.size());
				ArrayList<Cell> cells = new ArrayList<Cell>();
				coordinates.forEach(c -> {
					Cell currCell = levelGrid.getCell(c.getX(), c.getY());
					cells.add(currCell);
				});
				levelGrid.setNoPath(true);
				levelGrid.setStart(cells.get(0));

				levelGrid.setEnd(levelGrid.getCell(7, 3));
				//levelGrid.setEnd(cells.get(1));
				//gameplayer.model.Path newPath = new gameplayer.model.Path(cells, levelGrid.getGrid());
				//allPaths.put(index, newPath);
			}

			//levelGrid.setAllPath(allPaths);
			
		}

		else{
			for (Integer index : levelPaths) {
				Path currPath = paths.get(index);
				List<Coordinate<Integer>> coordinates = currPath.getCoordinates();
				System.out.println("coordinates size: " + coordinates.size());
				ArrayList<Cell> cells = new ArrayList<Cell>();
				coordinates.forEach(c -> {
					Cell currCell = new Cell(c.getX(), c.getY());
					cells.add(currCell);
				});
				gameplayer.model.Path newPath = new gameplayer.model.Path(cells, levelGrid.getGrid());
				allPaths.put(index, newPath);
			}

			levelGrid.setAllPath(allPaths);
		}
		
		return levelGrid;

	}

	public EffectManager getWeaponEffectManager() {
		return this.authoringFileReader.getWeaponEffectManager();
	}


	public Map<Integer, Tower> getTowers() {
		for (Tower t : authoringFileReader.getTowerTypes().values()) {
			System.out.println("TOWER IMAGE PATH");
			System.out.println(t.getImagePath());
		}

		return (Map<Integer, Tower>) authoringFileReader.getTowerTypes(); 
	}


	public Queue<Wave> getWaves(int levelNumber) {
		Level level = this.authoringFileReader.getLevelManager().getEntity(levelNumber);//NEED TO CHANGE
		List<Wave> waves = level.getWaves();
		Queue<Wave> ret = new LinkedList<Wave>();
		waves.forEach(w -> ret.add(w));
		return ret;
	}

	public Queue<Enemy> getIndividualWaveQueue(Wave wave, int levelNumber) {
		System.out.println("dsakfhsdaf jksdahflsjksdhafjk sdahjk sdah");
		Map<Integer, engine.enemy.Enemy> enemyTypes = this.authoringFileReader.getEnemyTypes(); //refactor name
		engine.enemy.Enemy enemyType = enemyTypes.get(wave.getEnemyID());
		Queue<Enemy> enemies = new LinkedList<Enemy>();
		int pathID = wave.getPathID(); //needs to start at 0, hacky fix
		System.out.println("Path id: "+pathID);
		for (int i = 0; i < wave.getEnemyCount(); i++) {
			//System.out.println("Level: "+levelNumber);
			//System.out.println("Does the grid with the path exist?");
			//System.out.println(this.getGrid(levelNumber).getPath(pathID));
			Cell start;
			if (this.getGrid(levelNumber).isNoPathType()) {
				start = this.getGrid(levelNumber).getStart();
			}
			else {
				start = this.getGrid(levelNumber).getPath(pathID).getPathStart();
			}
			enemies.add(this.enemyFactory.createModelEnemy(enemyType, start, pathID));
		}
		return enemies;
	}

	public String getGameTitle() {
		return this.authoringFileReader.getName();
	}
}
