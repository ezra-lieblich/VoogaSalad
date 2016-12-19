package authoring.editorview.weapon;

import java.io.IOException;
import authoring.editorview.EditorViewController;
import authoring.editorview.ListCellData;
import authoring.editorview.ListDataSource;
import authoring.editorview.collisioneffects.EffectAuthoringViewController;
import engine.effect.EffectManagerController;
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
    private EffectManagerController effectDataSource;
    private int currentWeaponID;
    private WeaponUpdateView weaponView;

    public WeaponAuthoringViewController (int editorWidth, int editorHeight) throws IOException {
        weaponView = WeaponAuthoringViewFactory.build(editorWidth, editorHeight);
        weaponView.setDelegate(this);
        weaponView.setWeaponListDataSource(this);
        this.view = weaponView;
    }

    public void setWeaponDataSource (WeaponManagerController source) {
        this.weaponDataSource = source;
        this.weaponDataSource.addTypeBankListener(this.weaponView);
        effectDataSource = weaponDataSource.getEffectManagerController();
        onUserPressedCreateWeapon();
    }

    @Override
    public void onUserEnteredWeaponFireRate (String weaponFireRate) {
        weaponDataSource.setWeaponFireRate(currentWeaponID, Double.parseDouble(weaponFireRate));
    }

    @Override
    public void onUserEnteredWeaponSpeed (String weaponSpeed) {
        weaponDataSource.setWeaponSpeed(currentWeaponID, Double.parseDouble(weaponSpeed));
    }

    @Override
    public void onUserEnteredWeaponRange (String weaponRange) {
        weaponDataSource.setWeaponRange(currentWeaponID, Double.parseDouble(weaponRange));
    }

    @Override
    public void onUserEnteredWeaponImagePath (String weaponImagePath) {
        weaponDataSource.setImagePath(currentWeaponID, weaponImagePath);
    }

    @Override
    public void onUserPressedCreateWeapon () {
        currentWeaponID = weaponDataSource.createType(weaponView);
        refreshView();
    }

    public void refreshView () {
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

    @Override
    public void onUserEnteredNewTargetEnemy (String enemyID) {
        // TODO Auto-generated method stub

    }

    @Override
    public void onUserPressedDeleteWeapon () {
        int nextID = this.weaponView.getNearestAvailableItemID(currentWeaponID);
        weaponDataSource.deleteType(currentWeaponID);
        currentWeaponID = nextID;
        this.refreshView();
    }

    @Override
    public void onUserEnteredWeaponSize (String weaponSize) {
        weaponDataSource.setSize(currentWeaponID, Double.parseDouble(weaponSize));
    }

    @Override
    public void onUserSelectedWeapon (int weaponID) {
        currentWeaponID = weaponID;
        refreshView();
    }

    @Override
    public ListCellData getCellDataForSubject (int id) {
        ListCellData cellData = new ListCellData();
        cellData.setName(weaponDataSource.getName(id));
        cellData.setImagePath(weaponDataSource.getImagePath(id));
        cellData.setId(id);
        return cellData;
    }

    @Override
    public void onUserPressedAddEffect () {
        EffectAuthoringViewController effectAuthoringView =
                new EffectAuthoringViewController(effectDataSource);
        effectDataSource.createType(effectAuthoringView.getEffectAuthoringView());
        effectAuthoringView.setEffectOptions(effectDataSource.getCreatedTypeIds());
        effectAuthoringView.setAvailClasses(effectDataSource.getAvailableClasses());
        effectAuthoringView.setAvailDataObjects(effectDataSource.getAvailableDataObjects());
        effectAuthoringView.openEffectView();
    }

}
