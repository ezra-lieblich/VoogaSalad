package authoring.editorview.tower.subviews;

import authoring.editorview.tower.TowerEditorViewDelegate;
import authoring.utilityfactories.TextFieldFactory;
import javafx.scene.control.TextField;

public class TowerRangeField {

    private TowerEditorViewDelegate delegate;
    private TextField towerRangeField;

    public TowerRangeField () {
        towerRangeField =
                TextFieldFactory.makeTextField("Set tower range: ",
                                               e -> delegate
                                                       .onUserEnteredRange(towerRangeField
                                                               .getText()));
    }

    public void setDelegate (TowerEditorViewDelegate delegate) {
        this.delegate = delegate;
    }

    public TextField getTowerRangeField () {
        return towerRangeField;
    }

    public void updateTowerRange (String towerRange) {
        towerRangeField.setText(towerRange);
    }
    
}
