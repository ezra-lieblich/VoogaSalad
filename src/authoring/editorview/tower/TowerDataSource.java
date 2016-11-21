package authoring.editorview.tower;

public interface TowerDataSource {
	public int getBuyPrice(int towerID);
	public int getSellPrice(int towerID);
	public int getUnlockLevel(int towerID);
	
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
