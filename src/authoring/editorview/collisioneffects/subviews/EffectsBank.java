package authoring.editorview.collisioneffects.subviews;

import authoring.editorview.ImageBank;
import authoring.editorview.collisioneffects.EffectsAuthoringViewDelegate;


public class EffectsBank extends ImageBank {

    private EffectsAuthoringViewDelegate delegate;

    public EffectsBank () {
        super();
    }

    @Override
    protected void userSelectedRow (int index) {
        // TODO Auto-generated method stub

    }

    public void setDelegate (EffectsAuthoringViewDelegate delegate) {
        this.delegate = delegate;
    }

}
