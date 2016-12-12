package authoring.editorview.tower.subviews.editorfields;

import java.util.ResourceBundle;
import authoring.editorview.tower.TowerSetView;
import authoring.editorview.tower.TowerAuthoringViewDelegate;
import authoring.utilityfactories.TextFieldFactory;
import javafx.scene.Node;
import javafx.scene.control.TextField;


/**
 * 
 * @author Kayla Schulz
 *
 */
public class TowerUnlockLevelField implements TowerSetView {

    private TextField towerLevelField;
    private TowerAuthoringViewDelegate delegate;

    public TowerUnlockLevelField (ResourceBundle labelsResource) {
        towerLevelField =
                TextFieldFactory.makeTextField(labelsResource.getString("EnterInt"),
                                               e -> delegate
                                                       .onUserEnteredTowerUnlockLevel(towerLevelField
                                                               .getText()));
    }

    @Override
    public void setDelegate (TowerAuthoringViewDelegate delegate) {
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
