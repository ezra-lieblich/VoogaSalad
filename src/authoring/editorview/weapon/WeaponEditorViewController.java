package authoring.editorview.weapon;

import java.io.IOException;
import authoring.editorview.EditorViewController;


public class WeaponEditorViewController extends EditorViewController
        implements WeaponEditorViewDelegate {

    private WeaponDataSource weaponDataSource;

    public WeaponEditorViewController (int editorWidth, int editorHeight) throws IOException {
        IWeaponEditorView myView = WeaponEditorViewFactory.build(editorWidth, editorHeight);
        myView.setDelegate(this);
        this.view = myView;
    }

    public void setWeaponDataSource (WeaponDataSource source) {
        this.weaponDataSource = source;
    }

    @Override
    public void onUserEnteredWeaponFireRate (String rate) {
        // TODO Auto-generated method stub

    }

    @Override
    public void onUserEnteredProjectileSpeed (String speed) {
        // TODO Auto-generated method stub

    }

    @Override
    public void onUserEnteredWeaponEffect (String collisionEffect) {
        // TODO Auto-generated method stub

    }

    @Override
    public void onUserEnteredWeaponRange (String range) {
        weaponDataSource.setWeaponRange(0, Integer.parseInt(range));
    }

    @Override
    public void onUserEnteredWeaponImage (String weaponImageID) {
        // TODO Auto-generated method stub

    }

    @Override
    public void onUserEnteredWeaponDamage (String damage) {
        // TODO Auto-generated method stub

    }

    @Override
    public void onUserPressedCreateWeapon () {
        // TODO Auto-generated method stub

    }

    @Override
    public void onUserEnteredWeaponName (String weaponName) {
        // TODO Auto-generated method stub

    }

    @Override
    public void onUserEnteredWeaponPath (String path) {
        // TODO Auto-generated method stub

    }
}
