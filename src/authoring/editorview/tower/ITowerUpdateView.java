package authoring.editorview.tower;

import java.util.List;
import authoring.editorview.IUpdateView;


/**
 * 
 * @author Andrew Bihl
 * @author Kayla Schulz
 *
 */
public interface ITowerUpdateView extends ITowerEditorView, IUpdateView {

    public void updateUnlockLevelDisplay (int towerLevel);

    public void updateTowerBuyPriceDisplay (double towerBuyPrice);

    public void updateTowerSellPriceDisplay (double towerSellPrice);

    public void updateTowerAbility (List<Integer> towerAbility);

    public void updateTowerChosenWeapon (List<Integer> newValue);

    public void updateTowerUpgradeBank (List<Integer> towerUpgrades);

    public void updateTowerBank (List<Integer> createdTowers);

    public void createNewTower ();

}
