// This entire file is part of my masterpiece.
// Diane Hadley

package authoring.editorview;

/**
 * This interface is a general interface between a view and its controller. It
 * is extended by other delegate interfaces.
 * 
 * The purpose for being in the masterpiece is discussed more fully in EditorNameView
 * 
 * @author Diane
 *
 */


public interface EditorViewDelegate {
	
	public void onUserEnteredName (String name);
	
	public void onUserPressedDeleteEntity ();


}
