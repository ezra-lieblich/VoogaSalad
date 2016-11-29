package gameplayer.loader;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;
import engine.enemy.EnemyType;
import engine.tower.Tower;
import engine.tower.TowerType;
import engine.tower.TowerTypeBuilder;
import gameplayer.model.Enemy;



/**
 * This class is an xml parser that is able to read xml files and grab the appropriate values from them. 
 * @author Naijiao
 *
 */
public class XMLParser {
	// Keep only one documentBuilder around because it is expensive to make and just need to reset it before every parse
    private static final DocumentBuilder DOCUMENT_BUILDER = getDocumentBuilder();
	
	private Element rootElement;
	private Document xmlDocument; 
	private TowerTypeBuilder towerBuilder;

	public XMLParser(String xmlFilename){
		parseNewXML(xmlFilename);
		rootElement = getRootElement(); 
		towerBuilder = new TowerTypeBuilder();
	}
	
    /**
     * Gets the root element in an XML file.
     *
     * @param xmlFilename the location of the xmlFile
     * @return the root element in the xmlFile
     */
    public Element getRootElement () {
    		return xmlDocument.getDocumentElement();
    }
    
    public void parseNewXML(String xmlFilename){
    	reset(); 
    	try{
    		xmlDocument = DOCUMENT_BUILDER.parse(xmlFilename);
    	}
    	catch(SAXException | IOException e){
    		throw new XMLParserException(e);
    	}
    }
   
    private void reset(){
    	DOCUMENT_BUILDER.reset(); 
    }

    
    // Helper method to do the boilerplate code needed to make a documentBuilder.
    private static DocumentBuilder getDocumentBuilder () {
        try {
            return DocumentBuilderFactory.newInstance().newDocumentBuilder();
        }
        catch (ParserConfigurationException e) {
            throw new XMLParserException(e);
        }
    }
    
    public boolean isValid() {
    	NodeList nodeList = rootElement.getElementsByTagName("isValid");
    	//System.out.println("node" + nodeList.item(0).getTextContent());
    	if (nodeList != null && nodeList.getLength() > 0) {
			return Boolean.parseBoolean(nodeList.item(0).getTextContent().trim()); //check if the string can actually be parsed as a boolean
		}
    	return false;
    	
    }
    
    //This returns the TYPE of the xml
    public String getName(){
    	return rootElement.getAttribute("Title");
    }
    
    public String getTextValue(String parent, String tagName) {
        String textVal = "";
        System.out.println("parent: " + parent);
        System.out.println("tag name: " + tagName);
        try{
        	NodeList parentList = xmlDocument.getElementsByTagName(parent);
	        NodeList nl = ((Element)parentList.item(0)).getElementsByTagName(tagName);
	        if (nl != null && nl.getLength() > 0) {
	        	for(int i=0;i<nl.getLength();i++){
		            Element el = (Element) nl.item(i);
		            textVal += el.getFirstChild().getNodeValue();
	        	}
	        }
        }
        catch(Exception e){
        	throw new XMLParserException(e);
        }
        return textVal;
    }
    
    public HashMap<Integer,Tower> getTowerTypes(){
    	HashMap<Integer,Tower>ret = new HashMap<>(); 
    	try{
    		NodeList parentList = xmlDocument.getElementsByTagName("tower");
    		for(int i=0;i<parentList.getLength();i++){

    			Element towerElement= (Element)parentList.item(i);
    			towerBuilder.buildName(((Element)(towerElement.getElementsByTagName("name").item(0))).getFirstChild().getNodeValue());
    			towerBuilder.buildImagePath(((Element)(towerElement.getElementsByTagName("imageLocation").item(0))).getFirstChild().getNodeValue());
    			towerBuilder.buildCost(Double.parseDouble(((Element)(towerElement.getElementsByTagName("cost").item(0))).getFirstChild().getNodeValue()));
    			towerBuilder.buildSellAmount(Double.parseDouble(((Element)(towerElement.getElementsByTagName("sellAmount").item(0))).getFirstChild().getNodeValue()));
    			towerBuilder.buildUnlockLevel(Integer.parseInt(((Element)(towerElement.getElementsByTagName("unlockLevel").item(0))).getFirstChild().getNodeValue()));
    			//TowerType towerType = new TowerType(name,imageLocation,cost,sellAmount,fireRate,unlockLevel);
    			Tower tower = towerBuilder.build();
    			ret.put(i, tower);
    		}
    	}
    	catch(Exception e){
    		throw new XMLParserException(e);
    	}
    	return ret; 
    }
    
