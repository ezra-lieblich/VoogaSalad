package authoring.editorview.level.subviews;

import authoring.editorview.level.ILevelSetView;
import authoring.editorview.level.LevelEditorViewDelegate;
import javafx.scene.Node;
import javafx.scene.control.ComboBox;
import javafx.scene.layout.VBox;


public class LevelDesign implements ILevelSetView {

    private ComboBox<Object> pathComboBox;
    private LevelEditorViewDelegate delegate;

    private VBox vbox;

    public LevelDesign () {
        vbox = new VBox();
        // makePathComboBox();
    }

    @Override
    public Node getInstanceAsNode () {
        return vbox;
    }

    @Override
    public void setDelegate (LevelEditorViewDelegate delegate) {
        this.delegate = delegate;
    }

    // private void makePathComboBox(){
    // pathComboBox = ComboBoxFactory.makeComboBox("Select path",
    // e -> ,
    // options)
    // }
    //
}
