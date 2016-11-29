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
public class TowerUpgradeBank implements ITowerEditorView {

    private HBox towerUpgradeBox;
    private TowerEditorViewDelegate delegate;
    private ResourceBundle labelsResource;

    public TowerUpgradeBank (ResourceBundle labelsResource) {
        this.labelsResource = labelsResource;
        // towerUpgradeBox=
    }

    @Override
    public void setDelegate (TowerEditorViewDelegate delegate) {
        this.delegate = delegate;
    }

    @Override
    public Node getInstanceAsNode () {
        return towerUpgradeBox;
    }

    public void addTowerUpgrade (String towerUpgrade) {
        //towerUpgradeBox.setValue(towerUpgrade);
    }

    public void deleteTowerUpgrade (String towerUpgrade) {

    }

}
