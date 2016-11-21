package authoring.editorview.tower;

public interface TowerDataSource {
	public String getTowerName(int towerID);
	public int getTowerImage(int towerID);
	public int getBuyPrice(int towerID);
	public int getSellPrice(int towerID);
	public int getUnlockLevel(int towerID);
	public int getFireRate(int towerID);
	
	/**
	 * Create new tower with default values
	 * @return tower id
	 */
	public int createNewTower();
	public void setTowerName(int towerID, String name);
    public void setTowerImage (int towerID, int imageID);
    public void setBuyPrice(int towerID, int price);
	public void setSellPrice(int towerID, int price);
	public void setUnlockLevel(int towerID, int level);
    public void setFireRate(int towerID, int fireRate);
}
