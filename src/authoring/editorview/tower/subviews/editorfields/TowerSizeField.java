package authoring.editorview.tower.subviews.editorfields;

import java.util.ResourceBundle;
import authoring.editorview.tower.TowerSetView;
import authoring.editorview.tower.TowerAuthoringViewDelegate;
import authoring.utilityfactories.TextFieldFactory;
import javafx.scene.Node;
import javafx.scene.control.TextField;


public class TowerSizeField implements TowerSetView {

    private TextField towerSizeField;
    private TowerAuthoringViewDelegate delegate;

    public TowerSizeField (ResourceBundle labelsResource) {
        towerSizeField =
                TextFieldFactory.makeTextField(labelsResource.getString("EnterInt"),
                                               e -> delegate.onUserEnteredTowerSize(towerSizeField
                                                       .getText()));
    }

    @Override
    public void setDelegate (TowerAuthoringViewDelegate delegate) {
        this.delegate = delegate;
    }

    @Override
    public Node getInstanceAsNode () {
        return towerSizeField;
    }

    public void updateTowerSize (String towerSize) {
        towerSizeField.setText(towerSize);
    }

}
