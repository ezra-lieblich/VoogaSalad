package authoring.editorview.collisioneffects.subviews;

import authoring.editorview.ImageBank;
import authoring.editorview.collisioneffects.EffectAuthoringViewDelegate;
import authoring.editorview.collisioneffects.EffectSetView;


/**
 * 
 * @author Kayla Schulz
 *
 */
public class EffectBank extends ImageBank implements EffectSetView {

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
