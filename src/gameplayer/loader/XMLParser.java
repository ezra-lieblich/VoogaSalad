package gameplayer.loader;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;

import engine.enemy.EnemyType;
import engine.enemy.EnemyTypeBuilder;
import engine.enemy.EnemyTypeManager;
import engine.level.LevelTypeManager;
import engine.path.PathTypeManager;
import engine.settings.GameMode;
import engine.settings.GameModeType;
import engine.settings.GameModeTypeManager;
import engine.tower.Tower;
import engine.tower.TowerType;
import engine.tower.TowerTypeBuilder;
import engine.tower.TowerTypeManager;
import engine.weapon.Weapon;
import engine.weapon.WeaponTypeManager;
import engine.enemy.EnemyTypeBuilder;
import engine.ManagerTypeMediator;
import gameplayer.model.Enemy;



/**
 * This class is an xml parser that is able to read xml files and grab the appropriate values from them. 
 * @author Naijiao
 *
 */
public class XMLParser {
	
	private Element rootElement;
	private XStream serializer;
	private ManagerTypeMediator gameManager;

	public XMLParser(String xmlFilename) {
		serializer = new XStream(new DomDriver());
		gameManager = getGameManager(xmlFilename);
		getEnemyTypes();

	}
	
	private ManagerTypeMediator getGameManager(String xmlFilename) {
		ObjectInputStream objectStream;
		try {
			FileInputStream fileInput = new FileInputStream(xmlFilename);
			objectStream = serializer.createObjectInputStream(fileInput);
			ManagerTypeMediator gameManager = (ManagerTypeMediator) objectStream.readObject();
			return gameManager;

		} catch (IOException i) {
			//TODO: actually handle the file
			System.out.println("Input file could not be read");
		} catch (ClassNotFoundException c) {
			//TODO: actually handle the file
			System.out.println("Input file not valid");
		}
		return null;

	}
    
    
    public Map<Integer,Tower> getTowerTypes(){
    	TowerTypeManager towerManager = gameManager.getManager(TowerTypeManager.class);
    	Map<Integer, Tower> towerTypes = towerManager.getEntities();
    	return towerTypes;
    }
    
    public Map<Integer,Tower> getTowerUpgrades() {
    	TowerTypeManager towerManager = gameManager.getManager(TowerTypeManager.class);
    	//return towerManager.getUpgrades(); need sean to add getUpgrades method to TowerTypeManager
    	return null;
    }
    
    
    public Map<Integer, Weapon> getWeaponTypes() {
    	WeaponTypeManager weaponManager = gameManager.getManager(WeaponTypeManager.class);
    	Map<Integer, Weapon> weaponTypes = weaponManager.getEntities();
    	return weaponTypes;
    }
    
	protected Map<Integer, engine.enemy.Enemy> getEnemyTypes() { //refactor names
		EnemyTypeManager enemyManager = gameManager.getManager(EnemyTypeManager.class);
		Map<Integer, engine.enemy.Enemy> enemyTypes = enemyManager.getEntities();
		//System.out.println(enemyTypes.get(0).getName());
		return enemyTypes;
	}
	
	protected GameMode getGameMode() {
		GameModeTypeManager gameModeManager = gameManager.getManager(GameModeTypeManager.class);
		return gameModeManager.getEntity(0);
	}
	
	protected LevelTypeManager getLevelManager() {
		return gameManager.getManager(LevelTypeManager.class);
	}
	
	protected PathTypeManager getPathManager() {
		return gameManager.getManager(PathTypeManager.class);
	}
	
    //refactor to get it out of from xml (waiting for ezra)
	public List<Queue<Enemy>> getEnemy(int level){
		ArrayList<Queue<Enemy>>enemyByLevel=new ArrayList<>(); 
		Map<Integer,engine.enemy.Enemy> types = getEnemyTypes(); //refactor names
		String[]enemiesRawString = getTextValue("level"+level,"typeAmount").split(";");
		for(int i=0;i<enemiesRawString.length;i++){
			Queue<Enemy>enemiesInLevel= new LinkedList<Enemy>(); 
			String[]enemies = enemiesRawString[i].split(",");
			for(int k=0;k<Integer.parseInt(enemies[1]);k++){

				engine.enemy.Enemy type = types.get(enemies[0]); //refactor names
				double width = 20; //for testing purposes
				double height = 20; //for testing purposes
		//+++++++++++++add enemy construction once game authoring is done++++++++++++++++	
				//		enemiesInLevel.add(new Enemy(type.getName(),type.getSpeed(),(int)(type.getHealth()), type.getImagePath(), width ,height)); //for testing
			}
			enemyByLevel.add(enemiesInLevel);
		}
		return enemyByLevel; 
	}
	
	
	//TODO: get rid of this method
    public boolean isValid() {
    	return true;
    	
    }
    
    //This returns the TYPE of the xml
    public String getName(){
    	GameMode gameMode = getGameMode();
    	return gameMode.getGameType(); //type or name?
    }
	

}