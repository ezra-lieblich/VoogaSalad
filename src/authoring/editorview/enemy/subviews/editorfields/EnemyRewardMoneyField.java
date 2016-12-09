package authoring.editorview.enemy.subviews.editorfields;

import java.util.ResourceBundle;
import authoring.editorview.enemy.EnemyEditorViewDelegate;
import authoring.editorview.enemy.IEnemySetView;
import authoring.utilityfactories.BoxFactory;
import authoring.utilityfactories.TextFieldFactory;
import javafx.scene.Node;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;


public class EnemyRewardMoneyField implements IEnemySetView {

    private EnemyEditorViewDelegate delegate;
    private TextField enemyRewardMoneyField;
    private HBox hbox;

    public EnemyRewardMoneyField (ResourceBundle labelsResource) {
        createField(labelsResource);
    }

    @Override
    public void setDelegate (EnemyEditorViewDelegate delegate) {
        this.delegate = delegate;
    }

    @Override
    public Node getInstanceAsNode () {
        return hbox;
    }

    public void updateEnemyRewardMoney (String enemyRewardMoney) {
        enemyRewardMoneyField.setText(enemyRewardMoney);
    }

    private void createField (ResourceBundle labelsResource) {
        enemyRewardMoneyField =
                TextFieldFactory.makeTextField(labelsResource.getString("EnterInt"),
                                               e -> delegate
                                                       .onUserEnteredEnemyMoney(enemyRewardMoneyField
                                                               .getText()));
        hbox =
                BoxFactory.createHBoxWithLabelandNode(labelsResource.getString("RewardMoney"),
                                                      enemyRewardMoneyField);
    }

}
