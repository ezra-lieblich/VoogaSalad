package authoring.editorview.tower;

public interface TowerDataSource {
	public int getBuyPrice(int towerID);
	public int getSellPrice(int towerID);
	public int getUnlockLevel(int towerID);
	
}
