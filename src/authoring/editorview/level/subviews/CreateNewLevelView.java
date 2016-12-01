package authoring.editorview.level.subviews;

import java.util.ResourceBundle;
import authoring.editorview.level.ILevelSetView;
import authoring.editorview.level.LevelEditorViewDelegate;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;


public class CreateNewLevelView implements ILevelSetView {

    private static final String RESOURCE_FILE_NAME = "resources/GameAuthoringLevels";
    private ResourceBundle levelResource = ResourceBundle.getBundle(RESOURCE_FILE_NAME);

    private LevelEditorViewDelegate delegate;
    private VBox vbox;

    public CreateNewLevelView (ResourceBundle levelsResource) {
        this.vbox = new VBox();
        buildViewComponents();
    }

    @Override
    public Node getInstanceAsNode () {
        return vbox;
    }

    @Override
    public void setDelegate (LevelEditorViewDelegate delegate) {
        this.delegate = delegate;
    }

    private void buildViewComponents () {

        Button createLevelButton =
                createButton(levelResource.getString("NewLevelButton"),
                             e -> {
                                 createNewLevel();
                             });
        vbox.getChildren().add(createLevelButton);
        createLevelButton.setTranslateY(5);
        createLevelButton.setTranslateX(5);
        createLevelButton.setFocusTraversable(false);
    }

    public void createNewLevel () {
        delegate.onUserEnteredCreateLevel();
    }

    private Button createButton (String label, EventHandler<ActionEvent> event) {
        Button button = new Button(label);
        button.setOnAction(event);
        return button;
    }

}
