package gameplayer.loader;

import java.io.IOException;
import java.util.HashMap;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import engine.TowerType;



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

	public XMLParser(String xmlFilename){
		parseNewXML(xmlFilename);
		rootElement = getRootElement(); 		
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
    
    //This returns the TYPE of the xml
    public String getName(){
    	return rootElement.getAttribute("Title");
    }
    
    public String getTextValue(String parent, String tagName) {
        String textVal = "";
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
    
    public HashMap<Integer,TowerType> getTowerTypes(){
    	HashMap<Integer,TowerType>ret = new HashMap<>(); 
    	try{
    		NodeList parentList = xmlDocument.getElementsByTagName("tower");
    		for(int i=0;i<parentList.getLength();i++){
    			Element tower = (Element)parentList.item(i);
    			String name = ((Element)(tower.getElementsByTagName("name").item(0))).getFirstChild().getNodeValue();
    			String imageLocation = ((Element)(tower.getElementsByTagName("imageLocation").item(0))).getFirstChild().getNodeValue();
    			double cost = Double.parseDouble(((Element)(tower.getElementsByTagName("imageLocation").item(0))).getFirstChild().getNodeValue());
    			double sellAmount = Double.parseDouble(((Element)(tower.getElementsByTagName("sellAmount").item(0))).getFirstChild().getNodeValue());
    			int fireRate = Integer.parseInt(((Element)(tower.getElementsByTagName("fireRate").item(0))).getFirstChild().getNodeValue());
    			int unlockLevel = Integer.parseInt(((Element)(tower.getElementsByTagName("unlockLevel").item(0))).getFirstChild().getNodeValue());
    			TowerType towerType = new TowerType(name,imageLocation,cost,sellAmount,fireRate,unlockLevel);
    			ret.put(i, towerType);
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

}