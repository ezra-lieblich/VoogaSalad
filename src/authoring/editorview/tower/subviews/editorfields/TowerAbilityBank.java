package authoring.editorview.tower.subviews.editorfields;

import java.util.ResourceBundle;
import authoring.editorview.tower.ITowerSetView;
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
public class TowerAbilityBank implements ITowerSetView {

    private HBox towerAbilityBox;
    private TowerEditorViewDelegate delegate;
    private ResourceBundle labelsResource;

    public TowerAbilityBank (ResourceBundle labelsResource) {
        this.labelsResource = labelsResource;
        towerAbilityBox = new HBox(5);
    }

    @Override
    public void setDelegate (TowerEditorViewDelegate delegate) {
        this.delegate = delegate;
    }

    @Override
    public Node getInstanceAsNode () {
        return towerAbilityBox;
    }

    public void updateTowerAbility (String towerAbility) {
        // towerAbilityBox.setValue(towerAbility);
    }

}
