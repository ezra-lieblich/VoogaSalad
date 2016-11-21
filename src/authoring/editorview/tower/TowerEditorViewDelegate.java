package authoring.editorview.tower;

public interface TowerEditorViewDelegate {

    public int createNewTower ();

    public void setTowerName (String name);

    public void setTowerImage (int imageID);

    public void setBuyPrice (int price);

    public void setSellPrice (int price);

    public void setUnlockLevel (int level);

    public void setFireRate (int fireRate);

}
