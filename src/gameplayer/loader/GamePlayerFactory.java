package gameplayer.loader;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Observable;
import java.util.Queue;

import engine.TowerType;
import gameplayer.model.Cell;
import gameplayer.model.Enemy;
import gameplayer.model.Grid;
import gameplayer.model.Tower;

public class GamePlayerFactory{
	XMLParser authoringFileReader;
	HashMap<Integer, TowerType> allTowerTypes;


	public GamePlayerFactory(XMLParser parser){
		this.authoringFileReader = parser;
	}
	
	private void generateAllTowerTypes(){
		HashMap<Integer,TowerType> allTowers = new HashMap<>(); 
		String name = authoringFileReader.getTextValue("tower", "name");
		String imageLocation = authoringFileReader.getTextValue("tower", "imageLocation");
		double cost = Double.parseDouble(authoringFileReader.getTextValue("tower", "cost"));
		double sellAmount = Double.parseDouble(authoringFileReader.getTextValue("tower", "sellAmount"));
		int fireRate = Integer.parseInt(authoringFileReader.getTextValue("tower", "fireRate"));
		int unlockLevel = Integer.parseInt(authoringFileReader.getTextValue("tower", "unlockLevel"));
		allTowers.put(1,new TowerType(name,imageLocation,cost,sellAmount,fireRate,unlockLevel));
		this.allTowerTypes = allTowers;
		
	}
	
	public HashMap<String, Double> getGameSetting(){
		HashMap<String,Double>settings = new HashMap<>(); 
		settings.put("lives", Double.parseDouble(authoringFileReader.getVariableValues("lives")));
		settings.put("gold",  Double.parseDouble(authoringFileReader.getVariableValues("gold")));
		settings.put("levelnumber",  Double.parseDouble(authoringFileReader.getVariableValues("levelnumber")));
		return settings; 
	}

	public Grid getGrid(int level){
		String width = authoringFileReader.getTextValue("level"+level,"width");
		String height = authoringFileReader.getTextValue("level"+level,"height");
		Grid gameGrid = new Grid(Integer.parseInt(width),Integer.parseInt(height));
		String coordinates = authoringFileReader.getTextValue("level"+level, "coordinates");
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
	
	
	
	public HashMap<Integer, TowerType> getTowers(){
		return this.allTowerTypes; 
	}
	
	public List<Queue<Enemy>> getEnemy(){
		// each queue is a wave of enemy 
		// ArrayList of queue are all the waves at the current level
		
		
		
		return null;
	}
	
	
	public String getGameTitle(){
		return this.authoringFileReader.getName();
	}
}
