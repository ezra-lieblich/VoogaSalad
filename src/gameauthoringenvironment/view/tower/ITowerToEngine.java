package gameauthoringenvironment.view.tower;

/**
 * 
 * Interface to communicate with the game engine about changes in the tower settings
 *
 */
public interface ITowerToEngine {

	
	/**
	 * Create new tower with default values
	 * @return tower id
	 */
	public int createNewTower();
	
    /**
     * Passes the selected image to the game engine
     * 
     * @param towerImage
     */
    public void setTowerImage (int towerImageID);
    
    
    

    public void setTowerFrequency (int towerFrequency);
}
