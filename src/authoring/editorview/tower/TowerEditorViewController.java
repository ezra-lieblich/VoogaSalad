package authoring.editorview.tower;

import authoring.editorview.EditorViewController;


public class TowerEditorViewController extends EditorViewController
        implements TowerEditorViewDelegate {

    private TowerDataSource towerDataSource;
    private int currentTowerID;

    public TowerEditorViewController (int editorWidth, int editorHeight) {
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
        // TODO Auto-generated method stub
    }

    @Override
    public void onUserEnteredTowerName (String towerName) {
        // TODO Auto-generated method stub

    }

    @Override
    public void onUserEnteredTowerImage (String imageID) {
        // TODO Auto-generated method stub

    }

    @Override
    public void onUserEnteredBuyPrice (String price) {
        // TODO Auto-generated method stub

    }

    @Override
    public void onUserEnteredSellPrice (String price) {
        // TODO Auto-generated method stub

    }

    @Override
    public void onUserEnteredUnlockLevel (String level) {
        // TODO Auto-generated method stub

    }

    @Override
    public void onUserEnteredFireRate (String fireRate) {
        // TODO Auto-generated method stub

    }

    @Override
    public void onUserEnteredFrequency (String frequency) {
        // TODO Auto-generated method stub

    }

    @Override
    public void onUserEnteredRange (String range) {
        // TODO Auto-generated method stub

    }

}
