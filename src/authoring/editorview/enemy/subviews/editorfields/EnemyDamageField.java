package authoring.editorview.enemy.subviews.editorfields;

import java.util.ResourceBundle;
import authoring.editorview.TextFieldView;
import authoring.editorview.enemy.EnemyAuthoringViewDelegate;
import authoring.editorview.enemy.EnemySubView;
import authoring.utilityfactories.GridFactory;
import authoring.utilityfactories.TextFieldFactory;
import javafx.scene.control.TextField;


/**
 * 
 * @author Kayla Schulz
 *
 */
public class EnemyDamageField extends TextFieldView implements EnemySubView {

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
                TextFieldFactory.makeNumberTextField(labelsResource.getString("EnterInt"),
                                               e -> delegate
                                                       .onUserEnteredEnemyDamage(enemyDamageField
                                                               .getText()));
        enemyDamageField.setPrefWidth(110);
        root = GridFactory.createRowWithLabelandNode(
                                                     labelsResource.getString("Damage"),
                                                     enemyDamageField,
                                                     170);

    }

    @Override
    public void updateField (String newData) {
        enemyDamageField.setText(newData);
    }

}
