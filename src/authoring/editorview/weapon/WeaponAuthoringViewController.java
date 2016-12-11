package authoring.editorview.weapon;

import java.io.IOException;
import java.util.ResourceBundle;
import authoring.editorview.EditorViewController;
import authoring.editorview.ListCellData;
import authoring.editorview.ListDataSource;
import authoring.utilityfactories.DialogueBoxFactory;
import engine.weapon.WeaponManagerController;


/**
 * 
 * @author Kayla Schulz
 * @author Andrew Bihl
 *
 */
public class WeaponAuthoringViewController extends EditorViewController
        implements WeaponAuthoringViewDelegate, ListDataSource {

    private WeaponManagerController weaponDataSource;
    private int currentWeaponID;
    private IWeaponUpdateView weaponView;

    public WeaponAuthoringViewController (int editorWidth, int editorHeight) throws IOException {
        weaponView = WeaponAuthoringViewFactory.build(editorWidth, editorHeight);
        weaponView.setDelegate(this);
        weaponView.setWeaponListDataSource(this);
        this.view = weaponView;
    }

    public void setWeaponDataSource (WeaponManagerController source) {
        this.weaponDataSource = source;
        this.weaponDataSource.addTypeBankListener(this.weaponView);
        onUserPressedCreateWeapon();
    }

    @Override
    public void onUserEnteredWeaponFireRate (String weaponFireRate) {
        try {
            Double.parseDouble(weaponFireRate);
            weaponDataSource.setWeaponFireRate(currentWeaponID, Double.parseDouble(weaponFireRate));
        }
        catch (NumberFormatException e) {
            createDialogueBox();
        }
    }

    @Override
    public void onUserEnteredWeaponSpeed (String weaponSpeed) {
        try {
            Double.parseDouble(weaponSpeed);
            weaponDataSource.setWeaponSpeed(currentWeaponID, Double.parseDouble(weaponSpeed));
        }
        catch (NumberFormatException e) {
            createDialogueBox();
        }
    }

    @Override
    public void onUserEnteredWeaponRange (String weaponRange) {
        try {
            Double.parseDouble(weaponRange);
            weaponDataSource.setWeaponRange(currentWeaponID, Double.parseDouble(weaponRange));
        }
        catch (NumberFormatException e) {
            createDialogueBox();
        }
    }

    @Override
    public void onUserEnteredWeaponImagePath (String weaponImagePath) {
        weaponDataSource.setImagePath(currentWeaponID, weaponImagePath);
    }

    @Override
    public void onUserPressedCreateWeapon () {
        currentWeaponID = weaponDataSource.createType(weaponView);
        refreshWeaponView();
    }

    private void refreshWeaponView () {
        weaponView.updateImagePathDisplay(weaponDataSource.getImagePath(currentWeaponID));
        weaponView.updateNameDisplay(weaponDataSource.getName(currentWeaponID));
        weaponView.updateFireRateDisplay(weaponDataSource.getWeaponReloadTime(currentWeaponID));
        weaponView.updateRangeDisplay(weaponDataSource.getWeaponRange(currentWeaponID));
        weaponView.updateSizeDisplay(weaponDataSource.getSize(currentWeaponID));
        weaponView.updateSpeedDisplay(weaponDataSource.getWeaponSpeed(currentWeaponID));
    }

    @Override
    public void onUserEnteredWeaponName (String weaponName) {
        weaponDataSource.setName(currentWeaponID, weaponName);
    }

    @Override
    public void onUserEnteredWeaponTrajectory (String weaponTrajectory) {
        weaponDataSource.setWeaponTrajectory(currentWeaponID, weaponTrajectory);
    }

    private void createDialogueBox () {
        ResourceBundle dialogueBoxResource = ResourceBundle.getBundle("resources/DialogueBox");
        DialogueBoxFactory.createErrorDialogueBox(dialogueBoxResource.getString("Integer"),
                                                  dialogueBoxResource.getString("CheckInput"));
    }

    @Override
    public void onUserEnteredNewTargetEnemy (String enemyID) {
        // TODO Auto-generated method stub

    }

    @Override
    public void onUserPressedDeleteWeapon () {
        // TODO Auto-generated method stub

    }

    @Override
    public void onUserEnteredWeaponSize (String weaponSize) {
        try {
            Double.parseDouble(weaponSize);
            weaponDataSource.setSize(currentWeaponID, Double.parseDouble(weaponSize));
        }
        catch (NumberFormatException e) {
            createDialogueBox();
        }
    }

    @Override
    public void onUserSelectedWeapon (int weaponID) {
        currentWeaponID = weaponID;
        refreshWeaponView();
    }

    @Override
    public ListCellData getCellDataForSubject (int id) {
        ListCellData cellData = new ListCellData();
        cellData.setName(weaponDataSource.getName(id));
        cellData.setImagePath(weaponDataSource.getImagePath(id));
        cellData.setId(id);
        return cellData;
    }

}
