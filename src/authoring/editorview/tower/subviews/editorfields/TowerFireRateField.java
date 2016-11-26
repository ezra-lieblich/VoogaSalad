package authoring.editorview.tower.subviews.editorfields;

import java.util.ResourceBundle;
import authoring.editorview.tower.ITowerEditorView;
import authoring.editorview.tower.TowerEditorViewDelegate;
import authoring.utilityfactories.TextFieldFactory;
import javafx.scene.Node;
import javafx.scene.control.TextField;


/**
 * 
 * @author Kayla Schulz
 *
 */
public class TowerFireRateField implements ITowerEditorView {

    private TextField towerFireRateField;
    private TowerEditorViewDelegate delegate;

    public TowerFireRateField () {
        ResourceBundle labelsResource;
        String TOWER_EFFECT_RESOURCE_PATH = "resources/GameAuthoringTower";
        labelsResource = ResourceBundle.getBundle(TOWER_EFFECT_RESOURCE_PATH);
        towerFireRateField =
                TextFieldFactory.makeTextField(labelsResource.getString("EnterInt"),
                                               e -> delegate
                                                       .onUserEnteredTowerFireRate(towerFireRateField
                                                               .getText()));
    }

    @Override
    public void setDelegate (TowerEditorViewDelegate delegate) {
        this.delegate = delegate;
    }

    @Override
    public Node getInstanceAsNode () {
        return towerFireRateField;
    }

    public void updateTowerFireRate (String towerFireRate) {
        towerFireRateField.setText(towerFireRate);
    }

}
