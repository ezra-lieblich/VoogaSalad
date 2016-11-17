package gameplayer.loader;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Observable;
import java.util.Queue;

import gameplayer.model.Enemy;
import gameplayer.model.Grid;
import gameplayer.model.Tower;

public class GamePlayerFactory{
	XMLParser authoringFileReader;
	private int currentLivel; // know which level for level specific info

	public GamePlayerFactory(String fileLocation){
		authoringFileReader = new XMLParser(fileLocation);
//		System.out.println(authoringFileReader.getTagsUnder("level1"));
	}
	
	public HashMap<String, Double> getGameSetting(){
		HashMap<String,Double>settings = new HashMap<>(); 
		settings.put("lives", Double.parseDouble(authoringFileReader.getVariableValues("lives")));
		settings.put("gold",  Double.parseDouble(authoringFileReader.getVariableValues("lives")));
		settings.put("levelnumber",  Double.parseDouble(authoringFileReader.getVariableValues("levelnumber")));
		return settings; 
	}
	
	
	public void getLevelInfo(int level){
		this.currentLivel = level;
	}

	
	public Grid getGrid(int level){
		
		
		return null;		
	}
	
	public Map<Integer, Tower> getTowers(){
		
		
		return null;
	}
	
	public List<Queue<Enemy>> getEnemy(){
		// each queue is a wave of enemy 
		// ArrayList of queue are all the waves at the current level
		
		return null;
	}
	
}
