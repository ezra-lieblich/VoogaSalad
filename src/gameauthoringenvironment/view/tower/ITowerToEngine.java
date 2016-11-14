package gameauthoringenvironment.view.tower;

/**
 * 
 * Interface to communicate with the game engine about changes in the tower settings
 *
 */
public interface ITowerToEngine {

    /**
     * Passes the selected image to the game engine
     * 
     * @param towerImage
     */
    public void setTowerImage (int towerImageID);

    public void setTowerFrequency (int towerFrequency);
}
