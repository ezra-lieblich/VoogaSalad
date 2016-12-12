package authoring.editorview.collisioneffects.subviews;

import java.util.List;
import authoring.editorview.ImageBank;
import authoring.editorview.collisioneffects.EffectAuthoringViewDelegate;
import authoring.editorview.collisioneffects.EffectSetView;
import javafx.scene.control.Label;


/**
 * 
 * @author Kayla Schulz
 *
 */
public class EffectBank extends ImageBank implements EffectSetView {

    private EffectAuthoringViewDelegate delegate;

    public EffectBank () {
        super();
        Label effectLabel = new Label("Effects");
        this.items.add(effectLabel);
    }

    @Override
    protected void userSelectedRow (int index) {
        // TODO Auto-generated method stub

    }
    
    public void updateEffectBank (List<Integer> activeEffects) {
        super.updateBank(activeEffects);
    }

    public void setDelegate (EffectAuthoringViewDelegate delegate) {
        this.delegate = delegate;
    }

}
