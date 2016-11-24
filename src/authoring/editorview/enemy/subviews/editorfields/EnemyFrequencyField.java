package authoring.editorview.enemy.subviews.editorfields;

import authoring.editorview.enemy.EnemyEditorViewDelegate;
import authoring.editorview.enemy.IEnemyEditorView;
import authoring.utilityfactories.TextFieldFactory;
import javafx.scene.Node;
import javafx.scene.control.TextField;


public class EnemyFrequencyField implements IEnemyEditorView {

    private EnemyEditorViewDelegate delegate;
    private TextField enemyFrequencyField;

    public EnemyFrequencyField () {
        enemyFrequencyField =
                TextFieldFactory.makeTextField("Set enemy frequency: ",
                                               e -> delegate
                                                       .onUserEnteredEnemyFrequency(enemyFrequencyField
                                                               .getText()));
    }

    @Override
    public void setDelegate (EnemyEditorViewDelegate delegate) {
        this.delegate = delegate;
    }

    @Override
    public Node getInstanceAsNode () {
        return enemyFrequencyField;
    }

    public void updateTowerFrequency (String enemyFrequency) {
        enemyFrequencyField.setText(enemyFrequency);
    }
}
