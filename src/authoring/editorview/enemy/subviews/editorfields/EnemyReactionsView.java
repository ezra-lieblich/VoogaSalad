package authoring.editorview.enemy.subviews.editorfields;

import authoring.editorview.enemy.EnemyEditorViewDelegate;
import authoring.utilityfactories.TextFieldFactory;
import javafx.scene.control.TextField;


public class EnemyReactionsView {

    private TextField enemyReactionsField;
    private EnemyEditorViewDelegate delegate;

    public EnemyReactionsView () {
        enemyReactionsField =
                TextFieldFactory.makeTextField("Set enemy reactions: ",
                                               e -> delegate
                                                       .onUserEnteredEnemyCollisionEffect(enemyReactionsField
                                                               .getText()));
    }

    public void setDelegate (EnemyEditorViewDelegate delegate) {
        this.delegate = delegate;
    }

    public TextField getEnemyReactionField () {
        return enemyReactionsField;
    }

    public void updateEnemyReaction (String enemyReaction) {
        enemyReactionsField.setText(enemyReaction);
    }

}
