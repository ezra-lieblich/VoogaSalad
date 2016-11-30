package authoring.editorview.weapon;

import java.io.IOException;
import java.util.ResourceBundle;
import authoring.editorview.EditorViewController;
import authoring.utilityfactories.DialogueBoxFactory;
import engine.weapon.WeaponManagerController;


/**
 * 
 * @author Kayla Schulz
 * @author Andrew Bihl
 *
 */
public class WeaponEditorViewController extends EditorViewController
        implements WeaponEditorViewDelegate {

    private WeaponManagerController weaponDataSource;
    private int currentWeaponID;
    private IWeaponEditorView myView;

    public WeaponEditorViewController (int editorWidth, int editorHeight) throws IOException {
        myView = WeaponEditorViewFactory.build(editorWidth, editorHeight);
        myView.setDelegate(this);
        this.view = myView;
    }

    public void setWeaponDataSource (WeaponManagerController source) {
        this.weaponDataSource = source;
        currentWeaponID = weaponDataSource.createType(myView);
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
    public void onUserEnteredWeaponEffect (String weaponCollisionEffect) {
        weaponDataSource.setWeaponCollisionEffect(currentWeaponID, weaponCollisionEffect);
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
    public void onUserEnteredWeaponImage (String weaponImagePath) {
        weaponDataSource.setImagePath(currentWeaponID, weaponImagePath);
    }

    @Override
    public void onUserPressedCreateWeapon () {
        // weaponDataSource.createWeapon();
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
	public void onUserSelectedWeapon(int weaponID) {
		// TODO Auto-generated method stub
		
	}

}
