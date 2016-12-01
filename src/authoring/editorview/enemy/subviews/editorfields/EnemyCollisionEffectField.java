package authoring.editorview.enemy.subviews.editorfields;

import java.util.ResourceBundle;
import authoring.editorview.enemy.EnemyEditorViewDelegate;
import authoring.editorview.enemy.IEnemySetView;
import authoring.utilityfactories.TextFieldFactory;
import javafx.scene.Node;
import javafx.scene.control.TextField;


/**
 * 
 * @author Kayla Schulz
 *
 */
public class EnemyCollisionEffectField implements IEnemySetView {

    private TextField enemyReactionsField;
    private EnemyEditorViewDelegate delegate;

    public EnemyCollisionEffectField (ResourceBundle labelsResource) {
        enemyReactionsField =
                TextFieldFactory.makeTextField(labelsResource.getString("EnterString"),
                                               e -> delegate
                                                       .onUserEnteredEnemyCollisionEffect(enemyReactionsField
                                                               .getText()));
    }

    @Override
    public void setDelegate (EnemyEditorViewDelegate delegate) {
        this.delegate = delegate;
    }

    @Override
    public Node getInstanceAsNode () {
        return enemyReactionsField;
    }

    public void updateEnemyReaction (String enemyReaction) {
        enemyReactionsField.setText(enemyReaction);
    }

}
