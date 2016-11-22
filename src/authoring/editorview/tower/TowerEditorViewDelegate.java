package authoring.editorview.tower;

public interface TowerEditorViewDelegate {

    public int onUserPressedCreateNewTower ();

    public void onUserEnteredName (String name);

    public void onUserEnteredTowerImage (String imageID);

    public void onUserEnteredBuyPrice (String price);

    public void onUserEnteredSellPrice (String price);

    public void onUserEnteredUnlockLevel (String level);

    public void onUserEnteredFireRate (String fireRate);

}
