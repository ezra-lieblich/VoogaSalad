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
        try {
            Integer.parseInt(level);
            towerDataSource.setUnlockLevel(currentTowerID, Integer.parseInt(level));
        }
        catch (NumberFormatException e) {
            System.out.println("This input is not an integer");
        }
    }

    @Override
    public void onUserEnteredFireRate (String fireRate) {
        try {
            Integer.parseInt(fireRate);
            towerDataSource.setFireRate(currentTowerID, Integer.parseInt(fireRate));
        }
        catch (NumberFormatException e) {
            System.out.println("This input is not an integer");
        }
    }

    @Override
    public void onUserEnteredFrequency (String frequency) {
        try {
            Integer.parseInt(frequency);
            towerDataSource.setTowerFrequency(currentTowerID, Integer.parseInt(frequency));
        }
        catch (NumberFormatException e) {
            System.out.println("This input is not an integer");
        }
    }

    @Override
    public void onUserEnteredRange (String range) {
        try {
            Integer.parseInt(range);
            towerDataSource.setTowerRange(currentTowerID, Integer.parseInt(range));
        }
        catch (NumberFormatException e) {
            System.out.println("This input is not an integer");
        }
    }

    @Override
    public void onUserEnteredTowerBuyPrice (String buyPrice) {
        try {
            Integer.parseInt(buyPrice);
            towerDataSource.setBuyPrice(currentTowerID, Integer.parseInt(buyPrice));
        }
        catch (NumberFormatException e) {
            System.out.println("This input is not an integer");
        }
    }

    @Override
    public void onUserEnteredTowerSellPrice (String sellPrice) {
        try {
            Integer.parseInt(sellPrice);
            towerDataSource.setSellPrice(currentTowerID, Integer.parseInt(sellPrice));
        }
        catch (NumberFormatException e) {
            System.out.println("This input is not an integer");
        }
    }

}
