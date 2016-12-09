package authoring.editorview.enemy.subviews.editorfields;

import java.util.ResourceBundle;
import authoring.editorview.enemy.EnemyEditorViewDelegate;
import authoring.editorview.enemy.IEnemySetView;
import authoring.utilityfactories.BoxFactory;
import authoring.utilityfactories.TextFieldFactory;
import javafx.scene.Node;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;


/**
 * 
 * @author Kayla Schulz
 *
 */
public class EnemyDamageField implements IEnemySetView {

    private EnemyEditorViewDelegate delegate;
    private TextField enemyDamageField;
    private HBox hbox;

    public EnemyDamageField (ResourceBundle labelsResource) {
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

    private void createField (ResourceBundle labelsResource) {
        enemyDamageField =
                TextFieldFactory.makeTextField(labelsResource.getString("EnterInt"),
                                               e -> delegate
                                                       .onUserEnteredEnemyDamage(enemyDamageField
                                                               .getText()));
        hbox =
                BoxFactory.createHBoxWithLabelandNode(labelsResource.getString("Damage"),
                                                      enemyDamageField);
    }

    public void updateEnemyDamage (String enemyDamage) {
        enemyDamageField.setText(enemyDamage);
    }

}
