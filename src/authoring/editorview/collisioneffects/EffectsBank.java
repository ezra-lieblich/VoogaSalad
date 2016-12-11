package authoring.editorview.collisioneffects;

import authoring.editorview.ImageBank;


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
