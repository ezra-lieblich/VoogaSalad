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
public class TowerUpgradeBank implements ITowerSetView {

    private HBox towerUpgradeBox;
    private TowerEditorViewDelegate delegate;
    private ResourceBundle labelsResource;

    public TowerUpgradeBank (ResourceBundle labelsResource) {
        this.labelsResource = labelsResource;
        towerUpgradeBox = new HBox(5);
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
        // towerUpgradeBox.setValue(towerUpgrade);
    }

    public void deleteTowerUpgrade (String towerUpgrade) {

    }

}
