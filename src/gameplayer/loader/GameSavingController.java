package gameplayer.loader;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;

import authoring.utilityfactories.DialogueBoxFactory;
import gameplayer.model.GamePlayData;
import gameplayer.model.GamePlayModel;
import gameplayer.model.Grid;
import gameplayer.model.enemy.Enemy;
import gameplayer.model.enemy.EnemyManager;
import javafx.scene.control.Alert;

public class GameSavingController {
	//private XStream serializer;
	private GamePlayModel gameModel;
	String xmlName;
	
	public GameSavingController(GamePlayModel model, String xmlFilename) {
		//serializer = new XStream(new DomDriver());
		this.gameModel = model;
		this.xmlName = xmlFilename;
	}
	
	public String toPrettyXML() {
		EnemyManager eman = gameModel.getEnemyManager();
		GamePlayData gameData = gameModel.getData();
		SavedSettings settings = new SavedSettings(this.xmlName);
		settings.setGold(gameData.getGold());
		settings.setLevel(gameData.getCurrentLevel());
		settings.setLives(gameData.getLife());
		settings.setScore(gameData.getScore());
		return new XStream(new DomDriver()).toXML(settings);
	}
	
	public void saveGame() {
		//GamePlayData gameData = gameModel.getData();
		//int level = gameData.getCurrentLevel();
		//String content = this.xmlName+"\n"+level;
		//File dirFile = new File("player.samplexml/savedGame-"+counter);
		
		String content = this.toPrettyXML();
		FileWriter fw;
		try {
			fw = new FileWriter("SavedGames/savedGame.xml");
			BufferedWriter bw = new BufferedWriter(fw);
			bw.write(content);
			bw.close();
		} catch (IOException e) {
			System.out.println("Game does not exist, please choose another");
		}
		
		/*
>>>>>>> 6804c3a6943d043933632ab14cb7138487ba9d41
		try {
			FileWriter writer = new FileWriter(newFile);
			writer.write(content);
			writer.close();
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		*/
	}
}
