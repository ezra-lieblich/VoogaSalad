package authoring.editorview.tower;

import java.io.IOException;
import java.util.ResourceBundle;
import authoring.editorview.EditorViewController;
import authoring.utilityfactories.DialogueBoxFactory;
import engine.tower.TowerManagerController;
import authoring.editorview.tower.ITowerEditorView;


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
    private ITowerEditorView towerView;

    public TowerEditorViewController (int editorWidth, int editorHeight) throws IOException {
        towerView = TowerEditorViewFactory.build(editorWidth, editorHeight);
        towerView.setDelegate(this);
        this.view = towerView;

    }

    public void setTowerDataSource (TowerManagerController source) {
        this.towerDataSource = source;
        this.towerDataSource.addTypeBankListener(this.towerView);
        onUserPressedCreateNewTower();
    }

    /**
     * Notification methods coming from delegate
     */
    @Override
    public void onUserPressedCreateNewTower () {
        currentTowerID = towerDataSource.createType(towerView);
        towerView.updateImagePathDisplay(towerDataSource.getImagePath(currentTowerID));
        towerView.updateNameDisplay(towerDataSource.getName(currentTowerID));
        towerView.updateSizeDisplay(towerDataSource.getSize(currentTowerID));
        towerView.updateTowerBuyPriceDisplay(towerDataSource.getTowerBuyPrice(currentTowerID));
        towerView.updateTowerSellPriceDisplay(towerDataSource.getTowerSellPrice(currentTowerID));
        towerView.updateUnlockLevelDisplay(towerDataSource.getTowerUnlockLevel(currentTowerID));
    }

    @Override
    public void onUserEnteredTowerName (String towerName) {
        towerDataSource.setName(currentTowerID, towerName);
    }

    @Override
    public void onUserEnteredTowerImagePath (String towerImagePath) {
        towerDataSource.setImagePath(currentTowerID, towerImagePath);
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

    @Override
    public void onUserPressedDeleteTower () {
        towerDataSource.deleteType(currentTowerID);
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
        try {
            Double.parseDouble(towerSize);
            towerDataSource.setSize(currentTowerID, Double.parseDouble(towerSize));
        }
        catch (NumberFormatException e) {
            createDialogueBox();
        }
    }

    @Override
    public void onUserEnteredTowerChosenWeapon (String towerChosenWeapon) {
        // TODO Auto-generated method stub

    }

    @Override
    public void onUserEnteredTowerUpgrade (String towerUpgrade) {
        // TODO Auto-generated method stub

    }

    private void createDialogueBox () {
        ResourceBundle dialogueBoxResource = ResourceBundle.getBundle("resources/DialogueBox");
        DialogueBoxFactory.createErrorDialogueBox(dialogueBoxResource.getString("Integer"),
                                                  dialogueBoxResource.getString("CheckInput"));
    }

	@Override
	public void onUserSelectedTower(int towerID) {
		// TODO Auto-generated method stub
		
	}

}
