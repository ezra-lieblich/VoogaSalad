package authoring.editorview.enemy.subviews.editorfields;

import java.util.ResourceBundle;
import authoring.editorview.TextFieldView;
import authoring.editorview.enemy.EnemyAuthoringViewDelegate;
import authoring.editorview.enemy.EnemySetView;
import authoring.utilityfactories.GridFactory;
import authoring.utilityfactories.TextFieldFactory;
import javafx.scene.Node;
import javafx.scene.control.TextField;


/**
 * 
 * @author Kayla Schulz
 *
 */
public class EnemyHealthField extends TextFieldView implements EnemySetView {

    private EnemyAuthoringViewDelegate delegate;
   

    public EnemyHealthField (ResourceBundle labelsResource) {
        super(labelsResource);
    }

    @Override
    public void setDelegate (EnemyAuthoringViewDelegate delegate) {
        this.delegate = delegate;
    }

    @Override
    protected void makeTextField (ResourceBundle labelsResource) {
        textField =
                TextFieldFactory.makeTextField(labelsResource.getString("EnterInt"),
                                               e -> delegate
                                                       .onUserEnteredEnemyHealth(textField
                                                               .getText()));
        textField.setPrefWidth(110);

        root = GridFactory.createRowWithLabelandNode(
                                                     labelsResource.getString("Health"),
                                                     textField,
                                                     170);

    }
}
