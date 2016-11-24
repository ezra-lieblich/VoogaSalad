package authoring.editorview.tower.subviews.editorfields;

import authoring.editorview.tower.ITowerEditorView;
import authoring.editorview.tower.TowerEditorViewDelegate;
import authoring.utilityfactories.TextFieldFactory;
import javafx.scene.Node;
import javafx.scene.control.TextField;


public class TowerNameField implements ITowerEditorView {

    private TextField towerNameField;
    private TowerEditorViewDelegate delegate;

    public TowerNameField () {
        towerNameField =
                TextFieldFactory.makeTextField("Set tower name: ",
                                               e -> delegate.onUserEnteredTowerName(towerNameField
                                                       .getText()));
    }

    @Override
    public void setDelegate (TowerEditorViewDelegate delegate) {
        this.delegate = delegate;
    }

    @Override
    public Node getInstanceAsNode () {
        return towerNameField;
    }

    public void updateTowerName (String towerName) {
        towerNameField.setText(towerName);
    }

}
