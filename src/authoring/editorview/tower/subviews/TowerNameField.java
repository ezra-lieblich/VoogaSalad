package authoring.editorview.tower.subviews;

import authoring.editorview.tower.TowerEditorViewDelegate;
import authoring.utilityfactories.TextFieldFactory;
import javafx.scene.control.TextField;


public class TowerNameField {

    private TextField towerNameField;
    private TowerEditorViewDelegate delegate;

    public TowerNameField () {
        towerNameField =
                TextFieldFactory.makeTextField("Set tower name: ",
                                               e -> delegate.onUserEnteredTowerName(towerNameField
                                                       .getText()));
    }

    public void setDelegate (TowerEditorViewDelegate delegate) {
        this.delegate = delegate;
    }

    public TextField getTowerNameField () {
        return towerNameField;
    }

    public void updateTowerName (String towerName) {
        towerNameField.setText(towerName);
    }

}
