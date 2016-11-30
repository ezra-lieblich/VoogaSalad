package authoring.editorview.tower.subviews.editorfields;

import java.util.ResourceBundle;
import authoring.editorview.tower.ITowerSetView;
import authoring.editorview.tower.TowerEditorViewDelegate;
import javafx.scene.Node;
import javafx.scene.layout.HBox;


/**
 * 
 * @author Kayla Schulz
 *
 */
public class TowerWeaponBank implements ITowerSetView {

    private HBox towerChooseWeaponBox;
    private TowerEditorViewDelegate delegate;
    private ResourceBundle labelsResource;

    public TowerWeaponBank (ResourceBundle labelsResource) {
        this.labelsResource = labelsResource;
        towerChooseWeaponBox = new HBox(5);
    }

    @Override
    public void setDelegate (TowerEditorViewDelegate delegate) {
        this.delegate = delegate;
    }

    @Override
    public Node getInstanceAsNode () {
        return towerChooseWeaponBox;
    }

    public void updateTowerChosenWeapon (String chosenWeapon) {
        // towerChooseWeaponBox.setValue(chosenWeapon);
    }

}
