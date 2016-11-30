package authoring.editorview.enemy.subviews.editorfields;

import java.util.ResourceBundle;
import authoring.editorview.enemy.EnemyEditorViewDelegate;
import authoring.editorview.enemy.IEnemySetView;
import authoring.utilityfactories.TextFieldFactory;
import javafx.scene.Node;
import javafx.scene.control.TextField;


/**
 * 
 * @author Kayla Schulz
 *
 */
public class EnemyHealthField implements IEnemySetView {

    private EnemyEditorViewDelegate delegate;
    private TextField enemyHealthField;

    public EnemyHealthField (ResourceBundle labelsResource) {
        enemyHealthField =
                TextFieldFactory.makeTextField(labelsResource.getString("EnterInt"),
                                               e -> delegate
                                                       .onUserEnteredEnemyHealth(enemyHealthField
                                                               .getText()));
    }

    @Override
    public void setDelegate (EnemyEditorViewDelegate delegate) {
        this.delegate = delegate;
    }

    @Override
    public Node getInstanceAsNode () {
        return enemyHealthField;
    }

    public void updateEnemyHealth (String enemyHealth) {
        enemyHealthField.setText(enemyHealth);
    }

}
