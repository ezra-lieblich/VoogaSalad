package authoring.editorview.enemy.subviews.editorfields;

import java.util.ResourceBundle;
import authoring.editorview.enemy.EnemyEditorViewDelegate;
import authoring.editorview.enemy.IEnemyEditorView;
import authoring.utilityfactories.TextFieldFactory;
import javafx.scene.Node;
import javafx.scene.control.TextField;


/**
 * 
 * @author Kayla Schulz
 *
 */
public class EnemyFrequencyField implements IEnemyEditorView {

    private EnemyEditorViewDelegate delegate;
    private TextField enemyFrequencyField;

    public EnemyFrequencyField (ResourceBundle labelsResource) {
        enemyFrequencyField =
                TextFieldFactory.makeTextField(labelsResource.getString("EnterInt"),
                                               e -> delegate
                                                       .onUserEnteredEnemyFrequency(enemyFrequencyField
                                                               .getText()));
    }

    @Override
    public void setDelegate (EnemyEditorViewDelegate delegate) {
        this.delegate = delegate;
    }

    @Override
    public Node getInstanceAsNode () {
        return enemyFrequencyField;
    }

    public void updateEnemyFrequency (String enemyFrequency) {
        enemyFrequencyField.setText(enemyFrequency);
    }
}
