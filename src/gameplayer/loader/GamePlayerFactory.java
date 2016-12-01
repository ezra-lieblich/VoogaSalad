package gameplayer.loader;

import java.util.ArrayList;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Observable;
import java.util.Queue;
import engine.enemy.EnemyType;
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
		settings.put("totalNumberOfLevels", Double.parseDouble(authoringFileReader.getVariableValues("numLevels")));
		settings.put("lives", Double.parseDouble(authoringFileReader.getVariableValues("lives")));
		settings.put("gold",  Double.parseDouble(authoringFileReader.getVariableValues("gold")));
		settings.put("levelnumber",  Double.parseDouble(authoringFileReader.getVariableValues("levelnumber")));
		return settings; 
	}
	
	/*
	public int[] getGridDimension{
		int width = Integer.parseInt(authoringFileReader.getTextValue("level"+level,"width"));
		int height = Integer.parseInt(authoringFileReader.getTextValue("level"+level,"height"));
		
		
	}

	*/
	
	
	public Grid getGrid(int level){
		String width = authoringFileReader.getTextValue("level"+level,"width");
		String height = authoringFileReader.getTextValue("level"+level,"height");
		Grid gameGrid = new Grid(Integer.parseInt(width),Integer.parseInt(height));
		String coordinates = authoringFileReader.getTextValue("level"+level, "coordinate");
		//String coordinates = authoringFileReader.getTextValue("level"+level, "path");
		String[] splitCoordinates = coordinates.split(";");
		String[] start = splitCoordinates[0].split(",");
		Cell current = gameGrid.getCell(Integer.parseInt(start[0]), Integer.parseInt(start[1]));
		
		gameGrid.setStart(current);
		
		for(int i=1;i<splitCoordinates.length;i++){
			String[] nextLocations = splitCoordinates[i].split(",");
			Cell next = gameGrid.getCell(Integer.parseInt(nextLocations[0]), Integer.parseInt(nextLocations[1]));
			current.setNext(next);
			current = next; 
		}
		return gameGrid; 	
	}
	
	
	
	public HashMap<Integer, Tower> getTowers() {
		return authoringFileReader.getTowerTypes(); 
	}
	
	
	public List<Queue<Enemy>> getEnemy(int level) {
		return authoringFileReader.getEnemy(level); 
	}
	
	
	
	public String getGameTitle() {
		return this.authoringFileReader.getName();
	}
}
