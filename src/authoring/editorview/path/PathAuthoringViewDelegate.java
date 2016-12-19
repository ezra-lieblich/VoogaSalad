// This entire file is part of my masterpiece.
// Diane Hadley

package authoring.editorview.path;

import authoring.editorview.EditorViewDelegate;

/**
 * 
 * This interface is implemented by PathAuthoringViewController and contains methods
 * that the view calls in order to update the controller. I included this in my masterpiece
 * to demonstrate how EditorViewDelegate is extended.
 * 
 * @author Diane Hadley
 *
 */


public interface PathAuthoringViewDelegate extends EditorViewDelegate {

    public void onUserEnteredGridDimensions (int dimensions);

    public void onUserEnteredPathImage (String pathImagePath);

    public void onUserEnteredPathType (String pathType);

    public void onUserEnteredCreatePath ();

    public void onUserEnteredEditPath (int pathID);

    public boolean onUserEnteredAddPathCoordinate (int x, int y);

    public boolean onUserEnteredRemovePathCoordinate (int x, int y);

}
