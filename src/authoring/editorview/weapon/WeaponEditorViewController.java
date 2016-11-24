package authoring.editorview.weapon;

import java.io.IOException;
import authoring.editorview.EditorViewController;


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
        // currentWeaponID = weaponDataSource.getWeap
    }

    public void setWeaponDataSource (WeaponDataSource source) {
        this.weaponDataSource = source;
    }

    @Override
    public void onUserEnteredWeaponFireRate (String fireRate) {
        // Should update currentWeaponID every time this is called
        weaponDataSource.setWeaponFireRate(currentWeaponID, Integer.parseInt(fireRate));
    }

    @Override
    public void onUserEnteredProjectileSpeed (String speed) {
        weaponDataSource.setWeaponSpeed(currentWeaponID, Integer.parseInt(speed));
    }

    @Override
    public void onUserEnteredWeaponEffect (String collisionEffect) {
        weaponDataSource.setWeaponCollisionEffect(currentWeaponID, collisionEffect);

    }

    @Override
    public void onUserEnteredWeaponRange (String range) {
        weaponDataSource.setWeaponRange(currentWeaponID, Integer.parseInt(range));
    }

    @Override
    public void onUserEnteredWeaponImage (String weaponImagePath) {
        weaponDataSource.setWeaponImagePath(currentWeaponID, weaponImagePath);
    }

    @Override
    public void onUserEnteredWeaponDamage (String damage) {
        weaponDataSource.setWeaponDamage(currentWeaponID, Integer.parseInt(damage));
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
    public void onUserEnteredWeaponPath (String path) {
        weaponDataSource.setWeaponPath(currentWeaponID, path);
    }
}
