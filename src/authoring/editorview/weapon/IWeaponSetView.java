package authoring.editorview.weapon;

import authoring.editorview.IEditorView;


/**
 * The interface for all weapon views. Allows those classes to implement setDelegate and
 * getInstanceAsNode
 * 
 * @author Kayla Schulz
 *
 */
public interface IWeaponSetView extends IEditorView {

    public void setDelegate (WeaponEditorViewDelegate delegate);
}
