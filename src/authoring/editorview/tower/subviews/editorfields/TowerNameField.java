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
public class TowerNameField implements ITowerEditorView {

    private TextField towerNameField;
    private TowerEditorViewDelegate delegate;

    public TowerNameField () {
        ResourceBundle labelsResource;
        String TOWER_EFFECT_RESOURCE_PATH = "resources/GameAuthoringTower";
        labelsResource = ResourceBundle.getBundle(TOWER_EFFECT_RESOURCE_PATH);
        towerNameField =
                TextFieldFactory.makeTextField(labelsResource.getString("EnterString"),
                                               e -> delegate.onUserEnteredTowerName(towerNameField
                                                       .getText()));
    }

    @Override
    public void setDelegate (TowerEditorViewDelegate delegate) {
        this.delegate = delegate;
    }

    @Override
    public Node getInstanceAsNode () {
        return towerNameField;
    }

    public void updateTowerName (String towerName) {
        towerNameField.setText(towerName);
    }

}
