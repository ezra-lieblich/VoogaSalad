package authoring.editorview.level.subviews;

import java.util.ResourceBundle;
import authoring.editorview.level.ILevelSetView;
import authoring.editorview.level.LevelEditorViewDelegate;
import authoring.editorview.tower.TowerEditorViewDelegate;
import authoring.utilityfactories.BoxFactory;
import authoring.utilityfactories.TextFieldFactory;
import javafx.scene.Node;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;


public class LevelTransitionTimeField implements ILevelSetView {

    private TextField transitionTimeField;
    private LevelEditorViewDelegate delegate;
    private HBox hbox;

    public LevelTransitionTimeField (ResourceBundle levelResource) {
        transitionTimeField =
                TextFieldFactory.makeTextField("",
                                               e -> delegate
                                                       .onUserEnteredTransitionTime(transitionTimeField
                                                               .getText()));
        hbox =
                BoxFactory.createHBoxWithLabelandNode(levelResource.getString("TransitionTime"),
                                                      transitionTimeField);
    }

    @Override
    public void setDelegate (LevelEditorViewDelegate delegate) {
        this.delegate = delegate;
    }

    @Override
    public Node getInstanceAsNode () {
        return hbox;
    }

    public void updateTransitionTimeField (String transitionTime) {
        transitionTimeField.setText(transitionTime);
    }

}
