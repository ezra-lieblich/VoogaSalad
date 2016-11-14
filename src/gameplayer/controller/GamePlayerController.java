package gameplayer.controller;

import gameplayer.loader.XMLParser;
import gameplayer.view.GameGUI;

public class GamePlayerController {
	
	private GameGUI view;
	
	public GamePlayerController(GameGUI gui){
		view = gui; 
		XMLParser authoringFileReader = new XMLParser("../../player.samplexml/test.xml");
		
	}
	

}
