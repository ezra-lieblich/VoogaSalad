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
public class EnemyNameField implements IEnemySetView {

    private TextField nameTextField;
    private EnemyEditorViewDelegate delegate;

    public EnemyNameField (ResourceBundle labelsResource) {
        nameTextField =
                TextFieldFactory.makeTextField(labelsResource.getString("EnterString"),
                                               e -> delegate.onUserEnteredEnemyName(nameTextField
                                                       .getText()));
    }

    @Override
    public void setDelegate (EnemyEditorViewDelegate delegate) {
        this.delegate = delegate;
    }

    @Override
    public Node getInstanceAsNode () {
        return nameTextField;
    }

    public void updateName (String name) {
        nameTextField.setText(name);
    }

}
