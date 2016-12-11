package gameplayer.loader;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;

import authoring.utilityfactories.DialogueBoxFactory;
import gameplayer.model.GamePlayModel;
import javafx.scene.control.Alert;

public class GameSavingController {
	private XStream serializer;
	private GamePlayModel gameModel;
	
	public GameSavingController(GamePlayModel model) {
		serializer = new XStream(new DomDriver());
	}
	
	public String toPrettyXML() {
		return serializer.toXML(gameModel);
	}
	
	public void saveGame() {
		String dirName = "/Users/aaronchang/Desktop/";
		File newFile = new File(dirName);
		try {
			FileWriter writer = new FileWriter(newFile);
			writer.write(toPrettyXML());
			writer.close();
			
		} catch (IOException e) {
			Alert fileError =
                    DialogueBoxFactory.createErrorDialogueBox("Error with file. Can't be saved",
                                                              "File Error");
            fileError.show();
		}
	}
}
