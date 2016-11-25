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
        try {
            Integer.parseInt(fireRate);
            weaponDataSource.setWeaponFireRate(currentWeaponID, Integer.parseInt(fireRate));
        }
        catch (NumberFormatException e) {
            System.out.println("This input is not an integer");
        }
    }

    @Override
    public void onUserEnteredProjectileSpeed (String speed) {
        try {
            Integer.parseInt(speed);
            weaponDataSource.setWeaponSpeed(currentWeaponID, Integer.parseInt(speed));
        }
        catch (NumberFormatException e) {
            System.out.println("This input is not an integer");
        }
    }

    @Override
    public void onUserEnteredWeaponEffect (String collisionEffect) {
        weaponDataSource.setWeaponCollisionEffect(currentWeaponID, collisionEffect);

    }

    @Override
    public void onUserEnteredWeaponRange (String range) {
        try {
            Integer.parseInt(range);
            weaponDataSource.setWeaponRange(currentWeaponID, Integer.parseInt(range));
        }
        catch (NumberFormatException e) {
            System.out.println("This input is not an integer");
        }
    }

    @Override
    public void onUserEnteredWeaponImage (String weaponImagePath) {
        weaponDataSource.setWeaponImagePath(currentWeaponID, weaponImagePath);
    }

    @Override
    public void onUserEnteredWeaponDamage (String damage) {
        try {
            Integer.parseInt(damage);
            weaponDataSource.setWeaponDamage(currentWeaponID, Integer.parseInt(damage));
        }
        catch (NumberFormatException e) {
            System.out.println("This input is not an integer");
        }
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
