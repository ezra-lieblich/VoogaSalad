package authoring.editorview.tower;

import authoring.editorview.EditorViewDelegate;

/**
 * 
 * @author Andrew Bihl
 * @author Kayla Schulz
 *
 */
public interface TowerAuthoringViewDelegate extends EditorViewDelegate {

    public void onUserPressedCreateNewTower ();

    public void onUserPressedCreateTowerUpgrade ();

    public void onUserPressedAddEffect ();

    public void onUserEnteredTowerAbility (String towerAbility);

    public void onUserDeletedTowerAbility (String towerAbility);

    public void onUserEnteredTowerChosenWeapon (String towerChosenWeapon);

    public void onUserDeletedTowerWeapon (String towerChosenWeapon);

    public void onUserEnteredTowerUpgrade (String towerUpgrade);

    public void onUserDeletedTowerUpgrade (String towerUpgrade);

    public void onUserEnteredTowerImagePath (String towerImagePath);

    public void onUserEnteredTowerBuyPrice (String towerBuyPrice);

    public void onUserEnteredTowerSellPrice (String towerSellPrice);

    public void onUserEnteredTowerUnlockLevel (String towerLevel);

    public void onUserEnteredTowerSize (String towerSize);

    public void onUserSelectedTower (int towerID);

    public void onUserSelectedTowerUpgrade (int towerID);

}
