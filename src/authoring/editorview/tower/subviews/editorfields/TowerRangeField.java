package authoring.editorview.tower.subviews.editorfields;

import authoring.editorview.tower.ITowerEditorView;
import authoring.editorview.tower.TowerEditorViewDelegate;
import authoring.utilityfactories.TextFieldFactory;
import javafx.scene.Node;
import javafx.scene.control.TextField;

public class TowerRangeField implements ITowerEditorView {

    private TowerEditorViewDelegate delegate;
    private TextField towerRangeField;

    public TowerRangeField () {
        towerRangeField =
                TextFieldFactory.makeTextField("Set tower range: ",
                                               e -> delegate
                                                       .onUserEnteredRange(towerRangeField
                                                               .getText()));
    }

    @Override
    public void setDelegate (TowerEditorViewDelegate delegate) {
        this.delegate = delegate;
    }

    @Override
    public Node getInstanceAsNode () {
        return towerRangeField;
    }

    public void updateTowerRange (String towerRange) {
        towerRangeField.setText(towerRange);
    }
    
}