    //Returns String of w.e variable u give it. For example: Within the example xml, if call this with variable = width, this should return 500
    public String getVariableValues(String variable){
    	NodeList info = xmlDocument.getElementsByTagName(variable);
    	if(info!=null&& info.getLength()>0){
    		return info.item(0).getFirstChild().getNodeValue(); 
    	}
    	else{
    		return null; 
    	}
    }
	
	public List<Queue<Enemy>> getEnemy(int level){
		ArrayList<Queue<Enemy>>enemyByLevel=new ArrayList<>(); 
		HashMap<String,EnemyType> types = getEnemyTypes();
		String[]enemiesRawString = getTextValue("level"+level,"typeAmount").split(";");
		for(int i=0;i<enemiesRawString.length;i++){
			Queue<Enemy>enemiesInLevel= new LinkedList<Enemy>(); 
			String[]enemies = enemiesRawString[i].split(",");
			for(int k=0;k<Integer.parseInt(enemies[1]);k++){
				EnemyType type = types.get(enemies[0]);

				double width = 20; //for testing purposes
				double height = 20; //for testing purposes
		//+++++++++++++add enemy construction once game authoring is done++++++++++++++++	
				//		enemiesInLevel.add(new Enemy(type.getName(),type.getSpeed(),(int)(type.getHealth()), type.getImagePath(), width ,height)); //for testing
			}
			enemyByLevel.add(enemiesInLevel);
		}
		return enemyByLevel; 
	}
	
	
	private HashMap<String, EnemyType> getEnemyTypes() {
		HashMap<String,EnemyType>ret = new HashMap<>(); 
    	try{
    		NodeList parentList = xmlDocument.getElementsByTagName("enemy");
    		for(int i=0;i<parentList.getLength();i++){
    			Element enemy = (Element)parentList.item(i);
    			String name = ((Element)(enemy.getElementsByTagName("name").item(0))).getFirstChild().getNodeValue();
    			String imageLocation = ((Element)(enemy.getElementsByTagName("imageLocation").item(0))).getFirstChild().getNodeValue();
    			double speed = Double.parseDouble(((Element)(enemy.getElementsByTagName("speed").item(0))).getFirstChild().getNodeValue());
    			double health = Double.parseDouble(((Element)(enemy.getElementsByTagName("health").item(0))).getFirstChild().getNodeValue());
    			double points = Double.parseDouble(((Element)(enemy.getElementsByTagName("points").item(0))).getFirstChild().getNodeValue());
    			double money = Double.parseDouble(((Element)(enemy.getElementsByTagName("money").item(0))).getFirstChild().getNodeValue());
    			String collisionEffect = ((Element)(enemy.getElementsByTagName("collisionEffect").item(0))).getFirstChild().getNodeValue();
    			
    			
  //+++++++++++++talked to game engine for enemy type constructor what is the interface initializer????++++++
    			//EnemyType enemyType = new EnemyType(name,imageLocation,speed,health,points,money,collisionEffect);
    			EnemyType enemyType = new EnemyType(null);
    			ret.put(name, enemyType);
    		}
    	}
    	catch(Exception e){
    		throw new XMLParserException(e);
    	}
    	return ret; 
	}
	

}