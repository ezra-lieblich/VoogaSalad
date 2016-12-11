package authoring.editorview.path.subviews.editorfields;

import java.util.ResourceBundle;
import authoring.editorview.EditorNameView;
import authoring.editorview.path.IPathSetView;
import authoring.editorview.path.PathAuthoringViewDelegate;
import authoring.utilityfactories.BoxFactory;
import authoring.utilityfactories.TextFieldFactory;


public class PathNameView extends EditorNameView implements IPathSetView {

    private PathAuthoringViewDelegate delegate;

    public PathNameView (ResourceBundle pathResource) {
        super(pathResource);
    }

    @Override
    public void setDelegate (PathAuthoringViewDelegate delegate) {
        this.delegate = delegate;
    }

    @Override
    protected void makeNameTextField () {
        nameTextField = TextFieldFactory.makeTextField("",
                                                       e -> delegate
                                                               .onUserEnteredPathName(nameTextField
                                                                       .getText()));
        nameTextField.setMaxWidth(100);
        root = BoxFactory.createHBoxWithLabelandNode(resource.getString("NameTextField"),
                                                      nameTextField);
    }

}
