package authoring.editorview.tower;

import java.util.List;
import authoring.editorview.IUpdateView;


/**
 * 
 * @author Andrew Bihl
 * @author Kayla Schulz
 *
 */
public interface ITowerEditorView extends ITowerSetView, IUpdateView {

    public void updateUnlockLevelDisplay (int towerLevel);

    public void updateTowerBuyPriceDisplay (double towerBuyPrice);

    public void updateTowerSellPriceDisplay (double towerSellPrice);

    public void updateTowerAbilityBank (List<Integer> towerAbility);

    public void updateTowerWeaponBank (List<Integer> newValue);

    public void updateTowerUpgradeBank (List<Integer> towerUpgrades);

    public void updateTowerBank (List<Integer> createdTowers);

    public void createNewTower ();
    
    public void deleteTower ();

}
