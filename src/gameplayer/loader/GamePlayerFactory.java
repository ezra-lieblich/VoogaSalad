package gameplayer.loader;

import java.util.ArrayList;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Observable;
import java.util.Queue;
import engine.enemy.EnemyType;
import engine.level.LevelTypeManager;
import engine.path.Coordinate;
import engine.path.Path;
import engine.path.PathTypeManager;
import engine.settings.GameMode;
import engine.tower.Tower;
import engine.tower.TowerType;
import engine.weapon.WeaponTypeBuilder;
import engine.weapon.Weapon;
import gameplayer.model.Cell;
import gameplayer.model.Enemy;
import gameplayer.model.Grid;

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
		LevelTypeManager levelManager = authoringFileReader.getLevelManager();
		settings.put("lives", gameSettings.getInitalLives());
		settings.put("gold", gameSettings.getInitialMoney());
		settings.put("totalNumberOfLevels", (double) levelManager.getEntities().size());
		return settings; 
	}
	
	/*
	public int[] getGridDimension{
		int width = Integer.parseInt(authoringFileReader.getTextValue("level"+level,"width"));
		int height = Integer.parseInt(authoringFileReader.getTextValue("level"+level,"height"));
		
		
	}

	*/
	
	
	public Grid getGrid(int level){
		PathTypeManager pathManager = authoringFileReader.getPathManager();
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
		return authoringFileReader.getEnemy(level); 
	}
	
	
	
	public String getGameTitle() {
		return this.authoringFileReader.getName();
	}
}
