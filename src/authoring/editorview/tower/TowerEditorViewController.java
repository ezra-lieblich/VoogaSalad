package authoring.editorview.tower;

import java.io.IOException;
import authoring.editorview.EditorViewController;


public class TowerEditorViewController extends EditorViewController
        implements TowerEditorViewDelegate {

    private TowerDataSource towerDataSource;
    private int currentTowerID;

    public TowerEditorViewController (int editorWidth, int editorHeight) throws IOException {
        ITowerEditorView myView = TowerEditorViewFactory.build(editorWidth, editorHeight);
        myView.setDelegate(this);
        this.view = myView;
    }

    public void setTowerDataSource (TowerDataSource source) {
        this.towerDataSource = source;
    }

    /**
     * Notification methods coming from delegate
     */
    @Override
    public void onUserPressedCreateNewTower () {
        towerDataSource.createNewTower();
    }

    @Override
    public void onUserEnteredTowerName (String towerName) {
        towerDataSource.setTowerName(currentTowerID, towerName);
    }

    @Override
    public void onUserEnteredTowerImagePath (String imagePath) {
        towerDataSource.setTowerImagePath(currentTowerID, imagePath);
    }

    @Override
    public void onUserEnteredUnlockLevel (String level) {
        towerDataSource.setUnlockLevel(currentTowerID, Integer.parseInt(level));
    }

    @Override
    public void onUserEnteredFireRate (String fireRate) {
        towerDataSource.setFireRate(currentTowerID, Integer.parseInt(fireRate));
    }

    @Override
    public void onUserEnteredFrequency (String frequency) {
        towerDataSource.setTowerFrequency(currentTowerID, Integer.parseInt(frequency));
    }

    @Override
    public void onUserEnteredRange (String range) {
        towerDataSource.setTowerRange(currentTowerID, Integer.parseInt(range));
    }

    @Override
    public void onUserEnteredTowerBuyPrice (String buyPrice) {
        towerDataSource.setBuyPrice(currentTowerID, Integer.parseInt(buyPrice));
    }

    @Override
    public void onUserEnteredTowerSellPrice (String sellPrice) {
        towerDataSource.setSellPrice(currentTowerID, Integer.parseInt(sellPrice));
    }

}
