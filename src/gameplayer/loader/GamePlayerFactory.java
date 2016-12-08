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
		return (HashMap<Integer, Weapon>) authoringFileReader.getWeaponTypes();
		
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
	
	public Map<Integer, Tower> getTowerUpgrades() {
		return authoringFileReader.getTowerUpgrades();
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
		Coordinate<Integer> start;
		//String coordinates = authoringFileReader.getTextValue("level"+level, "path");
		try {
			start = coordinates.get(level);
		} catch (IndexOutOfBoundsException e){
			//TODO: handle null pointer if no path exists
			System.out.println("path doesn't exist,please try make new game");
			return null;
		}
		
		Cell current = gameGrid.getCell(start.getX().intValue(), start.getY().intValue());
		
		gameGrid.setStart(current);
		
		for(int i=1; i< coordinates.size(); i++){
			Coordinate<Integer> nextCoordinate = coordinates.get(i);
			Cell next = gameGrid.getCell(nextCoordinate.getX().intValue(), nextCoordinate.getY().intValue());
			current.setNext(next);
			//System.out.println("in gameplayerfactory: is there a next?");
			//System.out.println(current.getNext());
			current = next; 
		}
		/*
		Cell blah = gameGrid.getStartPoint();
		System.out.println("Alright let's check if path is there");
		while (blah!=null){
			System.out.println(blah.getNext());
			blah = blah.getNext();
		}
		*/
		
		return gameGrid;
	}
	
	
	
	public HashMap<Integer, Tower> getTowers() {
		for (Tower t : authoringFileReader.getTowerTypes().values()) {
			System.out.println("TOWER IMAGE PATH");
			System.out.println(t.getImagePath());
		}
		
		return (HashMap<Integer, Tower>) authoringFileReader.getTowerTypes(); 
	}
	
	
	public List<Queue<Enemy>> getEnemy(int level) {
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
	
	
	
	public String getGameTitle() {
		return this.authoringFileReader.getName();
	}
}
