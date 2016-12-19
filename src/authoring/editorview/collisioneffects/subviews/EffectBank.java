package authoring.editorview.collisioneffects.subviews;

import java.util.List;

import authoring.editorview.collisioneffects.EffectAuthoringViewDelegate;
import authoring.editorview.collisioneffects.EffectSetView;
import authoring.editorview.imagebank.ImageBank;
import javafx.scene.Node;
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
        this.addStaticCell(effectLabel);
    }

    @Override
    protected void userSelectedRow (int index) {
        int selectedEffect = this.itemIDs.get(index);
        if (selectedEffect != -1) {
            this.delegate.onUserSelectedEffect(selectedEffect);
        }

    }

    public void updateEffectBank (List<Integer> activeEffects) {
        super.updateBank(activeEffects);
    }

    public void setDelegate (EffectAuthoringViewDelegate delegate) {
        this.delegate = delegate;
    }

    @Override
    protected Node createCellForItemID(int id) {
        Label cell = new Label();
        String name = this.dataSource.getName(id);
        if (name.equals(null) || name.length() < 1) {
            name = DEFAULT_SUBJECT_IMAGE_PATH;
        }
        cell.setText(name);
        return cell;
    }

}
