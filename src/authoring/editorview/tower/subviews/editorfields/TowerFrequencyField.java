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
public class TowerFrequencyField implements ITowerEditorView {

    private TowerEditorViewDelegate delegate;
    private TextField towerFrequencyField;

    public TowerFrequencyField (ResourceBundle labelsResource) {
        towerFrequencyField =
                TextFieldFactory.makeTextField(labelsResource.getString("EnterInt"),
                                               e -> delegate
                                                       .onUserEnteredTowerFrequency(towerFrequencyField
                                                               .getText()));
    }

    @Override
    public void setDelegate (TowerEditorViewDelegate delegate) {
        this.delegate = delegate;
    }

    @Override
    public Node getInstanceAsNode () {
        return towerFrequencyField;
    }

    public void updateTowerFrequency (String towerFrequency) {
        towerFrequencyField.setText(towerFrequency);
    }

}
