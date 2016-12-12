package authoring.editorview.collisioneffects.subviews;

import authoring.editorview.ImageBank;
import authoring.editorview.ListCellData;
import authoring.editorview.collisioneffects.EffectAuthoringViewDelegate;
import authoring.editorview.collisioneffects.EffectSetView;
import javafx.scene.Node;
import javafx.scene.control.Label;


/**
 * 
 * @author Kayla Schulz
 *
 */
public class EffectAvailableClassesView extends ImageBank implements EffectSetView {

    private EffectAuthoringViewDelegate delegate;

    public EffectAvailableClassesView () {
        super();
        Label effectLabel = new Label("Available Classes");
        this.items.add(effectLabel);
    }

    @Override
    public void setDelegate (EffectAuthoringViewDelegate delegate) {
        this.delegate = delegate;
    }

    @Override
    protected void userSelectedRow (int index) {
        // TODO Auto-generated method stub

    }

    @Override
    protected Node createCellFromData (ListCellData data) {
        // TODO Auto-generated method stub
        return null;
    }

}
