package authoring.editorview.level.subviews;

import java.util.ResourceBundle;
import authoring.editorview.level.ILevelSetView;
import authoring.editorview.level.LevelEditorViewDelegate;
import javafx.scene.Node;
import javafx.scene.layout.HBox;


public class LevelChooserView implements ILevelSetView {

    private HBox hbox;
    private LevelEditorViewDelegate delegate;

    public LevelChooserView (ResourceBundle levelsResource) {
        hbox = new HBox();
        buildLevelComboBox();
    }

    @Override
    public Node getInstanceAsNode () {
        return hbox;
    }

    private void buildLevelComboBox () {

    }

    private void displayLevelToUpdate () {

    }

    @Override
    public void setDelegate (LevelEditorViewDelegate delegate) {
        this.delegate = delegate;
    }

}
