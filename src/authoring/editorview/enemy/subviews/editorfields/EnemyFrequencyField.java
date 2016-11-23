package authoring.editorview.enemy.subviews.editorfields;

import authoring.editorview.enemy.EnemyEditorViewDelegate;
import authoring.utilityfactories.TextFieldFactory;
import javafx.scene.control.TextField;


public class EnemyFrequencyField {

    private EnemyEditorViewDelegate delegate;
    private TextField enemyFrequencyField;

    public EnemyFrequencyField () {
        enemyFrequencyField =
                TextFieldFactory.makeTextField("Set tower frequency: ",
                                               e -> delegate
                                                       .onUserEnteredEnemyFrequency(enemyFrequencyField
                                                               .getText()));
    }

    public void setDelegate (EnemyEditorViewDelegate delegate) {
        this.delegate = delegate;
    }

    public TextField getTowerFrequencyField () {
        return enemyFrequencyField;
    }

    public void updateTowerFrequency (String enemyFrequency) {
        enemyFrequencyField.setText(enemyFrequency);
    }

}
