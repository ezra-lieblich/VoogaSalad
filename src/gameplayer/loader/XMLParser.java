package gameplayer.loader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;
import engine.GameAuthoringData;
import engine.Manager;
import engine.ManagerMediator;

/**
 * This class is an xml parser that is able to read xml files and grab the appropriate values from them. 
 * @author Aaron
 *
 */
public class XMLParser {
	
	private XStream serializer;
	private ManagerMediator gameManager;
	
	public XMLParser(String xmlFilename) {
		serializer = new XStream(new DomDriver());
		gameManager = getGameManager(xmlFilename);
	}
	
	
	private ManagerMediator getGameManager(String xmlFilename) {
		try {
			File xmlFile = new File(xmlFilename);
			GameAuthoringData data = (GameAuthoringData) serializer.fromXML(new FileInputStream(xmlFile));
			return data.getManagerMediator();
			
		} catch (FileNotFoundException e) {
			throw new XMLParserException(e);
		} 
	}
	
	protected <T extends Manager> T getManager(Class<T> managerType) {
		return gameManager.getManager(managerType);
	}
	
}