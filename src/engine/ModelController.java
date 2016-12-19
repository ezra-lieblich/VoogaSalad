package engine;

import java.io.FileNotFoundException;

/**
 * This interface handles the methods for communicating with the master level model controller
 * 
 * @author seanhudson
 *
 */
public interface ModelController {

    /**
     * returns the specified model Controller
     * 
     * @param key
     * @return
     */
    <R> R getModelController (Class<R> key);

    /**
     * Exports a the XML file for the created game
     * 
     * @return
     */
    String SaveData ();
    
    /**
     * Loads in a file to work on
     * 
     * @param filePath
     * @return
     * @throws FileNotFoundException
     */
    GameAuthoringData loadData (String filePath) throws FileNotFoundException;
    
    /**
     * Gets the object that contains the model data.
     * 
     * @return
     */
    GameData getGameData ();
}
