package authoring.editorview.enemy.subviews.editorfields;

import authoring.editorview.enemy.EnemyEditorViewDelegate;
import authoring.editorview.enemy.IEnemyEditorView;
import authoring.utilityfactories.TextFieldFactory;
import javafx.scene.Node;
import javafx.scene.control.TextField;


public class EnemySpeedField implements IEnemyEditorView {

    private TextField enemySpeedField;
    private EnemyEditorViewDelegate delegate;

    public EnemySpeedField () {
        enemySpeedField =
                TextFieldFactory.makeTextField("Set enemy speed: ",
                                               e -> delegate
                                                       .onUserEnteredEnemySpeed(enemySpeedField
                                                               .getText()));
    }

    @Override
    public void setDelegate (EnemyEditorViewDelegate delegate) {
        this.delegate = delegate;
    }

    @Override
    public Node getInstanceAsNode () {
        return enemySpeedField;
    }

    public void updateEnemySpeed (String enemySpeed) {
        enemySpeedField.setText(enemySpeed);
    }

}
