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
public class EnemyNameField implements IEnemyEditorView {

    private TextField enemyNameField;
    private EnemyEditorViewDelegate delegate;

    public EnemyNameField (ResourceBundle labelsResource) {
        enemyNameField =
                TextFieldFactory.makeTextField(labelsResource.getString("EnterString"),
                                               e -> delegate.onUserEnteredEnemyName(enemyNameField
                                                       .getText()));
    }

    @Override
    public void setDelegate (EnemyEditorViewDelegate delegate) {
        this.delegate = delegate;
    }

    @Override
    public Node getInstanceAsNode () {
        return enemyNameField;
    }

    public void updateEnemyName (String enemyName) {
        enemyNameField.setText(enemyName);
    }

}
