package gameplayer.loader;

import java.util.HashMap;

import gameplayer.model.Grid;

public class GamePlayerFactory {
	
	XMLParser authoringFileReader;

	public GamePlayerFactory(XMLParser parser){
		authoringFileReader = parser;
//		System.out.println(authoringFileReader.getTagsUnder("level1"));
	}
	
	public HashMap<String, Double> getGameSetting(){
		HashMap<String,Double>settings = new HashMap<>(); 
		settings.put("lives", Double.parseDouble(authoringFileReader.getVariableValues("lives")));
		settings.put("gold",  Double.parseDouble(authoringFileReader.getVariableValues("lives")));
		settings.put("levelnumber",  Double.parseDouble(authoringFileReader.getVariableValues("levelnumber")));
		return settings; 
	}
	
//	public Grid getGrid(int level){
//		
//		
//		
//		
//	}
	
}
