package authoring.editorview.level.subviews.editorfields;

import java.util.ResourceBundle;
import authoring.editorview.level.LevelSetView;
import authoring.utilityfactories.ButtonFactory;
import authoring.editorview.level.LevelAuthoringViewDelegate;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;


/**
 * 
 * @author Kayla Schulz
 *
 */
public class CreateNewLevelView implements LevelSetView {

    private static final String RESOURCE_FILE_NAME = "resources/GameAuthoringLevels";
    private ResourceBundle levelResource = ResourceBundle.getBundle(RESOURCE_FILE_NAME);

    private LevelAuthoringViewDelegate delegate;
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
    public void setDelegate (LevelAuthoringViewDelegate delegate) {
        this.delegate = delegate;
    }

    private void buildViewComponents () {

        Button createLevelButton =
                ButtonFactory.makeButton(levelResource.getString("NewLevelButton"),
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

}
