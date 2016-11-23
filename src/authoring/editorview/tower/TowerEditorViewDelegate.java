package authoring.editorview.tower;

public interface TowerEditorViewDelegate {

    public void onUserPressedCreateNewTower ();

    public void onUserEnteredTowerName (String towerName);

    public void onUserEnteredTowerImagePath (String imagePath);

    public void onUserEnteredBuyPrice (String buyPrice);

    public void onUserEnteredSellPrice (String sellPrice);

    public void onUserEnteredUnlockLevel (String level);

    public void onUserEnteredFireRate (String fireRate);

    // TODO: Does tower need either of the below methods?

    public void onUserEnteredFrequency (String frequency);

    public void onUserEnteredRange (String range);

}
