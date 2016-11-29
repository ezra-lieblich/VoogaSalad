package authoring.editorview.tower;

import java.util.List;


/**
 * 
 * @author Andrew Bihl
 * @author Kayla Schulz
 *
 */
public interface ITowerUpdateView extends ITowerEditorView {

    public void updateFireRateDisplay (int towerFireRate);

    public void updateUnlockLevelDisplay (int towerUnlockLevel);

    public void updateRangeDisplay (int towerRange);

    public void updateTowerImagePath (String towerImagePath);

    public void updateTowerName (String towerName);

    public void updateTowerBuyPriceDisplay (int towerBuyPrice);

    public void updateTowerSellPriceDisplay (int towerSellPrice);

    public void updateTowerAbility (String towerAbility);

    public void updateTowerChosenWeapon (String towerChosenWeapon);

    public void updateTowerUpgradeBank (List<Integer> towerUpgrades);

    public void updateTowerBank (List<Integer> createdTowers);

    public void createNewTower ();

}
