package authoring.editorview.tower;

/**
 * 
 * @author Andrew Bihl
 * @author Kayla Schulz
 *
 */
public interface TowerEditorViewDelegate {

    public void onUserPressedCreateNewTower ();

    public void onUserEnteredTowerAbility (String towerAbility);

    public void onUserEnteredTowerChosenEnemy (String towerChosenEnemy);

    public void onUserEnteredTowerChosenWeapon (String towerChosenWeapon);

    public void onUserEnteredTowerUpgrade (String towerUpgrade);

    public void onUserEnteredTowerName (String towerName);

    public void onUserEnteredTowerImagePath (String towerImagePath);

    public void onUserEnteredTowerBuyPrice (String towerBuyPrice);

    public void onUserEnteredTowerSellPrice (String towerSellPrice);

    public void onUserEnteredTowerUnlockLevel (String towerLevel);

    public void onUserEnteredTowerFireRate (String towerFireRate);

    // TODO: Does tower need either of the below methods?

    public void onUserEnteredTowerFrequency (String towerFrequency);

    public void onUserEnteredTowerRange (String towerRange);

}
