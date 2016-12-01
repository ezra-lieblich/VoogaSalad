package authoring.editorview.tower.subviews.editorfields;

import java.util.ResourceBundle;
import authoring.editorview.tower.ITowerSetView;
import authoring.editorview.tower.TowerEditorViewDelegate;
import authoring.utilityfactories.TextFieldFactory;
import javafx.scene.Node;
import javafx.scene.control.TextField;


/**
 * 
 * @author Kayla Schulz
 *
 */
public class TowerUnlockLevelField implements ITowerSetView {

    private TextField towerLevelField;
    private TowerEditorViewDelegate delegate;

    public TowerUnlockLevelField (ResourceBundle labelsResource) {
        towerLevelField =
                TextFieldFactory.makeTextField(labelsResource.getString("EnterInt"),
                                               e -> delegate
                                                       .onUserEnteredTowerUnlockLevel(towerLevelField
                                                               .getText()));
    }

    @Override
    public void setDelegate (TowerEditorViewDelegate delegate) {
        this.delegate = delegate;
    }

    @Override
    public Node getInstanceAsNode () {
        return towerLevelField;
    }

    public void updateTowerUnlockLevel (String towerLevel) {
        towerLevelField.setText(towerLevel);
    }

}
