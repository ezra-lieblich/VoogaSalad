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
public class EnemyHealthField implements IEnemySetView {

    private EnemyEditorViewDelegate delegate;
    private TextField enemyHealthField;
    private HBox hbox;

    public EnemyHealthField (ResourceBundle labelsResource) {
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

    public void updateEnemyHealth (String enemyHealth) {
        enemyHealthField.setText(enemyHealth);
    }

    private void createField (ResourceBundle labelsResource) {
        enemyHealthField =
                TextFieldFactory.makeTextField(labelsResource.getString("EnterInt"),
                                               e -> delegate
                                                       .onUserEnteredEnemyHealth(enemyHealthField
                                                               .getText()));
        hbox =
                BoxFactory.createHBoxWithLabelandNode(labelsResource.getString("Health"),
                                                      enemyHealthField);
    }
}
