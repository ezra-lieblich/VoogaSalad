package authoring.editorview.weapon;

import authoring.editorview.IEditorView;

/**
 * The Weapon View interface will detail the components of the weapon creation. The interface
 * determines a portion of our internal API.
 *
 */
public interface IWeaponEditorView extends IEditorView {
    
    public void setDelegate(WeaponEditorViewDelegate delegate);
    
}
