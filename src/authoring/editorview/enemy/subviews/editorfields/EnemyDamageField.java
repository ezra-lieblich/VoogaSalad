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
public class EnemyDamageField implements IEnemyEditorView {

    private EnemyEditorViewDelegate delegate;
    private TextField enemyDamageField;

    public EnemyDamageField (ResourceBundle labelsResource) {
        enemyDamageField =
                TextFieldFactory.makeTextField(labelsResource.getString("EnterInt"),
                                               e -> delegate
                                                       .onUserEnteredEnemyDamage(enemyDamageField
                                                               .getText()));
    }

    @Override
    public void setDelegate (EnemyEditorViewDelegate delegate) {
        this.delegate = delegate;
    }

    @Override
    public Node getInstanceAsNode () {
        return enemyDamageField;
    }

    public void updateEnemyFrequency (String enemyDamage) {
        enemyDamageField.setText(enemyDamage);
    }

}
