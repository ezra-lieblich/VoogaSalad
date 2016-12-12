package authoring.editorview.collisioneffects;

import authoring.editorview.EditorViewController;
import engine.effect.EffectManagerController;


public class EffectController extends EditorViewController
        implements EffectAuthoringViewDelegate {

    private EffectManagerController effectsDataSource;
    private int currentEffectID;

    public EffectController () {

    }

    public void setEffectDataSource (EffectManagerController source) {
        this.effectsDataSource = source;
    }

    @Override
    public void onUserSelectedAvailableClass (String selectedClass) {
        effectsDataSource.setAvailableClass(selectedClass);
        // TODO: This also needs to update the available methods
    }

    @Override
    public void onUserSelectedEffectName (String name) {
        effectsDataSource.setName(currentEffectID, name);
    }

    @Override
    public void onUserEnteredCondition (String condition) {
        effectsDataSource.setCondition(currentEffectID, condition);
    }

    @Override
    public void onUserEnteredEffect (String effect) {
        effectsDataSource.setEffect(currentEffectID, effect);
    }

}
