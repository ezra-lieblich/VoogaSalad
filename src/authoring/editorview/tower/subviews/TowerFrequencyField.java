package authoring.editorview.tower.subviews;

import authoring.editorview.tower.TowerEditorViewDelegate;
import authoring.utilityfactories.TextFieldFactory;
import javafx.scene.control.TextField;


public class TowerFrequencyField {

    private TowerEditorViewDelegate delegate;
    private TextField towerFrequencyField;

    public TowerFrequencyField () {
        towerFrequencyField =
                TextFieldFactory.makeTextField("Set tower frequency: ",
                                               e -> delegate
                                                       .onUserEnteredFrequency(towerFrequencyField
                                                               .getText()));
    }

    public void setDelegate (TowerEditorViewDelegate delegate) {
        this.delegate = delegate;
    }

    public TextField getTowerFrequencyField () {
        return towerFrequencyField;
    }

    public void updateTowerFrequency (String towerFrequency) {
        towerFrequencyField.setText(towerFrequency);
    }

}
