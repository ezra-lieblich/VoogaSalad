package authoring.editorview.tower.subviews.editorfields;

import authoring.editorview.tower.TowerEditorViewDelegate;
import authoring.utilityfactories.TextFieldFactory;
import javafx.scene.control.TextField;


public class TowerFireRateField {

    private TextField towerFireRateField;
    private TowerEditorViewDelegate delegate;

    public TowerFireRateField () {
        towerFireRateField =
                TextFieldFactory.makeTextField("Set tower fire rate: ",
                                               e -> delegate
                                                       .onUserEnteredFireRate(towerFireRateField
                                                               .getText()));
    }

    public void setDelegate (TowerEditorViewDelegate delegate) {
        this.delegate = delegate;
    }

    public TextField getTowerFireRateField () {
        return towerFireRateField;
    }

    public void updateTowerFireRate (String towerFireRate) {
        towerFireRateField.setText(towerFireRate);
    }

}
