package gameplayer.loader;

import java.util.ArrayList;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.ResourceBundle;

import engine.effect.EffectManager;
import engine.enemy.EnemyKind;
import engine.enemy.EnemyManager;
import engine.level.Level;
import engine.level.LevelManager;
import engine.level.wave.Wave;
import engine.path.Coordinate;
import engine.path.PathKind;
import engine.path.PathManager;
import engine.settings.GameMode;
import engine.settings.GameModeManager;
import engine.tower.Tower;
import engine.tower.TowerManager;
import engine.weapon.Weapon;
import engine.weapon.WeaponManager;
import gameplayer.model.Cell;
import gameplayer.model.Grid;
import gameplayer.model.enemy.Enemy;
import gameplayer.model.Path;

public class GamePlayerFactory{
	public static final String DEFAULT_RESOURCE_PACKAGE = "resources/";
	public static final String SETTING_NAMES = "gamePlayerSettings";
	protected static ResourceBundle RESOURCES = ResourceBundle.getBundle(DEFAULT_RESOURCE_PACKAGE + SETTING_NAMES);

	private EnemyFactory enemyFactory;
	private Grid currGrid;
	
	private LevelManager levelManager;
	private EnemyManager enemyManager;
	private TowerManager towerManager;
	private PathManager pathManager;
	private WeaponManager weaponManager;
	private GameModeManager gameModeManager;
	private GameMode gameMode;

	XMLParser authoringFileReader;	

	public GamePlayerFactory(XMLParser parser){
		this.authoringFileReader = parser;
		this.enemyFactory = new EnemyFactory();
		
		this.levelManager = authoringFileReader.getManager(LevelManager.class);
		this.enemyManager = authoringFileReader.getManager(EnemyManager.class);
		this.towerManager = authoringFileReader.getManager(TowerManager.class);
		this.pathManager = authoringFileReader.getManager(PathManager.class);
		this.weaponManager = authoringFileReader.getManager(WeaponManager.class);
		this.gameModeManager = authoringFileReader.getManager(GameModeManager.class);
		this.gameMode = gameModeManager.getEntity(0);
	}

	public Map<Integer, Weapon> getWeaponBank() {
		return this.weaponManager.getEntities();
	}

	public double getLevelRewardScore(int levelNumber) {
		return this.levelManager.getEntity(levelNumber).getRewardScore();
	}

	public double getLevelRewardMoney(int levelNumber) {
		return this.levelManager.getEntity(levelNumber).getRewardMoney();
	}

	public double getLevelRewardLives(int levelNumber) {
		return this.levelManager.getEntity(levelNumber).getRewardHealth();
	}
	public Map<Integer, Tower> getTowerUpgrades() {
		return this.towerManager.getUpgrades();
	}
	
	public PathManager getPathManager() {
		return this.pathManager;
	}
	public EffectManager getWeaponEffectManager() {
		return this.weaponManager.getWeaponEffectManager();
	}
	
	public EffectManager getWinEffectManager() {
		return this.gameModeManager.getGameModeEffectManager();
	}


	public Map<Integer, Tower> getTowers() {
		return this.towerManager.getEntities();
	}

	public HashMap<String, Double> getGameSetting(){
		HashMap<String,Double>settings = new HashMap<>(); 
		System.out.println("resources???");
		System.out.println(RESOURCES.getString("numLevels"));
		settings.put(RESOURCES.getString("levelNumber"), (double) this.levelManager.getEntityIds().get(0)); 
		settings.put(RESOURCES.getString("lives"),(double) this.gameMode.getInitalLives());
		settings.put(RESOURCES.getString("gold"), (double) this.gameMode.getInitialMoney());
		settings.put(RESOURCES.getString("numLevels"), (double) this.levelManager.getEntities().size());

		return settings; 
	}

	public Grid getGrid(int levelNumber){
		String pathType = this.gameMode.getPathType().name();
		HashMap<Integer, Path> allPaths = new HashMap<Integer, Path>(); 
		Grid levelGrid = new Grid(this.gameMode.getGridSize(), this.gameMode.getGridSize()); 
		Map<Integer, PathKind> paths = this.pathManager.getEntities();
		if(pathType.equals(RESOURCES.getString("freePath"))){
			for (Integer index : paths.keySet()) {
				PathKind currPath = paths.get(index);
				List<Coordinate<Integer>> coordinates = currPath.getCoordinates();
				ArrayList<Cell> cells = new ArrayList<Cell>();
				coordinates.forEach(c -> {
					Cell currCell = levelGrid.getCell(c.getX(), c.getY());
					cells.add(currCell);
				});
				levelGrid.setNoPath(true);
				levelGrid.setStart(cells.get(0));
				levelGrid.setEnd(cells.get(1));
			}			
		}
		else{
			for (Integer pathIndex : paths.keySet()) {
				PathKind currPath = paths.get(pathIndex);
				List<Coordinate<Integer>> coordinates = currPath.getCoordinates();
				ArrayList<Cell> cells = new ArrayList<Cell>();
				coordinates.forEach(c -> {
					Cell currCell = levelGrid.getCell(c.getX(), c.getY());
					cells.add(currCell);
				});
				Path newPath = new Path(cells, levelGrid.getGrid());
				allPaths.put(pathIndex, newPath);
			}
			levelGrid.setAllPath(allPaths);
		}
		this.currGrid = levelGrid;
		return levelGrid;
	}

	public Queue<Wave> getWaves(int levelNumber) {
		Level level = this.levelManager.getEntity(levelNumber);
		List<Wave> waves = level.getWaves();
		Queue<Wave> ret = new LinkedList<Wave>();
		waves.forEach(w -> ret.add(w));
		return ret;
	}

	public Queue<Enemy> getIndividualWaveQueue(Wave wave, int levelNumber) {
		Map<Integer, EnemyKind> enemyTypes = this.enemyManager.getEntities(); //refactor name
		EnemyKind enemyType = enemyTypes.get(wave.getEnemyID());
		Queue<Enemy> enemies = new LinkedList<Enemy>();
		int pathID = wave.getPathID(); 
		for (int i = 0; i < wave.getEnemyCount(); i++) {

			Cell start;
			if (currGrid.isNoPathType()) {
				start = currGrid.getStart();
			}
			else {
				start = currGrid.getPath(pathID).getPathStart();
			}
			enemies.add(this.enemyFactory.createModelEnemy(enemyType, start, pathID));
		}
		return enemies;
	}

	public String getGameTitle() {
		return this.gameMode.getName();
	}
}
