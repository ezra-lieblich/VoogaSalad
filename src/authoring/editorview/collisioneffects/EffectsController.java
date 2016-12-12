package authoring.editorview.collisioneffects;

import authoring.editorview.EditorViewController;
import engine.effect.EffectManagerController;


public class EffectsController extends EditorViewController
        implements EffectsAuthoringViewDelegate {

    private EffectManagerController effectsDataSource;
    private int currentEffectID;

    public EffectsController () {

    }

    public void setEffectDataSource (EffectManagerController source) {
        this.effectsDataSource = source;
    }

    @Override
    public void onUserSelectedAvailableClass () {
        // TODO Auto-generated method stub

    }

    @Override
    public void onUserSelectedEffectName () {
        // TODO Auto-generated method stub

    }

}
