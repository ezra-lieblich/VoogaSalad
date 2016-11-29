package authoring.editorview.tower;

import java.io.IOException;
import java.util.ResourceBundle;
import authoring.editorview.EditorViewController;
import authoring.utilityfactories.DialogueBoxFactory;
import engine.tower.TowerManagerController;
import authoring.editorview.tower.ITowerUpdateView;


/**
 * 
 * @author Kayla Schulz
 * @author Andrew Bihl
 *
 */
public class TowerEditorViewController extends EditorViewController
        implements TowerEditorViewDelegate {

    private TowerManagerController towerDataSource;
    private int currentTowerID;
    private ITowerUpdateView myView;

    public TowerEditorViewController (int editorWidth, int editorHeight) throws IOException {
        myView = TowerEditorViewFactory.build(editorWidth, editorHeight);
        myView.setDelegate(this);
        this.view = myView;
    }

    public void setTowerDataSource (TowerManagerController source) {
        this.towerDataSource = source;
    }

    /**
     * Notification methods coming from delegate
     */
    @Override
    public void onUserPressedCreateNewTower () {
        towerDataSource.createNewTower(myView);
    }

    @Override
    public void onUserEnteredTowerName (String towerName) {
        towerDataSource.setTowerName(currentTowerID, towerName);
    }

    @Override
    public void onUserEnteredTowerImagePath (String towerImagePath) {
        towerDataSource.setTowerImagePath(currentTowerID, towerImagePath);
    }

    @Override
    public void onUserEnteredTowerUnlockLevel (String towerLevel) {
        try {
            Integer.parseInt(towerLevel);
            towerDataSource.setTowerUnlockLevel(currentTowerID, Integer.parseInt(towerLevel));
        }
        catch (NumberFormatException e) {
            createDialogueBox();
        }
    }

    @Override
    public void onUserEnteredTowerBuyPrice (String towerBuyPrice) {
        try {
            Double.parseDouble(towerBuyPrice);
            towerDataSource.setTowerBuyPrice(currentTowerID, Double.parseDouble(towerBuyPrice));
        }
        catch (NumberFormatException e) {
            createDialogueBox();
        }
    }

    @Override
    public void onUserEnteredTowerSellPrice (String towerSellPrice) {
        try {
            Double.parseDouble(towerSellPrice);
            towerDataSource.setTowerSellPrice(currentTowerID, Double.parseDouble(towerSellPrice));
        }
        catch (NumberFormatException e) {
            createDialogueBox();
        }
    }

    @Override
    public void onUserEnteredTowerAbility (String towerAbility) {
        towerDataSource.setTowerChosenAbility(currentTowerID, Integer.parseInt(towerAbility));
    }

    private void createDialogueBox () {
        ResourceBundle dialogueBoxResource = ResourceBundle.getBundle("resources/DialogueBox");
        DialogueBoxFactory.createErrorDialogueBox(dialogueBoxResource.getString("Integer"),
                                                  dialogueBoxResource.getString("CheckInput"));
    }

    @Override
    public void onUserPressedDeleteTower () {
        // TODO Auto-generated method stub

    }

    @Override
    public void onUserDeletedTowerAbility (String towerAbility) {
        // TODO Auto-generated method stub

    }

    @Override
    public void onUserDeletedTowerWeapon (String towerChosenWeapon) {
        // TODO Auto-generated method stub

    }

    @Override
    public void onUserDeletedTowerUpgrade (String towerUpgrade) {
        // TODO Auto-generated method stub

    }

    @Override
    public void onUserEnteredTowerSize (String towerSize) {
        // TODO Auto-generated method stub

    }

    @Override
    public void onUserEnteredTowerChosenWeapon (String towerChosenWeapon) {
        // TODO Auto-generated method stub

    }

    @Override
    public void onUserEnteredTowerUpgrade (String towerUpgrade) {
        // TODO Auto-generated method stub

    }

}
