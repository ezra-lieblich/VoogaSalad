package gameplayer.loader;

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
	
	public GameSavingController(GamePlayModel model) {
		//serializer = new XStream(new DomDriver());
		this.gameModel = model;
		this.counter = 0;
	}
	
	public String toPrettyXML() {
		EnemyManager eman = gameModel.getEnemyManager();
		Enemy e = eman.getPackOfEnemyComing().element();
		GamePlayData gameData = gameModel.getData();
		//GamePlayerFactory factory = gameData.getFactory();
		return new XStream(new DomDriver()).toXML(gameData);
	}
	
	public void saveGame() {
		String dirName = "SavedGames/newGame" + counter+ ".xml";
		counter += 1;
		File newFile = new File(dirName);
		String content = toPrettyXML();
		System.out.println("XML LENTHHHHH " +content.length());
		try {
			FileWriter writer = new FileWriter(newFile);
			writer.write(content);
			writer.close();
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
