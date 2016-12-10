package authoring.editorview.enemy.subviews.editorfields;

import java.util.ResourceBundle;
import authoring.editorview.TextFieldView;
import authoring.editorview.enemy.EnemyEditorViewDelegate;
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
public class EnemySpeedField extends TextFieldView implements IEnemySetView {

    private TextField enemySpeedField;
    private EnemyEditorViewDelegate delegate;

    public EnemySpeedField (ResourceBundle labelsResource) {
        super(labelsResource);
    }

    @Override
    public void setDelegate (EnemyEditorViewDelegate delegate) {
        this.delegate = delegate;
    }

    @Override
    public Node getInstanceAsNode () {
        return hbox;
    }

    @Override
    public void updateField (String newData) {
        enemySpeedField.setText(newData);
    }

    @Override
    protected void makeTextField (ResourceBundle labelsResource) {
        enemySpeedField =
                TextFieldFactory.makeTextField(labelsResource.getString("EnterInt"),
                                               e -> delegate
                                                       .onUserEnteredEnemySpeed(enemySpeedField
                                                               .getText()));
        hbox = BoxFactory.createHBoxWithLabelandNode(labelsResource.getString("Speed"),
                                                     enemySpeedField);
    }

}
