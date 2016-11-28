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
public class EnemyHealthField implements IEnemyEditorView {

    private EnemyEditorViewDelegate delegate;
    private TextField enemyHealthField;

    public EnemyHealthField () {
        enemyHealthField =
                TextFieldFactory.makeTextField("Set enemy health: ",
                                               e -> delegate
                                                       .onUserEnteredEnemyHealth(enemyHealthField
                                                               .getText()));
    }

    @Override
    public void setDelegate (EnemyEditorViewDelegate delegate) {
        this.delegate = delegate;
    }

    @Override
    public Node getInstanceAsNode () {
        return enemyHealthField;
    }

    public void updateEnemyHealth (String enemyHealth) {
        enemyHealthField.setText(enemyHealth);
    }

}
