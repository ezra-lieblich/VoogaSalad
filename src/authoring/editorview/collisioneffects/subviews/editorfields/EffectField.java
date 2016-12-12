package authoring.editorview.collisioneffects.subviews.editorfields;

import java.util.ResourceBundle;
import authoring.editorview.TextFieldView;
import authoring.editorview.collisioneffects.EffectAuthoringViewDelegate;
import authoring.editorview.collisioneffects.EffectSetView;


public class EffectField extends TextFieldView implements EffectSetView {

    private EffectAuthoringViewDelegate delegate;

    public EffectField (ResourceBundle resource) {
        super(resource);
    }

    @Override
    public void updateField (String newData) {
        // TODO Auto-generated method stub

    }

    @Override
    protected void makeTextField (ResourceBundle labelsResource) {
        // TODO Auto-generated method stub

    }

    @Override
    public void setDelegate (EffectAuthoringViewDelegate delegate) {
        this.delegate = delegate;
    }

}
