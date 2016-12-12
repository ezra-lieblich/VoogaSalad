package authoring.editorview.enemy.subviews.editorfields;

import java.util.ResourceBundle;
import authoring.editorview.TextFieldView;
import authoring.editorview.enemy.EnemyAuthoringViewDelegate;
import authoring.editorview.enemy.EnemySetView;
import authoring.utilityfactories.BoxFactory;
import authoring.utilityfactories.TextFieldFactory;
import javafx.scene.control.TextField;


/**
 * 
 * @author Kayla Schulz
 *
 */
public class EnemyDamageField extends TextFieldView implements EnemySetView {

    private EnemyAuthoringViewDelegate delegate;
    private TextField enemyDamageField;

    public EnemyDamageField (ResourceBundle labelsResource) {
        super(labelsResource);
    }

    @Override
    public void setDelegate (EnemyAuthoringViewDelegate delegate) {
        this.delegate = delegate;
    }

    @Override
    protected void makeTextField (ResourceBundle labelsResource) {
        enemyDamageField =
                TextFieldFactory.makeTextField(labelsResource.getString("EnterInt"),
                                               e -> delegate
                                                       .onUserEnteredEnemyDamage(enemyDamageField
                                                               .getText()));
        hbox =
                BoxFactory.createHBoxWithLabelandNode(labelsResource.getString("Damage"),
                                                      enemyDamageField);
    }

    @Override
    public void updateField (String newData) {
        enemyDamageField.setText(newData);
    }

}
