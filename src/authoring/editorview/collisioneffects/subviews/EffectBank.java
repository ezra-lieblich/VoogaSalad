package authoring.editorview.collisioneffects.subviews;

import java.io.File;
import java.util.List;
import authoring.editorview.ImageBank;
import authoring.editorview.ListCellData;
import authoring.editorview.collisioneffects.EffectAuthoringViewDelegate;
import authoring.editorview.collisioneffects.EffectSetView;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;


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

    @Override
    protected Node createCellFromData (ListCellData data) {
        Label cell = new Label();
        String name = data.getName();
        if (name.equals(null) || name.length() < 1) {
            name = DEFAULT_SUBJECT_IMAGE_PATH;
        }
        cell.setText(name);
        return cell;
    }

}
