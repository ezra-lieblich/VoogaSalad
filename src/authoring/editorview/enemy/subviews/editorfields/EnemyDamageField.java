package authoring.editorview.enemy.subviews.editorfields;

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

    public EnemyDamageField () {
        enemyDamageField =
                TextFieldFactory.makeTextField("Set enemy damage: ",
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
