package authoring.editorview.tower.subviews.editorfields;

import authoring.editorview.tower.TowerEditorViewDelegate;
import authoring.utilityfactories.TextFieldFactory;
import javafx.scene.control.TextField;


public class TowerUnlockLevelField {

    private TextField towerLevelField;
    private TowerEditorViewDelegate delegate;

    public TowerUnlockLevelField () {
        towerLevelField =
                TextFieldFactory.makeTextField("Set tower unlock level: ",
                                               e -> delegate
                                                       .onUserEnteredUnlockLevel(towerLevelField
                                                               .getText()));
    }

    public void setDelegate (TowerEditorViewDelegate delegate) {
        this.delegate = delegate;
    }

    public TextField getTowerLevelField () {
        return towerLevelField;
    }

    public void updateTowerUnlockLevel (String towerLevel) {
        towerLevelField.setText(towerLevel);
    }

}
