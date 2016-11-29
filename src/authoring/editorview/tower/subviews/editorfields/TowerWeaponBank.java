package authoring.editorview.tower.subviews.editorfields;

import java.util.ResourceBundle;
import authoring.editorview.tower.ITowerEditorView;
import authoring.editorview.tower.TowerEditorViewDelegate;
import authoring.utilityfactories.ComboBoxFactory;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Node;
import javafx.scene.control.ComboBox;
import javafx.scene.layout.HBox;


/**
 * 
 * @author Kayla Schulz
 *
 */
public class TowerWeaponBank implements ITowerEditorView {

    private HBox towerChooseWeaponBox;
    private TowerEditorViewDelegate delegate;
    private ResourceBundle labelsResource;

    public TowerWeaponBank (ResourceBundle labelsResource) {
        this.labelsResource = labelsResource;
        // towerChooseWeaponBox=
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
