package gameplayer.loader;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

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
	int counter;
	String xmlName;
	
	public GameSavingController(GamePlayModel model, String xmlFilename) {
		//serializer = new XStream(new DomDriver());
		this.gameModel = model;
		this.counter = 0;
		this.xmlName = xmlFilename;
	}
	
	public String toPrettyXML() {
		EnemyManager eman = gameModel.getEnemyManager();
		Enemy e = eman.getPackOfEnemyComing().element();
		GamePlayData gameData = gameModel.getData();
		//GamePlayerFactory factory = gameData.getFactory();
		return "" +gameData.getCurrentLevel();
	}
	
	public void saveGame() {
		GamePlayData gameData = gameModel.getData();
		int level = gameData.getCurrentLevel();
		String content = this.xmlName+"\n"+level;
		//File dirFile = new File("player.samplexml/savedGame-"+counter);
		
		FileWriter fw;
		try {
			fw = new FileWriter("player.samplexml/savedGame-"+counter+".txt");
			BufferedWriter bw = new BufferedWriter(fw);
			bw.write(content);
			bw.close();
		} catch (IOException e) {
			System.out.println("Game does not exist, please choose another");
		}
		
		counter += 1;
		/*
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
