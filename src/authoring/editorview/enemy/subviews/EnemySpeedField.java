package authoring.editorview.enemy.subviews;

import authoring.editorview.enemy.EnemyEditorViewDelegate;
import authoring.utilityfactories.TextFieldFactory;
import javafx.scene.control.TextField;


public class EnemySpeedField {

    private TextField enemySpeedField;
    private EnemyEditorViewDelegate delegate;

    public EnemySpeedField () {
        enemySpeedField =
                TextFieldFactory.makeTextField("Set enemy speed: ",
                                               e -> delegate
                                                       .onUserEnteredEnemySpeed(enemySpeedField
                                                               .getText()));
    }

    public void setDelegate (EnemyEditorViewDelegate delegate) {
        this.delegate = delegate;
    }

    public TextField getEnemySpeedField () {
        return enemySpeedField;
    }

    public void updateEnemySpeed (String enemySpeed) {
        enemySpeedField.setText(enemySpeed);
    }

}
