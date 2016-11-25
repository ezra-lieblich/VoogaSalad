package authoring.editorview.enemy.subviews.editorfields;

import authoring.editorview.enemy.EnemyEditorViewDelegate;
import authoring.editorview.enemy.IEnemyEditorView;
import authoring.utilityfactories.TextFieldFactory;
import javafx.scene.Node;
import javafx.scene.control.TextField;


public class EnemyRewardPointsField implements IEnemyEditorView {

    private EnemyEditorViewDelegate delegate;
    private TextField enemyRewardPointsField;

    public EnemyRewardPointsField () {
        enemyRewardPointsField =
                TextFieldFactory.makeTextField("Set enemy reward points: ",
                                               e -> delegate
                                                       .onUserEnteredEnemyPoints(enemyRewardPointsField
                                                               .getText()));
    }

    @Override
    public void setDelegate (EnemyEditorViewDelegate delegate) {
        this.delegate = delegate;
    }

    @Override
    public Node getInstanceAsNode () {
        return enemyRewardPointsField;
    }

    public void updateEnemyRewardPoints (String enemyRewardPoints) {
        enemyRewardPointsField.setText(enemyRewardPoints);
    }

}
