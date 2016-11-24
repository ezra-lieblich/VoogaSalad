package authoring.editorview.enemy.subviews.editorfields;

import authoring.editorview.enemy.EnemyEditorViewDelegate;
import authoring.editorview.enemy.IEnemyEditorView;
import authoring.utilityfactories.TextFieldFactory;
import javafx.scene.Node;
import javafx.scene.control.TextField;


public class EnemyNameField implements IEnemyEditorView {

    private TextField enemyNameField;
    private EnemyEditorViewDelegate delegate;

    public EnemyNameField () {
        enemyNameField =
                TextFieldFactory.makeTextField("Set enemy name: ",
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
