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
public class EnemySpeedField implements IEnemySetView {

    private TextField enemySpeedField;
    private EnemyEditorViewDelegate delegate;

    public EnemySpeedField (ResourceBundle labelsResource) {
        enemySpeedField =
                TextFieldFactory.makeTextField(labelsResource.getString("EnterInt"),
                                               e -> delegate
                                                       .onUserEnteredEnemySpeed(enemySpeedField
                                                               .getText()));
    }

    @Override
    public void setDelegate (EnemyEditorViewDelegate delegate) {
        this.delegate = delegate;
    }

    @Override
    public Node getInstanceAsNode () {
        return enemySpeedField;
    }

    public void updateEnemySpeed (String enemySpeed) {
        enemySpeedField.setText(enemySpeed);
    }

}
