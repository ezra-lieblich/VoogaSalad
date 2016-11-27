package authoring.editorview.tower;

import java.io.IOException;
import java.util.ResourceBundle;
import authoring.editorview.EditorViewController;
import authoring.utilityfactories.DialogueBoxFactory;


/**
 * 
 * @author Kayla Schulz
 * @author Andrew Bihl
 *
 */
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
    public void onUserEnteredTowerFireRate (String towerFireRate) {
        try {
            Integer.parseInt(towerFireRate);
            towerDataSource.setTowerFireRate(currentTowerID, Integer.parseInt(towerFireRate));
        }
        catch (NumberFormatException e) {
            createDialogueBox();
        }
    }

    @Override
    public void onUserEnteredTowerFrequency (String towerFrequency) {
        try {
            Integer.parseInt(towerFrequency);
            towerDataSource.setTowerFrequency(currentTowerID, Integer.parseInt(towerFrequency));
        }
        catch (NumberFormatException e) {
            createDialogueBox();
        }
    }

    @Override
    public void onUserEnteredTowerRange (String towerRange) {
        try {
            Integer.parseInt(towerRange);
            towerDataSource.setTowerRange(currentTowerID, Integer.parseInt(towerRange));
        }
        catch (NumberFormatException e) {
            createDialogueBox();
        }
    }

    @Override
    public void onUserEnteredTowerBuyPrice (String towerBuyPrice) {
        try {
            Integer.parseInt(towerBuyPrice);
            towerDataSource.setTowerBuyPrice(currentTowerID, Integer.parseInt(towerBuyPrice));
        }
        catch (NumberFormatException e) {
            createDialogueBox();
        }
    }

    @Override
    public void onUserEnteredTowerSellPrice (String towerSellPrice) {
        try {
            Integer.parseInt(towerSellPrice);
            towerDataSource.setTowerSellPrice(currentTowerID, Integer.parseInt(towerSellPrice));
        }
        catch (NumberFormatException e) {
            createDialogueBox();
        }
    }

    @Override
    public void onUserEnteredTowerAbility (String towerAbility) {
        towerDataSource.setTowerAbility(currentTowerID, towerAbility);
    }

    @Override
    public void onUserEnteredTowerChosenEnemy (String towerChosenEnemy) {
        towerDataSource.setTowerChosenEnemy(currentTowerID, towerChosenEnemy);
    }

    @Override
    public void onUserEnteredTowerChosenWeapon (String towerChosenWeapon) {
        towerDataSource.setTowerChosenWeapon(currentTowerID, towerChosenWeapon);
    }

    @Override
    public void onUserEnteredTowerUpgrade (String towerUpgrade) {
        towerDataSource.setTowerUpgrade(currentTowerID, towerUpgrade);
    }

    private void createDialogueBox () {
        ResourceBundle dialogueBoxResource = ResourceBundle.getBundle("resources/DialogueBox");
        DialogueBoxFactory.createErrorDialogueBox(dialogueBoxResource.getString("Integer"),
                                                  dialogueBoxResource.getString("CheckInput"));
    }

}
