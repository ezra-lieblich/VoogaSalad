package authoring.editorview.level.subviews;

import java.util.ResourceBundle;
import authoring.editorview.NameView;
import authoring.editorview.level.ILevelSetView;
import authoring.editorview.level.LevelEditorViewDelegate;
import authoring.utilityfactories.BoxFactory;
import authoring.utilityfactories.TextFieldFactory;
import javafx.scene.Node;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;


public class LevelNameView extends NameView implements ILevelSetView {

    private HBox hbox;
    private LevelEditorViewDelegate delegate;
    private TextField nameTextField;

    private static final String RESOURCE_FILE_NAME = "resources/GameAuthoringLevels";
    private ResourceBundle levelResource = ResourceBundle.getBundle(RESOURCE_FILE_NAME);

    public LevelNameView (ResourceBundle levelsResource) {
        super(levelsResource);
    }

    @Override
    public Node getInstanceAsNode () {
        return hbox;
    }

    @Override
    public void setDelegate (LevelEditorViewDelegate delegate) {
        this.delegate = delegate;
    }

    protected void makeNameTextField () {
        nameTextField = TextFieldFactory.makeTextField("",
                                                       e -> delegate
                                                               .onUserEnteredLevelName(
                                                                                       nameTextField
                                                                                               .getText()));
        nameTextField.setMaxWidth(75);
        hbox =
                BoxFactory.createHBoxWithLabelandNode(levelResource.getString("NameTextField"),
                                                      nameTextField);

    }

}
