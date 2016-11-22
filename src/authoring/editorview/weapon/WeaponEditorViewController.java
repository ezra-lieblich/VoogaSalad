package authoring.editorview.weapon;

import java.io.IOException;
import authoring.editorview.EditorViewController;
import authoring.editorview.weapon.subviews.WeaponEffectView;


public class WeaponEditorViewController extends EditorViewController
        implements WeaponEditorViewDelegate {

    private WeaponDataSource weaponDataSource;
    private IWeaponEditorView myView;
    private WeaponEffectView effectView;

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
        // TODO Auto-generated method stub
        
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
    public void onUserPressedCreate () {
        // TODO Auto-generated method stub
        
    }
}
