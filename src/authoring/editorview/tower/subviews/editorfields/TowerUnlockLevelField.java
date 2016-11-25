package authoring.editorview.tower.subviews.editorfields;

import authoring.editorview.tower.ITowerEditorView;
import authoring.editorview.tower.TowerEditorViewDelegate;
import authoring.utilityfactories.TextFieldFactory;
import javafx.scene.Node;
import javafx.scene.control.TextField;


public class TowerUnlockLevelField implements ITowerEditorView {

    private TextField towerLevelField;
    private TowerEditorViewDelegate delegate;

    public TowerUnlockLevelField () {
        towerLevelField =
                TextFieldFactory.makeTextField("Set tower unlock level: ",
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
