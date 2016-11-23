package authoring.editorview.enemy.subviews.editorfields;

import authoring.editorview.enemy.EnemyEditorViewDelegate;
import authoring.utilityfactories.TextFieldFactory;
import javafx.scene.control.TextField;


public class EnemyNameField {

    private TextField enemyNameField;
    private EnemyEditorViewDelegate delegate;

    public EnemyNameField () {
        enemyNameField =
                TextFieldFactory.makeTextField("Set enemy name: ",
                                               e -> delegate.onUserEnteredEnemyName(enemyNameField
                                                       .getText()));
    }

    public void setDelegate (EnemyEditorViewDelegate delegate) {
        this.delegate = delegate;
    }

    public TextField getEnemyNameField () {
        return enemyNameField;
    }

    public void updateEnemyName (String enemyName) {
        enemyNameField.setText(enemyName);
    }

}
