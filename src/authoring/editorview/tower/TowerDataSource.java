package authoring.editorview.tower;

import java.util.List;


public interface TowerDataSource {
    public String getTowerName (int towerID);

    public String getTowerImagePath (int towerID);

    public int getBuyPrice (int towerID);

    public int getSellPrice (int towerID);

    public int getUnlockLevel (int towerID);

    public int getFireRate (int towerID);

    public int getFrequency (int towerID);
    
    public int getRange (int towerID);

    public List<Integer> getActiveTowers ();

    /**
     * Create new tower with default values
     * 
     * @return tower id
     */
    public int createNewTower ();

    public void setTowerName (int towerID, String name);

    public void setTowerImagePath (int towerID, String imagePath);

    public void setBuyPrice (int towerID, int buyPrice);

    public void setSellPrice (int towerID, int sellPrice);

    public void setUnlockLevel (int towerID, int level);

    public void setFireRate (int towerID, int fireRate);

    public void setTowerFrequency (int towerID, int frequency);
    
    public void setTowerRange (int towerID, int range);
}
