package authoring.editorview.collisioneffects;

public interface EffectAuthoringViewDelegate {

    public void onUserSelectedAvailableClass (String selectedClass);

    public void onUserSelectedEffectName (String name);

    public void onUserEnteredCondition (String condition);

    public void onUserEnteredEffect (String effect);
}
