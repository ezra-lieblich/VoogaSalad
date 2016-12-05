package gameplayer.loader;

import java.util.ArrayList;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Observable;
import java.util.Queue;
import engine.enemy.EnemyType;
import engine.level.LevelManager;
import engine.level.LevelTypeManager;
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

	XMLParser authoringFileReader;	

	public GamePlayerFactory(XMLParser parser){
		this.authoringFileReader = parser;
	}
	
	public boolean xmlIsValid() {
		return authoringFileReader.isValid();
	}
	
	public HashMap<Integer, engine.weapon.Weapon> getWeaponBank() {
		WeaponTypeBuilder weaponBuilder = new WeaponTypeBuilder();
		HashMap<Integer, Weapon> bank = new HashMap<Integer, Weapon>();
		bank.put(0, weaponBuilder.build());
		return bank;
		
	}

	
	public HashMap<String, Double> getGameSetting(){
		HashMap<String,Double>settings = new HashMap<>(); 
		GameMode gameSettings = authoringFileReader.getGameMode();
		LevelManager levelManager = authoringFileReader.getLevelManager();
		//refactor b/c current exml has no GameModeManager
		settings.put("levelnumber", 0.0); //take this out
		settings.put("lives", 5.0);
		settings.put("gold", 100.0);
		settings.put("totalNumberOfLevels", 3.0);
		return settings; 
	}
	
	/*
	public int[] getGridDimension{
		int width = Integer.parseInt(authoringFileReader.getTextValue("level"+level,"width"));
		int height = Integer.parseInt(authoringFileReader.getTextValue("level"+level,"height"));
		
		
	}

	*/
	
	
	public Grid getGrid(int level){
		PathManager pathManager = authoringFileReader.getPathManager();
		Map<Integer, Path> paths = pathManager.getEntities();
		Path currPath = paths.get(0); //refactor to be the path for current level
		int width = currPath.getGridColumns();
		int height = currPath.getGridRows();
		Grid gameGrid = new Grid(width, height);
		List<Coordinate<Integer>> coordinates = currPath.getCoordinates();
		//String coordinates = authoringFileReader.getTextValue("level"+level, "path");
		Coordinate<Integer> start = coordinates.get(0);
		Cell current = gameGrid.getCell(start.getX().intValue(), start.getY().intValue());
		
		gameGrid.setStart(current);
		
		for(int i=1; i< coordinates.size(); i++){
			Coordinate<Integer> nextCoordinate = coordinates.get(i);
			Cell next = gameGrid.getCell(nextCoordinate.getX().intValue(), nextCoordinate.getY().intValue());
			current.setNext(next);
			current = next; 
		}
		return gameGrid;
	}
	
	
	
	public HashMap<Integer, Tower> getTowers() {
		return (HashMap<Integer, Tower>) authoringFileReader.getTowerTypes(); 
	}
	
	
	public List<Queue<Enemy>> getEnemy(int level) {
		Queue<Enemy> myQueue = new LinkedList<Enemy>();
		Queue<Enemy> myQueue1 = new LinkedList<Enemy>();
		Enemy enem1 = new Enemy(1, "Izaya", 4, 7, "questionmark.png", 50.0, 50.0);
		enem1.setCurrentCell(this.getGrid(0).getCell(0, 0));
		Enemy enem2 = new Enemy(2, "Shizuo", 4, 7, "questionmark.png", 50.0, 50.0);
		enem2.setCurrentCell(this.getGrid(0).getCell(0, 0));
		Enemy enem3 = new Enemy(3, "Mikado", 4, 7, "kaneki.jpg", 50.0, 50.0);
		enem3.setCurrentCell(this.getGrid(0).getCell(0, 0));
		Enemy enem4 = new Enemy(4, "Kanra", 4, 7, "penguin.jpg", 50.0, 50.0);
		enem4.setCurrentCell(this.getGrid(0).getCell(0, 0));
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
	
	
	
	public String getGameTitle() {
		return this.authoringFileReader.getName();
	}
}
