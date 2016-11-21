package authoring.editorview.weapon;

import authoring.editorview.EditorViewController;


public class WeaponEditorViewController extends EditorViewController
        implements WeaponEditorViewDelegate {

    public WeaponEditorViewController (int editorWidth, int editorHeight) {
        IWeaponEditorView myView = WeaponEditorViewFactory.build(editorWidth, editorHeight);
        myView.setDelegate(this);
        this.view = myView;
    }

    @Override
    public void setWeaponFireRate (double fireRate) {
        // TODO Auto-generated method stub

    }

    @Override
    public void setWeaponSpeed (double speed) {
        // TODO Auto-generated method stub

    }

    @Override
    public void setWeaponEffect (String collisionEffect) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void setWeaponRange (double range) {
        // TODO Auto-generated method stub
        
    }
}
