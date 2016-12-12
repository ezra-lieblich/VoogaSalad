package authoring.editorview.collisioneffects.subviews;

import authoring.editorview.collisioneffects.EffectAuthoringViewDelegate;
import authoring.editorview.collisioneffects.EffectSetView;
import javafx.scene.Node;


/**
 * 
 * @author Kayla Schulz
 *
 */
public class EffectDataView implements EffectSetView {

    private EffectAuthoringViewDelegate delegate;

    @Override
    public Node getInstanceAsNode () {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public void setDelegate (EffectAuthoringViewDelegate delegate) {
        this.delegate = delegate;
    }

}
