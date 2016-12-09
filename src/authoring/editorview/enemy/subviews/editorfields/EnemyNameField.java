package authoring.editorview.enemy.subviews.editorfields;

import java.util.ResourceBundle;
import authoring.editorview.NameView;
import authoring.editorview.enemy.EnemyEditorViewDelegate;
import authoring.editorview.enemy.IEnemySetView;
import authoring.utilityfactories.BoxFactory;
import authoring.utilityfactories.TextFieldFactory;


/**
 * 
 * @author Kayla Schulz
 *
 */
public class EnemyNameField extends NameView implements IEnemySetView {

    private EnemyEditorViewDelegate delegate;

    public EnemyNameField (ResourceBundle labelsResource) {
        super(labelsResource);
    }

    @Override
    public void setDelegate (EnemyEditorViewDelegate delegate) {
        this.delegate = delegate;
    }

    @Override
    protected void makeNameTextField () {
        nameTextField =
                TextFieldFactory.makeTextField(resource.getString("EnterString"),
                                               e -> delegate.onUserEnteredEnemyName(nameTextField
                                                       .getText()));
        root = BoxFactory.createHBoxWithLabelandNode(resource.getString("NameTextField"),
                                                     nameTextField);
    }

}
