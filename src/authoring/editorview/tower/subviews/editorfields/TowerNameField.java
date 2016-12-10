package authoring.editorview.tower.subviews.editorfields;

import java.util.ResourceBundle;
import authoring.editorview.EditorNameView;
import authoring.editorview.tower.ITowerSetView;
import authoring.editorview.tower.TowerEditorViewDelegate;
import authoring.utilityfactories.BoxFactory;
import authoring.utilityfactories.TextFieldFactory;


/**
 * 
 * @author Kayla Schulz
 *
 */
public class TowerNameField extends EditorNameView implements ITowerSetView {

    private TowerEditorViewDelegate delegate;

    public TowerNameField (ResourceBundle labelsResource) {
        super(labelsResource);
    }

    @Override
    public void setDelegate (TowerEditorViewDelegate delegate) {
        this.delegate = delegate;
    }

    @Override
    protected void makeNameTextField () {
        nameTextField =
                TextFieldFactory.makeTextField(resource.getString("EnterString"),
                                               e -> delegate.onUserEnteredTowerName(nameTextField
                                                       .getText()));
        root = BoxFactory.createHBoxWithLabelandNode(resource.getString("NameTextField"),
                                                     nameTextField);
    }

}
