//this entire file is part of my masterpiece.
//AARON CHANG
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
 * This class is part of my masterpiece because it is very flexible.
 * Previously, it had methods to retrieve specific game object Managers from the XML file
 * Now, it uses Generics so it only needs one method to retrieve any type of manager from the XML file
 * This makes it very extensible and flexible because you can get any type of manager without adding another method
 * So if another Manager is added in the game engine, you can get it from the XMLParser without adding any methods
 * In this way, it is almost like a utility. Any game can use this class as long as it has objects that extend the Manager class
 * @author Aaron Chang
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
	
	/**
	 * Returns the Manager of the managerType's class from the XML file
	 * used by GamePlayerFactory to get any type of Manager from the XML file
	 * @param managerType
	 * @return <T extends Manager>
	 */
	protected <T extends Manager> T getManager(Class<T> managerType) {
		return gameManager.getManager(managerType);
	}
	
}