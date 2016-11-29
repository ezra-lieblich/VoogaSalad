package authoring.editorview.tower;

import java.util.List;


/**
 * 
 * @author Andrew Bihl
 * @author Kayla Schulz
 *
 */
public interface TowerDataSource {

    public String getTowerName (int towerID);

    public double getTowerSize (int towerID);

    public String getTowerImagePath (int towerID);

    public double getTowerBuyPrice (int towerID);

    public double getTowerSellPrice (int towerID);

    public int getTowerUnlockLevel (int towerID);

    public List<Integer> getTowerUpgrades (int towerID);

    public List<Integer> getTowerChosenWeapons (int towerID);

    public List<Integer> getTowerAbilities (int towerID);

    public List<Integer> getCreatedTowers ();

    /**
     * Create new tower with default values
     * 
     * @return tower id
     */
    public int createNewTower (ITowerUpdateView towerUpdater);

    public void deleteTower (int towerID);

    public void setTowerSize (int towerID, double towerSize);

    public void setTowerName (int towerID, String towerName);

    public void setTowerImagePath (int towerID, String towerImagePath);

    public void setTowerBuyPrice (int towerID, double towerBuyPrice);

    public void setTowerSellPrice (int towerID, double towerSellPrice);

    public void setTowerUnlockLevel (int towerID, int towerLevel);

    public void setTowerChosenAbility (int towerID, int towerAbility);

    public void removeTowerChosenAbility (int towerID, int towerAbility);

    public void setTowerChosenWeapon (int towerID, int towerChosenWeaponID);

    public void removeTowerWeapon (int towerID, int towerChosenWeaponID);

    public int createTowerUpgrade (ITowerUpdateView towerUpdater, int parentTowerID);

    public void removeTowerUpgrade (int parentTowerID, int childTowerID);

}
