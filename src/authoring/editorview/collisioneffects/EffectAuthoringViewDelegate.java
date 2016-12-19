package authoring.editorview.collisioneffects;

import authoring.editorview.EditorViewDelegate;

/**
 * 
 * @author Kayla Schulz
 *
 */
public interface EffectAuthoringViewDelegate extends EditorViewDelegate {

    public void onUserSelectedAvailableClass (String selectedClass);

    public void onUserEnteredCondition (String condition);

    public void onUserSelectedEffect (int effectID);

    public void onUserEnteredEffectText (String effect);
}
