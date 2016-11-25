package authoring.editorview.tower;

public interface TowerEditorViewDelegate {

    public void onUserPressedCreateNewTower ();

    public void onUserEnteredTowerAbility (String towerAbility);

    public void onUserEnteredTowerChosenEnemy (String chosenEnemy);

    public void onUserEnteredTowerChosenWeapon (String chosenWeapon);

    public void onUserEnteredTowerUpgrade (String towerUpgrade);

    public void onUserEnteredTowerName (String towerName);

    public void onUserEnteredTowerImagePath (String imagePath);

    public void onUserEnteredTowerBuyPrice (String buyPrice);

    public void onUserEnteredTowerSellPrice (String sellPrice);

    public void onUserEnteredUnlockLevel (String level);

    public void onUserEnteredFireRate (String fireRate);

    // TODO: Does tower need either of the below methods?

    public void onUserEnteredFrequency (String frequency);

    public void onUserEnteredRange (String range);

}
