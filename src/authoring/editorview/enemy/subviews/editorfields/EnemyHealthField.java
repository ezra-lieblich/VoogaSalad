package authoring.editorview.enemy.subviews.editorfields;

import java.util.ResourceBundle;
import authoring.editorview.TextFieldView;
import authoring.editorview.enemy.EnemyAuthoringViewDelegate;
import authoring.editorview.enemy.IEnemySetView;
import authoring.utilityfactories.BoxFactory;
import authoring.utilityfactories.TextFieldFactory;
import javafx.scene.Node;
import javafx.scene.control.TextField;


/**
 * 
 * @author Kayla Schulz
 *
 */
public class EnemyHealthField extends TextFieldView implements IEnemySetView {

    private EnemyAuthoringViewDelegate delegate;
    private TextField enemyHealthField;

    public EnemyHealthField (ResourceBundle labelsResource) {
        super(labelsResource);
    }

    @Override
    public void setDelegate (EnemyAuthoringViewDelegate delegate) {
        this.delegate = delegate;
    }

    @Override
    public Node getInstanceAsNode () {
        return hbox;
    }

    @Override
    public void updateField (String newData) {
        enemyHealthField.setText(newData);
    }

    @Override
    protected void makeTextField (ResourceBundle labelsResource) {
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
