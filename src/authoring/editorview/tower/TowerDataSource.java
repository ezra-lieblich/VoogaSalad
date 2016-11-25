package authoring.editorview.tower;

import java.util.List;


public interface TowerDataSource {
    public String getTowerName (int towerID);

    public String getTowerImagePath (int towerID);

    public int getTowerBuyPrice (int towerID);

    public int getTowerSellPrice (int towerID);

    public int getTowerUnlockLevel (int towerID);

    public int getTowerFireRate (int towerID);

    public int getTowerFrequency (int towerID);

    public int getTowerRange (int towerID);

    public String getTowerUpgrade (int towerID);

    public String getTowerChosenEnemy (int towerID);

    public String getTowerChosenWeapon (int towerID);

    public String getTowerAbility (int towerID);

    public int getCreatedTower ();

    public List<Integer> getActiveTowers ();

    /**
     * Create new tower with default values
     * 
     * @return tower id
     */
    public void createNewTower ();

    public void setTowerName (int towerID, String towerName);

    public void setTowerImagePath (int towerID, String towerImagePath);

    public void setTowerBuyPrice (int towerID, int towerBuyPrice);

    public void setTowerSellPrice (int towerID, int towerSellPrice);

    public void setTowerUnlockLevel (int towerID, int towerLevel);

    public void setTowerFireRate (int towerID, int towerFireRate);

    public void setTowerFrequency (int towerID, int towerFrequency);

    public void setTowerRange (int towerID, int towerRange);

    public void setTowerAbility (int towerID, String towerAbility);

    public void setTowerChosenEnemy (int towerID, String towerChosenEnemy);

    public void setTowerChosenWeapon (int towerID, String towerChosenWeapon);

    public void setTowerUpgrade (int towerID, String towerUpgrade);
}
