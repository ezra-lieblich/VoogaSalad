package authoring.editorview.tower.subviews.editorfields;

import java.util.ResourceBundle;
import authoring.editorview.tower.ITowerEditorView;
import authoring.editorview.tower.TowerEditorViewDelegate;
import authoring.utilityfactories.TextFieldFactory;
import javafx.scene.Node;
import javafx.scene.control.TextField;


/**
 * 
 * @author Kayla Schulz
 *
 */
public class TowerRangeField implements ITowerEditorView {

    private TowerEditorViewDelegate delegate;
    private TextField towerRangeField;

    public TowerRangeField (ResourceBundle labelsResource) {
        towerRangeField =
                TextFieldFactory.makeTextField(labelsResource.getString("EnterInt"),
                                               e -> delegate
                                                       .onUserEnteredTowerRange(towerRangeField
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
