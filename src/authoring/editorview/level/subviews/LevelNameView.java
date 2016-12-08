package authoring.editorview.level.subviews;

import java.util.ResourceBundle;
import authoring.editorview.NameView;
import authoring.editorview.level.ILevelSetView;
import authoring.editorview.level.LevelEditorViewDelegate;
import authoring.utilityfactories.BoxFactory;
import authoring.utilityfactories.TextFieldFactory;
import javafx.scene.Node;


public class LevelNameView extends NameView implements ILevelSetView {

    private LevelEditorViewDelegate delegate;

    public LevelNameView (ResourceBundle levelsResource) {
        super(levelsResource);
    }

    @Override
    public Node getInstanceAsNode () {
        return root;
    }

    @Override
    public void setDelegate (LevelEditorViewDelegate delegate) {
        this.delegate = delegate;
    }

    @Override
    protected void makeNameTextField () {
        nameTextField = TextFieldFactory.makeTextField("",
                                                       e -> delegate
                                                               .onUserEnteredLevelName(
                                                                                       nameTextField
                                                                                               .getText()));
        nameTextField.setMaxWidth(75);
        root =
                BoxFactory.createHBoxWithLabelandNode(resource.getString("NameTextField"),
                                                      nameTextField);

    }

}
