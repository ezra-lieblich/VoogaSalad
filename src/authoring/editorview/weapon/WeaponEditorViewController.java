package authoring.editorview.weapon;

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
public class WeaponEditorViewController extends EditorViewController
        implements WeaponEditorViewDelegate {

    private WeaponDataSource weaponDataSource;
    private int currentWeaponID;

    public WeaponEditorViewController (int editorWidth, int editorHeight) throws IOException {
        IWeaponUpdateView myView = WeaponEditorViewFactory.build(editorWidth, editorHeight);
        myView.setDelegate(this);
        this.view = myView;
    }

    private void updateWeaponID () {
        // How do I know which ID I'm working with?
        currentWeaponID = weaponDataSource.getCreatedWeapon();
    }

    public void setWeaponDataSource (WeaponDataSource source) {
        this.weaponDataSource = source;
    }

    @Override
    public void onUserEnteredWeaponFireRate (String weaponFireRate) {
        // Should update currentWeaponID every time this is called
        try {
            Integer.parseInt(weaponFireRate);
            weaponDataSource.setWeaponFireRate(currentWeaponID, Integer.parseInt(weaponFireRate));
        }
        catch (NumberFormatException e) {
            createDialogueBox();
        }
    }

    @Override
    public void onUserEnteredWeaponSpeed (String weaponSpeed) {
        try {
            Integer.parseInt(weaponSpeed);
            weaponDataSource.setWeaponSpeed(currentWeaponID, Integer.parseInt(weaponSpeed));
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
            Integer.parseInt(weaponRange);
            weaponDataSource.setWeaponRange(currentWeaponID, Integer.parseInt(weaponRange));
        }
        catch (NumberFormatException e) {
            createDialogueBox();
        }
    }

    @Override
    public void onUserEnteredWeaponImage (String weaponImagePath) {
        weaponDataSource.setWeaponImagePath(currentWeaponID, weaponImagePath);
    }

    @Override
    public void onUserEnteredWeaponDamage (String weaponDamage) {
        try {
            Integer.parseInt(weaponDamage);
            weaponDataSource.setWeaponDamage(currentWeaponID, Integer.parseInt(weaponDamage));
        }
        catch (NumberFormatException e) {
            createDialogueBox();
        }
    }

    @Override
    public void onUserPressedCreateWeapon () {
        weaponDataSource.createWeapon();
    }

    @Override
    public void onUserEnteredWeaponName (String weaponName) {
        weaponDataSource.setWeaponName(currentWeaponID, weaponName);
    }

    @Override
    public void onUserEnteredWeaponPath (String weaponPath) {
        weaponDataSource.setWeaponPath(currentWeaponID, weaponPath);
    }

    private void createDialogueBox () {
        ResourceBundle dialogueBoxResource = ResourceBundle.getBundle("resources/DialogueBox");
        DialogueBoxFactory.createErrorDialogueBox(dialogueBoxResource.getString("Integer"),
                                                  dialogueBoxResource.getString("CheckInput"));
    }
}
