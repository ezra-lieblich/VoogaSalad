package authoring.editorview.collisioneffects.subviews;

import authoring.editorview.ImageBank;
import authoring.editorview.collisioneffects.EffectAuthoringViewDelegate;


public class EffectBank extends ImageBank {

    private EffectAuthoringViewDelegate delegate;

    public EffectBank () {
        super();
    }

    @Override
    protected void userSelectedRow (int index) {
        // TODO Auto-generated method stub

    }

    public void setDelegate (EffectAuthoringViewDelegate delegate) {
        this.delegate = delegate;
    }

}
