package authoring.editorview.enemy.subviews.editorfields;

import authoring.editorview.enemy.EnemyEditorViewDelegate;
import authoring.editorview.enemy.IEnemyEditorView;
import authoring.utilityfactories.TextFieldFactory;
import javafx.scene.Node;
import javafx.scene.control.TextField;


public class EnemyRewardMoneyField implements IEnemyEditorView {

    private EnemyEditorViewDelegate delegate;
    private TextField enemyRewardMoneyField;

    public EnemyRewardMoneyField () {
        enemyRewardMoneyField =
                TextFieldFactory.makeTextField("Set enemy reward money: ",
                                               e -> delegate
                                                       .onUserEnteredEnemyMoney(enemyRewardMoneyField
                                                               .getText()));
    }

    @Override
    public void setDelegate (EnemyEditorViewDelegate delegate) {
        this.delegate = delegate;
    }

    @Override
    public Node getInstanceAsNode () {
        return enemyRewardMoneyField;
    }

    public void updateEnemyRewardMoney (String enemyRewardMoney) {
        enemyRewardMoneyField.setText(enemyRewardMoney);
    }

}
