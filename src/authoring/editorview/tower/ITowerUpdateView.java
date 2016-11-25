package authoring.editorview.tower;

import java.util.List;


public interface ITowerUpdateView extends ITowerEditorView {

    public void updateFireRateDisplay (int towerFireRate);

    public void updateUnlockLevelDisplay (int towerUnlockLevel);

    public void updateFrequencyDisplay (int towerFrequency);

    public void updateRangeDisplay (int towerRange);

    public void updateTowerImagePath (String towerImagePath);

    public void updateTowerName (String towerName);

    public void updateTowerBuyPriceDisplay (int towerBuyPrice);

    public void updateTowerSellPriceDisplay (int towerSellPrice);

    public void updateTowerAbility (String towerAbility);

    public void updateTowerChosenEnemy (String towerChosenEnemy);

    public void updateTowerChosenWeapon (String towerChosenWeapon);

    public void updateTowerUpgrade (String towerUpgrade);

    public void updateTowerBank (List<Integer> activeTowers);

    public void createNewTower ();

}
