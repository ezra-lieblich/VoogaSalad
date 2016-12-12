package authoring.editorview.level.subviews;

import java.util.ResourceBundle;
import authoring.editorview.EditorNameView;
import authoring.editorview.level.LevelSetView;
import authoring.editorview.level.LevelAuthoringViewDelegate;
import authoring.utilityfactories.BoxFactory;
import authoring.utilityfactories.TextFieldFactory;


public class LevelNameView extends EditorNameView implements LevelSetView {

    private LevelAuthoringViewDelegate delegate;

    public LevelNameView (ResourceBundle levelsResource) {
        super(levelsResource);
    }

    @Override
    public void setDelegate (LevelAuthoringViewDelegate delegate) {
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
